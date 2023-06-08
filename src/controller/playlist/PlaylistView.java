package controller.playlist;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Favorite;
import model.Playlist;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class PlaylistView implements Initializable {

    @FXML
    private VBox podcastContainer;

    @FXML
    private ImageView playlistIMG;

    @FXML
    private Label playlistTitle;

    private static ImageView staticPlaylistIMG;
    private static Label staticPlaylistLabel;

    private static VBox staticVBoxContainer;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        staticVBoxContainer = podcastContainer;
    }


    public void setData(Image image, String name) {
        playlistIMG.setImage(image);
        playlistTitle.setText(name);
    }

    public void addPodcastToContainer(int id) {
        podcastContainer.getChildren().removeAll();
        for (HBox hBox : Playlist.getPlayListPodcastArr().get(id)) {
            podcastContainer.getChildren().add(hBox);
        }
    }
}
