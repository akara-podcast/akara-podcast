/*-----------------------------------------------------------------------------------------
 * NAME : DiscoverController.java
 * VER  : v0.1
 * PROJ : Akara
 * CODE CLEAN? : Yes
 *-----------------------------------------------------------------------------------------
 *                      H      I      S      T      O      R      Y
 *-----------------------------------------------------------------------------------------
 *   DATE        AUTHOR         DESCRIPTION
 * ----------  --------------  ------------------------------------------------------------
 * 2022-06-24   Nuth Vireak     creation
 * ----------  --------------  ------------------------------------------------------------
 * 2022-08-03   Nuth Vireak     Modification
 *---------------------------------------------------------------------------------------*/

package controller;

import com.github.javafaker.Faker;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import model.Podcast;
import podcastData.DataInitializer;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;


public class DiscoverController implements Initializable {

    //------------------------------------------------------------------------------------
    // fields declaration                                                               |
    //------------------------------------------------------------------------------------

    @FXML
    private BorderPane borderPane;


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


    @FXML
    private Label seeAllPopularPodcast;

    @FXML
    private Label seeAllTopPodcastInGaming;

    @FXML
    private Label seeAllTopPodcastInTechnology;

    @FXML
    private Label seeAllTopPodcastInHistory;

    @FXML
    private Label seeAllTopPodcastInComedy;

    @FXML
    private Label seeAllTopPodcastInProgrammingLanguage;


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

        // Initialize the lists of podcasts to be displayed in the Discover page
        recentlyPlayed = new ArrayList<>(getRecentlyPlayed());
        popularPodcast = new ArrayList<>(getPopularPodcast());
        topPodcastInGaming = new ArrayList<>(getTopPodcastInGaming());
        topPodcastInTechnology = new ArrayList<>(getTopPodcastInTechnology());
        topPodcastInHistory = new ArrayList<>(getTopPodcastInHistory());
        topPodcastInComedy = new ArrayList<>(getTopPodcastInComedy());
        topPodcastInProgrammingLanguage = new ArrayList<>(getTopPodcastInProgrammingLanguage());

