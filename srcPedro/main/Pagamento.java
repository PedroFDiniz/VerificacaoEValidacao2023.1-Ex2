package srcPedro.main;

import java.time.LocalDateTime;

public class Pagamento {
    private double valorPago;
    private LocalDateTime dataDoPagamento;
    private String tipo;

    public Pagamento(double valorPago, LocalDateTime data, String tipo) {
        this.valorPago = valorPago;
        this.dataDoPagamento = data;
        this.tipo = tipo;
    }

    public double getValorPago() {
        return this.valorPago;
    }

    public String getTipo() {
        return this.tipo;
    }

    public LocalDateTime getDate() {
        return this.dataDoPagamento;
    }
}
