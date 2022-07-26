/*-----------------------------------------------------------------------------------------
 * NAME : PodcastVboxController.java
 * VER  : v0.1
 * PROJ : Akara
 *-----------------------------------------------------------------------------------------
 *                      H      I      S      T      O      R      Y
 *-----------------------------------------------------------------------------------------
 *   DATE        AUTHOR         DESCRIPTION
 * ----------  --------------  ------------------------------------------------------------
 * 2022-06-24   Nuth Vireak     creation
 * ----------  --------------  ------------------------------------------------------------
 * 2022-07-08   Nuth Vireak     Modification
 *---------------------------------------------------------------------------------------*/

package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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

    private Media media;
    private MediaPlayer mediaPlayer;
    private File file;

    //------------------------------------------------------------------------------------
    //  Methods declaration                                                              |
    //------------------------------------------------------------------------------------

    /**
     * Set the data of the Vbox (Podcast)
     * @param podcast the podcast
     */
    public void setData(Podcast podcast) {

        // create an image object
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(podcast.getCover())));

        // set the image object to the image view
        imgVbox.setImage(image);

        // set the title text
        titleVbox.setText(podcast.getTitle());

        podcasterVbox.setText(podcast.getPodcaster());

        file = new File(podcast.getPodcastUrl());

        media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }

    @FXML
    public void setDataToMediaPlayer(ActionEvent actionEvent) {

        String title = titleVbox.getText();
        String podcaster = podcasterVbox.getText();
        String source = media.getSource();

        System.out.println(title);
        System.out.println(podcaster);
        System.out.println(source);

        mediaPlayer.play();

        MediaPlayerController.setTitleMediaPlayerStatic(title);
        MediaPlayerController.setPodcasterMediaPlayerStatic(podcaster);

    }
}
