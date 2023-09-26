package srcPedro.junit5Tests;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import srcPedro.main.Boleto;
import srcPedro.main.BoletoProcessor;
import srcPedro.main.Fatura;
import srcPedro.main.Pagamento;

public class AVLTests {
    private BoletoProcessor processadorBoletos;
    private List<Boleto> boletos;
    private Fatura fatura;

    @BeforeEach
    public void variableInit() {
        processadorBoletos = new BoletoProcessor();
        fatura = new Fatura("Cliente Teste", LocalDateTime.now(), 1);
        boletos = new ArrayList<>();
    }

    @Test
    @DisplayName("Teste do limite inferior, valor = limite + 1")
    public void testFaturaAcimaDoLimiteInferior() {
        boletos.add(new Boleto(0, LocalDateTime.now(), 1));
        for (Pagamento pagamento : processadorBoletos.processarBoletos(boletos)) {
            fatura.addPagamento(pagamento);
        }
        Assertions.assertEquals(1, fatura.somaPagamentos());
    }

    @Test
    @DisplayName("Teste do limite inferior, valor = limite")
    public void testFaturaNoLimiteInferior() {
        boletos.add(new Boleto(0, LocalDateTime.now(), 0));
        fatura.setValorTotal(0);
        for (Pagamento pagamento : processadorBoletos.processarBoletos(boletos)) {
            fatura.addPagamento(pagamento);
        }
        Assertions.assertEquals(0, fatura.somaPagamentos());
    }

    @Test
    @DisplayName("Teste do limite inferior, valor = limite - 1")
    public void testFaturaAbaixoDoLimiteInferior() {
        boletos.add(new Boleto(0, LocalDateTime.now(), -1));
        fatura.setValorTotal(-1);
        Assertions.assertThrows(IllegalArgumentException.class, () -> processadorBoletos.processarBoletos(boletos));
    }
}
