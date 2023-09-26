package taskManager.test.junit5Tests.interfaces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Tag("WrongFormat")
public @interface WrongFormat {
    @Target({ ElementType.TYPE, ElementType.METHOD })
    @Retention(RetentionPolicy.RUNTIME)
    @DisplayName("Wrong Format of Data")
    @Test
    @interface WrongFormatData {
    }
}

