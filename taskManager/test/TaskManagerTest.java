package taskManager.test;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class TaskManagerTest {

    private TaskManager taskManager;

    @BeforeEach
    public void setUp() {
        this.taskManager = new TaskManager();
    }

    @Test
    public void testCreateTask() {
        taskID = taskManager.createTask("Task Test", "EOF", "2023-08-21", Priority.HIGH);
        List<Task> tasks = taskManager.listTasks();
        assertEquals(1, tasks.size());
        assertEquals("Task Test", tasks.get(taskID).getTitle());
        assertEquals("EOF", tasks.get(taskID).getDescription());
        assertEquals(LocalDate.parse("2023-08-21"), tasks.get(taskID).getDueDate());
        assertEquals(Priority.HIGH, tasks.get(taskID).getPriority());
    }

    @Test
    public void testUpdateTask() {
        taskID = taskManager.createTask("Task 0", "EOF", "2023-08-21", Priority.LOW);
        taskManager.updateTask(taskID, "Task 0 Updated", "EOW", "2023-08-20", Priority.HIGH);
        List<Task> tasks = taskManager.listTasks();
        assertEquals("Task 0 Updated", tasks.get(taskID).getTitle());
        assertEquals("EOW", tasks.get(taskID).getDescription());
        assertEquals(LocalDate.parse("2023-08-20"), tasks.get(taskID).getDueDate());
        assertEquals(Priority.HIGH, tasks.get(taskID).getPriority());
    }

    @Test
    public void testDeleteTask() {
        taskID0 = taskManager.createTask("Task 0", "EOF", "2023-03-25", Priority.LOW);
        taskID1 = taskManager.createTask("Task 1", "EOW", "2023-03-24", Priority.HIGH);

        List<Task> tasks = taskManager.listTasks();
        assertEquals(2, tasks.size());

        taskManager.deleteTask(taskID0);
        assertEquals(1, tasks.size());

        assertEquals("Task 1", tasks.get(taskID).getTitle());
        assertEquals("EOW", tasks.get(taskID).getDescription());
        assertEquals(LocalDate.parse("2023-03-24"), tasks.get(taskID).getDueDate());
        assertEquals(Priority.LOW, tasks.get(taskID).getPriority());

    }

    @Test
    public void testListTasks() {
        taskID0 = taskManager.createTask("Task 0", "EOF", "2023-08-25", Priority.LOW);
        taskID1 = taskManager.createTask("Task 1", "EOW", "2023-06-24", Priority.MEDIUM);
        taskID2 = taskManager.createTask("Task 2", "EOL", "2023-01-26", Priority.HIGH);
        List<Task> tasks = taskManager.listTasks();
        assertEquals("Task 2", tasks.get(taskID0).getTitle());
        assertEquals("Task 1", tasks.get(taskID1).getTitle());
        assertEquals("Task 3", tasks.get(taskID2).getTitle());
    }

    @Test
    public void testChangePriority() {
        taskID0 = taskManager.createTask("Task 0", "EOF", "2023-08-25", Priority.LOW);
        taskManager.setTaskPriority(taskID0, Priority.MEDIUM);
        List<Task> tasks = taskManager.listTasks();
        assertEquals(Priority.HIGH, tasks.get(taskID0).getPriority());
    }
}
