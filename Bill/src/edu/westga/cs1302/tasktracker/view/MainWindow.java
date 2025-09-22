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

    // Fields for selected task
    @FXML
    private TextArea selectedDescriptionField; // editable for updating
    @FXML
    private TextField selectedPriorityField;   // read-only

    // Fields for counting tasks by priority
    @FXML
    private Label lowCountLabel;
    @FXML
    private Label mediumCountLabel;
    @FXML
    private Label highCountLabel;

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

    // Update description of selected task
    @FXML
    private void updateDescription() {
        Task selectedTask = taskList.getSelectionModel().getSelectedItem();
        if (selectedTask != null) {
            selectedTask.setDescription(selectedDescriptionField.getText());
            taskList.refresh();
        }
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

    @FXML
    private void countTasksByPriority() {
        int lowCount = TaskUtils.countTasks("Low", tasks);
        int mediumCount = TaskUtils.countTasks("Medium", tasks);
        int highCount = TaskUtils.countTasks("High", tasks);

        lowCountLabel.setText(String.valueOf(lowCount));
        mediumCountLabel.setText(String.valueOf(mediumCount));
        highCountLabel.setText(String.valueOf(highCount));
    }
}
