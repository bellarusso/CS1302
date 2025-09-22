package edu.westga.cs1302.tasktracker.view;

import edu.westga.cs1302.tasktracker.model.Task;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class MainWindow {

    @FXML
    private TextField nameField;
    @FXML
    private TextArea descriptionField;
    @FXML
    private ComboBox<String> priorityBox;
    @FXML
    private ListView<Task> taskList;

    private ObservableList<Task> tasks;

    public void initialize() {
        tasks = FXCollections.observableArrayList();
        taskList.setItems(tasks);

        priorityBox.setItems(FXCollections.observableArrayList("Low", "Medium", "High"));
    }

    @FXML
    private void addTask() {
        String name = nameField.getText();
        String desc = descriptionField.getText();
        String priority = priorityBox.getValue();

        if (name != null && !name.isEmpty() && priority != null) {
            Task newTask = new Task(name, desc, priority);
            tasks.add(newTask);
            nameField.clear();
            descriptionField.clear();
            priorityBox.getSelectionModel().clearSelection();
        }
    }
}
