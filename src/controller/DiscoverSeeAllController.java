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
 * 2022-08-03   Nuth Vireak     Modification
 *---------------------------------------------------------------------------------------*/

package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import model.Podcast;
import podcastData.DataInitializer;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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

    static List<Podcast> popularPodcast;
    static List<Podcast> topPodcastInGaming;
    static List<Podcast> topPodcastInTechnology;
    static List<Podcast> topPodcastInHistory;
    static List<Podcast> topPodcastInComedy;
    static List<Podcast> topPodcastInProgrammingLanguage;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        titleDiscoverSeeAllStatic = titleDiscoverSeeAll;
        descriptionSeeAllStatic = descriptionSeeAll;
        podcastContainerStatic = podcastContainer;
        borderPaneStatic = borderPane;

        popularPodcast = new ArrayList<>(getPopularPodcast());
        topPodcastInGaming = new ArrayList<>(getTopPodcastInGaming());
        topPodcastInTechnology = new ArrayList<>(getTopPodcastInTechnology());
        topPodcastInHistory = new ArrayList<>(getTopPodcastInHistory());
        topPodcastInComedy = new ArrayList<>(getTopPodcastInComedy());
        topPodcastInProgrammingLanguage = new ArrayList<>(getTopPodcastInProgrammingLanguage());
    }

    private static List<Podcast> getPopularPodcast() {

        DataInitializer dataInitializer = new DataInitializer();
        List<Podcast> popularPodcast = new ArrayList<>();

        for (Podcast podcast : dataInitializer.podcastList()) {
            if (podcast.getViewCount() > 5000) {
                    popularPodcast.add(podcast);
            }}
        return popularPodcast;
    }

    private List<Podcast> getTopPodcastInGaming() {

        DataInitializer dataInitializer = new DataInitializer();
        List<Podcast> topPodcastInGaming = new ArrayList<>();

        for (Podcast podcast : dataInitializer.podcastList()) {
            if (podcast.getGenre().equals("GAMING")) {
                topPodcastInGaming.add(podcast);
            }}
        return topPodcastInGaming;
    }

    private List<Podcast> getTopPodcastInTechnology() {

        DataInitializer dataInitializer = new DataInitializer();
        List<Podcast> topPodcastInTechnology = new ArrayList<>();

        for (Podcast podcast : dataInitializer.podcastList()) {
            if (podcast.getGenre().equals("TECHNOLOGY")) {
                    topPodcastInTechnology.add(podcast);
            }}
        return topPodcastInTechnology;
    }

    private List<Podcast> getTopPodcastInHistory() {

        DataInitializer dataInitializer = new DataInitializer();
        List<Podcast> topPodcastInHistory = new ArrayList<>();

        for (Podcast podcast : dataInitializer.podcastList()) {
            if (podcast.getGenre().equals("HISTORY")) {
                    topPodcastInHistory.add(podcast);
            }}
        return topPodcastInHistory;
    }

    private List<Podcast> getTopPodcastInComedy() {

        DataInitializer dataInitializer = new DataInitializer();
        List<Podcast> topPodcastInComedy = new ArrayList<>();

        for (Podcast podcast : dataInitializer.podcastList()) {
            if (podcast.getGenre().equals("COMEDY")) {
                    topPodcastInComedy.add(podcast);
            }}
        return topPodcastInComedy;
    }

    private List<Podcast> getTopPodcastInProgrammingLanguage() {

        DataInitializer dataInitializer = new DataInitializer();
        List<Podcast> topPodcastInProgrammingLanguage = new ArrayList<>();

        for (Podcast podcast : dataInitializer.podcastList()) {
            if (podcast.getGenre().equals("PROGRAMMING")) {
                    topPodcastInProgrammingLanguage.add(podcast);
            }}
        return topPodcastInProgrammingLanguage;
    }

    public static void setPopularPodcastToView() throws IOException {

        for (Podcast podcast : popularPodcast) {
            HBox hBox = getHBox(podcast);
            podcastContainerStatic.getChildren().add(hBox);
        }
    }

    public static void setTopPodcastInGamingToView() throws IOException {

        for (Podcast podcast : topPodcastInGaming) {
            HBox hBox = getHBox(podcast);
            podcastContainerStatic.getChildren().add(hBox);
        }
    }

    public static void setTopPodcastInTechnologyToView() throws IOException {

        for (Podcast podcast : topPodcastInTechnology) {
            HBox hBox = getHBox(podcast);
            podcastContainerStatic.getChildren().add(hBox);
        }
    }

    public static void setTopPodcastInHistoryToView() throws IOException {

        for (Podcast podcast : topPodcastInHistory) {
            HBox hBox = getHBox(podcast);
            podcastContainerStatic.getChildren().add(hBox);
        }
    }

    public static void setTopPodcastInComedyToView() throws IOException {

        for (Podcast podcast : topPodcastInComedy) {
            HBox hBox = getHBox(podcast);
            podcastContainerStatic.getChildren().add(hBox);
        }
    }

    public static void setTopPodcastInProgrammingLanguageToView() throws IOException {

        for (Podcast podcast : topPodcastInProgrammingLanguage) {
            HBox hBox = getHBox(podcast);
            podcastContainerStatic.getChildren().add(hBox);
        }
    }

    private static HBox getHBox(Podcast podcast) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(DiscoverSeeAllController.class.getResource("/view/podcastHboxLong.fxml"));

        HBox hBox = fxmlLoader.load();
        PodcastHboxLongController podcastHboxLongController = fxmlLoader.getController();
        podcastHboxLongController.setData(podcast);
        return hBox;
    }

} // End of class DiscoverSeeAllController
