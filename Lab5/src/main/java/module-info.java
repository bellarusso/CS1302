module edu.westga.cs1302.lab5 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens edu.westga.cs1302.lab5.views to javafx.fxml;
    opens edu.westga.cs1302.lab5.persistence.student_data_persistence_manager to org.junit.jupiter.api;

    exports edu.westga.cs1302.lab5;
    exports edu.westga.cs1302.lab5.persistence.student_data_persistence_manager;
}
