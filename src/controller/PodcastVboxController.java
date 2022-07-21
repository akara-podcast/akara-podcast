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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import model.Podcast;
import podcastData.DataInitializer;

import java.io.File;
import java.net.URL;
import java.util.*;


public class PodcastVboxController implements Initializable {

    //------------------------------------------------------------------------------------
    // fields declaration                                                               |
    //------------------------------------------------------------------------------------

    @FXML
    private ImageView img;

    @FXML
    private Label title;

    @FXML
    private Button playButton;



    String path = "podcastSound/I_K_W_Y_B_-_Forget_the_Whale_(2).mp3";
    Media media = new Media(new File(path).toURI().toString());
    MediaPlayer mediaPlayer = new MediaPlayer(media);

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
        img.setImage(image);

        // set the title text
        title.setText(podcast.getTitle());

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }


    @FXML
    public void playMedia(ActionEvent actionEvent) throws Exception {

        DataInitializer dataInitializer = new DataInitializer();
        Podcast podcast = new Podcast();

        // check if the media player is playing
        if (mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING) {
            mediaPlayer.stop();
        } else {
            mediaPlayer.play();
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/MediaPlayer.fxml"));
        MediaPlayerController mediaPlayerController = loader.getController();
        loader.setController(mediaPlayerController);
        mediaPlayerController.title.setText(podcast.getTitle());
    }

    public void setDataToMediaController(Podcast podcast) {

    }

}
