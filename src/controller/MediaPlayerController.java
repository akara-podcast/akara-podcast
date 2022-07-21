/*-----------------------------------------------------------------------------------------
 * NAME : MediaPlayerController.java
 * VER  : v0.1
 * PROJ : Akara
 *-----------------------------------------------------------------------------------------
 *                      H      I      S      T      O      R      Y
 *-----------------------------------------------------------------------------------------
 *   DATE        AUTHOR         DESCRIPTION
 * ----------  --------------  ------------------------------------------------------------
 * 2022-07-06   Nuth Vireak     creation
 * ----------  --------------  ---------------------------------------------------------
 * 2022-07-08   Nuth Vireak     Modification
 *---------------------------------------------------------------------------------------*/

package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import model.Podcast;
import org.w3c.dom.Text;

import java.io.File;
import java.net.URL;
import java.util.*;

public class MediaPlayerController implements Initializable {

    //------------------------------------------------------------------------------------
    // fields declaration                                                               |
    //------------------------------------------------------------------------------------

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
    public Label title;

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

    Podcast podcast = new Podcast();

    //------------------------------------------------------------------------------------
    //  Methods declarations                                                             |
    //------------------------------------------------------------------------------------

    public Label getTitle() {
        return title;
    }

    public void setTitle(Label title) {
        this.title = title;
    }

    public void setData(Podcast podcast) {

        // create an image object
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(podcast.getCover())));

        // set the image object to the image view
        img.setImage(image);

        // set the title text
        title.setText(podcast.getTitle());

    }

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

        title.setText(podcast.getTitle());
    }

    @FXML
    void playMedia() {

        beginTimer();
        mediaPlayer.play();
    }

    @FXML
    void previousMedia(ActionEvent event) {

        if (songNumbers > 0) {

            songNumbers--;

            mediaPlayer.stop();

            if (running) {
                cancelTimer();
            }

            media = new Media(songs.get(songNumbers).toURI().toString());
            mediaPlayer = new MediaPlayer(media);

            title.setText(songs.get(songNumbers).getName());

            playMedia();
        }
        else {

            songNumbers = songs.size() - 1;

            mediaPlayer.stop();

            media = new Media(songs.get(songNumbers).toURI().toString());
            mediaPlayer = new MediaPlayer(media);

            title.setText(songs.get(songNumbers).getName());

            playMedia();
        }
    }

    @FXML
    void nextMedia(ActionEvent event) {

        if (songNumbers < songs.size() - 1) {

            songNumbers++;

            mediaPlayer.stop();

            if (running) {
                cancelTimer();
            }

            media = new Media(songs.get(songNumbers).toURI().toString());
            mediaPlayer = new MediaPlayer(media);

            title.setText(songs.get(songNumbers).getName());

            playMedia();
        }
        else {

            songNumbers = 0;

            mediaPlayer.stop();

            if (running) {
                cancelTimer();
            }

            media = new Media(songs.get(songNumbers).toURI().toString());
            mediaPlayer = new MediaPlayer(media);

            title.setText(songs.get(songNumbers).getName());

            playMedia();
        }
    }

    @FXML
    void replayMedia(ActionEvent event) {

        podcastProgressBar.setProgress(0);
        mediaPlayer.seek(Duration.seconds(0));
    }

    @FXML
    void suffleMedia(ActionEvent event) {

    }

    public void beginTimer() {

        timer = new Timer();
        task = new TimerTask() {

            @Override
            public void run() {
                running = true;
                double current = mediaPlayer.getCurrentTime().toSeconds();
                double end = media.getDuration().toSeconds();
                System.out.println(current/end);
                podcastProgressBar.setProgress(current/end);

                if (current/end == 1) {
                    cancelTimer();
                }
            }
        };

        timer.scheduleAtFixedRate(task, 1000, 1000);
    }

    public void cancelTimer() {
        running = false;
        timer.cancel();
    }

}
