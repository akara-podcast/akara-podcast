package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class AddPlaylistDialogController implements Initializable {

    @FXML
    ImageView playlistImg;

    @FXML
    Label playlistLabel;

    @FXML
    TextField playlistTF;

    @FXML
    RadioButton pinkV, purpleV, blueV, yellowV, redV, orangeV, greenV, cyanV, blackV, grayV;

    public static String imgURL = "/image/pinkPlaylist.png";
    public static Label staticLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        playlistLabel.textProperty().bindBidirectional(playlistTF.textProperty());
        staticLabel = playlistLabel;

        ToggleGroup colorGroup = new ToggleGroup();
        pinkV.setToggleGroup(colorGroup);
        purpleV.setToggleGroup(colorGroup);
        blueV.setToggleGroup(colorGroup);
        yellowV.setToggleGroup(colorGroup);
        redV.setToggleGroup(colorGroup);
        orangeV.setToggleGroup(colorGroup);
        greenV.setToggleGroup(colorGroup);
        cyanV.setToggleGroup(colorGroup);
        blackV.setToggleGroup(colorGroup);
        grayV.setToggleGroup(colorGroup);
    }


    public void colorCheck(ActionEvent event) {

        if (pinkV.isSelected()) {
            playlistImg.setImage(new Image(Objects.requireNonNull(getClass().getResource("/image/pinkPlaylist.png")).toString()));
            imgURL = "/image/pinkPlaylist.png";
        }
        if (purpleV.isSelected()) {
            playlistImg.setImage(new Image(Objects.requireNonNull(getClass().getResource("/image/purplePlaylist.png")).toString()));
            imgURL = "/image/purplePlaylist.png";
        }

        if (blueV.isSelected()) {
            playlistImg.setImage(new Image(Objects.requireNonNull(getClass().getResource("/image/bluePlaylist.png")).toString()));
            imgURL = "/image/bluePlaylist.png";
        }

        if (yellowV.isSelected()) {
            playlistImg.setImage(new Image(Objects.requireNonNull(getClass().getResource("/image/yellowPlaylist.png")).toString()));
            imgURL = "/image/yellowPlaylist.png";
        }

        if (redV.isSelected()) {
            playlistImg.setImage(new Image(Objects.requireNonNull(getClass().getResource("/image/redPlaylist.png")).toString()));
            imgURL = "/image/redPlaylist.png";
        }

        if (orangeV.isSelected()) {
            playlistImg.setImage(new Image(Objects.requireNonNull(getClass().getResource("/image/orangePlaylist.png")).toString()));
            imgURL = "/image/orangePlaylist.png";
        }

        if (greenV.isSelected()) {
            playlistImg.setImage(new Image(Objects.requireNonNull(getClass().getResource("/image/greenPlaylist.png")).toString()));
            imgURL = "/image/greenPlaylist.png";
        }

        if (cyanV.isSelected()) {
            playlistImg.setImage(new Image(Objects.requireNonNull(getClass().getResource("/image/cyanPlaylist.png")).toString()));
            imgURL = "/image/cyanPlaylist.png";
        }

        if (blackV.isSelected()) {
            playlistImg.setImage(new Image(Objects.requireNonNull(getClass().getResource("/image/blackPlaylist.png")).toString()));
            imgURL = "/image/blackPlaylist.png";
        }

        if (grayV.isSelected()) {
            playlistImg.setImage(new Image(Objects.requireNonNull(getClass().getResource("/image/grayPlaylist.png")).toString()));
            imgURL = "/image/grayPlaylist.png";
        }
        // end method
    }


    // end class
}
