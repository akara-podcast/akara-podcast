/*-----------------------------------------------------------------------------------------
 * NAME : PodcastHboxLongPodcasterController.java
 * VER  : v0.1
 * PROJ : Akara
 * CODE CLEAN? : Yes
 *-----------------------------------------------------------------------------------------
 *                      H      I      S      T      O      R      Y
 *-----------------------------------------------------------------------------------------
 *   DATE        AUTHOR         DESCRIPTION
 * ----------  --------------  ------------------------------------------------------------
 * 2022-08-13   Nuth Vireak     creation
 * ----------  --------------  ------------------------------------------------------------
 * 2022-08-13   Nuth Vireak     Modification
 *---------------------------------------------------------------------------------------*/

package controller.main;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.paint.Color;
import model.Podcast;
import model.RecentlyPlayed;

import java.io.File;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class PodcastHboxLongPodcasterController implements Initializable {

    //------------------------------------------------------------------------------------
    // fields declaration                                                               |
    //------------------------------------------------------------------------------------

    @FXML
    private Label datePostHboxLongPodcaster;

    @FXML
    private Label durationHboxLongPodcaster;

    @FXML
    private Label genreHboxLongPodcaster;

    @FXML
    private ImageView imgHboxLongPodcaster;

    @FXML
    private Label titleHboxLongPodcaster;

    @FXML
    private ImageView playImg;

    @FXML
    private Button playButtonVBox;

    @FXML
    private HBox hBoxPodcast;

    private Podcast podcast;
    private boolean isPlaying = false;

    private Media media;

    private File file;

    private RecentlyPlayed recently;

    //------------------------------------------------------------------------------------
    //  Methods declaration                                                              |
    //------------------------------------------------------------------------------------

    public void setData(Podcast podcast) {
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(podcast.getCover())));

        this.podcast = podcast;
        recently = new RecentlyPlayed(podcast.getId(), podcast.getCover(), podcast.getTitle(),
                podcast.getDescription(), podcast.getDescription(), podcast.getDuration(), podcast.getPodcastUrl(),
                podcast.getGenre());

        imgHboxLongPodcaster.setImage(image);
        titleHboxLongPodcaster.setText(podcast.getTitle());
        datePostHboxLongPodcaster.setText(podcast.getCreatedAt());
        genreHboxLongPodcaster.setText(podcast.getGenre());
        durationHboxLongPodcaster.setText(podcast.getDuration() + " min");

        file = new File(podcast.getPodcastUrl());
        media = new Media(file.toURI().toString());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void setDataToMediaPlayer(MouseEvent mouseEvent) {

        if (!isPlaying){
            String title = this.podcast.getTitle();
            String podcaster = this.podcast.getPodcaster();
            String duration = this.podcast.getDuration();
            String genre = this.podcast.getGenre();
            String source = media.getSource();
            Image image = imgHboxLongPodcaster.getImage();

            System.out.println("title: " + title);
            System.out.println("podcaster: " + podcaster);
            System.out.println("source podcast: " + source);
            System.out.println("duration: " + duration);
            System.out.println("genre: " + genre);
            System.out.println("---");

            MediaPlayerController.setTitleMediaPlayerStatic(title);
            MediaPlayerController.setPodcasterMediaPlayerStatic(podcaster);
            MediaPlayerController.setImgMediaPlayerStatic(image);
            MediaPlayerController.setDurationMediaPlayerStatic(duration);
            MediaPlayerController.setGenreMediaPlayerStatic(genre);
            MediaPlayerController.setMediaStatic(media, file);
            MediaPlayerController.writeToFile(recently);
            playImg.setImage(new Image(Objects.requireNonNull(getClass().getResource("/image/pause.png")).toString()));
            isPlaying = true;
        }
        else {
            playImg.setImage(new Image(Objects.requireNonNull(getClass().getResource("/image/play.png")).toString()));
            MediaPlayerController.pauseMedia();
            isPlaying = false;
        }
    }

    // On mouse entered the podcast VBox
    @FXML
    public void showPlayButton(MouseEvent mouseEvent){
        playButtonVBox.setVisible(true);
        playButtonVBox.setDisable(false);
        hBoxPodcast.setBackground(new Background(new BackgroundFill(Color.web("#EDEDED"), new CornerRadii(4), Insets.EMPTY)));
    }

    // On mouse exited the podcast VBox
    @FXML
    public void hidePlayButton(MouseEvent mouseEvent){
        playButtonVBox.setDisable(true);
        playButtonVBox.setVisible(false);
        hBoxPodcast.setBackground(new Background(new BackgroundFill(Color.web("#F8F8F8FF"), new CornerRadii(4), Insets.EMPTY)));
    }
}