        // Add the podcasts to the containers in the Discover page (recently played, popular, top in gaming, etc.)
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
                AnchorPane anchorPane = getAnchorPane(podcast);
                popularPodcastContainer.getChildren().add(anchorPane);
            }

            for (Podcast podcast : topPodcastInGaming) {
                AnchorPane anchorPane = getAnchorPane(podcast);
                topPodcastInGamingContainer.getChildren().add(anchorPane);
            }

            for (Podcast podcast : topPodcastInTechnology) {
                AnchorPane anchorPane = getAnchorPane(podcast);
                topPodcastInTechnologyContainer.getChildren().add(anchorPane);
            }

            for (Podcast podcast : topPodcastInHistory) {
                AnchorPane anchorPane = getAnchorPane(podcast);
                topPodcastInHistoryContainer.getChildren().add(anchorPane);
            }

            for (Podcast podcast : topPodcastInComedy) {
                AnchorPane anchorPane = getAnchorPane(podcast);
                topPodcastInComedyContainer.getChildren().add(anchorPane);
            }

            for (Podcast podcast : topPodcastInProgrammingLanguage) {
                AnchorPane anchorPane = getAnchorPane(podcast);
                topPodcastInProgrammingLanguageContainer.getChildren().add(anchorPane);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Podcast> getRecentlyPlayed() {

        DataInitializer dataInitializer = new DataInitializer();
        List<Podcast> recentlyPlayed = new ArrayList<>();

        for (Podcast podcast : dataInitializer.podcastList()) {
            if (podcast.getWasPlayed()) {
                if (recentlyPlayed.size() < 10) {
                    recentlyPlayed.add(podcast);
                }}}
        return recentlyPlayed;
    }

    private static List<Podcast> getPopularPodcast() {

        DataInitializer dataInitializer = new DataInitializer();
        List<Podcast> popularPodcast = new ArrayList<>();

        for (Podcast podcast : dataInitializer.podcastList()) {
            if (podcast.getViewCount() > 5000) {
                if (popularPodcast.size() < 10) {
                    popularPodcast.add(podcast);
                }}}
        return popularPodcast;
    }

    private List<Podcast> getTopPodcastInGaming() {

        DataInitializer dataInitializer = new DataInitializer();
        List<Podcast> topPodcastInGaming = new ArrayList<>();

        for (Podcast podcast : dataInitializer.podcastList()) {
            if (podcast.getGenre().equals("GAMING")) {
                if (topPodcastInGaming.size() < 10) {
                    topPodcastInGaming.add(podcast);
                }}}
        return topPodcastInGaming;
    }

    private List<Podcast> getTopPodcastInTechnology() {

        DataInitializer dataInitializer = new DataInitializer();
        List<Podcast> topPodcastInTechnology = new ArrayList<>();

        for (Podcast podcast : dataInitializer.podcastList()) {
            if (podcast.getGenre().equals("TECHNOLOGY")) {
                if (topPodcastInTechnology.size() < 10) {
                    topPodcastInTechnology.add(podcast);
                }}}
        return topPodcastInTechnology;
    }

    private List<Podcast> getTopPodcastInHistory() {

        DataInitializer dataInitializer = new DataInitializer();
        List<Podcast> topPodcastInHistory = new ArrayList<>();

        for (Podcast podcast : dataInitializer.podcastList()) {
            if (podcast.getGenre().equals("HISTORY")) {
                if (topPodcastInHistory.size() < 10) {
                    topPodcastInHistory.add(podcast);
                }}}
        return topPodcastInHistory;
    }

    private List<Podcast> getTopPodcastInComedy() {

        DataInitializer dataInitializer = new DataInitializer();
        List<Podcast> topPodcastInComedy = new ArrayList<>();

        for (Podcast podcast : dataInitializer.podcastList()) {
            if (podcast.getGenre().equals("COMEDY")) {
                if (topPodcastInComedy.size() < 10) {
                    topPodcastInComedy.add(podcast);
                }}}
        return topPodcastInComedy;
    }

    private List<Podcast> getTopPodcastInProgrammingLanguage() {

        DataInitializer dataInitializer = new DataInitializer();
        List<Podcast> topPodcastInProgrammingLanguage = new ArrayList<>();

        for (Podcast podcast : dataInitializer.podcastList()) {
            if (podcast.getGenre().equals("PROGRAMMING")) {
                if (topPodcastInProgrammingLanguage.size() < 10) {
                    topPodcastInProgrammingLanguage.add(podcast);
                }}}
        return topPodcastInProgrammingLanguage;
    }

    @FXML
    void seeAllClick(MouseEvent event) throws Exception {

        Faker faker = new Faker();

        BorderPane discoverSeeAll = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/DiscoverSeeAll.fxml")));
        borderPane.setCenter(discoverSeeAll);

        if (event.getSource() == seeAllPopularPodcast) {

            System.out.println("See all popular podcasts");
            String title = "Popular Podcasts";
            String description = faker.lorem().paragraph(10);

            System.out.println("Title: " + title);

            setTitleAndDescriptionToDiscoverSeeAllStaticView(title, description);

            DiscoverSeeAllController.setPopularPodcastToView();

        }
        else if (event.getSource() == seeAllTopPodcastInGaming) {

            System.out.println("See all Top podcast in gaming");
            String title = "Top Podcast in Gaming";
            String description = faker.lorem().paragraph(10);

            System.out.println("Title: " + title);

            setTitleAndDescriptionToDiscoverSeeAllStaticView(title, description);

            DiscoverSeeAllController.setTopPodcastInGamingToView();
        }
        else if (event.getSource() == seeAllTopPodcastInTechnology) {

            System.out.println("See all Top podcast in Technology");
            String title = "Top Podcast in Technology";
            String description = faker.lorem().paragraph(10);

            System.out.println("Title: " + title);

            setTitleAndDescriptionToDiscoverSeeAllStaticView(title, description);

            DiscoverSeeAllController.setTopPodcastInTechnologyToView();
        }
        else if (event.getSource() == seeAllTopPodcastInHistory) {

            System.out.println("See all Top podcast in History");
            String title = "Top Podcast in History";
            String description = faker.lorem().paragraph(10);

            System.out.println("Title: " + title);

            setTitleAndDescriptionToDiscoverSeeAllStaticView(title, description);

            DiscoverSeeAllController.setTopPodcastInHistoryToView();
        }
        else if (event.getSource() == seeAllTopPodcastInComedy) {

            System.out.println("See all Top podcast in Comedy");
            String title = "Top Podcast in Comedy";
            String description = faker.lorem().paragraph(10);

            System.out.println("Title: " + title);

            setTitleAndDescriptionToDiscoverSeeAllStaticView(title, description);

            DiscoverSeeAllController.setTopPodcastInComedyToView();
        }
        else if (event.getSource() == seeAllTopPodcastInProgrammingLanguage) {

            System.out.println("See all Top podcast in Programming Language");
            String title = "Top Podcast in Programming Language";
            String description = faker.lorem().paragraph(10);

            System.out.println("Title: " + title);

            setTitleAndDescriptionToDiscoverSeeAllStaticView(title, description);

            DiscoverSeeAllController.setTopPodcastInProgrammingLanguageToView();
        }
    }

    private void setTitleAndDescriptionToDiscoverSeeAllStaticView(String title, String description) {

        DiscoverSeeAllController.setTitleDiscoverSeeAllStatic(title);
        DiscoverSeeAllController.setDescriptionSeeAllStatic(description);
    }

    private AnchorPane getAnchorPane(Podcast podcast) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/view/podcastVbox.fxml"));

        AnchorPane anchorPane = fxmlLoader.load();
        PodcastVboxController podcastVboxController = fxmlLoader.getController();
        podcastVboxController.setData(podcast);
        return anchorPane;
    }

} // end of class DiscoverController
