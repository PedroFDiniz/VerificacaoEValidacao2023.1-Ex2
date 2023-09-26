package taskManager.test.junit5Tests.interfaces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Tag("Update")
public @interface Update{

    @Target({ ElementType.TYPE, ElementType.METHOD })
    @Retention(RetentionPolicy.RUNTIME)
    @Tag("UpdateSuccessful")
    @DisplayName("Update Successful")
    @Test
    @interface Successful {

    }

    @Target({ ElementType.TYPE, ElementType.METHOD })
    @Retention(RetentionPolicy.RUNTIME)
    @Tag("UpdateFail")
    @DisplayName("Update Fail")
    @Test
    @interface Fail {

    }

    @Target({ ElementType.TYPE, ElementType.METHOD })
    @Retention(RetentionPolicy.RUNTIME)
    @Tag("UpdatePrioritySuccessful")
    @DisplayName("Update Priority Successful")
    @Test
    @interface UpdatePriority {

    }

}
