package taskManager.test.junit5Tests.tdd;

import org.junit.jupiter.api.*;
import taskManager.main.Priority;
import taskManager.main.Task;
import taskManager.main.TaskManager;
import taskManager.test.junit5Tests.interfaces.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("TDD - TaskManager Tests")
public class TaskManagerTestJ5 {

    private TaskManager taskManager;

    @BeforeEach
    public void setUp() {
        this.taskManager = new TaskManager();
    }

    @Create.Successful
    @Order(1)
    public void testCreateTask() {
        UUID taskID = this.taskManager.createTask("Task Test", "EOF", "2023-08-21", Priority.HIGH);
        Map<UUID,Task> tasks = this.taskManager.getTasks();

        assertAll(
                () -> assertEquals(1, tasks.size()),
                () -> assertEquals("Task Test", this.taskManager.getTask(taskID).getTitle()),
                () -> assertEquals("EOF", this.taskManager.getTask(taskID).getDescription()),
                () -> assertEquals(LocalDate.parse("2023-08-21"), this.taskManager.getTask(taskID).getDate()),
                () -> assertEquals(Priority.HIGH, this.taskManager.getTask(taskID).getPriority())
        );
    }

    @Update.Successful
    @Order(2)
    public void testUpdateTask() {
        UUID taskID = taskManager.createTask("Task 0", "EOF", "2023-08-21", Priority.LOW);
        taskManager.updateTask(taskID, "Task 0 Updated", "EOW", "2023-08-20", Priority.HIGH);
        assertAll(
                () -> assertEquals("Task 0 Updated", taskManager.getTask(taskID).getTitle()),
                () -> assertEquals("EOW", taskManager.getTask(taskID).getDescription()),
                () -> assertEquals(LocalDate.parse("2023-08-20"), taskManager.getTask(taskID).getDate()),
                () -> assertEquals(Priority.HIGH, taskManager.getTask(taskID).getPriority())
        );

    }

    @Delete.Successful
    @Order(6)
    public void testDeleteTask() {
        UUID taskID0 = taskManager.createTask("Task 0", "EOF", "2023-03-25", Priority.LOW);
        UUID taskID1 = taskManager.createTask("Task 1", "EOW", "2023-03-24", Priority.HIGH);

        Map<UUID,Task> tasks = taskManager.getTasks();
        assertEquals(2, tasks.size());

        taskManager.deleteTask(taskID0);

        assertAll(
                () -> assertEquals(1, tasks.size()),
                () -> assertEquals("Task 1", tasks.get(taskID1).getTitle()),
                () -> assertEquals("EOW", tasks.get(taskID1).getDescription()),
                () -> assertEquals(LocalDate.parse("2023-03-24"), tasks.get(taskID1).getDate()),
                () -> assertEquals(Priority.HIGH, tasks.get(taskID1).getPriority())
        );


    }

    @ListInOrder.ListSuccessful
    @Order(4)
    public void testListTasks() {
        UUID taskID0 = taskManager.createTask("Task 0", "EOF", "2023-08-25", Priority.LOW);
        UUID taskID1 = taskManager.createTask("Task 1", "EOW", "2023-06-24", Priority.MEDIUM);
        UUID taskID2 = taskManager.createTask("Task 2", "EOL", "2023-01-26", Priority.HIGH);

        List<Task> tasks = taskManager.listTasks();
        LocalDate previousDate = LocalDate.MIN;

        for (Task task : tasks) {
            LocalDate currentDate = task.getDate();
            assertTrue(currentDate.isEqual(previousDate) || currentDate.isAfter(previousDate));
            previousDate = currentDate;
        }

        assertAll(
                () -> assertEquals("Task 2", tasks.get(0).getTitle()),
                () -> assertEquals("Task 1", tasks.get(1).getTitle()),
                () -> assertEquals("Task 0", tasks.get(2).getTitle())
        );


    }

