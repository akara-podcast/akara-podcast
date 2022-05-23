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

public class SignUpController implements Initializable {
    @FXML
    private BorderPane signupPane;

    @FXML
    public void signUpClicked(MouseEvent event) throws IOException {
        BorderPane profile = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/Login.fxml")));
        signupPane.setCenter(profile);
    }

    @FXML
    public void loginSwitchClicked(MouseEvent event) throws IOException {
        BorderPane profile = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/Login.fxml")));
        signupPane.setCenter(profile);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
