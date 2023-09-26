package srcPedro.main;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Fatura {
    private String status = "NAO_PAGA";
    private String nomeDoCliente;
    private LocalDateTime dataDeEmissao;
    private double valorTotal;
    private List<Pagamento> pagamentos;

    public Fatura(String nomeDoCliente, LocalDateTime dataDeEmissao, double valorTotal) {
        this.nomeDoCliente = nomeDoCliente;
        this.dataDeEmissao = dataDeEmissao;
        this.valorTotal = valorTotal;
        this.pagamentos = new ArrayList<>();
    }

    public String getStatus() {
        return this.status;
    }

    public String getNomeDoCliente() {
        return this.nomeDoCliente;
    }

    public LocalDateTime getDataDeEmissao() {
        return this.dataDeEmissao;
    }

    public double getValorTotal() {
        return this.valorTotal;
    }

    public void setValorTotal(double novoValor) {
        this.valorTotal = novoValor;
    }

    public void setStatus(String novoStatus) {
        this.status = novoStatus;
    }

    public void addPagamento(Pagamento pagamento) {
        if (pagamento == null) {
            throw new NullPointerException("O pagamento nao pode ser nulo");
        }
        this.pagamentos.add(pagamento);
        if (this.somaPagamentos() >= this.valorTotal) {
            this.status = "PAGA";
        }

    }

    public double somaPagamentos() {
        double total = 0.0;

        Pagamento pagamento;
        for(Iterator<Pagamento> var3 = this.pagamentos.iterator(); var3.hasNext(); total += pagamento.getValorPago()) {
            pagamento = (Pagamento)var3.next();
        }

        return total;
    }

    public List<Pagamento> getPagamentos() {
        return this.pagamentos;
    }
}
