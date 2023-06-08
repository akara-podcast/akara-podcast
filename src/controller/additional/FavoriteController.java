package controller.additional;

import controller.main.MediaPlayerController;
import controller.main.PodcastHboxLongController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Favorite;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FavoriteController implements Initializable {

    @FXML
    private BorderPane borderPane;

    @FXML
    private VBox favoriteContainer;


    private HBox hBox;

    private static final FavoriteController instance = new FavoriteController();
    public static VBox favoriteContainerStatic;
    public static String titleMediaPlayerTextStatic;
    public static String podcasterMediaPlayerTextStatic;
    public static String genreMediaPlayerTextStatic;
    public static String durationMediaPlayerTextStatic;
    public static Image imgMediaPlayerStatic;

    public static FavoriteController getInstance() {
        return instance;
    }

    public FavoriteController(){
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        favoriteContainerStatic = favoriteContainer;
        titleMediaPlayerTextStatic = MediaPlayerController.titleMediaPlayerStatic.getText();
        podcasterMediaPlayerTextStatic = MediaPlayerController.podcasterMediaPlayerStatic.getText();
        genreMediaPlayerTextStatic = MediaPlayerController.genreMediaPlayerStatic.getText();
        durationMediaPlayerTextStatic = MediaPlayerController.durationMediaPlayerStatic.getText();
        imgMediaPlayerStatic = MediaPlayerController.imgMediaPlayerStatic.getImage();

        System.out.println(titleMediaPlayerTextStatic);
        System.out.println(podcasterMediaPlayerTextStatic);
        System.out.println(genreMediaPlayerTextStatic);
        System.out.println(durationMediaPlayerTextStatic);
        //System.out.println(imgMediaPlayerStatic);

        addFavoriteToContainer();
    }

    @FXML
    void addToFavorite() throws Exception {
        System.out.println("Button is worked");

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(FavoriteController.class.getResource("/view/main/podcastHboxLongPodcaster.fxml"));
        hBox = fxmlLoader.load();

        favoriteContainerStatic.getChildren().add(hBox);
    } // Test

    public void addPodcastToFavorite() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(FavoriteController.class.getResource("/view/main/podcastHboxLong.fxml"));
        hBox = fxmlLoader.load();

        // Add favorite to list
        Favorite.setFavoriteArr(hBox);

        // favoriteContainerStatic.getChildren().add(hBox);
        System.out.println(titleMediaPlayerTextStatic);

        //set hello to the text of the label in the podcastHboxLong.fxml
        PodcastHboxLongController.titleHboxLongStatic.setText(titleMediaPlayerTextStatic);
        PodcastHboxLongController.podcasterHboxLongStatic.setText(podcasterMediaPlayerTextStatic);
        PodcastHboxLongController.genreHboxLongStatic.setText(genreMediaPlayerTextStatic);
        PodcastHboxLongController.durationHboxLongStatic.setText(durationMediaPlayerTextStatic + " min");
        PodcastHboxLongController.imgHboxLongStatic.setImage(imgMediaPlayerStatic);

        favoriteContainerStatic.getChildren().add(hBox);
    }

    private static void addFavoriteToContainer() {
        for (HBox hBox : Favorite.getFavoriteArr()) {
            favoriteContainerStatic.getChildren().add(hBox);
        }
    }
}
