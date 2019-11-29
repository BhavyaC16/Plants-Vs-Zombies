package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Sunflower extends Plant{
    private Timeline sunProducer;
    public Sunflower(int x, int y, Pane pane, GridPane grid,int row,int col){
        super(x,y,"file:src/sample/assets/sunflower.gif",pane,6,73,74,grid,row,col);
        produceSun();
    }

    public void produceSun(){
        Timeline sunProducer = new Timeline(new KeyFrame(Duration.seconds(7), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Sun s = new Sun(getX()+20, getY()+40, pane, false);
            }
        }));
        sunProducer.setCycleCount(Timeline.INDEFINITE);
        sunProducer.play();
    }
    public Timeline getTimeline()
    {
        return this.sunProducer;
    }
}
