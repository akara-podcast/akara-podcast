module src.akara {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.media;
    requires javafaker;
    requires string.similarity;

    opens controller to javafx.fxml;
    exports controller;
    exports controller.playlist;
    opens controller.playlist to javafx.fxml;
    exports controller.trending;
    opens controller.trending to javafx.fxml;
    exports controller.search;
    opens controller.search to javafx.fxml;
    exports controller.discover;
    opens controller.discover to javafx.fxml;
    exports controller.channel;
    opens controller.channel to javafx.fxml;
    exports controller.main;
    opens controller.main to javafx.fxml;
    exports controller.user;
    opens controller.user to javafx.fxml;
    exports controller.additional;
    opens controller.additional to javafx.fxml;
}