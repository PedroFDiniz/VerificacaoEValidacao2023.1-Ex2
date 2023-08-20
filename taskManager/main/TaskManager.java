package taskManager.main;

import javax.swing.*;
import java.time.LocalDate;
import java.util.*;

public class TaskManager {

    private Map<UUID, Task> tasks;

    public TaskManager() {
       this.tasks = new HashMap<>();
    }

    public UUID createTask(String title, String description, String date, Priority priority){
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
        return this.tasks.get(taskID);
    }

    public void deleteTask(UUID taskID) {
        this.tasks.remove(taskID);
    }

    public void setTaskPriority(UUID taskID, Priority priority) {
        Task task = this.tasks.get(taskID);
        task.setPriority(priority);
        this.tasks.replace(taskID, task);
    }

    public void updateTask(UUID taskID, String title, String description, String date, Priority priority) {
        Task task = this.tasks.get(taskID);
        task.setTitle(title);
        task.setDescription(description);
        task.setDate(LocalDate.parse(date));
        task.setPriority(priority);

    }
}
