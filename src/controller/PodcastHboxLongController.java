/*-----------------------------------------------------------------------------------------
 * NAME : PodcastHboxLongController.java
 * VER  : v0.1
 * PROJ : Akara
 * CODE CLEAN? : No
 *-----------------------------------------------------------------------------------------
 *                      H      I      S      T      O      R      Y
 *-----------------------------------------------------------------------------------------
 *   DATE        AUTHOR         DESCRIPTION
 * ----------  --------------  ------------------------------------------------------------
 * 2022-07-30   Nuth Vireak     creation
 * ----------  --------------  ------------------------------------------------------------
 * 2022-08-22   Nuth Vireak     Modification
 *---------------------------------------------------------------------------------------*/

package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import model.Podcast;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class PodcastHboxLongController implements Initializable {

    //------------------------------------------------------------------------------------
    // fields declaration                                                               |
    //------------------------------------------------------------------------------------

    @FXML
    private Label durationHboxLong;

    @FXML
    private Label genreHboxLong;

    @FXML
    private ImageView imgHboxLong;

    @FXML
    private Label podcasterHboxLong;

    @FXML
    private Label titleHboxLong;

    //------------------------------------------------------------------------------------
    //  Methods declaration                                                              |
    //------------------------------------------------------------------------------------

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    void setData(Podcast podcast) {
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(podcast.getCover())));

        imgHboxLong.setImage(image);
        titleHboxLong.setText(podcast.getTitle());
        podcasterHboxLong.setText(podcast.getPodcaster());
        genreHboxLong.setText(podcast.getGenre());
        durationHboxLong.setText(podcast.getDuration() + " min");
    }

    @FXML
    void podcasterClicked(MouseEvent event) throws Exception {

        BorderPane channel = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/Channel.fxml")));
        //DiscoverSeeAllController.setBorderPaneStatic(channel);

        // BUG
        // check if the DiscoverSeeAllController is clicked or not and set the border pane accordingly
        if (DiscoverSeeAllController.getBorderPaneStatic() != null) {
            DiscoverSeeAllController.setBorderPaneStatic(channel);
        } else {
            TrendingSeeAllController.setBorderPaneStatic(channel);
        }

        String podcaster = podcasterHboxLong.getText();

        ChannelController.setPodcasterChannelStatic(podcaster);
        ChannelController.setPodcasterAboutChannelStatic(podcaster);
        ChannelController.setPopularPodcastReleaseToView();
        ChannelController.setMorePodcasterPodcastToView();
    }
}
