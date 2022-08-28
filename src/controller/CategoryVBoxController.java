package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

public class CategoryVBoxController {

    @FXML
    ImageView categoryIMG;

    @FXML
    Label categoryName;

    public void setData(String URL, String name) {
        Image image = new Image(Objects.requireNonNull(getClass().getResource(URL)).toString());

        categoryIMG.setImage(image);
        categoryName.setText(name);
    }
}
