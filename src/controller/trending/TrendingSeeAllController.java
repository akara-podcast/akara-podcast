/*-----------------------------------------------------------------------------------------
 * NAME : TrendingSeeAllController.java
 * VER  : v0.1
 * PROJ : Akara
 * CODE CLEAN? : No
 *-----------------------------------------------------------------------------------------
 *                      H      I      S      T      O      R      Y
 *-----------------------------------------------------------------------------------------
 *   DATE        AUTHOR         DESCRIPTION
 * ----------  --------------  ------------------------------------------------------------
 * 2022-08-22   Nuth Vireak     creation
 * ----------  --------------  ------------------------------------------------------------
 * 2022-08-22   Nuth Vireak     Modification
 *---------------------------------------------------------------------------------------*/

package controller.trending;

import controller.discover.DiscoverController;
import controller.discover.DiscoverSeeAllController;
import controller.main.PodcastHboxLongController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Podcast;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TrendingSeeAllController implements Initializable {

    //------------------------------------------------------------------------------------
    // fields declaration                                                               |
    //------------------------------------------------------------------------------------

    @FXML
    private BorderPane borderPane;

    @FXML
    private VBox podcastContainer;

    private static VBox podcastContainerStatic;

    private static BorderPane borderPaneStatic;

    //------------------------------------------------------------------------------------
    //  Methods declaration                                                              |
    //------------------------------------------------------------------------------------

    public static void setBorderPaneStatic(BorderPane borderPaneStatic) {
        TrendingSeeAllController.borderPaneStatic.setCenter(borderPaneStatic);
    }

    public static BorderPane getBorderPaneStatic() {
        return borderPaneStatic;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        podcastContainerStatic = podcastContainer;
        borderPaneStatic = borderPane;

    }


    public static void setPopularPodcastToView() throws IOException {

        for (Podcast podcast : DiscoverController.popularPodcast) {
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
}
