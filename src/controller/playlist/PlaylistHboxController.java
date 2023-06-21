package controller.playlist;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

public class PlaylistHboxController {
    @FXML
    private ImageView playlistIMG;

    @FXML
    private Label playlistName;

    @FXML
    private CheckBox playlistCheckBox;



    public void setData(String URL, String name) {
        Image image = new Image(Objects.requireNonNull(getClass().getResource(URL)).toString());

        playlistIMG.setImage(image);
        playlistName.setText(name);
    }
}
