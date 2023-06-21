/*-----------------------------------------------------------------------------------------
 * NAME : DiscoverSeeAllController.java
 * VER  : v0.1
 * PROJ : Akara
 * CODE CLEAN? : Yes
 *-----------------------------------------------------------------------------------------
 *                      H      I      S      T      O      R      Y
 *-----------------------------------------------------------------------------------------
 *   DATE        AUTHOR         DESCRIPTION
 * ----------  --------------  ------------------------------------------------------------
 * 2022-07-23   Nuth Vireak     creation
 * ----------  --------------  ------------------------------------------------------------
 * 2022-08-22   Nuth Vireak     Modification
 *---------------------------------------------------------------------------------------*/

package controller.discover;

import controller.main.PodcastHboxLongController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import model.Podcast;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DiscoverSeeAllController implements Initializable {

    //------------------------------------------------------------------------------------
    // fields declaration                                                               |
    //------------------------------------------------------------------------------------

    @FXML
    private BorderPane borderPane;

    @FXML
    private VBox podcastContainer;

    @FXML
    private Label titleDiscoverSeeAll;

    @FXML
    private Label descriptionSeeAll;

    private static Label titleDiscoverSeeAllStatic;
    private static Label descriptionSeeAllStatic;
    private static VBox podcastContainerStatic;
    private static BorderPane borderPaneStatic;

    //------------------------------------------------------------------------------------
    //  Methods declaration                                                              |
    //------------------------------------------------------------------------------------

    public static void setTitleDiscoverSeeAllStatic(String titleDiscoverSeeAllStatic) {
        DiscoverSeeAllController.titleDiscoverSeeAllStatic.setText(titleDiscoverSeeAllStatic);
    }

    public static void setDescriptionSeeAllStatic(String descriptionSeeAllStatic) {
        DiscoverSeeAllController.descriptionSeeAllStatic.setText(descriptionSeeAllStatic);
    }

    public static void setBorderPaneStatic(BorderPane borderPaneStatic) {
        DiscoverSeeAllController.borderPaneStatic.setCenter(borderPaneStatic);
    }

    public static BorderPane getBorderPaneStatic() {
        return borderPaneStatic;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        titleDiscoverSeeAllStatic = titleDiscoverSeeAll;
        descriptionSeeAllStatic = descriptionSeeAll;
        podcastContainerStatic = podcastContainer;
        borderPaneStatic = borderPane;

    }


    public static void setPopularPodcastToView() throws IOException {

        for (Podcast podcast : DiscoverController.popularPodcast) {
            HBox hBox = getHBox(podcast);
            podcastContainerStatic.getChildren().add(hBox);
        }
    }

    public static void setTopPodcastInGamingToView() throws IOException {

        for (Podcast podcast : DiscoverController.topPodcastInGaming) {
            HBox hBox = getHBox(podcast);
            podcastContainerStatic.getChildren().add(hBox);
        }
    }

    public static void setTopPodcastInTechnologyToView() throws IOException {

        for (Podcast podcast : DiscoverController.topPodcastInTechnology) {
            HBox hBox = getHBox(podcast);
            podcastContainerStatic.getChildren().add(hBox);
        }
    }

    public static void setTopPodcastInHistoryToView() throws IOException {

        for (Podcast podcast : DiscoverController.topPodcastInHistory) {
            HBox hBox = getHBox(podcast);
            podcastContainerStatic.getChildren().add(hBox);
        }
    }

    public static void setTopPodcastInComedyToView() throws IOException {

        for (Podcast podcast : DiscoverController.topPodcastInComedy) {
            HBox hBox = getHBox(podcast);
            podcastContainerStatic.getChildren().add(hBox);
        }
    }

    public static void setTopPodcastInProgrammingLanguageToView() throws IOException {

        for (Podcast podcast : DiscoverController.topPodcastInProgrammingLanguage) {
            HBox hBox = getHBox(podcast);
            podcastContainerStatic.getChildren().add(hBox);
        }
    }

    private static HBox getHBox(Podcast podcast) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(DiscoverSeeAllController.class.getResource("/view/main/podcastHboxLong.fxml"));

        HBox hBox = fxmlLoader.load();
        PodcastHboxLongController podcastHboxLongController = fxmlLoader.getController();
        podcastHboxLongController.setData(podcast);
        return hBox;
    }

} // End of class DiscoverSeeAllController
