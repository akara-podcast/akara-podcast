package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class PlaylistView implements Initializable {

    @FXML
    private ImageView playlistIMG;

    @FXML
    private Label playlistTitle;

    private static ImageView staticPlaylistIMG;
    private static Label staticPlaylistLabel;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }


    public void setData(Image image, String name) {
        playlistIMG.setImage(image);
        playlistTitle.setText(name);
    }
}
