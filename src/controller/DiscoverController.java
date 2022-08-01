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
 * ----------  --------------  ------------------------------------------------------------
 * 2022-07-08   Nuth Vireak     Modification
 *---------------------------------------------------------------------------------------*/

package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

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

        // initialize the lists of podcasts to be displayed in the Discover page (recently played, popular, etc.)
        // and fill them
        recentlyPlayed = new ArrayList<>(getRecentlyPlayed());
        popularPodcast = new ArrayList<>(getPopularPodcast());
        topPodcastInGaming = new ArrayList<>(getTopPodcastInGaming());
        topPodcastInTechnology = new ArrayList<>(getTopPodcastInTechnology());
        topPodcastInHistory = new ArrayList<>(getTopPodcastInHistory());
        topPodcastInComedy = new ArrayList<>(getTopPodcastInComedy());
        topPodcastInProgrammingLanguage = new ArrayList<>(getTopPodcastInProgrammingLanguage());

        try {

            // loop through the lists of recently played
            for (Podcast podcast : recentlyPlayed) {

                // create a fxml loader to load the podcastHbox.fxml
                FXMLLoader fxmlLoader = new FXMLLoader();

                // get the URL of the podcastHbox.fxml file
                fxmlLoader.setLocation(getClass().getResource("/view/podcastHbox.fxml"));

                // create a new HBox and add the podcastHbox.fxml to it
                HBox hBox = fxmlLoader.load();

                // create an instance of the PodcastHboxController and set the podcast
                // to be displayed in the HBox (podcastHbox.fxml)
                PodcastHboxController podcastHboxController = fxmlLoader.getController();

                // set data to the podcast model
                podcastHboxController.setData(podcast);

                // add the HBox to the recently played container
                recentlyPlayedContainer.getChildren().add(hBox);

            }

            for (Podcast podcast : popularPodcast) {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/view/podcastVbox.fxml"));

                AnchorPane anchorPane = fxmlLoader.load();
                PodcastVboxController podcastVboxController = fxmlLoader.getController();
                podcastVboxController.setData(podcast);

                popularPodcastContainer.getChildren().add(anchorPane);

            }

            for (Podcast podcast : topPodcastInGaming) {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/view/podcastVbox.fxml"));

                AnchorPane anchorPane = fxmlLoader.load();
                PodcastVboxController podcastVboxController = fxmlLoader.getController();
                podcastVboxController.setData(podcast);

                topPodcastInGamingContainer.getChildren().add(anchorPane);

            }

            for (Podcast podcast : topPodcastInTechnology) {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/view/podcastVbox.fxml"));

                AnchorPane anchorPane = fxmlLoader.load();
                PodcastVboxController podcastVboxController = fxmlLoader.getController();
                podcastVboxController.setData(podcast);

                topPodcastInTechnologyContainer.getChildren().add(anchorPane);

            }

            for (Podcast podcast : topPodcastInHistory) {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/view/podcastVbox.fxml"));

                AnchorPane anchorPane = fxmlLoader.load();
                PodcastVboxController podcastVboxController = fxmlLoader.getController();
                podcastVboxController.setData(podcast);

                topPodcastInHistoryContainer.getChildren().add(anchorPane);

            }

            for (Podcast podcast : topPodcastInComedy) {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/view/podcastVbox.fxml"));

                AnchorPane anchorPane = fxmlLoader.load();
                PodcastVboxController podcastVboxController = fxmlLoader.getController();
                podcastVboxController.setData(podcast);

                topPodcastInComedyContainer.getChildren().add(anchorPane);

            }

            for (Podcast podcast : topPodcastInProgrammingLanguage) {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/view/podcastVbox.fxml"));

                AnchorPane anchorPane = fxmlLoader.load();
                PodcastVboxController podcastVboxController = fxmlLoader.getController();
                podcastVboxController.setData(podcast);

                topPodcastInProgrammingLanguageContainer.getChildren().add(anchorPane);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get the list of podcasts that have been recently played
     * @return the list of podcasts that have been recently played
     */
    private List<Podcast> getRecentlyPlayed() {

        // Create data initializer object to get the list of all podcasts
        DataInitializer dataInitializer = new DataInitializer();

        // Create a list of recently played podcasts to store the podcasts that have been recently played
        List<Podcast> recentlyPlayed = new ArrayList<>();

        // loop through the list of data and find the ones that have the recentlyPlayed attribute set to true
        // and add them to the list of recentlyPlayed only 10 podcasts
        for (Podcast podcast : dataInitializer.podcastList()) {
            if (podcast.getWasPlayed()) {
                if (recentlyPlayed.size() < 10) {
                    recentlyPlayed.add(podcast);
                }
            }
        }

        return recentlyPlayed; // return the list of recently played podcasts
    }

    /**
     * Get the list of podcasts that are popular
     * @return the list of podcasts that are popular
     */
    public static List<Podcast> getPopularPodcast() {

        // Create data initializer object to get the list of all podcasts
        DataInitializer dataInitializer = new DataInitializer();

        // Create a list of popular podcasts to store the podcasts that are popular
        List<Podcast> popularPodcast = new ArrayList<>();

        // loop through the list of data and find the ones that have the most views more than 5000
        // and add them to the list of popularPodcast only 10 podcasts
        for (Podcast podcast : dataInitializer.podcastList()) {
            if (podcast.getViewCount() > 5000) {
                if (popularPodcast.size() < 10) {
                    popularPodcast.add(podcast);
                }
            }
        }

        return popularPodcast; // return the list of popular podcasts
    }


    /**
     * Get the list of podcasts that are in the category of gaming
     * @return the list of podcasts that are in the category of gaming
     */
    private List<Podcast> getTopPodcastInGaming() {

        // Create data initializer object to get the list of all podcasts
        DataInitializer dataInitializer = new DataInitializer();

        // Create a list of top podcasts to store the podcasts that are in the category of gaming
        List<Podcast> topPodcastInGaming = new ArrayList<>();

        // loop through the list of data and find the ones that have the category of gaming
        // and add them to the list of topPodcastInGaming only 10 podcasts
        for (Podcast podcast : dataInitializer.podcastList()) {
            if (podcast.getGenre().equals("GAMING")) {
                if (topPodcastInGaming.size() < 10) {
                    topPodcastInGaming.add(podcast);
                }
            }
        }

        return topPodcastInGaming; // return the list of top podcasts in gaming
    }


    /**
     * Get the list of podcasts that are in the category of technology
     * @return the list of podcasts that are in the category of technology
     */
    private List<Podcast> getTopPodcastInTechnology() {

        // Create data initializer object to get the list of all podcasts
        DataInitializer dataInitializer = new DataInitializer();

        // Create a list of top podcasts to store the podcasts that are in the category of technology
        List<Podcast> topPodcastInTechnology = new ArrayList<>();

        // loop through the list of data and find the ones that have the category of technology
        // and add them to the list of topPodcastInTechnology only 10 podcasts
        for (Podcast podcast : dataInitializer.podcastList()) {
            if (podcast.getGenre().equals("TECHNOLOGY")) {
                if (topPodcastInTechnology.size() < 10) {
                    topPodcastInTechnology.add(podcast);
                }
            }
        }

        return topPodcastInTechnology; // return the list of top podcasts in technology
    }


    /**
     * Get the list of podcasts that are in the category of history
     * @return the list of podcasts that are in the category of history
     */
    private List<Podcast> getTopPodcastInHistory() {

        // Create data initializer object to get the list of all podcasts
        DataInitializer dataInitializer = new DataInitializer();

        // Create a list of top podcasts to store the podcasts that are in the category of history
        List<Podcast> topPodcastInHistory = new ArrayList<>();

        // loop through the list of data and find the ones that have the category of history
        // and add them to the list of topPodcastInHistory only 10 podcasts
        for (Podcast podcast : dataInitializer.podcastList()) {
            if (podcast.getGenre().equals("HISTORY")) {
                if (topPodcastInHistory.size() < 10) {
                    topPodcastInHistory.add(podcast);
                }
            }
        }

        return topPodcastInHistory; // return the list of top podcasts in history
    }


    /**
     * Get the list of podcasts that are in the category of comedy
     * @return the list of podcasts that are in the category of comedy
     */
    private List<Podcast> getTopPodcastInComedy() {

        // Create data initializer object to get the list of all podcasts
        DataInitializer dataInitializer = new DataInitializer();

        // Create a list of top podcasts to store the podcasts that are in the category of comedy
        List<Podcast> topPodcastInComedy = new ArrayList<>();

        // loop through the list of data and find the ones that have the category of comedy
        // and add them to the list of topPodcastInComedy only 10 podcasts
        for (Podcast podcast : dataInitializer.podcastList()) {
            if (podcast.getGenre().equals("COMEDY")) {
                if (topPodcastInComedy.size() < 10) {
                    topPodcastInComedy.add(podcast);
                }
            }
        }

        return topPodcastInComedy; // return the list of top podcasts in comedy
    }


    /**
     * Get the list of podcasts that are in the category of programming language
     * @return the list of podcasts that are in the category of programming language
     */
    private List<Podcast> getTopPodcastInProgrammingLanguage() {

        // Create data initializer object to get the list of all podcasts
        DataInitializer dataInitializer = new DataInitializer();

        // Create a list of top podcasts to store the podcasts that are in the category of programming language
        List<Podcast> topPodcastInProgrammingLanguage = new ArrayList<>();

        // loop through the list of data and find the ones that have the category of programming language
        // and add them to the list of topPodcastInProgrammingLanguage only 10 podcasts
        for (Podcast podcast : dataInitializer.podcastList()) {
            if (podcast.getGenre().equals("PROGRAMMING")) {
                if (topPodcastInProgrammingLanguage.size() < 10) {
                    topPodcastInProgrammingLanguage.add(podcast);
                }
            }
        }

        return topPodcastInProgrammingLanguage; // return the list of top podcasts in programming language
    }

    @FXML
    void seeAllClick(MouseEvent event) throws Exception {

        BorderPane discoverSeeAll = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/DiscoverSeeAll.fxml")));
        borderPane.setCenter(discoverSeeAll);

        if (event.getSource() == seeAllPopularPodcast) {
            System.out.println("See all popular podcasts");
            String title = "Popular Podcasts";

            System.out.println("Title: " + title);

            DiscoverSeeAllController.setTitleDiscoverSeeAllStatic(title);
        }
        if (event.getSource() == seeAllTopPodcastInGaming) {
            System.out.println("See all top podcasts in gaming");
        }
    }

} // end of class DiscoverController
