/*-----------------------------------------------------------------------------------------
 * NAME : Podcast.java
 * VER  : v0.1
 * PROJ : Akara
 * CODE CLEAN? : Yes
 *-----------------------------------------------------------------------------------------
 *                      H      I      S      T      O      R      Y
 *-----------------------------------------------------------------------------------------
 *   DATE        AUTHOR         DESCRIPTION
 * ----------  --------------  ------------------------------------------------------------
 * 2022-06-24   Nuth Vireak     creation
 * ----------  --------------  ------------------------------------------------------------
 * 2022-08-03   Nuth Vireak     Modification
 *---------------------------------------------------------------------------------------*/

package model;


public class Podcast {

    //------------------------------------------------------------------------------------
    // fields declaration                                                               |
    //------------------------------------------------------------------------------------

    private int id;
    private String cover;
    private String title;
    private String description;
    private String genre;
    private String podcaster;
    private String duration;
    private String podcastUrl;
    private String createdAt;
    private String updatedAt;
    private Boolean wasPlayed;
    private int viewCount;

    //------------------------------------------------------------------------------------
    //  Methods declaration                                                              |
    //------------------------------------------------------------------------------------

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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Boolean getWasPlayed() {
        return wasPlayed;
    }

    public void setWasPlayed(Boolean wasPlayed) {
        this.wasPlayed = wasPlayed;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
