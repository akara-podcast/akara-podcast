package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Podcast;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class PodcastHboxLongController implements Initializable {

    //------------------------------------------------------------------------------------
    // fields declaration                                                               |
    //------------------------------------------------------------------------------------

    @FXML
    private Label durationHboxLong;

    @FXML
    private Label genreHboxLong;

    @FXML
    private ImageView imgHboxLong;

    @FXML
    private Label podcasterHboxLong;

    @FXML
    private Label titleHboxLong;

    //------------------------------------------------------------------------------------
    //  Methods declaration                                                              |
    //------------------------------------------------------------------------------------

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setData(Podcast podcast) {

        // create an image object
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(podcast.getCover())));

        // set the image object to the image view
        imgHboxLong.setImage(image);

        // set the title text
        titleHboxLong.setText(podcast.getTitle());

        // set the description text
        podcasterHboxLong.setText(podcast.getPodcaster());

        genreHboxLong.setText(podcast.getGenre());

        durationHboxLong.setText(podcast.getDuration() + " min");
    }
}
