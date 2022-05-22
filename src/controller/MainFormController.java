package controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class MainFormController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private BorderPane borderPane;

    @FXML
    private void communityClicked(MouseEvent event) throws IOException {

        VBox community = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/Community.fxml")));
        borderPane.setCenter(community);
    }

    @FXML
    private void discoverClick(MouseEvent event) throws IOException {

        VBox discover = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/Discover.fxml")));
        borderPane.setCenter(discover);
    }

    @FXML
    private void favoriteClick(MouseEvent event) throws IOException {

        VBox favorite = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/Favorite.fxml")));
        borderPane.setCenter(favorite);
    }

    @FXML
    private void playlistClick(MouseEvent event) throws IOException {

        VBox playlist = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/Playlist.fxml")));
        borderPane.setCenter(playlist);
    }

    @FXML
    private void trendingClicked(MouseEvent event) throws IOException {

        VBox trending = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/Trending.fxml")));
        borderPane.setCenter(trending);
    }

    @FXML
    public void profileClicked(MouseEvent event) throws IOException {
        BorderPane login = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/Login.fxml")));
        borderPane.setCenter(login);
    }

}