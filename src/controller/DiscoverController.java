/*-----------------------------------------------------------------------------------------
 * NAME : DiscoverController.java
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Podcast;
import podcastData.Data;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * <PRE>
 *     --- DiscoverController ---
 * </PRE>
 * @author Nuth Vireak
 * @EditDate 2020-06-24
 */
public class DiscoverController implements Initializable {

    //------------------------------------------------------------------------------------
    // fields declaration                                                               |
    //------------------------------------------------------------------------------------

    @FXML
    private HBox recentlyPlayedContainer;

    @FXML
    private HBox popularPodcastContainer;

    @FXML
    private HBox topPodcastInGamingContainer;

    @FXML
    private HBox topPodcastInTechnologyContainer;

    @FXML
    private HBox topPodcastInHistoryContainer;

    @FXML
    private HBox topPodcastInComedyContainer;

    @FXML
    private HBox topPodcastInProgrammingLanguageContainer;

    List<Podcast> recentlyPlayed;
    List<Podcast> popularPodcast;
    List<Podcast> topPodcastInGaming;
    List<Podcast> topPodcastInTechnology;
    List<Podcast> topPodcastInHistory;
    List<Podcast> topPodcastInComedy;
    List<Podcast> topPodcastInProgrammingLanguage;
    //------------------------------------------------------------------------------------
    //  Methods declaration                                                              |
    //------------------------------------------------------------------------------------

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        recentlyPlayed = new ArrayList<>(getRecentlyPlayed());
        popularPodcast = new ArrayList<>(getPopularPodcast());
        topPodcastInGaming = new ArrayList<>(getTopPodcastInGaming());
        topPodcastInTechnology = new ArrayList<>(getTopPodcastInTechnology());
        topPodcastInHistory = new ArrayList<>(getTopPodcastInHistory());
        topPodcastInComedy = new ArrayList<>(getTopPodcastInComedy());
        topPodcastInProgrammingLanguage = new ArrayList<>(getTopPodcastInProgrammingLanguage());

        try {

            for (Podcast podcast : recentlyPlayed) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/view/podcastHbox.fxml"));

                HBox hBox = fxmlLoader.load();
                PodcastHboxController podcastHboxController = fxmlLoader.getController();
                podcastHboxController.setData(podcast);

                recentlyPlayedContainer.getChildren().add(hBox);

            }

            for (Podcast podcast : popularPodcast) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/view/podcastVbox.fxml"));

                VBox vBox = fxmlLoader.load();
                PodcastVboxController podcastVboxController = fxmlLoader.getController();
                podcastVboxController.setData(podcast);

