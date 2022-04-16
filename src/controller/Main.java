package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/MainForm.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 840);
        stage.setTitle("Akara Podcast");
        stage.setScene(scene);

        Image applicationIcon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/image/Logo.png")));
        stage.getIcons().add(applicationIcon);

        stage.show();
    }
    //I'm edit right here, please don't delete it! again!
    public static void main(String[] args) {
        launch();
    }
}