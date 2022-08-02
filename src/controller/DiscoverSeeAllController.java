package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
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

public class DiscoverSeeAllController implements Initializable {

    //------------------------------------------------------------------------------------
    // fields declaration                                                               |
    //------------------------------------------------------------------------------------

    @FXML
    private static VBox podcastContainer;

    @FXML
    private Label titleDiscoverSeeAll;

    @FXML
    private Label descriptionSeeAll;

    private static Label titleDiscoverSeeAllStatic;
    private static Label descriptionSeeAllStatic;

    static List<Podcast> popularPodcast;
    List<Podcast> topPodcastInGaming;
    List<Podcast> topPodcastInTechnology;
    List<Podcast> topPodcastInHistory;
    List<Podcast> topPodcastInComedy;
    List<Podcast> topPodcastInProgrammingLanguage;

    //------------------------------------------------------------------------------------
    //  Methods declaration                                                              |
    //------------------------------------------------------------------------------------

    public static void setTitleDiscoverSeeAllStatic(String titleDiscoverSeeAllStatic) {
        DiscoverSeeAllController.titleDiscoverSeeAllStatic.setText(titleDiscoverSeeAllStatic);
    }

    public static void setDescriptionSeeAllStatic(String descriptionSeeAllStatic) {
        DiscoverSeeAllController.descriptionSeeAllStatic.setText(descriptionSeeAllStatic);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        titleDiscoverSeeAllStatic = titleDiscoverSeeAll;
        descriptionSeeAllStatic = descriptionSeeAll;

        popularPodcast = new ArrayList<>(getPopularPodcast());
        topPodcastInGaming = new ArrayList<>(getTopPodcastInGaming());

        setPopularPodcastToView();
    }

    public static List<Podcast> getPopularPodcast() {

        DataInitializer dataInitializer = new DataInitializer();

        List<Podcast> popularPodcast = new ArrayList<>();

        for (Podcast podcast : dataInitializer.podcastList()) {
            if (podcast.getViewCount() > 5000) {
                    popularPodcast.add(podcast);
            }
        }

        return popularPodcast;
    }

    private List<Podcast> getTopPodcastInGaming() {

        DataInitializer dataInitializer = new DataInitializer();

        List<Podcast> topPodcastInGaming = new ArrayList<>();

        for (Podcast podcast : dataInitializer.podcastList()) {
            if (podcast.getGenre().equals("GAMING")) {
                topPodcastInGaming.add(podcast);
            }
        }

        return topPodcastInGaming;
    }

    private static void setPopularPodcastToView() {
        try {
            for (Podcast podcast : popularPodcast) {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(DiscoverSeeAllController.class.getResource("/view/podcastHboxLong.fxml"));

                HBox hBox = fxmlLoader.load();
                PodcastHboxLongController podcastHboxLongController = fxmlLoader.getController();
                podcastHboxLongController.setData(podcast);

                podcastContainer.getChildren().add(hBox);

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
