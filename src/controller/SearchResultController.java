package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Podcast;
import model.SimilarityPodcast;
import net.ricecode.similarity.JaroWinklerStrategy;
import net.ricecode.similarity.SimilarityStrategy;
import net.ricecode.similarity.StringSimilarityService;
import net.ricecode.similarity.StringSimilarityServiceImpl;

import java.net.URL;
import java.util.*;

public class SearchResultController implements Initializable {
    // from SearchResult
    @FXML
    ImageView img;

    @FXML
    Label title;

    @FXML
    Label artist;

    private static ImageView staticImg;
    private static Label staticTitle;
    private static Label staticArtist;

    private static List<SimilarityPodcast> simPodcasts;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        staticImg = img;
        staticTitle = title;
        staticArtist = artist;
    }

    public static void stringSearch(String text){
        simPodcasts = new ArrayList<>();
        SimilarityStrategy strategy = new JaroWinklerStrategy();
        StringSimilarityService service = new StringSimilarityServiceImpl(strategy);
        for (Podcast podcast : MainFormController.podcastList) {
            SimilarityPodcast simPodcast = new SimilarityPodcast();
            simPodcast.setId(podcast.getId());
            simPodcast.setTitle(podcast.getTitle());
            simPodcast.setSimilarity(service.score(text, podcast.getTitle()));

            // add similar podcast to list
            simPodcasts.add(simPodcast);
        }

        for (SimilarityPodcast sim : simPodcasts){
            System.out.println("ID: "+ sim.getId() + "|" + sim.getTitle() + "|" + sim.getSimilarity());
        }

        simPodcasts.sort(new Comparator<SimilarityPodcast>() {
            @Override
            public int compare(SimilarityPodcast c1, SimilarityPodcast c2) {
                return Double.compare(c1.getSimilarity(), c2.getSimilarity());
            }
        });

        String imageURL = MainFormController.podcastList.get(simPodcasts.get(simPodcasts.size() - 1).getId()).getCover();
        String title  = MainFormController.podcastList.get(simPodcasts.get(simPodcasts.size() - 1).getId()).getTitle();
        String artist  = MainFormController.podcastList.get(simPodcasts.get(simPodcasts.size() - 1).getId()).getPodcaster();

        Image image = new Image(Objects.requireNonNull(SearchController.class.getResourceAsStream(imageURL)));
        // put data to view
        staticImg.setImage(image);
        staticTitle.setText(title);
        staticArtist.setText(artist);

        System.out.println("sorted!!!!!!!");
        for (SimilarityPodcast sim : simPodcasts){
            System.out.println("ID: "+ sim.getId() + "|" + sim.getTitle() + "|" + sim.getSimilarity());
        }
    }
}
