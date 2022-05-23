package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Podcast;

import java.util.Objects;

public class PodcastHboxController {

    @FXML
    private Label description;

    @FXML
    private ImageView img;

    @FXML
    private Label title;

    public void setData(Podcast podcast) {

        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(podcast.getCover())));
        img.setImage(image);
        title.setText(podcast.getTitle());
        description.setText(podcast.getDescription());
    }
}
