package model;

import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private static int playlistID;

    private static List<VBox> playlistVBoxArr = new ArrayList<>();

    private static List<CheckBox> playlistHBoxArr = new ArrayList<>();

    private static List<List<HBox>> playListPodcastArr = new ArrayList<>();


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

    public static void increaseID(){
        playlistID++;
    }

    public static String getID(){
        return String.valueOf(playlistID);
    }

    //get list of the list
    public static List<List<HBox>> getPlayListPodcastArr() {
        return playListPodcastArr;
    }

    // add list to the list
    public static void addPlayListPodcastArr(List<HBox> playListPodcast) {
        playListPodcastArr.add(playListPodcast);
    }

    // override list of the list
    public static void setPlayListPodcastArr(int index, List<HBox> playListPodcast){
        playListPodcastArr.set(index, playListPodcast);
    }

    public static void printLength(){
        for(List list : playListPodcastArr)
            System.out.print(list.toArray().length + " ");
    }
}
