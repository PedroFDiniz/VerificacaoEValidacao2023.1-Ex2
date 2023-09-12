package taskManager.test.tdd;

import org.junit.jupiter.api.Test;
import taskManager.main.Priority;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PriorityTest {
    @Test
    public void testPriorityEnum() {
        Priority high = Priority.HIGH;
        Priority medium = Priority.MEDIUM;
        Priority low = Priority.LOW;

        assertEquals(0, high.ordinal());
        assertEquals(1, medium.ordinal());
        assertEquals(2, low.ordinal());

        assertEquals("HIGH", high.toString());
        assertEquals("MEDIUM", medium.toString());
        assertEquals("LOW", low.toString());
    }
}
