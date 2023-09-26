package srcPedro.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import srcPedro.main.Boleto;
import srcPedro.main.BoletoProcessor;
import srcPedro.main.Pagamento;

public class BoletoProcessorTest {
    private static LocalDateTime ARBITRARY_DATE;

    private LocalDateTime createRandomDate() {
        Random generator = new Random();
        int randomYear = 1969 + generator.nextInt(55);
        int randomMonth = 1 + generator.nextInt(12);
        int randomDay = 1 + generator.nextInt(31);
        if (randomMonth == 2 && randomDay > 28) randomDay -= 3;

        return LocalDate.of(randomYear, randomMonth, randomDay).atStartOfDay();
    }

    @Test
    public void testValorPago() {
        ARBITRARY_DATE = this.createRandomDate();
        Boleto boleto1 = new Boleto(123, ARBITRARY_DATE, 500.0);
        Boleto boleto2 = new Boleto(124, ARBITRARY_DATE, 400.0);
        Boleto boleto3 = new Boleto(125, ARBITRARY_DATE, 600.0);
        List<Boleto> listaDeBoletos = new ArrayList<>(3);
        listaDeBoletos.add(boleto1);
        listaDeBoletos.add(boleto2);
        listaDeBoletos.add(boleto3);
        BoletoProcessor bp = new BoletoProcessor();
        List<Pagamento> pagamentos = bp.processarBoletos(listaDeBoletos);
        Assertions.assertEquals((pagamentos.get(0)).getValorPago(), 500.0);
        Assertions.assertEquals((pagamentos.get(1)).getValorPago(), 400.0);
        Assertions.assertEquals((pagamentos.get(2)).getValorPago(), 600.0);
    }

    @Test
    public void failValorPago() {
        ARBITRARY_DATE = this.createRandomDate();
        Boleto boleto1 = new Boleto(123, ARBITRARY_DATE, 500.0);
        List<Boleto> listaDeBoletos = new ArrayList<Boleto>(1);
        listaDeBoletos.add(boleto1);
        BoletoProcessor bp = new BoletoProcessor();
        Pagamento pagamento = bp.processarBoletos(listaDeBoletos).get(0);
        Assertions.assertNotEquals(pagamento.getValorPago(), 1500.0);
    }
}