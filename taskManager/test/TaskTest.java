package taskManager.test;

import org.junit.jupiter.api.Test;
import taskManager.main.Priority;
import taskManager.main.Task;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TaskTest {

    @Test
    public void testCreateTask(){

        Task task = new Task("first", "EOF", LocalDate.parse("2023-08-20"), Priority.HIGH);

        assertEquals("first", task.getTitle());
        assertEquals("EOF", task.getDescription());
        assertEquals(LocalDate.parse("2023-08-20"), task.getDate());
        assertEquals(Priority.HIGH, task.getPriority());
    }

    @Test
    public void testUniqueID(){
        Task task0 = new Task("first", "EOF", LocalDate.parse("2023-08-20"), Priority.HIGH);
        Task task1 = new Task("second", "EOW", LocalDate.parse("2023-08-21"), Priority.LOW);

        assertNotEquals(task0.getId(), task1.getId());
    }
    @Test
    public void testUniqueIDWithEqualsTasks() {
        Task task0 = new Task("first", "EOF", LocalDate.parse("2023-08-20"), Priority.HIGH);
        Task task1 = new Task("first", "EOF", LocalDate.parse("2023-08-20"), Priority.HIGH);

        assertNotEquals(task0.getId(), task1.getId());
    }
    @Test
    public void testSetTitle(){
        Task task = new Task("First", "EOF", LocalDate.parse("2023-08-20"), Priority.HIGH);

        String oldTitle = task.getTitle();
        String newTitle = "First update";

        task.setTitle(newTitle);

        assertNotEquals(oldTitle, task.getTitle());
        assertEquals(newTitle, task.getTitle());
    }

    @Test
    public void testSetDescription(){
        Task task = new Task("First", "EOF", LocalDate.parse("2023-08-20"), Priority.HIGH);

        String oldDescription = task.getDescription();
        String newDescription = "UPDATE";

        task.setDescription(newDescription);

        assertNotEquals(oldDescription, task.getDescription());
        assertEquals(newDescription, task.getDescription());
    }

    @Test
    public void testSetDate(){

        LocalDate data = LocalDate.parse("2023-08-20");
        Task task = new Task("First", "EOF", data, Priority.HIGH);

        LocalDate oldDate = task.getDate();
        String dateString = "2023-08-02";
        LocalDate newDate = LocalDate.parse(dateString);

        task.setDate(newDate);

        assertNotEquals(oldDate, task.getDate());
        assertEquals(newDate, task.getDate());

    }
    @Test
    public void testSetPriority(){
        Task task = new Task("First", "EOF", LocalDate.parse("2023-08-20"), Priority.HIGH);

        Priority oldPriority = task.getPriority();
        Priority newPriority = Priority.LOW;

        task.setPriority(newPriority);

        assertNotEquals(oldPriority, task.getPriority());
        assertEquals(newPriority, task.getPriority());

    }

    @Test
    public void testGetTitle(){
        String title = "First";
        Task task = new Task(title, "EOF", LocalDate.parse("2023-08-20"), Priority.HIGH);

        assertEquals(title, task.getTitle());

    }

    @Test
    public void testGetDescription(){
        String description = "EOF";
        Task task = new Task("First", description, LocalDate.parse("2023-08-20"), Priority.HIGH);

        assertEquals(description, task.getDescription());

    }
    @Test
    public void testGetDate(){
        LocalDate date = LocalDate.parse("2023-08-20");
        Task task = new Task("First", "EOF",date, Priority.HIGH);

        assertEquals(date, task.getDate());

    }
    @Test
    public void testGetPriority(){
        Priority priority = Priority.HIGH;
        Task task = new Task("First", "EOF", LocalDate.parse("2023-08-20"), priority);

        assertEquals(priority, task.getPriority());

    }

    @Test
    public void testToString(){
        Task task = new Task("First", "EOF", LocalDate.parse("2023-08-20"), Priority.HIGH);

        String expected = "\nTitle: First;\nDescription: EOF;\nDue Date: 2023-08-20;\nPriority: HIGH.\n";

        assertEquals(expected, task.toString());
    }
}
