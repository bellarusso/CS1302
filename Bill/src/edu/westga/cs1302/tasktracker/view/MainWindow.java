package edu.westga.cs1302.tasktracker.view;

import edu.westga.cs1302.tasktracker.model.Task;
import edu.westga.cs1302.tasktracker.model.TaskUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class MainWindow {

    // Input fields for adding a new task
    @FXML
    private TextField nameField;
    @FXML
    private TextArea descriptionField;
    @FXML
    private ComboBox<String> priorityBox;
    @FXML
    private ListView<Task> taskList;

    @FXML
    private TextArea selectedDescriptionField;
    @FXML
    private TextField selectedPriorityField;

    @FXML
    private TextField lowCountField;
    @FXML
    private TextField mediumCountField;
    @FXML
    private TextField highCountField;

    private ObservableList<Task> tasks;

    @FXML
    public void initialize() {
        tasks = FXCollections.observableArrayList();
        taskList.setItems(tasks);

        priorityBox.setItems(FXCollections.observableArrayList("Low", "Medium", "High"));

        taskList.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                selectedDescriptionField.setText(newSelection.getDescription());
                selectedPriorityField.setText(newSelection.getPriority());
            } else {
                selectedDescriptionField.clear();
                selectedPriorityField.clear();
            }
        });
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

    @FXML
    private void updateDescription() {
        Task selectedTask = taskList.getSelectionModel().getSelectedItem();
        if (selectedTask != null) {
            selectedTask.setDescription(selectedDescriptionField.getText());
            taskList.refresh();
        }
    }

    @FXML
    private void countTasks() {
        lowCountField.setText(String.valueOf(TaskUtils.countTasksByPriority("Low", tasks)));
        mediumCountField.setText(String.valueOf(TaskUtils.countTasksByPriority("Medium", tasks)));
        highCountField.setText(String.valueOf(TaskUtils.countTasksByPriority("High", tasks)));
    }
@FXML
private void removeTask() {
    Task selectedTask = taskList.getSelectionModel().getSelectedItem();
    if (selectedTask != null) {
        tasks.remove(selectedTask);
        selectedDescriptionField.clear();
        selectedPriorityField.clear();
    }
}
}
