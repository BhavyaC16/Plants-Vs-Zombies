package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;
import java.util.Iterator;

public class Pea extends GameElements{
    private int lane;
    private int plantPosition;
    transient private Timeline peaAnimation;
    private static int peaID=0;
    private boolean flag;
    private int thispea;
    public Pea(int x, int y, int plantPosition, int lane) {
        super(x, y, "/assets/pea.png",20,20);
//        super.makeImage();
        this.path = getClass().getResource("/assets/pea.png").toString();
        this.plantPosition = plantPosition;
        this.lane = lane;
        thispea = peaID++;
        this.flag = false;
    }

    public void movePea(){
        if(x<=1050)
        {
            setX(getX()+1);
        }
        if(this.plantPosition>getX())
        {
            img.setVisible(false);
        }
        else
        {
            img.setVisible(true);
        }
        checkZombieCollision();
    }

    public void shootPea(){
        Timeline animation = new Timeline(new KeyFrame(Duration.millis(5), e -> movePea()));
        animation.setCycleCount(1050);
        animation.play();
        this.peaAnimation = animation;
        GamePlayController.animationTimelines.add(animation);
    }

    public void checkZombieCollision()
    {
        synchronized (GamePlayController.allZombies) {
            Iterator<Zombie> i = GamePlayController.allZombies.iterator();
            while (i.hasNext()) {
                Zombie z = i.next();
                if(z.getLane() == lane && !flag)
                {
                    if(Math.abs(z.getX()-getX())<=3 && !flag)
                    {
                        this.flag = true;
                        z.setHp(z.getHp()-1);
                        img.setVisible(false);
                        img.setDisable(true);
                        peaAnimation.stop();
                        Media splat = new Media(getClass().getResource("/assets/sounds/splat3.wav").toString());
                        MediaPlayer mediaPlayer = new MediaPlayer(splat);
                        mediaPlayer.setAutoPlay(true);
                        mediaPlayer.play();
                    }
                }
            }
        }
    }

}
