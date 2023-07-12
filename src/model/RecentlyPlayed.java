package model;

import java.io.Serial;
import java.io.Serializable;

public class RecentlyPlayed implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private int id;
    private String cover;
    private String title;
    private String description;
    private String podcaster;
    private String duration;
    private String podcastUrl;
    private String genre;

    // default constructor
    public RecentlyPlayed(){}

    // non-default constructor
    public RecentlyPlayed(int id, String cover, String title, String description, String podcaster, String duration, String podcastUrl, String genre) {
        this.id = id;
        this.cover = cover;
        this.title = title;
        this.description = description;
        this.podcaster = podcaster;
        this.duration = duration;
        this.podcastUrl = podcastUrl;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Title:" + title;
    }


    //#region GETTER AND SETTER
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPodcaster() {
        return podcaster;
    }

    public void setPodcaster(String podcaster) {
        this.podcaster = podcaster;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getPodcastUrl() {
        return podcastUrl;
    }

    public void setPodcastUrl(String podcastUrl) {
        this.podcastUrl = podcastUrl;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    //#endregion
}
