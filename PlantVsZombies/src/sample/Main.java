package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.*;
import java.net.URL;

public class Main extends Application {
    public static MediaPlayer mediaPlayer;
    private static Database currentd;

    @Override
    public void start(Stage primaryStage) throws Exception{
        deserialize();
        addMusic();
        Parent mainPage=FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        Scene scene = new Scene(mainPage,1024,600);
        primaryStage.setTitle("Plants VS Zombies");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public void addMusic() {
        Media sound = new Media(getClass().getResource("/assets/background.wav").toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.setStartTime(Duration.seconds(0));
        mediaPlayer.setStopTime(Duration.seconds(50));
        mediaPlayer.play();
    }

    public static Database getDatabase(){
        return currentd;
    }
    public static void serialize() throws IOException {
        ObjectOutputStream out=null;
        try {
            out = new ObjectOutputStream (new FileOutputStream("database.txt"));
            out.writeObject(currentd);
        }
        finally {
            out.close();
            //System.out.println("Saved!");
            System.exit(0);
        }
    }
    public static void deserialize() throws ClassNotFoundException, FileNotFoundException, IOException{
        ObjectInputStream in = null;
        try {
            in=new ObjectInputStream (new FileInputStream("database.txt"));
            currentd=(Database) in.readObject();
            in.close();
        }
        catch (FileNotFoundException e){
            currentd=new Database();
        }
        catch (NullPointerException e) {
            currentd=new Database();
            //System.out.println("This user does not exist in the database");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
