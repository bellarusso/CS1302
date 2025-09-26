package edu.westga.cs1302.javafx_sample_starter.views;

import edu.westga.cs1302.javafx_sample_starter.model.Data;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * Controller class for the main window of the Task Tracker application. Handles
 * adding tasks and displaying selected task details.
 *
 * @author CS 1302
 * @version Fall 2025
 */
public class MainWindow {

  @FXML
  private TextField nameTextField;

  @FXML
  private TextArea descriptionTextArea;

  @FXML
  private ComboBox<String> priorityComboBox;

  @FXML
  private ListView<Data> taskListView;

  @FXML
  private TextArea selectedDescriptionTextArea;

  @FXML
  private TextField selectedPriorityTextField;

  @FXML
  public void initialize() {
    priorityComboBox.getItems().addAll("Low", "Medium", "High");

    taskListView.getSelectionModel().selectedItemProperty().addListener((obs, oldTask, newTask) -> {
      if (newTask != null) {
        selectedDescriptionTextArea.setText(newTask.getDescription());
        selectedPriorityTextField.setText(newTask.getPriority());
      } else {
        selectedDescriptionTextArea.clear();
        selectedPriorityTextField.clear();
      }
    });
  }

  @FXML
  private void handleAddTaskButton() {
    String name = nameTextField.getText();
    String description = descriptionTextArea.getText();
    String priority = priorityComboBox.getValue();

    if (name == null || name.trim().isEmpty()) {
      showAlert("Must enter name");
      return;
    }
    if (priority == null) {
      showAlert("Must select priority");
      return;
    }

    Data newTask = new Data(name, description, priority);
    taskListView.getItems().add(newTask);

    nameTextField.clear();
    descriptionTextArea.clear();
    priorityComboBox.getSelectionModel().clearSelection();
  }

  @FXML
  private void handleUpdateDescriptionButton() {
    Data selectedTask = taskListView.getSelectionModel().getSelectedItem();
    if (selectedTask != null) {
      showAlert("No task selected");
      return;
    }
    String newDescription = selectedDescriptionTextArea.getText();
    selectedTask.setDescription(newDescription);

    taskListView.refresh();
  }

  private void showAlert(String message) {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Input Error");
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.showAndWait();
  }
}
