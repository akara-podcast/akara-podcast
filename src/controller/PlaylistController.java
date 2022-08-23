package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.w3c.dom.events.MouseEvent;
import staticUtility.DbUtils;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;

public class PlaylistController implements Initializable {

    @FXML
    Button addButton;

    @FXML
    private void addClicked(MouseEvent event) throws IOException {
        DialogPane addPlaylist = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/AddPlaylistDialog.fxml")));
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setDialogPane(addPlaylist);
        dialog.setTitle("Add Playlist");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DialogPane addPlaylist;
                try {
                    addPlaylist = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/AddPlaylistDialog.fxml")));
                    Dialog<ButtonType> dialog = new Dialog<>();
                    dialog.setDialogPane(addPlaylist);
                    dialog.setTitle("Add Playlist");

                    Optional<ButtonType> clickedButton = dialog.showAndWait();

                    if (clickedButton.get() == ButtonType.APPLY) {

                    }

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        });
    }
}
