package taskManager.test.functionalTests;

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

public class DecisionTableTests {

    private TaskManager taskManager;

    @BeforeEach
    public void setUp() {
        this.taskManager = new TaskManager();
    }

    @Nested
    @DisplayName("Test Cases for the 1 Conditions")
    class test1Conditions {

        String title = "Task Test";
        String date = "2023-09-21";
        String description = "EOF";
        Priority priority= Priority.HIGH;

        @Test
        @DisplayName("Create Successful")
        public void testCreate() {


            UUID taskID = taskManager.createTask(title, description, date, priority);
            Map<UUID,Task> tasks = taskManager.getTasks();

            assertEquals(1, tasks.size());
            assertEquals(title, taskManager.getTask(taskID).getTitle());
            assertEquals(description, taskManager.getTask(taskID).getDescription());
            assertEquals(LocalDate.parse(date), taskManager.getTask(taskID).getDate());
            assertEquals(Priority.HIGH, taskManager.getTask(taskID).getPriority());
        }

        @Test
        @DisplayName("Update Fail")
        public void testUpdateFailOnCondition1() {

            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.updateTask(null, "Task 0 Updated", "EOW", "2023-08-20", Priority.HIGH);
            });

        }

        @Test
        @DisplayName("Delete Fail")
        public void testDeleteFailOnCondition1() {

            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.deleteTask(null);
            });

        }

        @Test
        @DisplayName("Get Fail")
        public void testGetFailOnCondition1() {

            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.getTask(null);
            });

        }

        @Test
        @DisplayName("Set Priority Fail")
        public void testSetPriorityFailOnCondition1() {

            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.setTaskPriority(null, Priority.MEDIUM);
            });

        }

        @Test
        @DisplayName("List in Order")
        public void testListInOrderOnCondition1() {

            UUID taskID = taskManager.createTask(title, description, date, priority);

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


    }

    @Nested
    @DisplayName("Test Cases for the 2 Conditions")
    class test2Conditions {

        String title = null;
        String date = "2023-09-21";
        String description = "EOF";
        Priority priority= Priority.HIGH;

        @Test
        @DisplayName("Create Fail")
        public void testCreate() {

            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.createTask(title, description, date,priority);
            });
        }

        @Test
        @DisplayName("Update Fail")
        public void testUpdateFailOnCondition2() {

            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.updateTask(null, "Task 0 Updated", "EOW", "2023-08-20", Priority.HIGH);
            });

        }

        @Test
        @DisplayName("Delete Fail")
        public void testDeleteFailOnCondition2() {

            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.deleteTask(null);
            });

        }

        @Test
        @DisplayName("Get Fail")
        public void testGetFailOnCondition2() {

            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.getTask(null);
            });

        }

        @Test
        @DisplayName("Set Priority Fail")
        public void testSetPriorityFailOnCondition2() {

            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.setTaskPriority(null, Priority.MEDIUM);
            });

        }

        @Test
        @DisplayName("List in Order")
        public void testListInOrderOnCondition2() {

            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.createTask(title, description, date,priority);
            });

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


    }

    @Nested
    @DisplayName("Test Cases for the 3 Conditions")
    class test3Conditions {

        String title = "Test Test ";
        String date = "2023-09-21";
        String description = null;
        Priority priority= Priority.HIGH;

        @Test
        @DisplayName("Create Fail")
        public void testCreate() {

            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.createTask(title, description, date,priority);
            });
        }

        @Test
        @DisplayName("Update Fail")
        public void testUpdateFailOnCondition3() {

            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.updateTask(null, "Task 0 Updated", "EOW", "2023-08-20", Priority.HIGH);
            });

        }

        @Test
        @DisplayName("Delete Fail")
        public void testDeleteFailOnCondition3() {

            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.deleteTask(null);
            });

        }

        @Test
        @DisplayName("Get Fail")
        public void testGetFailOnCondition3() {

            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.getTask(null);
            });

        }

        @Test
        @DisplayName("Set Priority Fail")
        public void testSetPriorityFailOnCondition3() {

            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.setTaskPriority(null, Priority.MEDIUM);
            });

        }

        @Test
        @DisplayName("List in Order")
        public void testListInOrderOnCondition3() {

            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.createTask(title, description, date,priority);
            });

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


    }

    @Nested
    @DisplayName("Test Cases for the 4 Conditions")
    class test4Conditions {

        String title = "Test Test ";
        String date = "2023-09-21";
        String description = "only a test";
        Priority priority= null;

        @Test
        @DisplayName("Create Fail")
        public void testCreate() {

            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.createTask(title, description, date,priority);
            });
        }

        @Test
        @DisplayName("Update Fail")
        public void testUpdateFailOnCondition4() {

            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.updateTask(null, "Task 0 Updated", "EOW", "2023-08-20", Priority.HIGH);
            });

        }

        @Test
        @DisplayName("Delete Fail")
        public void testDeleteFailOnCondition4() {

            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.deleteTask(null);
            });

        }

        @Test
        @DisplayName("Get Fail")
        public void testGetFailOnCondition4() {

            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.getTask(null);
            });

        }

        @Test
        @DisplayName("Set Priority Fail")
        public void testSetPriorityFailOnCondition4() {

            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.setTaskPriority(null, Priority.MEDIUM);
            });

        }

        @Test
        @DisplayName("List in Order")
        public void testListInOrderOnCondition4() {

            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.createTask(title, description, date,priority);
            });

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


    }
    @Nested
    @DisplayName("Test Cases for the 5 Conditions")
    class test5Conditions {

        String title = "Test Test ";
        String date = null;
        String description = "only a test";
        Priority priority= Priority.HIGH;

        @Test
        @DisplayName("Create Fail")
        public void testCreate() {

            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.createTask(title, description, date,priority);
            });
        }

        @Test
        @DisplayName("Update Fail")
        public void testUpdateFailOnCondition5() {

            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.updateTask(null, "Task 0 Updated", "EOW", "2023-08-20", Priority.HIGH);
            });

        }

        @Test
        @DisplayName("Delete Fail")
        public void testDeleteFailOnCondition5() {

            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.deleteTask(null);
            });

        }

        @Test
        @DisplayName("Get Fail")
        public void testGetFailOnCondition5() {

            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.getTask(null);
            });

        }

        @Test
        @DisplayName("Set Priority Fail")
        public void testSetPriorityFailOnCondition5() {

            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.setTaskPriority(null, Priority.MEDIUM);
            });

        }

        @Test
        @DisplayName("List in Order")
        public void testListInOrderOnCondition5() {

            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.createTask(title, description, date,priority);
            });

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


    }
    @Nested
    @DisplayName("Test Cases for the 6 Conditions")
    class test6Conditions {

        String title = "Test Test ";
        String date = "2023-09-21";
        String description = "only a test"  ;
        Priority priority= Priority.HIGH;

        @Test
        @DisplayName("Create Successful")
        public void testCreateSuccessfulOnCondition6() {

            UUID taskID = taskManager.createTask(title, description, date, priority);
            Map<UUID,Task> tasks = taskManager.getTasks();

            assertEquals(1, tasks.size());
            assertEquals(title, taskManager.getTask(taskID).getTitle());
            assertEquals(description, taskManager.getTask(taskID).getDescription());
            assertEquals(LocalDate.parse(date), taskManager.getTask(taskID).getDate());
            assertEquals(Priority.HIGH, taskManager.getTask(taskID).getPriority());
        }

        @Test
        @DisplayName("Update Successful")
        public void testUpdateSuccessfulOnCondition6() {

            UUID taskID = taskManager.createTask(title, description, date, priority);
            taskManager.updateTask(taskID, "Task 0 Updated", "EOW", "2023-08-20", Priority.HIGH);
            assertEquals("Task 0 Updated", taskManager.getTask(taskID).getTitle());
            assertEquals("EOW", taskManager.getTask(taskID).getDescription());
            assertEquals(LocalDate.parse("2023-08-20"), taskManager.getTask(taskID).getDate());
            assertEquals(Priority.HIGH, taskManager.getTask(taskID).getPriority());

        }

        @Test
        @DisplayName("Delete Successful")
        public void testDeleteSuccessfulOnCondition6l() {
            UUID taskID = taskManager.createTask(title, description, date, priority);

            taskManager.deleteTask(taskID);
            assertEquals(0, taskManager.getTasks().size());

        }

        @Test
        @DisplayName("Get Successful")
        public void testGetSuccessfulOnCondition6() {

            UUID taskID = taskManager.createTask(title, description, date, Priority.HIGH);

            assertEquals(title, taskManager.getTask(taskID).getTitle());
            assertEquals(description, taskManager.getTask(taskID).getDescription());
            assertEquals(LocalDate.parse(date), taskManager.getTask(taskID).getDate());
            assertEquals(Priority.HIGH, taskManager.getTask(taskID).getPriority());
            assertEquals(1, taskManager.getTasks().size());

        }

        @Test
        @DisplayName("Set Priority Successful")
        public void testSetPrioritySuccessfulOnCondition6() {

            UUID taskID0 = taskManager.createTask("Task 0", "EOF", "2023-08-25", Priority.LOW);
            taskManager.setTaskPriority(taskID0, Priority.MEDIUM);
            Map<UUID,Task> tasks = taskManager.getTasks();
            assertEquals(Priority.MEDIUM, tasks.get(taskID0).getPriority());

        }

        @Test
        @DisplayName("List in Order")
        public void testListInOrderOnCondition6() {

            UUID taskID0 = taskManager.createTask("Task 0", "EOF", "2023-08-25", Priority.LOW);

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


    }
    @Nested
    @DisplayName("Test Cases for the 7 Conditions")
    class test7Conditions {

        String title = null;
        String date = null;
        String description = null;
        Priority priority= null;


        @Test
        @DisplayName("Create Fail")
        public void testCreateFailOnCondition7() {

            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.createTask(title, description, date, priority);
            });
        }

        @Test
        @DisplayName("Update Fail")
        public void testUpdateFailOnCondition7() {

            UUID taskID0 = taskManager.createTask("Task 0", "EOF", "2023-08-25", Priority.LOW);

            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.updateTask(taskID0, title, description, date, priority);
            });

        }

        @Test
        @DisplayName("Delete Successful")
        public void testDeleteFailOnCondition7() {

            UUID taskID0 = taskManager.createTask("Task 0", "EOF", "2023-08-25", Priority.LOW);

            taskManager.deleteTask(taskID0);
            assertEquals(0, taskManager.getTasks().size());

        }

        @Test
        @DisplayName("Get Successful")
        public void testGetSuccessfulOnCondition7() {

            String title1 = "Task 0";
            String description1 = "EOF";
            String date1 = "2023-08-25";
            Priority priority1 = Priority.LOW;

            UUID taskID0 = taskManager.createTask(title1, description1, date1, priority1);

            assertEquals(title1, taskManager.getTask(taskID0).getTitle());
            assertEquals(description1, taskManager.getTask(taskID0).getDescription());
            assertEquals(LocalDate.parse(date1), taskManager.getTask(taskID0).getDate());
            assertEquals(priority1, taskManager.getTask(taskID0).getPriority());
            assertEquals(1, taskManager.getTasks().size());

        }

        @Test
        @DisplayName("Set Priority Fail")
        public void testSetPriorityFailOnCondition7() {
            String title1 = "Task 0";
            String description1 = "EOF";
            String date1 = "2023-08-25";
            Priority priority1 = Priority.LOW;
            UUID taskID0 = taskManager.createTask(title1, description1, date1, priority1);
            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.setTaskPriority(taskID0, priority);
            });

        }

        @Test
        @DisplayName("List in Order")
        public void testListInOrderOnCondition7() {

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


    }
    @Nested
    @DisplayName("Test Cases for the 8 Conditions")
    class test8Conditions {

        String title = null;
        String date = null;
        String description = null;
        Priority priority= Priority.HIGH;

        @Test
        @DisplayName("Create Fail")
        public void testCreateFailsOnCondition8() {

            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.createTask(title, description, date,priority);
            });
        }

        @Test
        @DisplayName("Update Fail")
        public void testUpdateFailOnCondition8() {
            String title1 = "Task 0";
            String description1 = "EOF";
            String date1 = "2023-08-25";
            Priority priority1 = Priority.LOW;
            UUID taskID0 = taskManager.createTask(title1, description1, date1, priority1);

            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.updateTask(taskID0, title, description, date, priority);
            });

        }

        @Test
        @DisplayName("Delete Successful")
        public void testDeleteSuccessfulOnCondition8() {

            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.deleteTask(null);
            });

        }

        @Test
        @DisplayName("Get Fail")
        public void testGetSuccessfulOnCondition8() {

            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.getTask(null);
            });

        }

        @Test
        @DisplayName("Set Priority Successful")
        public void testSetPriorityFailOnCondition8() {
            String title1 = "Task 0";
            String description1 = "EOF";
            String date1 = "2023-08-25";
            Priority priority1 = Priority.LOW;

            UUID taskID0 = taskManager.createTask(title1, description1, date1, priority1);
            taskManager.setTaskPriority(taskID0, priority);
            Map<UUID,Task> tasks = taskManager.getTasks();
            assertEquals(priority, tasks.get(taskID0).getPriority());

        }

        @Test
        @DisplayName("List in Order")
        public void testListInOrderOnCondition8() {

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


    }

}