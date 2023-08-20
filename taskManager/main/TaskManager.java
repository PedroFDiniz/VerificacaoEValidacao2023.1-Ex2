package taskManager.main;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;

public class TaskManager {

    private final Map<UUID, Task> tasks;

    public TaskManager() {
       this.tasks = new HashMap<>();
    }

    public UUID createTask(String title, String description, String date, Priority priority)  throws IllegalArgumentException {
        checkParam(title, description, date, priority);
        Task task = new Task(title, description, LocalDate.parse(date), priority);
        UUID taskID = task.getId();
        tasks.put(taskID, task);
        return taskID;
    }

    public List<Task> listTasks() {

        List<Task> tasksList = new ArrayList<>(this.tasks.values());

        Comparator<Task> taskComparator = Comparator.comparing(Task::getDate).thenComparing(Task::getPriority);

        tasksList.sort(taskComparator);

        return tasksList;
    }

    public Map<UUID, Task> getTasks() {
        return this.tasks;
    }

    public Task getTask(UUID taskID) {
        checkTaskID(taskID);
        return this.tasks.get(taskID);
    }

    public void deleteTask(UUID taskID) {
        checkTaskID(taskID);
        this.tasks.remove(taskID);
    }

    public void setTaskPriority(UUID taskID, Priority priority) {
        checkTaskID(taskID);
        Task task = this.tasks.get(taskID);
        task.setPriority(priority);
        this.tasks.replace(taskID, task);
    }

    public void updateTask(UUID taskID, String title, String description, String date, Priority priority) throws IllegalArgumentException {
        checkTaskID(taskID);
        checkParam(title, description, date, priority);
        Task task = this.tasks.get(taskID);
        task.setTitle(title);
        task.setDescription(description);
        task.setDate(LocalDate.parse(date));
        task.setPriority(priority);

    }

    private void checkParam(String title, String description, String date, Priority priority) throws IllegalArgumentException{
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException ("Title cannot be null or empty");
        }

        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException ("Description cannot be null or empty");
        }

        if (date == null || date.isEmpty()) {
            throw new IllegalArgumentException ("Date cannot be null or empty");
        }

        if (priority == null) {
            throw new IllegalArgumentException ("Priority cannot be null");
        }

        try {
            LocalDate.parse(date);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format");
        }

    }

    private void checkTaskID(UUID taskID) throws IllegalArgumentException{
        if (!tasks.containsKey(taskID)) {
            throw new IllegalArgumentException("Task with the given ID does not exist");
        }
    }
}
