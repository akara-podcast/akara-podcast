package controller.playlist;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.StageStyle;
import model.Playlist;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;

public class AddPlaylistDialogController implements Initializable {
    @FXML
    private Button addButton;

    @FXML
    private VBox playlistContainer;

    public static VBox staticPlaylistContainer;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        staticPlaylistContainer = playlistContainer;

        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DialogPane addPlaylist;
                try {
                    addPlaylist = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/playlist/CreatePlaylistDialog.fxml")));
                    Dialog<ButtonType> dialog = new Dialog<>();
                    dialog.setDialogPane(addPlaylist);
                    dialog.setTitle("Add Playlist");
                    dialog.initStyle(StageStyle.TRANSPARENT);

                    Optional<ButtonType> clickedButton = dialog.showAndWait();

                    // apply button in dialog clicked
                    if (clickedButton.get() == ButtonType.APPLY) {
                        // check text field is empty
                        if (!CreatePlaylistDialogController.staticLabel.getText().trim().equals("")) {
                            FXMLLoader fxmlLoader = new FXMLLoader();
                            fxmlLoader.setLocation(getClass().getResource("/view/playlist/PlaylistHBox.fxml"));
                            CheckBox playlist = fxmlLoader.load();

                            PlaylistHboxController playlistHBoxController = fxmlLoader.getController();
                            // set data to playlist VBox
                            playlistHBoxController.setData(CreatePlaylistDialogController.imgURL, CreatePlaylistDialogController.staticLabel.getText().trim());

                            // assignID
                            playlist.setId(Playlist.getID());

                            Playlist.setPlaylistHBoxArr(playlist);

                            // add playlist to container
                            playlistContainer.getChildren().add(playlist);

                            FXMLLoader fxmlLoader1 = new FXMLLoader();
                            fxmlLoader1.setLocation(getClass().getResource("/view/playlist/PlaylistVBox.fxml"));
                            VBox playlistV = fxmlLoader1.load();

                            PlaylistVBoxController playlistVBoxController = fxmlLoader1.getController();
                            // set data to playlist VBox
                            playlistVBoxController.setData(CreatePlaylistDialogController.imgURL, CreatePlaylistDialogController.staticLabel.getText().trim());

                            // assignID
                            playlistV.setId(Playlist.getID());
                            Playlist.increaseID();
                            // add new list to the list of the list
                            Playlist.addPlayListPodcastArr(new LinkedList<HBox>());
                            // add playlist to list
                            Playlist.setPlaylistToArr(playlistV);
                        }
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}