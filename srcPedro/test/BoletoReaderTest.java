package srcPedro.test;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import srcPedro.main.BoletoReader;

import java.io.FileNotFoundException;
import java.util.NoSuchElementException;

public class BoletoReaderTest {
    private BoletoReader reader;

    @Test
    public void throwsFileNotFoundException() throws Exception {
        Assertions.assertThrows(FileNotFoundException.class,
            ()-> {
                new BoletoReader("");
            });
    }

    @Test
    public void throwsNoSuchElementException() throws Exception {
        reader = new BoletoReader("boletoVazio.json");
        Assertions.assertThrows(NoSuchElementException.class,
            () -> {
                reader.readNextBoleto();
            });
    }
}