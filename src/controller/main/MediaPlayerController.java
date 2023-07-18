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

package controller.main;

import controller.additional.FavoriteController;
import controller.playlist.AddPlaylistDialogController;
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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import model.Playlist;
import model.RecentlyPlayed;
import podcastData.DataInitializer;

import java.io.*;
import java.net.URL;
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
    private ImageView playImg;

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
    private Button shuffleButtonMediaPlayer;

    @FXML
    public Label titleMediaPlayer;

    //endregion

    //region CLASS_FIELDS
    private static Timer timer;
    private static TimerTask task;

    public MediaPlayer mediaPlayer;
    public Media media;

    public static Label titleMediaPlayerStatic;
    public static Label podcasterMediaPlayerStatic;
    public static ImageView imgMediaPlayerStatic;
    public static Label durationMediaPlayerStatic;
    public static Label genreMediaPlayerStatic;
    public static Media mediaStatic;
    public static MediaPlayer mediaPlayerStatic;

    public static ImageView staticPlayImg;

    public static ProgressBar podcastProgressBarStatic;

    public static boolean isPlaying = false;

    private static ImageView oldPlay;


    private File directory;
    private File[] files;

    private static ArrayList<File> songs;

    private static int songNumber = 0;
    private static boolean running;
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

    public static void setMediaStatic(Media media, File file) {
        // pause current media play
        if (isPlaying) {
            staticPlayImg.setImage(new Image(Objects.requireNonNull(MediaPlayerController.class.getResource("/image/play.png")).toString()));
            mediaPlayerStatic.pause();
            timer.cancel();
            isPlaying = false;
        }

        // replace new media
        mediaStatic = media;
        mediaPlayerStatic = new MediaPlayer(media);

        // add file to songs
        songs.add(songNumber + 1, file);
        songNumber++;

        // play new one
        if (!isPlaying) {
            staticPlayImg.setImage(new Image(Objects.requireNonNull(MediaPlayerController.class.getResource("/image/pause.png")).toString()));
            System.out.println(mediaStatic.getSource());
            mediaPlayerStatic = new MediaPlayer(mediaStatic);
            beginTimer();
            mediaPlayerStatic.play();
            isPlaying = true;
        }
    }

    public static void pauseMedia() {
        // pause current media play
        if (isPlaying) {
            staticPlayImg.setImage(new Image(Objects.requireNonNull(MediaPlayerController.class.getResource("/image/play.png")).toString()));
            mediaPlayerStatic.stop();
            timer.cancel();
            isPlaying = false;
        }
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
                    addPlaylist = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/playlist/AddPlaylistDialog.fxml")));
                    Dialog<ButtonType> dialog = new Dialog<>();
                    dialog.setDialogPane(addPlaylist);
                    dialog.setTitle("Add to...");
                    dialog.initStyle(StageStyle.TRANSPARENT);

                    for (CheckBox playlist : Playlist.getPlaylistHBoxArr()) {
                        playlist.setSelected(false);
                        // add playlist to container
                        AddPlaylistDialogController.staticPlaylistContainer.getChildren().add(playlist);
                    }

                    Optional<ButtonType> clickedButton = dialog.showAndWait();

                    // apply button in dialog clicked
                    if (clickedButton.get() == ButtonType.APPLY) {
                        for (CheckBox playlist : Playlist.getPlaylistHBoxArr()) {
                            // add playlist to container
                            if (playlist.isSelected()) {
                                int id = Integer.parseInt(playlist.getId());
                                List<HBox> playlistArr = Playlist.getPlayListPodcastArr().get(id);

                                FXMLLoader fxmlLoader = new FXMLLoader();
                                fxmlLoader.setLocation(FavoriteController.class.getResource("/view/main/podcastHboxLong.fxml"));
                                HBox hBox = fxmlLoader.load();


                                //set hello to the text of the label in the podcastHboxLong.fxml
                                PodcastHboxLongController.titleHboxLongStatic.setText(MediaPlayerController.titleMediaPlayerStatic.getText());
                                PodcastHboxLongController.podcasterHboxLongStatic.setText(MediaPlayerController.podcasterMediaPlayerStatic.getText());
                                PodcastHboxLongController.genreHboxLongStatic.setText(MediaPlayerController.genreMediaPlayerStatic.getText());
                                PodcastHboxLongController.durationHboxLongStatic.setText(MediaPlayerController.durationMediaPlayerStatic.getText() + " min");
                                PodcastHboxLongController.imgHboxLongStatic.setImage(MediaPlayerController.imgMediaPlayerStatic.getImage());

                                // Add add song to list
                                playlistArr.add(hBox);

                                // add list to the list of the list
                                Playlist.setPlayListPodcastArr(id, playlistArr);

                                Playlist.printLength();
                                System.out.println();
                            }

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
        podcastProgressBarStatic = podcastProgressBar;
        staticPlayImg = playImg;

        // check if media is null
        if (mediaStatic == null) {
            System.out.println("media is null");
        } else {
            System.out.println("media is not null");
        }

        songs = new ArrayList<File>();

        directory = new File("podcastSound");

        files = directory.listFiles();

        if (files != null) {
            System.out.println("It's not null!");
            songs.addAll(Arrays.asList(files));
        }

        media = new Media(songs.get(songNumber).toURI().toString());
        mediaPlayer = new MediaPlayer(media);

        mediaStatic = media;
        mediaPlayerStatic = mediaPlayer;

        DataInitializer dataInitializer = new DataInitializer();

        titleMediaPlayer.setText(dataInitializer.podcastList().get(songNumber).getTitle());
        podcasterMediaPlayer.setText(dataInitializer.podcastList().get(songNumber).getPodcaster());

        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(dataInitializer.randomImage())));
        imgMediaPlayer.setImage(image);
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


        // play media player if count is 0, else pause media player
        if (!isPlaying) {
            staticPlayImg.setImage(new Image(Objects.requireNonNull(getClass().getResource("/image/pause.png")).toString()));
            System.out.println(mediaStatic.getSource());
            beginTimer();
            mediaPlayerStatic.play();
            isPlaying = true;
        } else {
            staticPlayImg.setImage(new Image(Objects.requireNonNull(getClass().getResource("/image/play.png")).toString()));
            mediaPlayerStatic.pause();
            cancelTimer();
            isPlaying = false;
        }
    }

    @FXML
    void prevoiusMedia(ActionEvent event) {


        if (songNumber > 0) {
            mediaPlayerStatic.stop();

            songNumber--;

            if (running) {
                cancelTimer();
            }

            mediaStatic = new Media(songs.get(songNumber).toURI().toString());
            mediaPlayerStatic = new MediaPlayer(mediaStatic);

            DataInitializer dataInitializer = new DataInitializer();

            titleMediaPlayer.setText(dataInitializer.podcastList().get(songNumber).getTitle());
            podcasterMediaPlayer.setText(dataInitializer.podcastList().get(songNumber).getPodcaster());

            Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(dataInitializer.randomImage())));
            imgMediaPlayer.setImage(image);

            playMediaTest();
        } else {

            songNumber = songs.size() - 1;

            mediaPlayerStatic.stop();

            if (running) {

                cancelTimer();
            }

            mediaStatic = new Media(songs.get(songNumber).toURI().toString());
            mediaPlayerStatic = new MediaPlayer(mediaStatic);

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

        if (songNumber < songs.size() - 1) {

            songNumber++;

            mediaPlayerStatic.stop();

            if (running) {

                cancelTimer();
            }

            mediaStatic = new Media(songs.get(songNumber).toURI().toString());
            mediaPlayerStatic = new MediaPlayer(mediaStatic);

            DataInitializer dataInitializer = new DataInitializer();

            titleMediaPlayer.setText(songs.get(songNumber).getName());
            podcasterMediaPlayer.setText(dataInitializer.podcastList().get(songNumber).getPodcaster());

            Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(dataInitializer.randomImage())));
            imgMediaPlayerStatic.setImage(image);

            playMediaTest();

        } else {

            songNumber = 0;

            mediaPlayerStatic.stop();

            mediaStatic = new Media(songs.get(songNumber).toURI().toString());
            mediaPlayerStatic = new MediaPlayer(mediaStatic);

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

    //#region WRITE_TO_FILE
    public static void writeToFile(RecentlyPlayed podcast){
        File recentFile = new File("src/podcastData/recentPlayed.txt");
        List<RecentlyPlayed> recentlyPlayedList = new ArrayList<RecentlyPlayed>();

        try {
            if (new BufferedReader(new FileReader(recentFile)).readLine() == null){
                System.out.println("No recently played found!");
            }
            else {
                FileInputStream fi = new FileInputStream(recentFile);
                ObjectInputStream oi = new ObjectInputStream(fi);
                List<RecentlyPlayed> recentlyPlayed = (List<RecentlyPlayed>) oi.readObject();
                recentlyPlayedList.addAll(recentlyPlayed);
                oi.close();
                fi.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        if (recentFile.isFile()) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(recentFile);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

                recentlyPlayedList.add(podcast);
                // write chav
                objectOutputStream.writeObject(recentlyPlayedList);

                objectOutputStream.close();
                fileOutputStream.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else { // create a file if it's not exist

            try {
                if (recentFile.createNewFile()) {
                    System.out.println("File created: " + recentFile.getName());
                } else {
                    System.out.println("File already exists.");
                }
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
    }
    //#endregion

    //region MEDIA_PLAYER_TIMER
    public static void beginTimer() {

        timer = new Timer();

        task = new TimerTask() {

            public void run() {

                running = true;
                double current = mediaPlayerStatic.getCurrentTime().toSeconds();
                double end = mediaStatic.getDuration().toSeconds();
                podcastProgressBarStatic.setProgress(current / end);

                if (current / end == 1) {

                    cancelTimer();
                }
            }
        };

        timer.scheduleAtFixedRate(task, 0, 1000);
    }

    public static void cancelTimer() {

        running = false;
        timer.cancel();
    }


    //------------------------------------------------------------------------------------
    // work but not working correctly just to test                                      |
    //------------------------------------------------------------------------------------

    private void playMediaTest() {
        beginTimerTest();
        mediaPlayerStatic.play();
    }

    public void beginTimerTest() {

        timer = new Timer();

        task = new TimerTask() {

            public void run() {

                running = true;
                double current = mediaPlayerStatic.getCurrentTime().toSeconds();
                double end = mediaStatic.getDuration().toSeconds();
                podcastProgressBar.setProgress(current / end);

                if (current / end == 1) {

                    cancelTimer();
                }
            }
        };

        timer.scheduleAtFixedRate(task, 0, 1000);
    }

    //endregion

}
