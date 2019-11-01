package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.scene.media.AudioClip;
import sample.view.viewManager;

import java.io.File;

public class Main extends Application {
    public static MediaPlayer mediaPlayer;
    @Override
    public void start(Stage primaryStage) throws Exception{
        addMusic();
        Parent mainPage=FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        Scene scene = new Scene(mainPage,1024,600);
        primaryStage.setTitle("Plant vs Zombies");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public void addMusic() {
        String musicFile = "src/sample/assets/background.wav";
        Media sound = new Media(new File(musicFile).toURI().toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
