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

package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.net.URL;
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

    //------------------------------------------------------------------------------------
    //  Methods declaration                                                              |
    //------------------------------------------------------------------------------------

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
