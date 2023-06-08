/*-----------------------------------------------------------------------------------------
 * NAME : ChannelController.java
 * VER  : v0.1
 * PROJ : Akara
 * CODE CLEAN? : No
 *-----------------------------------------------------------------------------------------
 *                      H      I      S      T      O      R      Y
 *-----------------------------------------------------------------------------------------
 *   DATE        AUTHOR         DESCRIPTION
 * ----------  --------------  ------------------------------------------------------------
 * 2022-08-13   Nuth Vireak     creation
 * ----------  --------------  ------------------------------------------------------------
 * 2022-08-13   Nuth Vireak     Modification
 *---------------------------------------------------------------------------------------*/

package controller.channel;

import controller.discover.DiscoverController;
import controller.main.MainFormController;
import controller.main.PodcastHboxLongPodcasterController;
import controller.main.PodcastVboxController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Podcast;
import podcastData.DataInitializer;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ChannelController implements Initializable {

    //------------------------------------------------------------------------------------
    // fields declaration                                                               |
    //------------------------------------------------------------------------------------

    @FXML
    private HBox popularReleaseContainer;

    @FXML
    private VBox morePodcastContainer;

    @FXML
    private Label podcasterChannel;

    @FXML
    private Label podcasterAboutChannel;

    private static Label podcasterChannelStatic;
    private static Label podcasterAboutChannelStatic;
    private static HBox popularReleaseContainerStatic;
    private static VBox morePodcastContainerStatic;

    //------------------------------------------------------------------------------------
    //  Methods declaration                                                              |
    //------------------------------------------------------------------------------------

    public static void setPodcasterChannelStatic(String podcasterChannelStatic) {
        ChannelController.podcasterChannelStatic.setText(podcasterChannelStatic);
    }

    public static void setPodcasterAboutChannelStatic(String podcasterAboutChannelStatic) {
        ChannelController.podcasterAboutChannelStatic.setText(podcasterAboutChannelStatic);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        podcasterChannelStatic = podcasterChannel;
        podcasterAboutChannelStatic = podcasterAboutChannel;
        popularReleaseContainerStatic = popularReleaseContainer;
        morePodcastContainerStatic = morePodcastContainer;


    }

    public static void setPopularPodcastReleaseToView() throws IOException {
            for (Podcast podcast : DiscoverController.popularPodcast) {
                AnchorPane anchorPane = getAnchorPane(podcast);
                popularReleaseContainerStatic.getChildren().add(anchorPane);
            }
    }

    public static void setMorePodcasterPodcastToView() throws IOException {
        for (Podcast podcast : DiscoverController.popularPodcast) {
            HBox hBox = getHBox(podcast);
            morePodcastContainerStatic.getChildren().add(hBox);
        }
    }




    private static AnchorPane getAnchorPane(Podcast podcast) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(ChannelController.class.getResource("/view/main/podcastVbox.fxml"));

        AnchorPane anchorPane = fxmlLoader.load();
        PodcastVboxController podcastVboxController = fxmlLoader.getController();
        podcastVboxController.setData(podcast);
        return anchorPane;
    }

    private static HBox getHBox(Podcast podcast) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(ChannelController.class.getResource("/view/main/podcastHboxLongPodcaster.fxml"));

        HBox hBox = fxmlLoader.load();
        PodcastHboxLongPodcasterController podcastHboxLongPodcasterController = fxmlLoader.getController();
        podcastHboxLongPodcasterController.setData(podcast);
        return hBox;
    }
}
