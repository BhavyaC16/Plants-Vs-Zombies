package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.scene.media.AudioClip;
import javafx.util.Duration;
import sample.view.viewManager;

import java.io.*;
import java.util.ArrayList;

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
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.setStartTime(Duration.seconds(0));
        mediaPlayer.setStopTime(Duration.seconds(50));
        mediaPlayer.play();
    }
    public static void serialize() throws IOException {
        ObjectOutputStream out=null;
        try {
            out = new ObjectOutputStream (new FileOutputStream("database.txt"));
            out.writeObject(Database.getInstance());
            System.out.println("Saved!");
        }
        catch (FileNotFoundException f){
            System.out.println("cant find file");
        }
        catch(IOException e){
            System.out.println("Not able to save");
        }
        finally {
            out.close();
        }
    }
    public static void deserialize() throws ClassNotFoundException, IOException{
        ObjectInputStream in = null;
        try {
            in=new ObjectInputStream (new FileInputStream("database.txt"));
            d=(Database) in.readObject();
            in.close();
        }
        catch (NullPointerException e) {
            System.out.println("No database exists, creating new");
            d=new Database();
        }
        catch (FileNotFoundException f){
            System.out.println("cant find file");
        }
        catch(IOException e){
            System.out.println("Not able to save");
        }
        finally {
            in.close();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
