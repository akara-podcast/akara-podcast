/*-----------------------------------------------------------------------------------------
 * NAME : MainFormController.java
 * VER  : v0.1
 * PROJ : Akara
 *-----------------------------------------------------------------------------------------
 *                      H      I      S      T      O      R      Y
 *-----------------------------------------------------------------------------------------
 *   DATE        AUTHOR         DESCRIPTION
 * ----------  --------------  ------------------------------------------------------------
 * 2022-06-24   Nuth Vireak     creation
 * ----------  --------------  ---------------------------------------------------------
 * 2022-07-08   Nuth Vireak     Modification
 *---------------------------------------------------------------------------------------*/

package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import staticUtility.DbUtils;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;


public class MainFormController implements Initializable {

    //------------------------------------------------------------------------------------
    // fields declaration                                                               |
    //------------------------------------------------------------------------------------
    @FXML
    public BorderPane borderPane;

    @FXML
    private BorderPane mainPane;

    @FXML
    private VBox mediaPlayerContainer;

    @FXML
    private Label modeLabel;

    public static BorderPane staticMainPane;
    public static Label staticModelLabel;

    //------------------------------------------------------------------------------------
    //  Methods declaration s                                                             |
    //------------------------------------------------------------------------------------

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        staticMainPane = mainPane;
        staticModelLabel = modeLabel;

        BorderPane discover;
        VBox mediaPlayer;

        try {
            discover = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/Discover.fxml")));
            mediaPlayer = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/MediaPlayer.fxml")));

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

        VBox community = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/Community.fxml")));
        community.setAlignment(Pos.CENTER);
        borderPane.setCenter(community);
    }

    @FXML
    private void discoverClick(MouseEvent event) throws IOException {

        BorderPane discover = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/Discover.fxml")));
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

        BorderPane login; // create a Profile VBox object to store the Profile VBox in the FXML file
        // check that user login or not
        if (DbUtils.getRetrievedID() != 0)
            login = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/Profile.fxml")));
        else
            login = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/Login.fxml")));

        // set the Profile VBox to the center of the BorderPane of the MainForm
        borderPane.setCenter(login);

        modeClicked(event);
    }

    @FXML
    public void feedbackClicked(MouseEvent event) throws IOException {

        VBox feedback = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/Feedback.fxml")));
        borderPane.setCenter(feedback);
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