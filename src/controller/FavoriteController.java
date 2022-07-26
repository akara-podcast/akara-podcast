package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import model.Podcast;
import podcastData.DataInitializer;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class FavoriteController implements Initializable {

    @FXML
    private VBox favouritePodcastContainer;

    List<Podcast> favouritePodcast;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        favouritePodcast = new ArrayList<>(getFavouritePodcast());

//        try {
//            for (Podcast podcast : favouritePodcast) {
//
////                FXMLLoader fxmlLoader = new FXMLLoader();
////                fxmlLoader.setLocation(getClass().getResource("/view/podcastVbox.fxml"));
////
////                VBox vBox = fxmlLoader.load();
////                PodcastVboxController podcastVboxController = fxmlLoader.getController();
////                podcastVboxController.setData(podcast);
////
////                favouritePodcastContainer.getChildren().add(vBox);
//            }
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    private List<Podcast> getFavouritePodcast() {

        // Create data initializer object to get the list of all podcasts
        DataInitializer dataInitializer = new DataInitializer();

        // Create a list of top podcasts to store the podcasts that are in the category of technology
        List<Podcast> favouritePodcast = new ArrayList<>();

        // loop through the list of data and find the ones that have the category of technology
        // and add them to the list of topPodcastInTechnology only 10 podcasts
        for (Podcast podcast : dataInitializer.podcastList()) {
            if (podcast.getGenre().equals("TECHNOLOGY")) {
                if (favouritePodcast.size() < 10) {
                    favouritePodcast.add(podcast);
                }
            }
        }

        return favouritePodcast; // return the list of top podcasts in technology
    }
}
