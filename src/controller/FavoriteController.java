package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

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
    // TODO: Add static field of Gnere, Duration

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
        // TODO: Initialize static field of Gnere, Duration from MediaPlayerController
        System.out.println(titleMediaPlayerTextStatic);
        System.out.println(podcasterMediaPlayerTextStatic);

    }

    @FXML
    void addToFavorite() throws Exception {
        System.out.println("Button is worked");

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(FavoriteController.class.getResource("/view/podcastHboxLongPodcaster.fxml"));
        hBox = fxmlLoader.load();

        favoriteContainerStatic.getChildren().add(hBox);
    } // Test

    public void addPodcastToFavorite() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(FavoriteController.class.getResource("/view/podcastHboxLong.fxml"));
        hBox = fxmlLoader.load();
        favoriteContainerStatic.getChildren().add(hBox);
        System.out.println(titleMediaPlayerTextStatic);

        //set hello to the text of the label in the podcastHboxLong.fxml
        PodcastHboxLongController.titleHboxLongStatic.setText(titleMediaPlayerTextStatic);
        PodcastHboxLongController.podcasterHboxLongStatic.setText(podcasterMediaPlayerTextStatic);
        // TODO: Set text of Genre, Duration to PodcastHboxLongController
    }
}
