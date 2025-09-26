package edu.westga.cs1302.javafx_sample_starter.views;

import edu.westga.cs1302.javafx_sample_starter.model.Data;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * Controller for Task Tracker MainWindow Handles adding tasks, displaying
 * selection, and updating description.
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
  private Label lowCountLabel;

  @FXML
  private Label mediumCountLabel;

  @FXML
  private Label highCountLabel;

  @FXML
  public void initialize() {
    // Initialize priority combo box
    priorityComboBox.getItems().addAll("Low", "Medium", "High");

    // When a task is selected, display its details
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

  /**
   * Adds a new task to the list using values from input fields
   */
  @FXML
  private void handleAddTaskButton(ActionEvent event) {
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

  /**
   * Updates the description of the currently selected task
   */
  @FXML
  private void handleUpdateDescriptionButton(ActionEvent event) {
    Data selectedTask = taskListView.getSelectionModel().getSelectedItem();
    if (selectedTask == null) {
      showAlert("No task selected");
      return;
    }

    String newDescription = selectedDescriptionTextArea.getText();
    selectedTask.setDescription(newDescription);

    taskListView.refresh();
  }

  @FXML
  private void handleRemoveTaskButton(ActionEvent event) {
    Data selectedTask = taskListView.getSelectionModel().getSelectedItem();
    if (selectedTask == null) {
      showAlert("No task selected");
      return;
    }

    taskListView.getItems().remove(selectedTask);

    selectedDescriptionTextArea.clear();
    selectedPriorityTextField.clear();
  }

  @FXML
  private void handleUpdateCountsButton(ActionEvent event) {
    int lowCount = 0;
    int mediumCount = 0;
    int highCount = 0;

    for (Data task : taskListView.getItems()) {
      String priority = task.getPriority();
      if ("Low".equals(priority)) {
        lowCount++;
      } else if ("Medium".equals(priority)) {
        mediumCount++;
      } else if ("High".equals(priority)) {
        highCount++;
      }
    }

    lowCountLabel.setText(String.valueOf(lowCount));
    mediumCountLabel.setText(String.valueOf(mediumCount));
    highCountLabel.setText(String.valueOf(highCount));
  }

  private void showAlert(String message) {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Input Error");
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.showAndWait();
  }

}
