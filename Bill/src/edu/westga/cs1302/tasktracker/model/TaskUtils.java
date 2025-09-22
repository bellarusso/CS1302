package edu.westga.cs1302.tasktracker.model;

import javafx.collections.ObservableList;

/**
 * Utility class for performing operations on a list of tasks.
 */
public class TaskUtils {
  /**
    * Counts the number of tasks in the given list that match the specified priority.
    *
    * @param priority the priority to count (e.g., "High", "Medium", "Low")
    * @param tasks the ObservableList of Task objects to search
    * @return the number of tasks with the specified priority
    */
  public static int countTasks(String priority, ObservableList<Task> tasks) {
    int count = 0;
    for (Task t : tasks) {
      if (t.getPriority().equals(priority)) {
        count++;
      }
    }
    return count;
  }
   
    
  /**
     * Counts the number of tasks in the given list that have the specified priority.
     * This method currently duplicates the functionality of countTasks.
     *
     * @param priority the priority to count (e.g., "High", "Medium", "Low")
     * @param tasks the ObservableList of Task objects to search
     * @return the number of tasks with the specified priority
     */
  public static int countTasksByPriority(String priority, ObservableList<Task> tasks) {
    int count = 0;
    for (Task t : tasks) {
      if (t.getPriority().equals(priority)) {
        count++;
      }
    }
    return count;
  }
}
