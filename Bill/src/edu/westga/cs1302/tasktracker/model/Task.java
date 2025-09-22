package edu.westga.cs1302.tasktracker.model;

public class Task {
    private final String name;
    private String description;
    private final String priority;

    public Task(String name, String description, String priority) {
        this.name = name;
        this.description = description;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return name;
    }
}
