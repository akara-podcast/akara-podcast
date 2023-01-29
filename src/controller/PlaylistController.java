package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;

public class PlaylistController implements Initializable {

    @FXML
    private BorderPane playlistPane;

    private static BorderPane staticPlaylistPane;

    @FXML
    Button addButton;

    @FXML
    FlowPane playlistContainer;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        staticPlaylistPane = playlistPane;

        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DialogPane addPlaylist;
                try {
                    addPlaylist = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/AddPlaylistDialog.fxml")));
                    Dialog<ButtonType> dialog = new Dialog<>();
                    dialog.setDialogPane(addPlaylist);
                    dialog.setTitle("Add Playlist");
                    dialog.initStyle(StageStyle.TRANSPARENT);

                    Optional<ButtonType> clickedButton = dialog.showAndWait();

                    // apply button in dialog clicked
                    if (clickedButton.get() == ButtonType.APPLY) {
                        // check text field is empty
                        if (!AddPlaylistDialogController.staticLabel.getText().trim().equals("")) {
                            FXMLLoader fxmlLoader = new FXMLLoader();
                            fxmlLoader.setLocation(getClass().getResource("/view/PlaylistVBox.fxml"));
                            VBox playlist = fxmlLoader.load();

                            playlistVBoxController playlistVBoxController = fxmlLoader.getController();
                            // set data to playlist VBox
                            playlistVBoxController.setData(AddPlaylistDialogController.imgURL, AddPlaylistDialogController.staticLabel.getText());

                            // add playlist to container
                            playlistContainer.getChildren().add(playlist);
                        }
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        });
    }

    public static BorderPane getPlaylistPane() {
        return staticPlaylistPane;
    }
}
