package taskManager.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import taskManager.main.Priority;
import taskManager.main.Task;
import taskManager.main.TaskManager;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class TaskManagerTest {

    private TaskManager taskManager;

    @BeforeEach
    public void setUp() {
        this.taskManager = new TaskManager();
    }

    @Test
    public void testCreateTask() {
        UUID taskID = this.taskManager.createTask("Task Test", "EOF", "2023-08-21", Priority.HIGH);
        Map<UUID,Task> tasks = this.taskManager.getTasks();
        assertEquals(1, tasks.size());
        assertEquals("Task Test", this.taskManager.getTask(taskID).getTitle());
        assertEquals("EOF", this.taskManager.getTask(taskID).getDescription());
        assertEquals(LocalDate.parse("2023-08-21"), this.taskManager.getTask(taskID).getDate());
        assertEquals(Priority.HIGH, this.taskManager.getTask(taskID).getPriority());
    }

    @Test
    public void testUpdateTask() {
        UUID taskID = taskManager.createTask("Task 0", "EOF", "2023-08-21", Priority.LOW);
        taskManager.updateTask(taskID, "Task 0 Updated", "EOW", "2023-08-20", Priority.HIGH);
        assertEquals("Task 0 Updated", taskManager.getTask(taskID).getTitle());
        assertEquals("EOW", taskManager.getTask(taskID).getDescription());
        assertEquals(LocalDate.parse("2023-08-20"), taskManager.getTask(taskID).getDate());
        assertEquals(Priority.HIGH, taskManager.getTask(taskID).getPriority());
    }

    @Test
    public void testDeleteTask() {
        UUID taskID0 = taskManager.createTask("Task 0", "EOF", "2023-03-25", Priority.LOW);
        UUID taskID1 = taskManager.createTask("Task 1", "EOW", "2023-03-24", Priority.HIGH);

        Map<UUID,Task> tasks = taskManager.getTasks();
        assertEquals(2, tasks.size());

        taskManager.deleteTask(taskID0);
        assertEquals(1, tasks.size());

        assertEquals("Task 1", tasks.get(taskID1).getTitle());
        assertEquals("EOW", tasks.get(taskID1).getDescription());
        assertEquals(LocalDate.parse("2023-03-24"), tasks.get(taskID1).getDate());
        assertEquals(Priority.LOW, tasks.get(taskID1).getPriority());

    }

    @Test
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

        assertEquals("Task 2", tasks.get(0).getTitle());
        assertEquals("Task 1", tasks.get(1).getTitle());
        assertEquals("Task 0", tasks.get(2).getTitle());

    }

    @Test
    public void testChangePriority() {
        UUID taskID0 = taskManager.createTask("Task 0", "EOF", "2023-08-25", Priority.LOW);
        taskManager.setTaskPriority(taskID0, Priority.MEDIUM);
        Map<UUID,Task> tasks = taskManager.getTasks();
        assertEquals(Priority.HIGH, tasks.get(taskID0).getPriority());
    }
}
