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

public class PagamentoTest {
    private static LocalDateTime ARBITRARY_DATE;
    private static LocalDateTime DIFFERENT_ARBITRARY_DATE;
    private static final String PAGAMENTO_TYPE_BOLETO = "BOLETO";
    private static final String ARBITRARY_PAGAMENTO_TYPE = "QWERTY";

    private LocalDateTime createRandomDate() {
        Random generator = new Random();
        int randomYear = 1969 + generator.nextInt(55);
        int randomMonth = 1 + generator.nextInt(12);
        int randomDay = 1 + generator.nextInt(31);
        if (randomMonth == 2 && randomDay > 28) randomDay -= 3;

        return LocalDate.of(randomYear, randomMonth, randomDay).atStartOfDay();
    }

    @Test
    public void testCreatePagamento() {
        ARBITRARY_DATE = this.createRandomDate();
        DIFFERENT_ARBITRARY_DATE = this.createRandomDate();

        Pagamento pag = new Pagamento(120.0, ARBITRARY_DATE, PAGAMENTO_TYPE_BOLETO);
        Assertions.assertEquals(120.0, pag.getValorPago());
        Assertions.assertNotEquals(121.0, pag.getValorPago());
        Assertions.assertEquals(ARBITRARY_DATE, pag.getDate());
        Assertions.assertNotEquals(DIFFERENT_ARBITRARY_DATE, pag.getDate());
        Assertions.assertEquals(PAGAMENTO_TYPE_BOLETO, pag.getTipo());
        Assertions.assertNotEquals(ARBITRARY_PAGAMENTO_TYPE, pag.getTipo());
    }

    @Test
    public void checkPagamentoTipo() {
        ARBITRARY_DATE = this.createRandomDate();
        DIFFERENT_ARBITRARY_DATE = this.createRandomDate();

        Boleto boleto1 = new Boleto(123, ARBITRARY_DATE, 1500.0);
        List<Boleto> listaDeBoletos = new ArrayList<Boleto>(1);
        listaDeBoletos.add(boleto1);
        BoletoProcessor bp = new BoletoProcessor();
        Pagamento pagamento = bp.processarBoletos(listaDeBoletos).get(0);
        Assertions.assertEquals(PAGAMENTO_TYPE_BOLETO, pagamento.getTipo());
    }
}