package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class MediaPlayerController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private ImageView img;

    @FXML
    private Button nextButton;

    @FXML
    private Button playButton;

    @FXML
    private ProgressBar podcastProgressBar;

    @FXML
    private Label podcaster;

    @FXML
    private Button previousButton;

    @FXML
    private Button replayButton;

    @FXML
    private Button suffleButton;

    @FXML
    private Label title;

    private File directory;
    private File[] files;

    // TO-DO

    @FXML
    void nextMedia(ActionEvent event) {

    }

    @FXML
    void playMedia(ActionEvent event) {

    }

    @FXML
    void previousMedia(ActionEvent event) {

    }

    @FXML
    void replayMedia(ActionEvent event) {

    }

    @FXML
    void suffleMedia(ActionEvent event) {

    }
}
