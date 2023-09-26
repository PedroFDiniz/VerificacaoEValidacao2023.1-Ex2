package srcPedro.junit5Tests;

import org.junit.jupiter.api.*;

import srcPedro.main.Boleto;
import srcPedro.main.BoletoProcessor;
import srcPedro.main.Fatura;
import srcPedro.main.Pagamento;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ParticaoEquivalenciaTests {
    private Fatura fatura;
    private Boleto boleto1;
    private Boleto boleto2;
    private Boleto boleto3;
    private List<Boleto> boletos;
    private BoletoProcessor boletoProcessor;

    @BeforeAll
    public void initBoletos() {
        boletoProcessor = new BoletoProcessor();
        boleto1 = new Boleto(0,LocalDateTime.now(),0);
        boleto2 = new Boleto(1, LocalDateTime.now(), 1000);
        boleto3 = new Boleto(2, LocalDateTime.now(), 1400);
    }

    @BeforeEach
    public void variablesInit() {
        fatura = new Fatura("Cliente Teste", LocalDateTime.now(), 1000);
        boletos = new ArrayList<>();
    }

    @Test
    public void testFaturaStatusPago() {
        boletos.add(boleto2);
        for (Pagamento pag : boletoProcessor.processarBoletos(boletos)) {
            fatura.addPagamento(pag);
        }
        Assertions.assertEquals("PAGA",fatura.getStatus());
    }

    @Test
    public void testFaturaStatusNaoPago() {
        boletos.add(boleto1);
        for (Pagamento pag : boletoProcessor.processarBoletos(boletos)) {
            fatura.addPagamento(pag);
        }
        Assertions.assertEquals("NAO_PAGA",fatura.getStatus());
    }

    @Test
    public void testFaturaStatusMaisQuePago() {
        boletos.add(boleto3);
        for (Pagamento pag : boletoProcessor.processarBoletos(boletos)) {
            fatura.addPagamento(pag);
        }
        Assertions.assertEquals("PAGA",fatura.getStatus());
    }

    @Test
    public void testFaturaPagamentoNulo() {
        Assertions.assertThrows(NullPointerException.class,() -> fatura.addPagamento(null));
    }
}