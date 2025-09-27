package edu.westga.cs1302.javafx_sample_starter.model;

/**
 * Represents a single Task with a name, description, and priority. Name and
 * priority are immutable. Description can be updated.
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
   * Creates a new Task with the given name, description, and priority.
   *
   * @param name        the name of the task
   * @param description the description of the task (can be empty)
   * @param priority    the priority of the task
   * 
   * @throws IllegalArgumentException if name or priority is null or empty
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

  @Override
  public String toString() {
    return this.name;
  }
}
