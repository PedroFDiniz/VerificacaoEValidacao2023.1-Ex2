package taskManager.test.junit5Tests.interfaces;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


public @interface Create{
    @Target({ ElementType.TYPE, ElementType.METHOD })
    @Retention(RetentionPolicy.RUNTIME)
    @Tag("CreateSuccessful")
    @DisplayName("Create Successful")
    @Test
    @interface Successful {

    }

    @Target({ ElementType.TYPE, ElementType.METHOD })
    @Retention(RetentionPolicy.RUNTIME)
    @Tag("CreateFail")
    @DisplayName("Create Fail")
    @Test
    @interface Fail {

    }
}
