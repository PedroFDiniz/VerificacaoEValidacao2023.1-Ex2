package taskManager.test.junit5Tests.tdd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import taskManager.main.Priority;
import taskManager.main.Task;
import taskManager.test.junit5Tests.interfaces.Create;
import taskManager.test.junit5Tests.interfaces.Get;
import taskManager.test.junit5Tests.interfaces.Set;
import taskManager.test.junit5Tests.interfaces.Uniques;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTestJ5 {

    @Create.Successful
    @Order(1)
    public void testCreateTask(){

        Task task = new Task("first", "EOF", LocalDate.parse("2023-08-20"), Priority.HIGH);

        assertAll(
                () -> assertEquals("first", task.getTitle()),
                () -> assertEquals("EOF", task.getDescription()),
                () -> assertEquals(LocalDate.parse("2023-08-20"), task.getDate()),
                () -> assertEquals(Priority.HIGH, task.getPriority())
        );

    }

    @Uniques.UniqueID
    @Order(2)
    public void testUniqueID(){
        Task task0 = new Task("first", "EOF", LocalDate.parse("2023-08-20"), Priority.HIGH);
        Task task1 = new Task("second", "EOW", LocalDate.parse("2023-08-21"), Priority.LOW);

        assertNotEquals(task0.getId(), task1.getId());
    }

    @Set.Title
    @Order(3)
    public void testSetTitle(){
        Task task = new Task("First", "EOF", LocalDate.parse("2023-08-20"), Priority.HIGH);

        String oldTitle = task.getTitle();
        String newTitle = "First update";

        task.setTitle(newTitle);

        assertAll(
                () -> assertNotEquals(oldTitle, task.getTitle()),
                () -> assertEquals(newTitle, task.getTitle())
        );

    }

    @Set.Description
    @Order(4)
    public void testSetDescription(){
        Task task = new Task("First", "EOF", LocalDate.parse("2023-08-20"), Priority.HIGH);

        String oldDescription = task.getDescription();
        String newDescription = "UPDATE";

        task.setDescription(newDescription);

        assertAll(
                () -> assertNotEquals(oldDescription, task.getDescription()),
                () -> assertEquals(newDescription, task.getDescription())
        );

    }

    @Set.Date
    @Order(5)
    public void testSetDate(){

        LocalDate data = LocalDate.parse("2023-08-20");
        Task task = new Task("First", "EOF", data, Priority.HIGH);

        LocalDate oldDate = task.getDate();
        String dateString = "2023-08-02";
        LocalDate newDate = LocalDate.parse(dateString);

        task.setDate(newDate);
        assertAll(
                () ->  assertNotEquals(oldDate, task.getDate()),
                () ->   assertEquals(newDate, task.getDate())
        );


    }
    @Set.Priority
    @Order(6)
    public void testSetPriority(){
        Task task = new Task("First", "EOF", LocalDate.parse("2023-08-20"), Priority.HIGH);

        Priority oldPriority = task.getPriority();
        Priority newPriority = Priority.LOW;

        task.setPriority(newPriority);

        assertAll(
                () -> assertNotEquals(oldPriority, task.getPriority()),
                () ->  assertEquals(newPriority, task.getPriority())
        );


    }

    @Get.Title
    @Order(7)
    public void testGetTitle(){
        String title = "First";
        Task task = new Task(title, "EOF", LocalDate.parse("2023-08-20"), Priority.HIGH);

        assertEquals(title, task.getTitle());

    }

    @Get.Description
    @Order(8)
    public void testGetDescription(){
        String description = "EOF";
        Task task = new Task("First", description, LocalDate.parse("2023-08-20"), Priority.HIGH);

        assertEquals(description, task.getDescription());

    }
    @Get.Date
    @Order(9)
    public void testGetDate(){
        LocalDate date = LocalDate.parse("2023-08-20");
        Task task = new Task("First", "EOF",date, Priority.HIGH);

        assertEquals(date, task.getDate());

    }
    @Get.Priority
    @Order(10)
    public void testGetPriority(){
        Priority priority = Priority.HIGH;
        Task task = new Task("First", "EOF", LocalDate.parse("2023-08-20"), priority);

        assertEquals(priority, task.getPriority());

    }

    @Test
    @Order(11)
    @DisplayName("To String")
    public void testToString(){
        Task task = new Task("First", "EOF", LocalDate.parse("2023-08-20"), Priority.HIGH);

        String expected = "\nTitle: First;\nDescription: EOF;\nDue Date: 2023-08-20;\nPriority: HIGH.\n";

        assertEquals(expected, task.toString());
    }
}
