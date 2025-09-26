package edu.westga.cs1302.javafx_sample_starter.views;

import edu.westga.cs1302.javafx_sample_starter.model.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * Controller class for drawing various things to our canvas window.
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
  private ListView<Task> taskListView;

  /**
   * Perform any needed initialization of UI components and underlying objects.
   */
  public void initialize() {
    priorityComboBox.getItems().addAll("Low", "Medium", "High");
  }

  /**
   * Method to handle the Add Task button being pressed. Creates task and adds to
   * listView
   */
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

  private void showAlert(String message) {
    Alert alert = new Alert(AlertType.WARNING);
    alert.setTitle("Input Error");
    alert.setContentText(message);
    alert.showAndWait();
  }
}
