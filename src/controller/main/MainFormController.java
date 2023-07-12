/*-----------------------------------------------------------------------------------------
 * NAME : MainFormController.java
 * VER  : v0.1
 * PROJ : Akara
 * CODE CLEAN? : Yes
 *-----------------------------------------------------------------------------------------
 *                      H      I      S      T      O      R      Y
 *-----------------------------------------------------------------------------------------
 *   DATE        AUTHOR         DESCRIPTION
 * ----------  --------------  ------------------------------------------------------------
 * 2022-06-24   Nuth Vireak     creation
 * ----------  --------------  ---------------------------------------------------------
 * 2022-07-22   Nuth Vireak     Modification
 *---------------------------------------------------------------------------------------*/

package controller.main;

import controller.search.SearchResultController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import model.Podcast;
import podcastData.DataInitializer;
import staticUtility.DbUtils;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;


public class MainFormController implements Initializable {

    //------------------------------------------------------------------------------------
    // fields declaration                                                                 |
    //------------------------------------------------------------------------------------
    @FXML
    public BorderPane borderPane;

    @FXML
    private BorderPane mainPane;

    @FXML
    private VBox mediaPlayerContainer;

    @FXML
    private Label modeLabel;

    @FXML
    private TextField searchTF;

    public static BorderPane staticMainPane;
    public static Label staticModelLabel;

    public static List<Podcast> podcastList;

    public static boolean init = false;

    private BorderPane discover;
    private BorderPane trending;

    public static BorderPane staticBorderpane;

    //------------------------------------------------------------------------------------
    //  Methods declarations                                                             |
    //------------------------------------------------------------------------------------

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // one init per start
        if (!init){
            System.out.println("do it!");
            DataInitializer dataInitializer = new DataInitializer();
            podcastList = dataInitializer.podcastList();

        }
        staticMainPane = mainPane;
        staticModelLabel = modeLabel;
        staticBorderpane = borderPane;

        VBox mediaPlayer;

        try {
            mediaPlayer = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/main/MediaPlayer.fxml")));
            discover = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/discover/Discover.fxml")));
            trending = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/trending/Trending.fxml")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // set the Discover VBox to the center of the BorderPane of the MainForm
        borderPane.setCenter(discover);

        // set the MediaPlayer VBox to the bottom of the BorderPane of the MainForm
        mediaPlayerContainer.getChildren().add(mediaPlayer);
    }

    @FXML
    private void communityClicked(MouseEvent event) throws IOException {

        VBox community = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/additional/Community.fxml")));
        community.setAlignment(Pos.CENTER);
        borderPane.setCenter(community);
    }

    @FXML
    private void discoverClick(MouseEvent event) throws IOException {
        FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/discover/Discover.fxml")));
        borderPane.setCenter(discover);
    }

    @FXML
    private void favoriteClick(MouseEvent event) throws IOException {

        BorderPane favorite = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/additional/Favorite.fxml")));
        borderPane.setCenter(favorite);
    }

    @FXML
    private void playlistClick(MouseEvent event) throws IOException {

        BorderPane playlist = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/playlist/Playlist.fxml")));
        borderPane.setCenter(playlist);

    }

    @FXML
    private void trendingClicked(MouseEvent event) throws IOException {
        borderPane.setCenter(trending);
    }

    @FXML
    public void profileClicked(MouseEvent event) throws IOException {

        BorderPane login; // create a Profile VBox object to store the Profile VBox in the FXML file
        // check that user login or not
        if (DbUtils.getRetrievedID() != 0) {
            login = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/user/Profile.fxml")));
        }
        else {
            login = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/user/Login.fxml")));
            modeClicked(event);
        }

        // set the Profile VBox to the center of the BorderPane of the MainForm
        borderPane.setCenter(login);

    }

    @FXML
    public void feedbackClicked(MouseEvent event) throws IOException {

        VBox feedback = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/main/Feedback.fxml")));
        borderPane.setCenter(feedback);
    }

    @FXML
    public void searchClicked(MouseEvent event) throws IOException {

        ScrollPane search = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/search/Search.fxml")));
        borderPane.setCenter(search);
    }

    @FXML
    void searchChange(KeyEvent event) throws IOException{
        if (!searchTF.getText().trim().equals("")){
            ScrollPane search = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/search/SearchResult.fxml")));
            borderPane.setCenter(search);

            // string search begin
            // SearchResultController.stringSearch(searchTF.getText().trim());

            // test string split search
            SearchResultController.stringSplitSearch(searchTF.getText().trim());
        }
        else{
            ScrollPane search = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/search/Search.fxml")));
            borderPane.setCenter(search);
        }
    }

    @FXML
    public void modeClicked(MouseEvent event) {

        // user can't change anything unless they log in
        if (DbUtils.getRetrievedID() != 0) {
            DbUtils.updateTheme(event, DbUtils.getRetrievedID());
        }
        if (!DbUtils.isRetrievedTheme()) {
            setDarkMode();
        } else {
            setLightMode();
        }
    }


    // get podcast by ID from list


    public static void setLightMode() {
        staticMainPane.getStylesheets().remove((Objects.requireNonNull(MainFormController.class.getResource("/css/darkMode.css"))).toString());
        staticMainPane.getStylesheets().add((Objects.requireNonNull(MainFormController.class.getResource("/css/style.css"))).toString());
        staticModelLabel.setText("Light Mode");
        System.out.println("Light");
    }

    public static void setDarkMode() {
        staticMainPane.getStylesheets().add((Objects.requireNonNull(MainFormController.class.getResource("/css/style.css"))).toString());
        staticMainPane.getStylesheets().add((Objects.requireNonNull(MainFormController.class.getResource("/css/darkMode.css"))).toString());
        staticModelLabel.setText("Dark Mode");
        System.out.println("Dark");
    }
}