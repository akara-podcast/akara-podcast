package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.Objects;


public class LoginController {
    @FXML
    private BorderPane loginPane;

    @FXML
    public void loginClicked(MouseEvent event) throws IOException {
        BorderPane profile = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/Profile.fxml")));
        loginPane.setCenter(profile);
    }


}
