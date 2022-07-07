package podcastData;

import model.Podcast;

import java.util.ArrayList;
import java.util.List;

public class Data {

    public List<Podcast> podcastList() {

        List<Podcast> podcastList = new ArrayList<>();

        Podcast podcast = new Podcast();
        podcast.setTitle("Tok Touch Episode 0 - ទំលាប់កែមិនឡើង?");
        podcast.setDescription("តេស្តលេងៗហ្នឹងហារ អ្នកទាំងអស់គ្នាគិតយ៉ាងម៊ិចចំពោះ Podcast សាកល្បងមួយនេះ?");
        podcast.setCover("/image/2.png");
        podcast.setGenre("Motivation");
        podcast.setArtist("Tok Touch");
        podcast.setDuration(30);
        podcast.setPodcastUrl("podcastSound/KAI-Mascara.mp3");
        podcast.setCreatedAt("2021-01-01");
        podcast.setUpdatedAt("2022-01-01");
        podcast.setWasPlayed(true);
        podcast.setViewCount(8672);
        podcastList.add(podcast);

        podcast = new Podcast();
        podcast.setTitle("ដេកលក់ស្កប់ស្កល់ជាងមុន ជាមួយនឹងស្តាប់ខ្ញុំ");
        podcast.setDescription("សំរាប់អ្នកដែលកំពុងរកអ្វីមកស្តាប់កំដរអារម្មណ៍ពេលជិះម៉ូតូ ឬធ្វើម្ហូបនោះ សំណាងល្អមកដល់ហើយ");
        podcast.setCover("/image/3.png");
        podcast.setGenre("Motivation");
        podcast.setArtist("Tok Touch");
        podcast.setDuration(30);
        podcast.setPodcastUrl("podcastSound/KAI-Mascara.mp3");
        podcast.setCreatedAt("2021-01-01");
        podcast.setUpdatedAt("2022-01-01");
        podcast.setWasPlayed(true);
        podcast.setViewCount(10000);
        podcastList.add(podcast);

        podcast = new Podcast();
        podcast.setTitle("បង្កើនការតស៊ូក្នុងខ្លួនជាមួយនឹងស្តាប់ខ្ញុំអានវគ្គថ្មី");
        podcast.setDescription("សំរាប់អ្នកដែលកំពុងរកអ្វីមកស្តាប់កំដរអារម្មណ៍ពេលជិះម៉ូតូ ឬធ្វើម្ហូបនោះ សំណាងល្អមកដល់ហើយ");
        podcast.setCover("/image/4.png");
        podcast.setGenre("Motivation");
        podcast.setArtist("Tok Touch");
        podcast.setDuration(30);
        podcast.setPodcastUrl("podcastSound/KAI-Mascara.mp3");
        podcast.setCreatedAt("2021-01-01");
        podcast.setUpdatedAt("2022-01-01");
        podcast.setWasPlayed(true);
        podcast.setViewCount(10000);
        podcastList.add(podcast);

        return podcastList;
    }

}
