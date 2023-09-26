package taskManager.test.junit5Tests.interfaces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public @interface Get {

    @Target({ ElementType.TYPE, ElementType.METHOD })
    @Retention(RetentionPolicy.RUNTIME)
    @Tag("GetSuccessful")
    @DisplayName("Get Successful")
    @Test
    @interface Successful {

    }

    @Target({ ElementType.TYPE, ElementType.METHOD })
    @Retention(RetentionPolicy.RUNTIME)
    @Tag("GetFail")
    @DisplayName("Get Fail")
    @Test
    @interface Fail {

    }

}
