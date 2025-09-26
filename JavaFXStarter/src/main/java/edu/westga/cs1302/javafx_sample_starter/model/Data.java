package edu.westga.cs1302.javafx_sample_starter.model;

/**
 * Represents a single Task with a name, description, and priority. Name and
 * priority are immutable after creation. Description can optionally be updated.
 * 
 * Subtask B – Business Logic for Storing a Task
 *
 * @author CS 1302
 * @version Fall 2025
 */
public class Data {

  private final String name;
  private String description;
  private final String priority;

  /**
   * Constructs a Data object for a Task.
   *
   * @param name        the task name (cannot be null or empty)
   * @param description the task description
   * @param priority    the task priority (cannot be null or empty)
   */
  public Data(String name, String description, String priority) {
    if (name == null || name.trim().isEmpty()) {
      throw new IllegalArgumentException("Task name cannot be empty");
    }
    if (priority == null || priority.trim().isEmpty()) {
      throw new IllegalArgumentException("Priority cannot be empty");
    }

    this.name = name;
    this.description = description != null ? description : "";
    this.priority = priority;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public String getPriority() {
    return priority;
  }

  public void setDescription(String description) {
    this.description = description != null ? description : "";
  }

  /**
   * Returns the name of the task.
   */
  @Override
  public String toString() {
    return this.name;
  }
}
