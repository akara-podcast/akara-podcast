/*-----------------------------------------------------------------------------------------
 * NAME : PodcastVboxController.java
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
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.media.Media;

import javafx.scene.paint.Color;
import model.Podcast;
import model.RecentlyPlayed;

import java.io.File;
import java.net.URL;
import java.util.*;


public class PodcastVboxController implements Initializable {

    //------------------------------------------------------------------------------------
    // fields declaration                                                               |
    //------------------------------------------------------------------------------------

    @FXML
    private AnchorPane parentPodCast;

    @FXML
    private ImageView imgVbox;

    @FXML
    private Button playButtonVBox;

    @FXML
    private ImageView playImg;

    @FXML
    private Label titleVbox;

    @FXML
    private Label podcasterVbox;

    @FXML
    private Label durationVbox;

    @FXML
    private Label genreVbox;

    @FXML
    private VBox vBoxPodcast;

    private Media media;

    private File file;

    private boolean isPlaying = false;
    public static boolean isPlayingStatic;

    public static ImageView staticPlayImg;

    private RecentlyPlayed recently;

    //------------------------------------------------------------------------------------
    //  Methods declaration                                                              |
    //------------------------------------------------------------------------------------

    public void setData(Podcast podcast) {
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(podcast.getCover())));
        imgVbox.setImage(image);
        titleVbox.setText(podcast.getTitle());
        podcasterVbox.setText(podcast.getPodcaster());
        durationVbox.setText(podcast.getDuration());
        genreVbox.setText(podcast.getGenre());

        recently = new RecentlyPlayed(podcast.getId(), podcast.getCover(), podcast.getTitle(),
                podcast.getDescription(), podcast.getDescription(), podcast.getDuration(), podcast.getPodcastUrl(),
                podcast.getGenre());

        file = new File(podcast.getPodcastUrl());
        media = new Media(file.toURI().toString());

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        staticPlayImg = playImg;
        isPlayingStatic = isPlaying;
    }

    @FXML
    public void setDataToMediaPlayer(MouseEvent mouseEvent) {

        if (!isPlaying){
            String title = titleVbox.getText();
            String podcaster = podcasterVbox.getText();
            String duration = durationVbox.getText();
            String genre = genreVbox.getText();
            String source = media.getSource();
            Image image = imgVbox.getImage();

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
        vBoxPodcast.setBackground(new Background(new BackgroundFill(Color.web("#EDEDED"), new CornerRadii(4), Insets.EMPTY)));
    }

    // On mouse exited the podcast VBox
    @FXML
    public void hidePlayButton(MouseEvent mouseEvent){
        playButtonVBox.setDisable(true);
        playButtonVBox.setVisible(false);
        vBoxPodcast.setBackground(new Background(new BackgroundFill(Color.web("#F8F8F8FF"), new CornerRadii(4), Insets.EMPTY)));
    }

} // end of class PodcastVboxController
