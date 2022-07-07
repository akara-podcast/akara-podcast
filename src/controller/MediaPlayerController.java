package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class MediaPlayerController implements Initializable {

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

    @FXML
    private Media media;
    private MediaPlayer mediaPlayer;

    private File directory;
    private File[] files;

    private ArrayList<File> songs;

    private int songNumbers;

    private Timer timer;
    private TimerTask task;
    private boolean running;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        songs = new ArrayList<File>();

        directory = new File("podcastSound");

        files = directory.listFiles();

        if (files != null) {

            for (File file : files) {
                songs.add(file);
                System.out.println(file);
            }
        }

        media = new Media(songs.get(songNumbers).toURI().toString());
        mediaPlayer = new MediaPlayer(media);

        title.setText(songs.get(songNumbers).getName());
    }

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
