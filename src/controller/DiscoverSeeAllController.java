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
    private VBox podcastContainer;

    @FXML
    private Label titleDiscoverSeeAll;

    private static Label titleDiscoverSeeAllStatic;

    List<Podcast> popularPodcast;

    //------------------------------------------------------------------------------------
    //  Methods declaration                                                              |
    //------------------------------------------------------------------------------------

    public static void setTitleDiscoverSeeAllStatic(String titleDiscoverSeeAllStatic) {
        DiscoverSeeAllController.titleDiscoverSeeAllStatic.setText(titleDiscoverSeeAllStatic);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        titleDiscoverSeeAllStatic = titleDiscoverSeeAll;

        popularPodcast = new ArrayList<>(getPopularPodcast());

        try {
            for (Podcast podcast : popularPodcast) {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/view/podcastHboxLong.fxml"));

                HBox hBox = fxmlLoader.load();
                PodcastHboxLongController podcastHboxLongController = fxmlLoader.getController();
                podcastHboxLongController.setData(podcast);

                podcastContainer.getChildren().add(hBox);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Podcast> getPopularPodcast() {

        // Create data initializer object to get the list of all podcasts
        DataInitializer dataInitializer = new DataInitializer();

        // Create a list of popular podcasts to store the podcasts that are popular
        List<Podcast> popularPodcast = new ArrayList<>();

        // loop through the list of data and find the ones that have the most views more than 5000
        // and add them to the list of popularPodcast only 10 podcasts
        for (Podcast podcast : dataInitializer.podcastList()) {
            if (podcast.getViewCount() > 5000) {
                    popularPodcast.add(podcast);
            }
        }

        return popularPodcast; // return the list of popular podcasts
    }

}
