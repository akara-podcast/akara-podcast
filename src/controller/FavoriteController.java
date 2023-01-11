package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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

public class FavoriteController implements Initializable {

    @FXML
    private BorderPane borderPane;

    @FXML
    private HBox favoriteContainer;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
