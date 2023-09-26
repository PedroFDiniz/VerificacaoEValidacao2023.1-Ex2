package taskManager.test.junit5Tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import taskManager.main.Priority;
import taskManager.main.Task;
import taskManager.main.TaskManager;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Cases for Equivalence Partition")
public class EquivalencePartitionJ5 {

    private TaskManager taskManager;

    @BeforeEach
    public void setUp() {
        this.taskManager = new TaskManager();
    }


    @Nested
    @DisplayName("Test Cases for the method creat")
    class testCreateEquivalencePartition {

        @Test
        @DisplayName("All valid attributes - TC-EP-1")
        public void testCreateWithAllValidAttributesTask() {
            String title = "Task Test";
            String date = "2023-09-21";
            String description = "EOF";

            UUID taskID = taskManager.createTask(title, description, date, Priority.HIGH);
            Map<UUID,Task> tasks = taskManager.getTasks();

            assertEquals(1, tasks.size());
            assertEquals(title, taskManager.getTask(taskID).getTitle());
            assertEquals(description, taskManager.getTask(taskID).getDescription());
            assertEquals(LocalDate.parse(date), taskManager.getTask(taskID).getDate());
            assertEquals(Priority.HIGH, taskManager.getTask(taskID).getPriority());
        }

        @Test
        @DisplayName("Null title - TC-EP-2")
        void createTaskWithNullTitle() throws Exception {
            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.createTask(null, "EOF", "2023-08-25", Priority.LOW);
            });
        }

        @Test
        @DisplayName("Empty title - TC-EP-7")
        void createTaskWithEmptyTitle() throws Exception {
            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.createTask("", "EOF", "2023-08-25", Priority.LOW);
            });
        }
        @Test
        @DisplayName("Null description - TC-EP-3")
        void createTaskWithNullDescription() throws Exception {
            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.createTask("First", null, "2023-08-25", Priority.LOW);
            });
        }

        @Test
        @DisplayName("Empty description - TC-EP-8")
        void createTaskWithEmptyDescription() throws Exception {
            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.createTask("First", "", "2023-08-25", Priority.LOW);
            });
        }

        @Test
        @DisplayName("Null date - TC-EP-4")
        void createTaskWithNullDate() throws Exception {
            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.createTask("First", "EOF", null, Priority.LOW);
            });
        }

        @Test
        @DisplayName("Empty date - TC-EP-9")
        void createTaskWithEmptyDate() throws Exception {
            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.createTask("First", "EOF","", Priority.LOW);
            });
        }

        @Test
        @DisplayName("Null priority - TC-EP-5")
        void createTaskWithNullPriority() throws Exception {
            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.createTask("First", "EOF", "2023-08-25",null);
            });
        }

        @Test
        @DisplayName("Empty priority - TC-EP-10 ")
        void createTaskWithEmptyPriority() throws Exception {
            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.createTask("First", "EOF", "2023-08-25", Priority.valueOf(""));
            });
        }

        @Test
        @DisplayName("All Null Attributes - TC-EP-6")
        void createTaskWithAllAttributesNull() throws Exception {
            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.createTask(null, null, null,null);
            });
        }

        @Test
        @DisplayName("All Empty Attributes - TC-EP-11")
        void createTaskWithAllAttributesEmpty() throws Exception {
            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.createTask("", "", "",Priority.valueOf(""));
            });
        }

    }

    @Nested
    @DisplayName("Test Cases for the method setPriority")
    class testSetPriorityEquivalencePartition {

        @Test
        @DisplayName("All Valid Attributes - TC-EP-12")
        public void testChangePriorityAllValidAttributes() {
            UUID taskID0 = taskManager.createTask("Task 0", "EOF", "2023-08-25", Priority.LOW);
            taskManager.setTaskPriority(taskID0, Priority.MEDIUM);
            Map<UUID,Task> tasks = taskManager.getTasks();
            assertEquals(Priority.MEDIUM, tasks.get(taskID0).getPriority());
        }

        @Test
        @DisplayName("Valid ID and Null Priority - TC-EP-13")
        public void testChangePriorityValidIDNullPriority() {
            assertThrows(IllegalArgumentException .class, () -> {
                UUID taskID0 = taskManager.createTask("Task 0", "EOF", "2023-08-25", Priority.LOW);
                taskManager.setTaskPriority(taskID0, null);
            });
        }

        @Test
        @DisplayName("Valid ID and Empty Priority - TC-EP-14")
        public void testChangePriorityValidIDEmptyPriority() {
            assertThrows(IllegalArgumentException .class, () -> {
                UUID taskID0 = taskManager.createTask("Task 0", "EOF", "2023-08-25", Priority.LOW);
                taskManager.setTaskPriority(taskID0, Priority.valueOf(""));
            });
        }

        @Test
        @DisplayName("Null ID and Valid Priority - TC-EP-15")
        public void testChangePriorityNullIDValidPriority() {
            assertThrows(IllegalArgumentException .class, () -> {
                UUID taskID0 = taskManager.createTask("Task 0", "EOF", "2023-08-25", Priority.LOW);
                taskManager.setTaskPriority(null, Priority.HIGH);
            });
        }

        @Test
        @DisplayName("Empty ID and Valid Priority - TC-EP-16")
        public void testChangePriorityEmptyIDValidPriority() {
            assertThrows(IllegalArgumentException .class, () -> {
                UUID taskID0 = taskManager.createTask("Task 0", "EOF", "2023-08-25", Priority.LOW);
                taskManager.setTaskPriority(UUID.fromString(""), Priority.HIGH);
            });
        }
        @Test
        @DisplayName("NonExistent ID and Valid Priority - TC-EP-17")
        public void testChangePriorityIDValidPriorityNull() {
            assertThrows(IllegalArgumentException .class, () -> {
                UUID x = UUID.randomUUID();
                UUID taskID0 = taskManager.createTask("Task 0", "EOF", "2023-08-25", Priority.LOW);
                taskManager.setTaskPriority(x, Priority.HIGH);
            });
        }
    }

    @Nested
    @DisplayName("Test Cases for the method getTask and deleteTask")
    class testGetTaskAndDeleteTaskEquivalencePartition {

        @Test
        @DisplayName("Valid ID Get - TC-EP-18")
        public void testGetValidTaskID(){
            String title = "Task Test 1";
            String date = "2023-09-22";
            String description = "EOF1";

            UUID taskID = taskManager.createTask(title, description, date, Priority.HIGH);

            assertEquals(title, taskManager.getTask(taskID).getTitle());
            assertEquals(description, taskManager.getTask(taskID).getDescription());
            assertEquals(LocalDate.parse(date), taskManager.getTask(taskID).getDate());
            assertEquals(Priority.HIGH, taskManager.getTask(taskID).getPriority());
            assertEquals(1, taskManager.getTasks().size());
        }

        @Test
        @DisplayName("Valid ID Delete - TC-EP-18")
        public void testDeleteValidTaskID(){

            UUID taskID0 = taskManager.createTask("Task 0", "EOF", "2023-03-25", Priority.LOW);

            taskManager.deleteTask(taskID0);
            assertEquals(0, taskManager.getTasks().size());

            assertThrows(IllegalArgumentException.class, () -> {
                taskManager.getTask(taskID0);
            });
        }

        @Test
        @DisplayName("Null ID Get - TC-EP-19")
        public void testGetNullTaskID(){

            assertThrows(IllegalArgumentException.class, () -> {
                taskManager.getTask(null);
            });
        }


        @Test
        @DisplayName("Null ID Delete - TC-EP-19")
        public void testDeleteNullTaskID(){

            assertThrows(IllegalArgumentException.class, () -> {
                taskManager.deleteTask(null);
            });
        }

        @Test
        @DisplayName("Empty ID Get - TC-EP-20")
        public void testGetEmptyTaskID(){

            assertThrows(IllegalArgumentException.class, () -> {
                taskManager.getTask(UUID.fromString(""));
            });
        }


        @Test
        @DisplayName("Empty ID Delete - TC-EP-20")
        public void testDeleteEmptyTaskID(){

            assertThrows(IllegalArgumentException.class, () -> {
                taskManager.deleteTask(UUID.fromString(""));
            });
        }


        @Test
        @DisplayName("NonExistent ID Get - TC-EP-21")
        public void testGetNonExistentTaskID(){
            UUID id = UUID.randomUUID();

            assertThrows(IllegalArgumentException.class, () -> {
                taskManager.getTask(id);
            });
        }

        @Test
        @DisplayName("NonExistent ID Delete - TC-EP-21")
        public void testDeleteNonExistentTaskID(){
            UUID id = UUID.randomUUID();

            assertThrows(IllegalArgumentException.class, () -> {
                taskManager.deleteTask(id);
            });
        }
    }

    @Nested
    @DisplayName("Test Cases for the method listTasks")
    class testListTasksEquivalencePartition {

        @Test
        @DisplayName("Correct Order - TC-EP-22")
        public void testCorrectOrderListTasks() {

            UUID taskID0 = taskManager.createTask("Task 1", "Desc 1", "2023-01-10", Priority.HIGH);
            UUID taskID1 = taskManager.createTask("Task 2", "Desc 2", "2023-01-11", Priority.HIGH);

            List<Task> tasks = taskManager.listTasks();
            System.out.println(tasks);
            LocalDate previousDate = LocalDate.MIN;
            Priority previousPriority = null;

            for (Task task : tasks) {
                LocalDate currentDate = task.getDate();
                Priority currentPriority = task.getPriority();
                assertTrue(currentDate.isEqual(previousDate) || currentDate.isAfter(previousDate) ||
                        (currentDate.equals(previousDate) && currentPriority.compareTo(Objects.requireNonNull(previousPriority)) != 0));

                previousDate = currentDate;
                previousPriority = currentPriority;
            }

        }

        @Test
        @DisplayName("Incorrect Order - TC-EP-23")
        public void testIncorrectOrderListTasks() {

            UUID taskID0 = taskManager.createTask("Task 1", "Desc 1", "2023-01-10", Priority.HIGH);
            UUID taskID1 = taskManager.createTask("Task 2", "Desc 2", "2023-01-11", Priority.HIGH);

            List<Task> tasks = taskManager.listTasks();
            System.out.println(tasks);
            LocalDate previousDate = LocalDate.MIN;
            Priority previousPriority = null;

            for (Task task : tasks) {
                LocalDate currentDate = task.getDate();
                Priority currentPriority = task.getPriority();

                assert currentDate.isEqual(previousDate) || currentDate.isAfter(previousDate) ||
                        (currentDate.equals(previousDate) && currentPriority.compareTo(Objects.requireNonNull(previousPriority)) != 0) :
                        "The order of the list its incorrect.";

                previousDate = currentDate;
                previousPriority = currentPriority;
            }

        }

    }

    @Nested
    @DisplayName("Test Cases for the method updateTask")
    class testUpdateTasksEquivalencePartition {
        @Test
        @DisplayName("All Valid Attributes - TC-EP-26")
        public void testUpdateAllAttributesValidTask() {
            UUID taskID = taskManager.createTask("Task 0", "EOF", "2023-08-21", Priority.LOW);
            taskManager.updateTask(taskID, "Task 0 Updated", "EOW", "2023-08-20", Priority.HIGH);
            assertEquals("Task 0 Updated", taskManager.getTask(taskID).getTitle());
            assertEquals("EOW", taskManager.getTask(taskID).getDescription());
            assertEquals(LocalDate.parse("2023-08-20"), taskManager.getTask(taskID).getDate());
            assertEquals(Priority.HIGH, taskManager.getTask(taskID).getPriority());
        }

        @Test
        @DisplayName("Null Title - TC-EP-27")
        public void testUpdateWithNullTitle() {
            UUID taskID = taskManager.createTask("Task 0", "EOF", "2023-08-21", Priority.LOW);

            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.updateTask(taskID, null, "EOW", "2023-08-20", Priority.HIGH);
            });
        }
        @Test
        @DisplayName("Null Description - TC-EP-28")
        public void testUpdateWithNullDescription() {
            UUID taskID = taskManager.createTask("Task 0", "EOF", "2023-08-21", Priority.LOW);

            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.updateTask(taskID, "Task 0", null, "2023-08-20", Priority.HIGH);
            });
        }

        @Test
        @DisplayName("Null DueDate - TC-EP-29")
        public void testUpdateWithNullDueDate() {
            UUID taskID = taskManager.createTask("Task 0", "EOF", "2023-08-21", Priority.LOW);

            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.updateTask(taskID, "Task 0", "EOW", null, Priority.HIGH);
            });
        }

        @Test
        @DisplayName("Null Priority - TC-EP-30")
        public void testUpdateWithNullPriority() {
            UUID taskID = taskManager.createTask("Task 0", "EOF", "2023-08-21", Priority.LOW);

            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.updateTask(taskID, "Task 0", "EOW", "2023-08-20", null);
            });
        }

        @Test
        @DisplayName("Only Valid ID - TC-EP-31")
        public void testUpdateOnLyValidID() {
            UUID taskID = taskManager.createTask("Task 0", "EOF", "2023-08-21", Priority.LOW);

            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.updateTask(taskID, null, null, null, null);
            });
        }

        @Test
        @DisplayName("Only Null ID - TC-EP-32")
        public void testUpdateWithOnlyNullID() {
            UUID taskID = taskManager.createTask("Task 0", "EOF", "2023-08-21", Priority.LOW);

            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.updateTask(null, "Task 0", "EOW", "2023-08-20", Priority.MEDIUM);
            });
        }

        @Test
        @DisplayName("Empty ID  - TC-EP-33")
        public void testUpdateWithEmptyID() {
            UUID taskID = taskManager.createTask("Task 0", "EOF", "2023-08-21", Priority.LOW);

            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.updateTask(null, "Task 0", "EOW", "2023-08-20", Priority.MEDIUM);
            });
        }

    }
}
