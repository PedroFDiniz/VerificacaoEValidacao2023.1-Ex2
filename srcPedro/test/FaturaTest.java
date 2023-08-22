package srcPedro.test;

import java.time.LocalDateTime;
import java.util.List;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import srcPedro.main.Fatura;
import srcPedro.main.Pagamento;

public class FaturaTest {
    private static final String FATURA_STATUS_PAGA = "PAGA";
    private static final LocalDateTime ARBITRARY_DATE = LocalDateTime.now();
    private final double VALOR_TOTAL = 1500.0;
    private final String TIPO_BOLETO = "BOLETO";
    private final double PARCELA1 = 500.0;
    private final double PARCELA2 = 400.0;
    private final double PARCELA3 = 600.0;

    @Test
    public void faturaStatusPaid() {
        int PAGAMENTOS = 5;
        int VALOR_PAGAMENTOS = 300;
        Fatura fatura = new Fatura("Arbitrary Name", ARBITRARY_DATE, 1500.0);

        for(int i = 0; i < PAGAMENTOS; ++i) {
            fatura.addPagamento(new Pagamento((double)VALOR_PAGAMENTOS, ARBITRARY_DATE, "BOLETO"));
        }

        Assertions.assertEquals(fatura.getStatus(), "PAGA");
    }

    @Test
    public void faturaFailStatusPaid() {
        int PAGAMENTOS = 3;
        int VALOR_PAGAMENTOS = 150;
        Fatura fatura = new Fatura("Arbitrary Name", ARBITRARY_DATE, 1500.0);

        for(int i = 0; i < PAGAMENTOS; ++i) {
            fatura.addPagamento(new Pagamento(VALOR_PAGAMENTOS, ARBITRARY_DATE, "BOLETO"));
        }

        Assertions.assertNotEquals(1500.0, fatura.somaPagamentos());
        Assertions.assertNotEquals("PAGA", fatura.getStatus());
    }

    @Test
    public void faturaOverpaid() {
        int PAGAMENTOS = 3;
        int VALOR_PAGAMENTOS = 750;
        Fatura fatura = new Fatura("Arbitrary Name", ARBITRARY_DATE, 1500.0);

        for(int i = 0; i < PAGAMENTOS; ++i) {
            fatura.addPagamento(new Pagamento((double)VALOR_PAGAMENTOS, ARBITRARY_DATE, "BOLETO"));
        }

        Assertions.assertEquals(fatura.getStatus(), "PAGA");
    }

    @Test
    public void testAddPagamentos() {
        Fatura fatura = new Fatura("Arbitrary Name", ARBITRARY_DATE, 1500.0);
        Pagamento pagamento1 = new Pagamento(PARCELA1, ARBITRARY_DATE, "BOLETO");
        Pagamento pagamento2 = new Pagamento(PARCELA2, ARBITRARY_DATE, "BOLETO");
        Pagamento pagamento3 = new Pagamento(PARCELA3, ARBITRARY_DATE, "BOLETO");
        fatura.addPagamento(pagamento1);
        fatura.addPagamento(pagamento2);
        fatura.addPagamento(pagamento3);
        List<Pagamento> pagamentos = fatura.getPagamentos();
        Assertions.assertTrue(pagamentos.contains(pagamento1));
        Assertions.assertTrue(pagamentos.contains(pagamento2));
        Assertions.assertTrue(pagamentos.contains(pagamento3));
        Pagamento pagamento4 = new Pagamento(600.0, ARBITRARY_DATE, "BOLETO");
        Assertions.assertFalse(pagamentos.contains(pagamento4));
    }
}
