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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import model.Favorite;
import model.Playlist;
import model.Podcast;
import podcastData.DataInitializer;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.BreakIterator;
import java.util.*;

public class MediaPlayerController implements Initializable {

    //------------------------------------------------------------------------------------
    // fields declaration                                                               |
    //------------------------------------------------------------------------------------

    //region FXML_FIELDS
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
    private Label durationMediaPlayer;

    @FXML
    private Label genreMediaPlayer;

    @FXML
    private Button previousButtonMediaPlayer;

    @FXML
    private Button replayButtonMediaPlayer;

    @FXML
    private Button suffleButtonMediaPlayer;

    @FXML
    public Label titleMediaPlayer;

    //endregion

    //region CLASS_FIELDS
    private Timer timer;
    private TimerTask task;

    public MediaPlayer mediaPlayer;
    public Media media;

    public static Label titleMediaPlayerStatic;
    public static Label podcasterMediaPlayerStatic;
    public static ImageView imgMediaPlayerStatic;
    public static Label durationMediaPlayerStatic;
    public static Label genreMediaPlayerStatic;
    public static Media mediaStatic;
    public MediaPlayer mediaPlayerStatic;

    public int count = 0;


    private File directory;
    private File[] files;

    private ArrayList<File> songs;

    private int songNumber;
    private boolean running;
    private boolean isShuffled; // not fixed yet

    //endregion

    //------------------------------------------------------------------------------------
    //  Methods declarations                                                             |
    //------------------------------------------------------------------------------------

    //region SETTER_PODCAST
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

    public static void setDurationMediaPlayerStatic(String duration) {
        MediaPlayerController.durationMediaPlayerStatic.setText(duration);
    }

    public static void setGenreMediaPlayerStatic(String genre) {
        MediaPlayerController.genreMediaPlayerStatic.setText(genre);
    }
    //endregion

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //region EVENT_ADD_PLAYLIST_BTN

        addPlaylistMediaPlayer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DialogPane addPlaylist;
                try {
                    addPlaylist = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/AddPlaylistDialog.fxml")));
                    Dialog<ButtonType> dialog = new Dialog<>();
                    dialog.setDialogPane(addPlaylist);
                    dialog.setTitle("Add to...");
                    dialog.initStyle(StageStyle.TRANSPARENT);

                    for (HBox playlist : Playlist.getPlaylistHBoxArr()){
                        // add playlist to container
                        AddPlaylistDialogController.staticPlaylistContainer.getChildren().add(playlist);
                    }

                    Optional<ButtonType> clickedButton = dialog.showAndWait();

                    // apply button in dialog clicked
                    if (clickedButton.get() == ButtonType.APPLY) {
                        for (HBox playlist : Playlist.getPlaylistHBoxArr()){
                            // add playlist to container

                        }
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        //endregion


        //region MEDIA_PLAYER_INIT
        titleMediaPlayerStatic = titleMediaPlayer;
        podcasterMediaPlayerStatic = podcasterMediaPlayer;
        imgMediaPlayerStatic = imgMediaPlayer;
        durationMediaPlayerStatic = durationMediaPlayer;
        genreMediaPlayerStatic = genreMediaPlayer;

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

        //endregion
    }

    //region MEDIA_PLAYER_BUTTON_ACTION
    @FXML
    void addToFavorite(MouseEvent event) throws Exception {

        System.out.println("Button is worked");

        FavoriteController favoriteController = new FavoriteController();
        favoriteController.addPodcastToFavorite();

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

    //endregion

    //region MEDIA_PLAYER_TIMER
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

    //endregion

}
