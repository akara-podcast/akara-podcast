package controller.playlist;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class PlaylistVBoxController implements Initializable {

    @FXML
    private VBox playlistVBox;

    @FXML
    private Button playlistButton;

    @FXML
    private ImageView playlistIMG;

    @FXML
    private Label playlistName;

    // static
    public static ImageView playlistImgStatic;
    public static Label playlistNameStatic;

    public void setData(String URL, String name) {
        Image image = new Image(Objects.requireNonNull(getClass().getResource(URL)).toString());

        playlistIMG.setImage(image);
        playlistName.setText(name);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        playlistImgStatic = playlistIMG;
        playlistNameStatic = playlistName;

        playlistButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int id = Integer.parseInt(playlistVBox.getId());
                BorderPane playlistView;
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("/view/playlist/PlaylistView.fxml"));
                    playlistView = fxmlLoader.load();

                    PlaylistView playlistViewController = fxmlLoader.getController();
                    // set data to playlist VBox
                    playlistViewController.setData(playlistIMG.getImage(), playlistName.getText());


                    playlistViewController.addPodcastToContainer(id);

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                PlaylistController.getPlaylistPane().setTop(null);
                PlaylistController.getPlaylistPane().setCenter(playlistView);


            }
        });

    }
}
