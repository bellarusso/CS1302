package edu.westga.cs1302.tasktracker.model;

public class Task {
    private final String name;
    private final String priority;
    private String description;

    public Task(String name, String description, String priority) {
        this.name = name;
        this.description = description;
        this.priority = priority;
    }

    public String getName() {
        return this.name;
    }

    public String getPriority() {
        return this.priority;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
