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
 *---------------------------------------------------------------------------------------*/

package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * <PRE>
 *     --- MainFormController ---
 * </PRE>
 * @author Nuth Vireak
 * @EditDate 2020-06-24
 */
public class MainFormController implements Initializable {

//------------------------------------------------------------------------------------
// fields declaration                                                               |
//------------------------------------------------------------------------------------
    @FXML
    private BorderPane borderPane;


//------------------------------------------------------------------------------------
//  Methods declaration                                                              |
//------------------------------------------------------------------------------------

    /**
     * <PRE>
     * Function initialize is called when the FXML file is loaded act like a constructor
     * This function is used to initialize the controller class.
     * </PRE>
     * @param url the location used to resolve relative paths for the root object, or null if the location is not known.
     * @param resourceBundle the resources used to localize the root object, or null if the root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // create a Discover VBox object to store the Discover VBox in the FXML file
        VBox discover;

        try {
            // load the FXML file and store it in the Discover variable
            discover = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/Discover.fxml")));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // set the Discover VBox to the center of the BorderPane of the MainForm
        borderPane.setCenter(discover);
    }


    /**
     * <PRE>
     * Function communityClicked is called when the Community button is clicked
     * This function is used to load the Community VBox in the center of the BorderPane of the MainForm
     * </PRE>
     * @param event the event that triggered the function
     */
    @FXML
    private void communityClicked(MouseEvent event) throws IOException {

        // create a Community VBox object to store the Community VBox in the FXML file
        VBox community = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/Community.fxml")));
        community.setAlignment(Pos.CENTER);
        // set the Community VBox to the center of the BorderPane of the MainForm
        borderPane.setCenter(community);
    }


    /**
     * <PRE>
     * Function DiscoverClick is called when the user clicks the Discover button
     * This function is used to load the Discover VBox in the center of the BorderPane of the MainForm.
     * </PRE>
     * @param event the event that triggered the function
     */
    @FXML
    private void discoverClick(MouseEvent event) throws IOException {

        // create a Discover VBox object to store the Discover VBox in the FXML file
        VBox discover = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/Discover.fxml")));
        // set the Discover VBox to the center of the BorderPane of the MainForm
        borderPane.setCenter(discover);
    }


    /**
     * <PRE>
     * Function favoritesClick is called when the user clicks the Favorites button
     * This function is used to load the Favorites VBox in the center of the BorderPane of the MainForm.
     * </PRE>
     * @param event the event that triggered the function
     */
    @FXML
    private void favoriteClick(MouseEvent event) throws IOException {

        // create a Favorites VBox object to store the Favorites VBox in the FXML file
        VBox favorite = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/Favorite.fxml")));
        // set the Favorites VBox to the center of the BorderPane of the MainForm
        borderPane.setCenter(favorite);
    }


    /**
     * <PRE>
     * Function playlistClick is called when the user clicks the Playlist button
     * This function is used to load the Playlist VBox in the center of the BorderPane of the MainForm.
     * </PRE>
     * @param event the event that triggered the function
     */
    @FXML
    private void playlistClick(MouseEvent event) throws IOException {

        // create a Playlist VBox object to store the Playlist VBox in the FXML file
        VBox playlist = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/Playlist.fxml")));
        // set the Playlist VBox to the center of the BorderPane of the MainForm
        borderPane.setCenter(playlist);
    }


    /**
     * <PRE>
     * Function trendingClick is called when the user clicks the Trending button
     * This function is used to load the Trending VBox in the center of the BorderPane of the MainForm.
     * </PRE>
     * @param event the event that triggered the function
     */
    @FXML
    private void trendingClicked(MouseEvent event) throws IOException {

        // create a Trending VBox object to store the Trending VBox in the FXML file
        VBox trending = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/Trending.fxml")));
        // set the Trending VBox to the center of the BorderPane of the MainForm
        borderPane.setCenter(trending);
    }


    /**
     * <PRE>
     * Function profileClick is called when the user clicks the Profile button
     * This function is used to load the Profile VBox in the center of the BorderPane of the MainForm.
     * </PRE>
     * @param event the event that triggered the function
     */
    @FXML
    public void profileClicked(MouseEvent event) throws IOException {

        // create a Profile VBox object to store the Profile VBox in the FXML file
        BorderPane login = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/Login.fxml")));
        // set the Profile VBox to the center of the BorderPane of the MainForm
        borderPane.setCenter(login);
    }

    @FXML
    public void feedbackClicked(MouseEvent event) throws IOException {
        // create a Feedback VBox object to store the Feedback VBox in the FXML file
        VBox feedback = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/Feedback.fxml")));
        // set the Feedback VBox to the center of the BorderPane of the MainForm
        borderPane.setCenter(feedback);
    }
}