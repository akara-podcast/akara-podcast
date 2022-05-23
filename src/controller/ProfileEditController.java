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

public class ProfileEditController implements Initializable {

    @FXML
    private BorderPane profileEditPane;

    @FXML
    public void saveClicked(MouseEvent event) throws IOException {
        BorderPane profileEdit = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/Profile.fxml")));
        profileEditPane.setCenter(profileEdit);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
