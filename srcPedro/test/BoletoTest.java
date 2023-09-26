package srcPedro.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import srcPedro.main.Boleto;

public class BoletoTest {
    private static LocalDateTime ARBITRARY_DATE;
    private static LocalDateTime DIFFERENT_ARBITRARY_DATE;
    private final int ARBITRARY_BOLETO_CODE = 123;
    private final int ARBITRARY_VALUE = 100;

    private LocalDateTime createRandomDate() {
        Random generator = new Random();
        int randomYear = 1969 + generator.nextInt(55);
        int randomMonth = 1 + generator.nextInt(12);
        int randomDay = 1 + generator.nextInt(31);
        if (randomMonth == 2 && randomDay > 28) {
            randomDay -= 3;
        }

        return LocalDate.of(randomYear, randomMonth, randomDay).atStartOfDay();
    }

    @Test
    public void testCreateBoleto() {
        ARBITRARY_DATE = this.createRandomDate();
        DIFFERENT_ARBITRARY_DATE = this.createRandomDate();
        Boleto boleto = new Boleto(123, ARBITRARY_DATE, 100.0);
        Assertions.assertEquals(123, boleto.getCode());
        Assertions.assertNotEquals(1234, boleto.getCode());
        Assertions.assertEquals(ARBITRARY_DATE, boleto.getDate());
        Assertions.assertNotEquals(DIFFERENT_ARBITRARY_DATE, boleto.getDate());
        Assertions.assertEquals(100.0, boleto.getValue());
        Assertions.assertNotEquals(101.0, boleto.getValue());
    }

    @Test
    public void testBoletoEquals() {
        ARBITRARY_DATE = this.createRandomDate();
        Boleto first = new Boleto(123, ARBITRARY_DATE, 100.0);
        Boleto second = new Boleto(123, ARBITRARY_DATE, 100.0);
        Assertions.assertEquals(first, second);
    }

    @Test
    public void failIfNotEqual() {
        ARBITRARY_DATE = this.createRandomDate();
        DIFFERENT_ARBITRARY_DATE = this.createRandomDate();
        Boleto first = new Boleto(123, ARBITRARY_DATE, 100.0);
        Boleto second = new Boleto(1234, ARBITRARY_DATE, 100.0);
        Boleto fourth = new Boleto(123, DIFFERENT_ARBITRARY_DATE, 100.0);
        Assertions.assertNotEquals(first, second);
        Assertions.assertNotEquals(first, fourth);
    }
}