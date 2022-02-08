module src.akara {
    requires javafx.controls;
    requires javafx.fxml;


    opens controller to javafx.fxml;
    exports controller;
}