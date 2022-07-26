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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import model.Podcast;
import org.w3c.dom.Text;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class MediaPlayerController implements Initializable {

    //------------------------------------------------------------------------------------
    // fields declaration                                                               |
    //------------------------------------------------------------------------------------

    @FXML
    private ImageView imgMediaPlayer;

    @FXML
    private Button playButton;

    @FXML
    private ProgressBar podcastProgressBar;

    @FXML
    private Label podcasterMediaPlayer;

    @FXML
    private Label titleMediaPlayer;

    private static Label titleMediaPlayerStatic;
    private static Label podcasterMediaPlayerStatic;


    //------------------------------------------------------------------------------------
    //  Methods declarations                                                             |
    //------------------------------------------------------------------------------------

    public static void setTitleMediaPlayerStatic(String titleMediaPlayerStatic) {
        MediaPlayerController.titleMediaPlayerStatic.setText(titleMediaPlayerStatic);
    }

    public static void setPodcasterMediaPlayerStatic(String podcasterMediaPlayerStatic) {
        MediaPlayerController.podcasterMediaPlayerStatic.setText(podcasterMediaPlayerStatic);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        titleMediaPlayerStatic = titleMediaPlayer;
        podcasterMediaPlayerStatic = podcasterMediaPlayer;
    }

}
