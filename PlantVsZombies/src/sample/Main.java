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

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent mainPage=FXMLLoader.load(getClass().getResource("MainPage.fxml"));

        Scene scene = new Scene(mainPage,1024,600);
        Media media = new Media(new File("src/sample/assets/background.wav").toURI().toString());

        //Instantiating MediaPlayer class   
        MediaPlayer mediaPlayer = new MediaPlayer(media);
          
        //by setting this property to true, the audio will be played   
        mediaPlayer.setAutoPlay(true);  
//        mainStage = new Stage();
//        mainStage.setScene(mainScene);
        primaryStage.setTitle("Plant vs Zombies");

//        viewManager view = new viewManager();
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
