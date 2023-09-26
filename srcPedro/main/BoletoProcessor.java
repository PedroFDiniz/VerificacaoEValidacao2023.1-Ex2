package srcPedro.main;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BoletoProcessor {
    public BoletoProcessor() {
    }

    public List<Pagamento> processarBoletos(List<Boleto> listaDeBoletos) {
        List<Pagamento> resultado = new ArrayList<>();
        String TIPO_BOLETO = "BOLETO";
        Iterator<Boleto> iterador = listaDeBoletos.iterator();

        while(iterador.hasNext()) {
            Boleto boleto = iterador.next();
            LocalDateTime AGORA = LocalDateTime.now();
            if (boleto.getValue() < 0) {
                throw new IllegalArgumentException("Value can't be negative");
            } 
            Pagamento novoPagamento = new Pagamento(boleto.getValue(), AGORA, TIPO_BOLETO);
            resultado.add(novoPagamento);
        }

        return resultado;
    }
}