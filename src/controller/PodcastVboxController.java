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

package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;

import javafx.scene.media.MediaPlayer;
import model.Podcast;

import java.io.File;
import java.net.URL;
import java.util.*;

public class PodcastVboxController implements Initializable {

    //------------------------------------------------------------------------------------
    // fields declaration                                                               |
    //------------------------------------------------------------------------------------

    @FXML
    private ImageView imgVbox;

    @FXML
    private Button playButtonVBox;

    @FXML
    private Label titleVbox;

    @FXML
    private Label podcasterVbox;

    @FXML
    private Label durationVbox;

    @FXML
    private Label genreVbox;

    private Media media;

    private MediaPlayer mediaPlayer;

    private File file;

    //------------------------------------------------------------------------------------
    //  Methods declaration                                                              |
    //------------------------------------------------------------------------------------

    void setData(Podcast podcast) {
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(podcast.getCover())));

        imgVbox.setImage(image);
        titleVbox.setText(podcast.getTitle());
        podcasterVbox.setText(podcast.getPodcaster());
        durationVbox.setText(podcast.getDuration());
        genreVbox.setText(podcast.getGenre());

        file = new File(podcast.getPodcastUrl());
        media = new Media(file.toURI().toString());

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    @FXML
    public void setDataToMediaPlayer(ActionEvent actionEvent) {

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

    }


} // end of class PodcastVboxController
