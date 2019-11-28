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
    public Sunflower(int x, int y, Pane pane, int z, GridPane grid){
        super(x,y,"file:src/sample/assets/sunflower.gif",pane,6,73,74,z,grid);
        produceSun();
    }

    public void produceSun(){
        Timeline sunDropper = new Timeline(new KeyFrame(Duration.seconds(7), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Sun s = new Sun((int)img.getX(), (int)img.getY(), pane, false);
            }
        }));
        sunDropper.setCycleCount(Timeline.INDEFINITE);
        sunDropper.play();
    }
}
