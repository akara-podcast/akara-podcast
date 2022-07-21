/*-----------------------------------------------------------------------------------------
 * NAME : DataInitializer.java
 * VER  : v0.1
 * PROJ : Akara
 *-----------------------------------------------------------------------------------------
 *                      H      I      S      T      O      R      Y
 *-----------------------------------------------------------------------------------------
 *   DATE        AUTHOR         DESCRIPTION
 * ----------  --------------  ------------------------------------------------------------
 * 2022-07-05   Nuth Vireak     creation
 * ----------  --------------  ------------------------------------------------------------
 * 2022-07-08   Nuth Vireak     Modification
 *---------------------------------------------------------------------------------------*/

package podcastData;

import model.Podcast;

import java.util.ArrayList;
import java.util.List;
import com.github.javafaker.Faker;
import model.RandomGenre;
import model.RandomImage;
import model.RandomSoundPodcast;

public class DataInitializer {

    Faker faker = new Faker(); // create a faker object to generate random data

    public List<Podcast> podcastList() {

        List<Podcast> podcastList = new ArrayList<>(); // create a list of podcasts to store the data

        // set random data to the podcast list
        for (int i = 0; i < 45; i++) {

            Podcast podcast = new Podcast();
            podcast.setTitle(faker.friends().quote());
            podcast.setDescription(faker.lorem().paragraph());
            podcast.setCover(randomImage());
            podcast.setGenre(randomGenre());
            podcast.setArtist(faker.artist().name());
            podcast.setDuration(faker.random().nextInt(30, 60));
            podcast.setPodcastUrl(randomSoundPodcast());
            podcast.setCreatedAt(faker.business().creditCardExpiry());
            podcast.setUpdatedAt(faker.business().creditCardExpiry());
            podcast.setWasPlayed(faker.random().nextBoolean());
            podcast.setViewCount(Integer.parseInt(faker.phoneNumber().subscriberNumber()));
            podcastList.add(podcast);
        }

        return podcastList; // return the list of podcasts
    }

    /**
     * function to generate random genre from the enum RandomGenre and get the name of the genre
     * @return a random image from the list of images
     */
    public String randomGenre() {
        int randomNumber = (int) (Math.random() * RandomGenre.values().length);
        return RandomGenre.values()[randomNumber].toString();
    }

    /**
     * function to generate random image from the list of images and get the name of the image
     * @return a random image from the list of images
     */
    public String randomImage() {
        int randomNumber = (int) (Math.random() * RandomImage.values().length);
        return RandomImage.values()[randomNumber].getImageUrl();
    }

    /**
     * function to generate random podcast sound from the list of podcast sound and get the name of the podcast
     * @return a random sound podcast from the list of random sound podcast
     */
    public String randomSoundPodcast() {
        int randomNumber = (int) (Math.random() * RandomSoundPodcast.values().length);
        return RandomSoundPodcast.values()[randomNumber].getSoundPodcastUrl();
    }
}
