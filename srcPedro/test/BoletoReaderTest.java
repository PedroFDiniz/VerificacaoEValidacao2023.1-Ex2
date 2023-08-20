package srcPedro.test;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import srcPedro.main.BoletoReader;
import java.util.NoSuchElementException;

public class BoletoReaderTest {
    private BoletoReader reader;

    @Test
    public void throwsNoSuchElementException() throws Exception {
        reader = new BoletoReader("boletoVazio.json");
        Assertions.assertThrows(NoSuchElementException.class,
            () -> {
                reader.readNextBoleto();
            });
    }
}