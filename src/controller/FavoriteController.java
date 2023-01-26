package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class FavoriteController implements Initializable {

    @FXML
    private BorderPane borderPane;

    @FXML
    private VBox favoriteContainer;


    private HBox hBox;

    private static FavoriteController instance = new FavoriteController(); //

    private FavoriteController(){} //

    public static FavoriteController getInstance() {
        return instance;
    }

    public static VBox favoriteContainerStatic;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        favoriteContainerStatic = favoriteContainer;
    }

    @FXML
    void addToFavorite() throws Exception {
        System.out.println("Button is worked");

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(FavoriteController.class.getResource("/view/podcastHboxLongPodcaster.fxml"));
        hBox = fxmlLoader.load();

        favoriteContainerStatic.getChildren().add(hBox);
    }
}
