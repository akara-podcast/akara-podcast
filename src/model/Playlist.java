package model;

import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private static List<VBox> playlistArr = new ArrayList<>();


    public static List<VBox> getPlaylistArr() {
        return playlistArr;
    }

    public static void setPlaylistToArr(VBox playlist) {
        playlistArr.add(playlist);
    }
}
