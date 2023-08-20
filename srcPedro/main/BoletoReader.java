package srcPedro.main;
import java.io.File;
import java.io.FileNotFoundException;

public class BoletoReader {
    File boletos;

    public BoletoReader(String filePath) throws FileNotFoundException {
        boletos = new File(filePath);
        if (!boletos.exists() || !boletos.isFile()) {
            throw new FileNotFoundException("Arquivo nao encontrado");
        }
    }

    public Boleto readNextBoleto() {
        return null;
    }
}
