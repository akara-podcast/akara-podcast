package model;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class Favorite {

    private static List<HBox> favoriteArr = new ArrayList<>();

    public static List<HBox> getFavoriteArr() {
        return favoriteArr;
    }

    public static void setFavoriteArr(HBox favorite) {
        favoriteArr.add(favorite);
    }
}