    @ListInOrder.Successful
    @Order(5)
    public void testTheOrderListTasks() {
        UUID taskID0 = taskManager.createTask("Task 0", "EOF", "2023-08-30", Priority.LOW);
        UUID taskID1 = taskManager.createTask("Task 1", "EOF", "2023-08-27", Priority.LOW);
        UUID taskID2 = taskManager.createTask("Task 2", "EOF", "2023-08-26", Priority.LOW);
        UUID taskID3 = taskManager.createTask("Task 3", "EOF", "2023-08-25", Priority.LOW);
        UUID taskID4 = taskManager.createTask("Task 4", "EOW", "2023-06-30", Priority.MEDIUM);
        UUID taskID5 = taskManager.createTask("Task 5", "EOW", "2023-06-27", Priority.MEDIUM);
        UUID taskID6 = taskManager.createTask("Task 6", "EOW", "2023-06-26", Priority.MEDIUM);
        UUID taskID7 = taskManager.createTask("Task 7", "EOW", "2023-06-25", Priority.MEDIUM);
        UUID taskID8 = taskManager.createTask("Task 8", "EOL", "2023-01-30", Priority.HIGH);
        UUID taskID9 = taskManager.createTask("Task 9", "EOL", "2023-01-27", Priority.HIGH);
        UUID taskID10 = taskManager.createTask("Task 10", "EOL", "2023-01-26", Priority.HIGH);
        UUID taskID11 = taskManager.createTask("Task 11", "EOL", "2023-01-25", Priority.HIGH);

        List<Task> tasks = taskManager.listTasks();
        System.out.println(tasks);
        LocalDate previousDate = LocalDate.MIN;
        Priority previousPriority = null;

        for (Task task : tasks) {
            LocalDate currentDate = task.getDate();
            Priority currentPriority = task.getPriority();
            assertTrue(currentDate.isEqual(previousDate) || currentDate.isAfter(previousDate) ||
                    (currentDate.equals(previousDate) && currentPriority.compareTo(previousPriority) != 0));

            previousDate = currentDate;
            previousPriority = currentPriority;
        }

    }

   @Update.UpdatePriority
    @Order(3)
    public void testChangePriority() {
        UUID taskID0 = taskManager.createTask("Task 0", "EOF", "2023-08-25", Priority.LOW);
        taskManager.setTaskPriority(taskID0, Priority.MEDIUM);
        Map<UUID,Task> tasks = taskManager.getTasks();
        assertEquals(Priority.MEDIUM, tasks.get(taskID0).getPriority());
    }

    @Create.Fail
    @Order(7)
    public void testCreateWithNullParameters(){
        assertThrows(IllegalArgumentException .class, () -> {
            taskManager.createTask(null, "EOF", "2023-08-25", Priority.LOW);
        });

        assertThrows(IllegalArgumentException .class, () -> {
            taskManager.createTask("First", null, "2023-08-25", Priority.LOW);
        });

        assertThrows(IllegalArgumentException .class, () -> {
             taskManager.createTask("First", "EOF", null, Priority.LOW);
        });

        assertThrows(IllegalArgumentException .class, () -> {
            taskManager.createTask("First", "EOF", "2023-08-25",null);
        });

        assertThrows(IllegalArgumentException .class, () -> {
            taskManager.createTask(null, null, null,null);
        });
    }

    @Test
    @WrongFormat.WrongFormatData
    @Order(8)
    public void testWrongDateFormat(){
        assertThrows(IllegalArgumentException.class, () -> {
            taskManager.createTask("First", "EOF", "25-08-2023", Priority.LOW);
        });

    }

    @Delete.DrainOut
    @Order(10)
    public void testDeleteTaskUntilDrainOut(){
        UUID taskID0 = taskManager.createTask("Task 0", "EOF", "2023-03-25", Priority.LOW);
        UUID taskID1 = taskManager.createTask("Task 1", "EOW", "2023-03-24", Priority.HIGH);

        assertEquals(2, taskManager.getTasks().size());

        taskManager.deleteTask(taskID0);
        assertEquals(1, taskManager.getTasks().size());

        taskManager.deleteTask(taskID1);
        assertTrue(taskManager.getTasks().isEmpty());
        assertNotNull(taskManager.getTasks());
    }

    @FalseID
    @Order(9)
    public void testCheckFalseTaskID(){
        UUID id = UUID.randomUUID();

        assertThrows(IllegalArgumentException.class, () -> {
            taskManager.getTask(id);
        });
    }


}
