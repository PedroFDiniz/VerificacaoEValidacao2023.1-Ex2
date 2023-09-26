package taskManager.test.junit5Tests.interfaces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Tag("Set")
public @interface Set {

    @Target({ ElementType.TYPE, ElementType.METHOD })
    @Retention(RetentionPolicy.RUNTIME)
    @Tag("SetSuccessful")
    @DisplayName("Set Successful")
    @Test
    @interface Successful {

    }

    @Target({ ElementType.TYPE, ElementType.METHOD })
    @Retention(RetentionPolicy.RUNTIME)
    @Tag("SetFail")
    @DisplayName("Set Fail")
    @Test
    @interface Fail {

    }

    @Target({ ElementType.TYPE, ElementType.METHOD })
    @Retention(RetentionPolicy.RUNTIME)
    @Tag("SetTitle")
    @DisplayName("Set Title")
    @Test
    @interface Title {

    }

    @Target({ ElementType.TYPE, ElementType.METHOD })
    @Retention(RetentionPolicy.RUNTIME)
    @Tag("SetDescription")
    @DisplayName("Set Description")
    @Test
    @interface Description {

    }

    @Target({ ElementType.TYPE, ElementType.METHOD })
    @Retention(RetentionPolicy.RUNTIME)
    @Tag("SetDate")
    @DisplayName("Set Date")
    @Test
    @interface Date {

    }

    @Target({ ElementType.TYPE, ElementType.METHOD })
    @Retention(RetentionPolicy.RUNTIME)
    @Tag("SetPriority")
    @DisplayName("Set Priority")
    @Test
    @interface Priority {

    }

}
