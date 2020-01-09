package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.util.Iterator;

public class Repeater extends Shooter {
    public Repeater(int x, int y,int row,int col) {
        super(x, y, "/assets/repeater.gif", 150,60,62,row,col);
        this.path=getClass().getResource("/assets/repeater.gif").toString();

    }
    @Override
    public void attack(Pane pane){
        Timeline peaShooter = new Timeline(new KeyFrame(Duration.seconds(2), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                synchronized (GamePlayController.allZombies) {
                    Iterator<Zombie> i = GamePlayController.allZombies.iterator();
                    while (i.hasNext()) {
                        Zombie z = i.next();
                        if (z.getLane() == getShooterLane() && getX()<=z.getX()) {
                            int pea1StartX = getX() + 50;
                            int pea2StartX = getX() - 20;
                            int peaStartY = getY() + 26;
                            Pea p1 = new Pea(pea1StartX, peaStartY, getX() + 50, row);
                            Pea p2 = new Pea(pea2StartX, peaStartY, getX() + 50, row);
                            p1.makeImage(pane);
                            p2.makeImage(pane);
                            p1.shootPea();
                            p2.shootPea();
                            checkHp();
                        }
                    }
                }
            }
        }));
        peaShooter.setCycleCount(Timeline.INDEFINITE);
        peaShooter.play();
        this.shooterTimeline = peaShooter;
        GamePlayController.animationTimelines.add(peaShooter);
    }
}
