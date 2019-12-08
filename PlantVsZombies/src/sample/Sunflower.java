package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Sunflower extends Plant{
    transient private Timeline sunProducer;
    public Sunflower(int x, int y,int row,int col){
        super(x,y,"file:src/sample/assets/sunflower.gif",100,73,74,row,col);
        this.path = "file:src/sample/assets/sunflower.gif";
    }

    @Override
    public void attack(Pane pane){
        produceSun(pane);
    }

    public void produceSun(Pane pane){
        Timeline stopGlow = new Timeline(new KeyFrame(Duration.seconds(5), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Glow glow=new Glow();
                img.setEffect(glow);
                glow.setLevel(0.0);
            }
        }));

        Timeline sunProducer = new Timeline(new KeyFrame(Duration.seconds(10), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                checkHp();
                Glow glow=new Glow();
                img.setEffect(glow);
                glow.setLevel(0.6);
                if(getHp()>0)
                {
                    Sun s = new Sun(getX()+20, getY()+40, false);
                    s.makeImage(pane);
                }
                stopGlow.play();
            }
        }));

        sunProducer.setCycleCount(Timeline.INDEFINITE);
        sunProducer.play();
        this.sunProducer = sunProducer;
        GamePlayController.animationTimelines.add(sunProducer);
    }
    public Timeline getTimeline()
    {
        return this.sunProducer;
    }

    public void checkHp()
    {
        if(getHp()<=0)
        {
            endAnimation(getTimeline());
        }
    }
}
