package controller.search;

import controller.discover.DiscoverSeeAllController;
import controller.main.MainFormController;
import controller.main.PodcastHboxLongController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Podcast;
import model.SimilarityPodcast;
import net.ricecode.similarity.JaroWinklerStrategy;
import net.ricecode.similarity.SimilarityStrategy;
import net.ricecode.similarity.StringSimilarityService;
import net.ricecode.similarity.StringSimilarityServiceImpl;

import java.io.IOException;
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

    @FXML
    VBox podcastContainer;

    private static ImageView staticImg;
    private static Label staticTitle;
    private static Label staticArtist;

    private static List<SimilarityPodcast> simPodcasts;
    private static VBox podcastContainerStatic;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        staticImg = img;
        staticTitle = title;
        staticArtist = artist;
        podcastContainerStatic = podcastContainer;
    }

    public static void stringSearch(String text) throws IOException{
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

        // add top 5 similarity podcasts to view
        top5Similarity();

        System.out.println("sorted!!!!!!!");
        for (SimilarityPodcast sim : simPodcasts){
            System.out.println("ID: "+ sim.getId() + "|" + sim.getTitle() + "|" + sim.getSimilarity());
        }
    }

    public static void top5Similarity() throws IOException{
        int n = simPodcasts.size() - 2;
        for (int i = n; i > n - 5; i--){
            HBox hBox = getHBox(MainFormController.podcastList.get(simPodcasts.get(i).getId()));
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
