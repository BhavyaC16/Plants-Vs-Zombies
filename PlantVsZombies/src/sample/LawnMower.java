package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;
import java.io.Serializable;
import java.util.Iterator;

public class LawnMower extends GameElements{
    int lane;
    boolean activated = false;
    String activatedPath="file:src/sample/assets/lawnmowerActivated.gif";
    public LawnMower(int x, int y, int lane){
        super(x, y, "file:src/sample/assets/lawnmowerIdle.gif", 81, 77);
        this.path="file:src/sample/assets/lawnmowerIdle.gif";
        this.lane=lane;
        checkZombie();
    }

    public void checkZombie()
    {
        Timeline findZombie = new Timeline(new KeyFrame(Duration.millis(50), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                synchronized (GamePlayController.allZombies) {
                    Iterator<Zombie> i = GamePlayController.allZombies.iterator();
                    while (i.hasNext()) {
                        Zombie z = i.next();
                        if(z.getLane()==lane)
                        {
                            if(Math.abs(z.getX()-getX())<=30)
                            {
                                if(activated==false)
                                {
                                    activate();
                                    z.setHp(0);
                                    activated = true;
                                    z.getZombieAnimation().stop();
                                }
                                else
                                {
                                    z.setHp(0);
                                    z.getZombieAnimation().stop();
                                }
                            }
                            GamePlayController.allMowers.remove(this);
                        }

                    }
                }
            }
        }));
        findZombie.setCycleCount(Timeline.INDEFINITE);
        findZombie.play();
    }

    public void activate(){
        img.setImage(new Image(activatedPath, 81, 77, false, false));
        String lawnMowerFile = "src/sample/assets/sounds/lawnmower.wav";
        Media lawnmower = new Media(new File(lawnMowerFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(lawnmower);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setVolume(1000);
        mediaPlayer.play();
        Timeline animation = new Timeline(new KeyFrame(Duration.millis(5), e -> moveMower()));
        animation.setCycleCount(1100);
        animation.play();
        GamePlayController.animationTimelines.add(animation);
    }
    public void moveMower()
    {
        if(getX()<=1500)
        {
            setX(getX()+1);
        }
    }

}
