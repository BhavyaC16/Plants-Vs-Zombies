package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Repeater extends Shooter {
//    String path="./assets/repeater.png";

    public Repeater(int x, int y, Pane pane, GridPane grid,int row,int col) {
        super(x, y, "file:src/sample/assets/repeater.gif", pane, 8,60,62,grid,row,col);

    }
    @Override
    public void attack(){
        Timeline peaShooter = new Timeline(new KeyFrame(Duration.seconds(3), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int pea1StartX = getX()+50;
                int pea2StartX = getX()-20;
                int peaStartY = getY()+30;
                Pea p1 = new Pea(pea1StartX, peaStartY, pane, getX()+50);
                Pea p2 = new Pea(pea2StartX, peaStartY, pane, getX()+50);
                p1.shootPea();
                p2.shootPea();

            }
        }));
        peaShooter.setCycleCount(Timeline.INDEFINITE);
        peaShooter.play();
    }
}
