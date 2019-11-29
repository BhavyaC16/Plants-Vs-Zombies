package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.util.ArrayList;

public class Shooter extends Plant {

    protected Timeline shooterTimeline;
    protected int lane;

    public Shooter(int x, int y, String path, Pane pane, int hp, int width, int height, GridPane grid,int row,int col){
        super(x,y,path,pane,hp,width,height,grid,row,col);
        this.lane = col;
        attack();
    }

    @Override
    public void attack(){
        Timeline peaShooter = new Timeline(new KeyFrame(Duration.seconds(3), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                for(int i = 0; i<GamePlayController.allZombies.size(); i++) {
                    if (GamePlayController.allZombies.get(i).getLane() == getShooterLane() && getX()<=GamePlayController.allZombies.get(i).getX()) {
                        int peaStartX = getX() + 50;
                        int peaStartY = getY() + 25;
                        Pea p = new Pea(peaStartX, peaStartY, pane, getX() + 50);
                        p.shootPea();
                    }
                }
            }
        }));
        peaShooter.setCycleCount(Timeline.INDEFINITE);
        peaShooter.play();
        this.shooterTimeline = peaShooter;
    }
    public Timeline getShooterTimeline()
    {
        return(this.shooterTimeline);
    }

    public int getShooterLane()
    {
        return(this.lane);
    }
}
