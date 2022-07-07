module src.akara {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.media;

    opens controller to javafx.fxml;
    exports controller;
}