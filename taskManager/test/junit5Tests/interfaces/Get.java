package taskManager.test.junit5Tests.interfaces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Tag("Get")
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

    @Target({ ElementType.TYPE, ElementType.METHOD })
    @Retention(RetentionPolicy.RUNTIME)
    @Tag("GetTitle")
    @DisplayName("Get Title")
    @Test
    @interface Title {

    }

    @Target({ ElementType.TYPE, ElementType.METHOD })
    @Retention(RetentionPolicy.RUNTIME)
    @Tag("GetDescription")
    @DisplayName("Get Description")
    @Test
    @interface Description {

    }

    @Target({ ElementType.TYPE, ElementType.METHOD })
    @Retention(RetentionPolicy.RUNTIME)
    @Tag("GetDate")
    @DisplayName("Get Date")
    @Test
    @interface Date {

    }

    @Target({ ElementType.TYPE, ElementType.METHOD })
    @Retention(RetentionPolicy.RUNTIME)
    @Tag("GetPriority")
    @DisplayName("Get Priority")
    @Test
    @interface Priority {

    }

}
