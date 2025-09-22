package edu.westga.cs1302.tasktracker.model;

import javafx.collections.ObservableList;

public class TaskUtils {
    public static int countTasks(String priority, ObservableList<Task> tasks) {
        int count = 0;
        for (Task t : tasks) {
            if (t.getPriority().equals(priority)) {
                count++;
            }
        }
        return count;
    }
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
