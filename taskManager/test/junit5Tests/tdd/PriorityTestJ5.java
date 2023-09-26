package taskManager.test.junit5Tests.tdd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import taskManager.main.Priority;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Priority Enum Test")
public class PriorityTestJ5 {
    @Test
    public void testPriorityEnum() {
        Priority high = Priority.HIGH;
        Priority medium = Priority.MEDIUM;
        Priority low = Priority.LOW;

        assertAll(

                () -> assertEquals(0, high.ordinal()),
                () ->assertEquals(1, medium.ordinal()),
                () ->assertEquals(2, low.ordinal()),

                () ->assertEquals("HIGH", high.toString()),
                () ->assertEquals("MEDIUM", medium.toString()),
                () ->assertEquals("LOW", low.toString())

        );

    }
}