                popularPodcastContainer.getChildren().add(vBox);

            }

            for (Podcast podcast : topPodcastInGaming) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/view/podcastVbox.fxml"));

                VBox vBox = fxmlLoader.load();
                PodcastVboxController podcastVboxController = fxmlLoader.getController();
                podcastVboxController.setData(podcast);

                topPodcastInGamingContainer.getChildren().add(vBox);

            }

            for (Podcast podcast : topPodcastInTechnology) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/view/podcastVbox.fxml"));

                VBox vBox = fxmlLoader.load();
                PodcastVboxController podcastVboxController = fxmlLoader.getController();
                podcastVboxController.setData(podcast);

                topPodcastInTechnologyContainer.getChildren().add(vBox);

            }

            for (Podcast podcast : topPodcastInHistory) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/view/podcastVbox.fxml"));

                VBox vBox = fxmlLoader.load();
                PodcastVboxController podcastVboxController = fxmlLoader.getController();
                podcastVboxController.setData(podcast);

                topPodcastInHistoryContainer.getChildren().add(vBox);

            }

            for (Podcast podcast : topPodcastInComedy) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/view/podcastVbox.fxml"));

                VBox vBox = fxmlLoader.load();
                PodcastVboxController podcastVboxController = fxmlLoader.getController();
                podcastVboxController.setData(podcast);

                topPodcastInComedyContainer.getChildren().add(vBox);

            }

            for (Podcast podcast : topPodcastInProgrammingLanguage) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/view/podcastVbox.fxml"));

                VBox vBox = fxmlLoader.load();
                PodcastVboxController podcastVboxController = fxmlLoader.getController();
                podcastVboxController.setData(podcast);

                topPodcastInProgrammingLanguageContainer.getChildren().add(vBox);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Podcast> getRecentlyPlayed() {

        Data data = new Data();
        List<Podcast> recentlyPlayed = new ArrayList<>();

        // loop through the list of Data and find the ones that have the recentlyPlayed attribute set to true
        for (Podcast d : data.podcastList()) {
            if (d.getWasPlayed()) {
                recentlyPlayed.add(d);
            }
        }

        return recentlyPlayed;
    }


    private List<Podcast> getPopularPodcast() {

        Data data = new Data();
        List<Podcast> popularPodcast = new ArrayList<>();

        // loop through the list of Data and find the ones that have the popular attribute set to true
        for (Podcast d : data.podcastList()) {
            if (d.getViewCount() > 5000) {
                popularPodcast.add(d);
            }
        }

        return popularPodcast;
    }


    private List<Podcast> getTopPodcastInGaming() {

        List<Podcast> ls = new ArrayList<>();

        Podcast podcast = new Podcast();
        podcast.setTitle("Tok Touch Episode 0 - ទំលាប់កែមិនឡើង?");
        podcast.setCover("/image/Podcast_EP-10-web_1.png");
        ls.add(podcast);

        podcast = new Podcast();
        podcast.setTitle("Tok Touch Episode 0 - ទំលាប់កែមិនឡើង?");
        podcast.setCover("/image/Podcast_EP-10-web_1.png");
        ls.add(podcast);

        podcast = new Podcast();
        podcast.setTitle("Tok Touch Episode 0 - ទំលាប់កែមិនឡើង?");
        podcast.setCover("/image/Podcast_EP-10-web_1.png");
        ls.add(podcast);

        podcast = new Podcast();
        podcast.setTitle("Tok Touch Episode 0 - ទំលាប់កែមិនឡើង?");
        podcast.setCover("/image/Podcast_EP-10-web_1.png");
        ls.add(podcast);

        podcast = new Podcast();
        podcast.setTitle("Tok Touch Episode 0 - ទំលាប់កែមិនឡើង?");
        podcast.setCover("/image/Podcast_EP-10-web_1.png");
        ls.add(podcast);

        podcast = new Podcast();
        podcast.setTitle("Tok Touch Episode 0 - ទំលាប់កែមិនឡើង?");
        podcast.setCover("/image/Podcast_EP-10-web_1.png");
        ls.add(podcast);

        podcast = new Podcast();
        podcast.setTitle("Tok Touch Episode 0 - ទំលាប់កែមិនឡើង?");
        podcast.setCover("/image/Podcast_EP-10-web_1.png");
        ls.add(podcast);

        podcast = new Podcast();
        podcast.setTitle("Tok Touch Episode 0 - ទំលាប់កែមិនឡើង?");
        podcast.setCover("/image/Podcast_EP-10-web_1.png");
        ls.add(podcast);

        podcast = new Podcast();
        podcast.setTitle("Tok Touch Episode 0 - ទំលាប់កែមិនឡើង?");
        podcast.setCover("/image/Podcast_EP-10-web_1.png");
        ls.add(podcast);

        podcast = new Podcast();
        podcast.setTitle("Tok Touch Episode 0 - ទំលាប់កែមិនឡើង?");
        podcast.setCover("/image/Podcast_EP-10-web_1.png");
        ls.add(podcast);

        podcast = new Podcast();
        podcast.setTitle("Tok Touch Episode 0 - ទំលាប់កែមិនឡើង?");
        podcast.setCover("/image/Podcast_EP-10-web_1.png");
        ls.add(podcast);

        podcast = new Podcast();
        podcast.setTitle("Tok Touch Episode 0 - ទំលាប់កែមិនឡើង?");
        podcast.setCover("/image/Podcast_EP-10-web_1.png");
        ls.add(podcast);

        return ls;
    }


    private List<Podcast> getTopPodcastInTechnology() {

        List<Podcast> ls = new ArrayList<>();

        Podcast podcast = new Podcast();
        podcast.setTitle("Tok Touch Episode 0 - ទំលាប់កែមិនឡើង?");
        podcast.setCover("/image/Podcast_EP-10-web_1.png");
        ls.add(podcast);

        podcast = new Podcast();
        podcast.setTitle("Tok Touch Episode 0 - ទំលាប់កែមិនឡើង?");
        podcast.setCover("/image/Podcast_EP-10-web_1.png");
        ls.add(podcast);

        podcast = new Podcast();
        podcast.setTitle("Tok Touch Episode 0 - ទំលាប់កែមិនឡើង?");
        podcast.setCover("/image/Podcast_EP-10-web_1.png");
        ls.add(podcast);

        podcast = new Podcast();
        podcast.setTitle("Tok Touch Episode 0 - ទំលាប់កែមិនឡើង?");
        podcast.setCover("/image/Podcast_EP-10-web_1.png");
        ls.add(podcast);

        podcast = new Podcast();
        podcast.setTitle("Tok Touch Episode 0 - ទំលាប់កែមិនឡើង?");
        podcast.setCover("/image/Podcast_EP-10-web_1.png");
        ls.add(podcast);

        podcast = new Podcast();
        podcast.setTitle("Tok Touch Episode 0 - ទំលាប់កែមិនឡើង?");
        podcast.setCover("/image/Podcast_EP-10-web_1.png");
        ls.add(podcast);

        podcast = new Podcast();
        podcast.setTitle("Tok Touch Episode 0 - ទំលាប់កែមិនឡើង?");
        podcast.setCover("/image/Podcast_EP-10-web_1.png");
        ls.add(podcast);

        podcast = new Podcast();
        podcast.setTitle("Tok Touch Episode 0 - ទំលាប់កែមិនឡើង?");
        podcast.setCover("/image/Podcast_EP-10-web_1.png");
        ls.add(podcast);

        podcast = new Podcast();
        podcast.setTitle("Tok Touch Episode 0 - ទំលាប់កែមិនឡើង?");
        podcast.setCover("/image/Podcast_EP-10-web_1.png");
        ls.add(podcast);

        podcast = new Podcast();
        podcast.setTitle("Tok Touch Episode 0 - ទំលាប់កែមិនឡើង?");
        podcast.setCover("/image/Podcast_EP-10-web_1.png");
        ls.add(podcast);

        podcast = new Podcast();
        podcast.setTitle("Tok Touch Episode 0 - ទំលាប់កែមិនឡើង?");
        podcast.setCover("/image/Podcast_EP-10-web_1.png");
        ls.add(podcast);

        podcast = new Podcast();
        podcast.setTitle("Tok Touch Episode 0 - ទំលាប់កែមិនឡើង?");
        podcast.setCover("/image/Podcast_EP-10-web_1.png");
        ls.add(podcast);

        return ls;
    }


    private List<Podcast> getTopPodcastInHistory() {

        List<Podcast> ls = new ArrayList<>();

        Podcast podcast = new Podcast();
        podcast.setTitle("Tok Touch Episode 0 - ទំលាប់កែមិនឡើង?");
        podcast.setCover("/image/Podcast_EP-10-web_1.png");
        ls.add(podcast);

        podcast = new Podcast();
        podcast.setTitle("Tok Touch Episode 0 - ទំលាប់កែមិនឡើង?");
        podcast.setCover("/image/Podcast_EP-10-web_1.png");
        ls.add(podcast);

        podcast = new Podcast();
        podcast.setTitle("Tok Touch Episode 0 - ទំលាប់កែមិនឡើង?");
        podcast.setCover("/image/Podcast_EP-10-web_1.png");
        ls.add(podcast);

        podcast = new Podcast();
        podcast.setTitle("Tok Touch Episode 0 - ទំលាប់កែមិនឡើង?");
        podcast.setCover("/image/Podcast_EP-10-web_1.png");
        ls.add(podcast);

        podcast = new Podcast();
        podcast.setTitle("Tok Touch Episode 0 - ទំលាប់កែមិនឡើង?");
        podcast.setCover("/image/Podcast_EP-10-web_1.png");
        ls.add(podcast);

        podcast = new Podcast();
        podcast.setTitle("Tok Touch Episode 0 - ទំលាប់កែមិនឡើង?");
        podcast.setCover("/image/Podcast_EP-10-web_1.png");
        ls.add(podcast);

        podcast = new Podcast();
        podcast.setTitle("Tok Touch Episode 0 - ទំលាប់កែមិនឡើង?");
        podcast.setCover("/image/Podcast_EP-10-web_1.png");
        ls.add(podcast);

        podcast = new Podcast();
        podcast.setTitle("Tok Touch Episode 0 - ទំលាប់កែមិនឡើង?");
        podcast.setCover("/image/Podcast_EP-10-web_1.png");
        ls.add(podcast);

        podcast = new Podcast();
        podcast.setTitle("Tok Touch Episode 0 - ទំលាប់កែមិនឡើង?");
        podcast.setCover("/image/Podcast_EP-10-web_1.png");
        ls.add(podcast);

        podcast = new Podcast();
        podcast.setTitle("Tok Touch Episode 0 - ទំលាប់កែមិនឡើង?");
        podcast.setCover("/image/Podcast_EP-10-web_1.png");
        ls.add(podcast);

        podcast = new Podcast();
        podcast.setTitle("Tok Touch Episode 0 - ទំលាប់កែមិនឡើង?");
        podcast.setCover("/image/Podcast_EP-10-web_1.png");
        ls.add(podcast);

        podcast = new Podcast();
        podcast.setTitle("Tok Touch Episode 0 - ទំលាប់កែមិនឡើង?");
        podcast.setCover("/image/Podcast_EP-10-web_1.png");
        ls.add(podcast);

        return ls;
    }


    private List<Podcast> getTopPodcastInComedy() {

        List<Podcast> ls = new ArrayList<>();

        Podcast podcast = new Podcast();
        podcast.setTitle("Tok Touch Episode 0 - ទំលាប់កែមិនឡើង?");
        podcast.setCover("/image/Podcast_EP-10-web_1.png");
        ls.add(podcast);

        podcast = new Podcast();
        podcast.setTitle("Tok Touch Episode 0 - ទំលាប់កែមិនឡើង?");
        podcast.setCover("/image/Podcast_EP-10-web_1.png");
        ls.add(podcast);

        podcast = new Podcast();
        podcast.setTitle("Tok Touch Episode 0 - ទំលាប់កែមិនឡើង?");
        podcast.setCover("/image/Podcast_EP-10-web_1.png");
        ls.add(podcast);

        podcast = new Podcast();
        podcast.setTitle("Tok Touch Episode 0 - ទំលាប់កែមិនឡើង?");
        podcast.setCover("/image/Podcast_EP-10-web_1.png");
        ls.add(podcast);

        podcast = new Podcast();
        podcast.setTitle("Tok Touch Episode 0 - ទំលាប់កែមិនឡើង?");
        podcast.setCover("/image/Podcast_EP-10-web_1.png");
        ls.add(podcast);

        podcast = new Podcast();
        podcast.setTitle("Tok Touch Episode 0 - ទំលាប់កែមិនឡើង?");
        podcast.setCover("/image/Podcast_EP-10-web_1.png");
        ls.add(podcast);

        podcast = new Podcast();
        podcast.setTitle("Tok Touch Episode 0 - ទំលាប់កែមិនឡើង?");
        podcast.setCover("/image/Podcast_EP-10-web_1.png");
        ls.add(podcast);

        podcast = new Podcast();
        podcast.setTitle("Tok Touch Episode 0 - ទំលាប់កែមិនឡើង?");
        podcast.setCover("/image/Podcast_EP-10-web_1.png");
        ls.add(podcast);

        podcast = new Podcast();
        podcast.setTitle("Tok Touch Episode 0 - ទំលាប់កែមិនឡើង?");
        podcast.setCover("/image/Podcast_EP-10-web_1.png");
        ls.add(podcast);

        podcast = new Podcast();
        podcast.setTitle("Tok Touch Episode 0 - ទំលាប់កែមិនឡើង?");
        podcast.setCover("/image/Podcast_EP-10-web_1.png");
        ls.add(podcast);

        podcast = new Podcast();
        podcast.setTitle("Tok Touch Episode 0 - ទំលាប់កែមិនឡើង?");
        podcast.setCover("/image/Podcast_EP-10-web_1.png");
        ls.add(podcast);

        podcast = new Podcast();
        podcast.setTitle("Tok Touch Episode 0 - ទំលាប់កែមិនឡើង?");
        podcast.setCover("/image/Podcast_EP-10-web_1.png");
        ls.add(podcast);

        return ls;
    }


    private List<Podcast> getTopPodcastInProgrammingLanguage() {

        List<Podcast> ls = new ArrayList<>();

        Podcast podcast = new Podcast();
        podcast.setTitle("Tok Touch Episode 0 - ទំលាប់កែមិនឡើង?");
        podcast.setCover("/image/Podcast_EP-10-web_1.png");
        ls.add(podcast);

        podcast = new Podcast();
        podcast.setTitle("Tok Touch Episode 0 - ទំលាប់កែមិនឡើង?");
        podcast.setCover("/image/Podcast_EP-10-web_1.png");
        ls.add(podcast);

        podcast = new Podcast();
        podcast.setTitle("Tok Touch Episode 0 - ទំលាប់កែមិនឡើង?");
        podcast.setCover("/image/Podcast_EP-10-web_1.png");
        ls.add(podcast);

        podcast = new Podcast();
        podcast.setTitle("Tok Touch Episode 0 - ទំលាប់កែមិនឡើង?");
        podcast.setCover("/image/Podcast_EP-10-web_1.png");
        ls.add(podcast);

        podcast = new Podcast();
        podcast.setTitle("Tok Touch Episode 0 - ទំលាប់កែមិនឡើង?");
        podcast.setCover("/image/Podcast_EP-10-web_1.png");
        ls.add(podcast);

        podcast = new Podcast();
        podcast.setTitle("Tok Touch Episode 0 - ទំលាប់កែមិនឡើង?");
        podcast.setCover("/image/Podcast_EP-10-web_1.png");
        ls.add(podcast);

        podcast = new Podcast();
        podcast.setTitle("Tok Touch Episode 0 - ទំលាប់កែមិនឡើង?");
        podcast.setCover("/image/Podcast_EP-10-web_1.png");
        ls.add(podcast);

        podcast = new Podcast();
        podcast.setTitle("Tok Touch Episode 0 - ទំលាប់កែមិនឡើង?");
        podcast.setCover("/image/Podcast_EP-10-web_1.png");
        ls.add(podcast);

        podcast = new Podcast();
        podcast.setTitle("Tok Touch Episode 0 - ទំលាប់កែមិនឡើង?");
        podcast.setCover("/image/Podcast_EP-10-web_1.png");
        ls.add(podcast);

        podcast = new Podcast();
        podcast.setTitle("Tok Touch Episode 0 - ទំលាប់កែមិនឡើង?");
        podcast.setCover("/image/Podcast_EP-10-web_1.png");
        ls.add(podcast);

        podcast = new Podcast();
        podcast.setTitle("Tok Touch Episode 0 - ទំលាប់កែមិនឡើង?");
        podcast.setCover("/image/Podcast_EP-10-web_1.png");
        ls.add(podcast);

        podcast = new Podcast();
        podcast.setTitle("Tok Touch Episode 0 - ទំលាប់កែមិនឡើង?");
        podcast.setCover("/image/Podcast_EP-10-web_1.png");
        ls.add(podcast);

        return ls;
    }
}
