/*-----------------------------------------------------------------------------------------
 * NAME : MediaPlayerController.java
 * VER  : v0.1
 * PROJ : Akara
 * CODE CLEAN? : No
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

import podcastData.DataInitializer;

import java.io.File;
import java.net.URL;
import java.util.*;

public class MediaPlayerController implements Initializable {

    //------------------------------------------------------------------------------------
    // fields declaration                                                               |
    //------------------------------------------------------------------------------------

    @FXML
    private Button addFavoriteMediaPlayer;

    @FXML
    private Button addPlaylistMediaPlayer;

    @FXML
    private ImageView imgMediaPlayer;

    @FXML
    private Button nextButtonMediaPlayer;

    @FXML
    private Button playButtonMediaPlayer;

    @FXML
    private ProgressBar podcastProgressBar;

    @FXML
    private Label podcasterMediaPlayer;

    @FXML
    private Button previousButtonMediaPlayer;

    @FXML
    private Button replayButtonMediaPlayer;

    @FXML
    private Button suffleButtonMediaPlayer;

    @FXML
    private Label titleMediaPlayer;

    private Timer timer;
    private TimerTask task;

    public MediaPlayer mediaPlayer;
    public Media media;

    private static Label titleMediaPlayerStatic;
    private static Label podcasterMediaPlayerStatic;
    private static ImageView imgMediaPlayerStatic;
    public static Media mediaStatic;
    public MediaPlayer mediaPlayerStatic;

    public int count = 0;


    private File directory;
    private File[] files;

    private ArrayList<File> songs;

    private int songNumber;
    private boolean running;
    private boolean isShuffled; // not fixed yet

    //------------------------------------------------------------------------------------
    //  Methods declarations                                                             |
    //------------------------------------------------------------------------------------

    public static void setTitleMediaPlayerStatic(String titleMediaPlayerStatic) {
        MediaPlayerController.titleMediaPlayerStatic.setText(titleMediaPlayerStatic);
    }

    public static void setPodcasterMediaPlayerStatic(String podcasterMediaPlayerStatic) {
        MediaPlayerController.podcasterMediaPlayerStatic.setText(podcasterMediaPlayerStatic);
    }

    public static void setImgMediaPlayerStatic(Image imgMediaPlayerStatic) {
        MediaPlayerController.imgMediaPlayerStatic.setImage(imgMediaPlayerStatic);
    }

    public static void setMediaStatic(Media mediaStatic) {
        MediaPlayerController.mediaStatic = mediaStatic;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        titleMediaPlayerStatic = titleMediaPlayer;
        podcasterMediaPlayerStatic = podcasterMediaPlayer;
        imgMediaPlayerStatic = imgMediaPlayer;

        // check if media is null
        if (mediaStatic == null) {
            System.out.println("media is null");
        } else {
            System.out.println("media is not null");
        }

        songs = new ArrayList<File>();

        directory = new File("podcastSound");

        files = directory.listFiles();

        if(files != null) {
            songs.addAll(Arrays.asList(files));
        }

        media = new Media(songs.get(songNumber).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
    }

    @FXML
    void playMedia() {

        System.out.println(mediaStatic.getSource());

        // play media player if count is 0, else pause media player
        if (count == 0) {
            mediaPlayerStatic = new MediaPlayer(mediaStatic);
            beginTimer();
            mediaPlayerStatic.play();
            count++;
        } else {
            mediaPlayerStatic.pause();
            count--;
        }
    }

    @FXML
    void prevoiusMedia(ActionEvent event) {

        if(songNumber > 0) {

            songNumber--;

            mediaPlayer.stop();

            if(running) {

                cancelTimer();
            }

            media = new Media(songs.get(songNumber).toURI().toString());
            mediaPlayer = new MediaPlayer(media);

            DataInitializer dataInitializer = new DataInitializer();

            titleMediaPlayer.setText(dataInitializer.podcastList().get(songNumber).getTitle());
            podcasterMediaPlayer.setText(dataInitializer.podcastList().get(songNumber).getPodcaster());

            Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(dataInitializer.randomImage())));
            imgMediaPlayer.setImage(image);

            playMediaTest();
        }
        else {

            songNumber = songs.size() - 1;

            mediaPlayer.stop();

            if(running) {

                cancelTimer();
            }

            media = new Media(songs.get(songNumber).toURI().toString());
            mediaPlayer = new MediaPlayer(media);

            DataInitializer dataInitializer = new DataInitializer();

            titleMediaPlayer.setText(dataInitializer.podcastList().get(songNumber).getTitle());
            podcasterMediaPlayer.setText(dataInitializer.podcastList().get(songNumber).getPodcaster());

            Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(dataInitializer.randomImage())));
            imgMediaPlayer.setImage(image);

            playMediaTest();
        }
    }

    @FXML
    void nextMedia(ActionEvent event) {

        if(songNumber < songs.size() - 1) {

            songNumber++;

            mediaPlayer.stop();

            if(running) {

                cancelTimer();
            }

            media = new Media(songs.get(songNumber).toURI().toString());
            mediaPlayer = new MediaPlayer(media);

            DataInitializer dataInitializer = new DataInitializer();

            titleMediaPlayer.setText(songs.get(songNumber).getName());
            podcasterMediaPlayer.setText(dataInitializer.podcastList().get(songNumber).getPodcaster());

            Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(dataInitializer.randomImage())));
            imgMediaPlayer.setImage(image);

            playMediaTest();

        }
        else {

            songNumber = 0;

            mediaPlayer.stop();

            media = new Media(songs.get(songNumber).toURI().toString());
            mediaPlayer = new MediaPlayer(media);

            playMediaTest();
        }
    }

    @FXML
    void replayMedia(ActionEvent event) {
        podcastProgressBar.setProgress(0);
        mediaPlayerStatic.seek(Duration.seconds(0));
    }

    @FXML
    void suffleMedia(ActionEvent event) {

        // not fixed yet
    }

    public void beginTimer() {

        timer = new Timer();

        task = new TimerTask() {

            public void run() {

                running = true;
                double current = mediaPlayerStatic.getCurrentTime().toSeconds();
                double end = mediaStatic.getDuration().toSeconds();
                podcastProgressBar.setProgress(current/end);

                if(current/end == 1) {

                    cancelTimer();
                }
            }
        };

        timer.scheduleAtFixedRate(task, 0, 1000);
    }

    public void cancelTimer() {

        running = false;
        timer.cancel();
    }


    //------------------------------------------------------------------------------------
    // work but not working correctly just to test                                      |
    //------------------------------------------------------------------------------------

    private void playMediaTest() {
        beginTimerTest();
        mediaPlayer.play();
    }

    public void beginTimerTest() {

        timer = new Timer();

        task = new TimerTask() {

            public void run() {

                running = true;
                double current = mediaPlayer.getCurrentTime().toSeconds();
                double end = media.getDuration().toSeconds();
                podcastProgressBar.setProgress(current/end);

                if(current/end == 1) {

                    cancelTimer();
                }
            }
        };

        timer.scheduleAtFixedRate(task, 0, 1000);
    }

}
