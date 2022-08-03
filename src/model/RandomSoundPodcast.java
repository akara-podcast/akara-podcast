/*-----------------------------------------------------------------------------------------
 * NAME : RandomSoundPodcast.java
 * VER  : v0.1
 * PROJ : Akara
 * CODE CLEAN? : Yes
 *-----------------------------------------------------------------------------------------
 *                      H      I      S      T      O      R      Y
 *-----------------------------------------------------------------------------------------
 *   DATE        AUTHOR         DESCRIPTION
 * ----------  --------------  ------------------------------------------------------------
 * 2022-08-03   Nuth Vireak     creation
 * ----------  --------------  ------------------------------------------------------------
 * 2022-08-03   Nuth Vireak     Modification
 *---------------------------------------------------------------------------------------*/

package model;

public enum RandomSoundPodcast {

    SOUND_PODCAST_1(1, "podcastSound/After_Midnight_-_Paxton_Pennington.mp3"),
    SOUND_PODCAST_2(2, "podcastSound/Bright_Red_and_March_Away_-_Ping_Pong_Club.mp3"),
    SOUND_PODCAST_3(3, "podcastSound/Done_With_You_-_SadMe.mp3"),
    SOUND_PODCAST_4(4, "podcastSound/Hourglass_-_Glass_Violet.mp3"),
    SOUND_PODCAST_5(5, "podcastSound/I_K_W_Y_B_-_Forget_the_Whale_(2).mp3"),
    SOUND_PODCAST_6(6, "podcastSound/ilyab_-_Flame_Up_-_ilyab.mp3"),
    SOUND_PODCAST_7(7, "podcastSound/Infinite_Blanket_-_Kara_Square_and_Piero_Peluche.mp3"),
    SOUND_PODCAST_8(8, "podcastSound/KAI-Mascara.mp3"),
    SOUND_PODCAST_9(9, "podcastSound/Less_Affected_-_equals.conquest.mp3"),
    SOUND_PODCAST_10(10, "podcastSound/Misery_Business_-_Plants.mp3"),
    SOUND_PODCAST_11(11, "podcastSound/Oh_So_Insecure_-_Jon_Worthy.mp3"),
    SOUND_PODCAST_12(12, "podcastSound/Set_The_Goals_-_Mouse_In_Da_Chaos_(3).mp3"),
    SOUND_PODCAST_13(13, "podcastSound/Talking_Cure_-_Of_Beauty_and_Love.mp3"),
    SOUND_PODCAST_14(14, "podcastSound/VANNDA-C.O.D.A.mp3"),
    SOUND_PODCAST_15(15, "podcastSound/VANNDA-DADDY-DA.mp3");

    private final int soundPodcastID;
    private final String soundPodcastUrl;

    RandomSoundPodcast(int soundPodcastID, String soundPodcastUrl) {
        this.soundPodcastID = soundPodcastID;
        this.soundPodcastUrl = soundPodcastUrl;
    }

    public int getSoundPodcastID() {
        return soundPodcastID;
    }

    public String getSoundPodcastUrl() {
        return soundPodcastUrl;
    }
}
