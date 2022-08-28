package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Podcast;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SearchController implements Initializable {

    @FXML
    FlowPane podcasterContainer;
    @FXML
    FlowPane categoryContainer;

    private final String[] podcasterName = {"M.Megamind", "GMK", "RavenBlaze", "DS", "Tos-Leng", "Lyviss", "Mr Kmav", "Rean Podcast"};
    private final String[] podcasterIMG = {"/image/megamine.png", "/image/gmk.png", "/image/raven.png", "/image/ds.png",
            "/image/tosleng.png", "/image/lyviss.png", "/image/kmav.png", "/image/reanpodcast.png"};
    private final String[] categoryImgURL = {"/image/categoryGaming.png", "/image/categoryHistory.png",
            "/image/categoryTechnology.png", "/image/categoryProgramming.png", "/image/categoryEducation.png",
            "/image/categoryComedy.png", "/image/categoryBusiness.png", "/image/categoryNews.png"};
    private final String[] categoryNameStr = {"Gaming", "History", "Technology", "Programing language",
            "Education", "Comedy", "Business", "News"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            for (int i=0; i<podcasterName.length; i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/view/PodcasterVBox.fxml"));

                VBox podcaster = fxmlLoader.load();
                PodcasterVBoxController controller = fxmlLoader.getController();
                controller.setData(podcasterIMG[i], podcasterName[i]);
                podcasterContainer.getChildren().add(podcaster);
            }
            for (int i=0; i<categoryNameStr.length; i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/view/categoryVBox.fxml"));

                VBox categories = fxmlLoader.load();
                CategoryVBoxController controller = fxmlLoader.getController();
                controller.setData(categoryImgURL[i], categoryNameStr[i]);
                categoryContainer.getChildren().add(categories);
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
