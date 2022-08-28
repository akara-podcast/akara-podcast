package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

public class PodcasterVBoxController {

    @FXML
    Button podcasterBTN;

    @FXML
    ImageView podcasterIMG;

    @FXML
    Label podcasterName;

    public void setData(String URL, String name) {
        Image image = new Image(Objects.requireNonNull(getClass().getResource(URL)).toString());

        podcasterIMG.setImage(image);
        podcasterName.setText(name);
    }

}
