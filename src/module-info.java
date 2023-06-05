module src.akara {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.media;
    requires javafaker;
    requires string.similarity;

    opens controller to javafx.fxml;
    exports controller;
}