package srcPedro.main;

import java.time.LocalDateTime;

public class Boleto {
    private int code;
    private LocalDateTime date;
    private double value;

    public Boleto(int code, LocalDateTime date, double value) {
        this.code = code;
        this.date = date;
        this.value = value;
    }

    public int getCode() {
        return this.code;
    }

    public LocalDateTime getDate() {
        return this.date;
    }

    public double getValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object outroObjeto) {
        if (!(outroObjeto instanceof Boleto outroBoleto)) {
            return false;
        } else {
            return this.getCode() == outroBoleto.getCode() && this.getDate().equals(outroBoleto.getDate()) && this.getValue() == outroBoleto.getValue();
        }
    }
}
