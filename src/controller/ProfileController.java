package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import static staticUtility.DbUtils.getRetrievedName;

public class ProfileController implements Initializable {

    @FXML
    private BorderPane profilePane;

    @FXML
    private Label userNameLabel;

    @FXML
    public void editPfClicked(MouseEvent event) throws IOException {
        profilePane.setTop(null);
        BorderPane profileEdit = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/ProfileEdit.fxml")));
        profilePane.setCenter(profileEdit);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // set username label
        userNameLabel.setText(getRetrievedName());
    }
}
