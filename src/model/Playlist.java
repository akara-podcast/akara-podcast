package model;

import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private static List<VBox> playlistVBoxArr = new ArrayList<>();

    private static List<CheckBox> playlistHBoxArr = new ArrayList<>();


    public static List<VBox> getPlaylistVBoxArr() {
        return playlistVBoxArr;
    }

    public static void setPlaylistToArr(VBox playlist) {
        playlistVBoxArr.add(playlist);
    }

    public static List<CheckBox> getPlaylistHBoxArr() {
        return playlistHBoxArr;
    }

    public static void setPlaylistHBoxArr(CheckBox playlist) {
       playlistHBoxArr.add(playlist);
    }

}
