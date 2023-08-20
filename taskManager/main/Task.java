package taskManager.main;

import java.time.LocalDate;
import java.util.UUID;

public class Task {
    private String title;
    private UUID id;
    private String description;
    private LocalDate date;
    private Priority priority;

    public Task(String title, String description, LocalDate date, Priority priority) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.description = description;
        this.date = date;
        this.priority = priority;
    }

    public UUID getId() {
        return  this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public Priority getPriority() {
        return this.priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
