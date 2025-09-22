package edu.westga.cs1302.tasktracker.model;

/**
 * Represents a task with a name, description, and priority.
 *
 * <p>Tasks are immutable for name and priority, but the description can be updated.
 */
public class Task {
  private final String name;
  private final String priority;
  private String description;

  /**
   * Constructs a new Task with the given name, description, and priority.
   *
   * @param name the name of the task
   * @param description the task description
   * @param priority the task priority
   */
  
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
