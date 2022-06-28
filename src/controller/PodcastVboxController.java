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
 *---------------------------------------------------------------------------------------*/

package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Podcast;
import java.util.Objects;

/**
 * <PRE>
 *     --- PodcastVboxController ---
 * </PRE>
 * @author Nuth Vireak
 * @EditDate 2020-06-24
 */
public class PodcastVboxController {

    //------------------------------------------------------------------------------------
    // fields declaration                                                               |
    //------------------------------------------------------------------------------------

    @FXML
    private ImageView img;

    @FXML
    private Label title;


    //------------------------------------------------------------------------------------
    //  Methods declaration                                                              |
    //------------------------------------------------------------------------------------

    public void setData(Podcast podcast) {

        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(podcast.getCover())));
        img.setImage(image);
        title.setText(podcast.getTitle());
    }
}
