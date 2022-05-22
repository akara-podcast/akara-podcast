package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.Objects;

public class ProfileEditController {

    @FXML
    private BorderPane profileEditPane;

    @FXML
    public void saveClicked(MouseEvent event) throws IOException {
        BorderPane profileEdit = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/Profile.fxml")));
        profileEditPane.setCenter(profileEdit);
    }
}
