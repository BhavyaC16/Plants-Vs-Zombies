package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Shooter extends Plant {

    public Shooter(int x, int y, String path, Pane pane, int hp, int width, int height, GridPane grid,int row,int col){
        super(x,y,path,pane,hp,width,height,grid,row,col);
        attack();

    }
    @Override
    public void attack(){
        Timeline peaShooter = new Timeline(new KeyFrame(Duration.seconds(3), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int peaStartX = getX()+50;
                int peaStartY = getY()+25;
                Pea p = new Pea(peaStartX, peaStartY, pane, getX()+50);
                p.shootPea();
            }
        }));
        peaShooter.setCycleCount(Timeline.INDEFINITE);
        peaShooter.play();
    }
}
