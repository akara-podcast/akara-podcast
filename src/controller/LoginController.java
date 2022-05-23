package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;


public class LoginController implements Initializable {
    @FXML
    private BorderPane loginPane;

    @FXML
    public void loginClicked(MouseEvent event) throws IOException {
        BorderPane profile = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/Profile.fxml")));
        loginPane.setCenter(profile);
    }

    @FXML
    public void signUpClicked(MouseEvent event) throws IOException {
        BorderPane profile = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/SignUp.fxml")));
        loginPane.setCenter(profile);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
