package edu.westga.cs1302.javafx_sample_starter.model;

import java.util.List;

public class Task {

  /**
   * Counts the number of tasks with a given priority in a list.
   *
   * @param priority the priority to count
   * @param tasks    the list of tasks
   * @return the number of tasks with the specified priority
   */
  public static int countTasksByPriority(String priority, List<Data> tasks) {
    int count = 0;
    for (Data task : tasks) {
      if (priority.equals(task.getPriority())) {
        count++;
      }
    }
    return count;
  }
}