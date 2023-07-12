/*-----------------------------------------------------------------------------------------
 * NAME : PodcastHboxController.java
 * VER  : v0.1
 * PROJ : Akara
 * CODE CLEAN? : Yes
 *-----------------------------------------------------------------------------------------
 *                      H      I      S      T      O      R      Y
 *-----------------------------------------------------------------------------------------
 *   DATE        AUTHOR         DESCRIPTION
 * ----------  --------------  ------------------------------------------------------------
 * 2022-06-24   Nuth Vireak     creation
 * ----------  --------------  ------------------------------------------------------------
 * 2022-08-03   Nuth Vireak     Modification
 *---------------------------------------------------------------------------------------*/

package controller.main;

import javafx.fxml.FXML;
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
import java.util.Objects;


public class PodcastHboxController {

    //------------------------------------------------------------------------------------
    // fields declaration                                                               |
    //------------------------------------------------------------------------------------

    @FXML
    private Label description;

    @FXML
    private ImageView img;

    @FXML
    private Label title;

    @FXML
    private ImageView playImg;

    @FXML
    private Button playButtonVBox;

    @FXML
    private HBox hBoxPodcast;


    private String podcaster;
    private String duration;
    private String genre;

    private Media media;

    private File file;

    private String source;
    private boolean isPlaying = false;

    private RecentlyPlayed podcast;

    //------------------------------------------------------------------------------------
    //  Methods declaration                                                              |
    //------------------------------------------------------------------------------------

    public void setData(RecentlyPlayed podcast) {
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(podcast.getCover())));

        img.setImage(image);
        title.setText(podcast.getTitle());
        description.setText(podcast.getDescription());
        podcaster = podcast.getPodcaster();
        duration = podcast.getDuration();
        genre = podcast.getGenre();
        this.podcast = podcast;

        // media source
        source = podcast.getPodcastUrl();
        file = new File(source);
        media = new Media(file.toURI().toString());
    }

    @FXML
    public void setDataToMediaPlayer(MouseEvent mouseEvent) {

        if (!isPlaying){
            String title = this.title.getText();
            String podcaster = this.podcaster;
            String duration = this.duration;
            String genre = this.genre;
            String source = media.getSource();
            Image image = img.getImage();

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
            MediaPlayerController.writeToFile(podcast);
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
