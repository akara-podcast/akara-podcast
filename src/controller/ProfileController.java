package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.Objects;

public class ProfileController {

    @FXML
    private BorderPane profilePane;

    @FXML
    public void editPfClicked(MouseEvent event) throws IOException {
        BorderPane profileEdit = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/ProfileEdit.fxml")));
        profilePane.setCenter(profileEdit);
    }
}
