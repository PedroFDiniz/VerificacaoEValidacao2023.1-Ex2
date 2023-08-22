package srcPedro.main;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BoletoProcessor {
    public BoletoProcessor() {
    }

    public List<Pagamento> processarBoletos(List<Boleto> listaDeBoletos) {
        List<Pagamento> resultado = new ArrayList();
        String TIPO_BOLETO = "BOLETO";
        Iterator var4 = listaDeBoletos.iterator();

        while(var4.hasNext()) {
            Boleto boleto = (Boleto)var4.next();
            LocalDateTime AGORA = LocalDateTime.now();
            Pagamento novoPagamento = new Pagamento(boleto.getValue(), AGORA, TIPO_BOLETO);
            resultado.add(novoPagamento);
        }

        return resultado;
    }
}