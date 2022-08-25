package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Podcast;

import java.util.Objects;

public class playlistVBoxController {

    @FXML
    private Button playlistButton;

    @FXML
    private ImageView playlistIMG;

    @FXML
    private Label playlistName;

    public void setData(String URL, String name) {
        Image image = new Image(Objects.requireNonNull(getClass().getResource(URL)).toString());

        playlistIMG.setImage(image);
        playlistName.setText(name);
    }
}
