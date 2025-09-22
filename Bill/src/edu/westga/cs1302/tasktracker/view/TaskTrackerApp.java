package edu.westga.cs1302.tasktracker.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main entry point for the Task Tracker application.
 *
 * <p>This class extends {@link javafx.application.Application} and is responsible
 * for launching the JavaFX application, loading the main window FXML, and
 * displaying the primary stage.
 */
public class TaskTrackerApp extends Application {

  @Override
    public void start(Stage primaryStage) throws Exception {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
    Scene scene = new Scene(loader.load());
    primaryStage.setTitle("Task Tracker");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
  
  /**
   * The main method launches the JavaFX application.
   *
   * @param args command-line arguments (not used)
   */
  public static void main(String[] args) {
    launch(args);
  }
}
