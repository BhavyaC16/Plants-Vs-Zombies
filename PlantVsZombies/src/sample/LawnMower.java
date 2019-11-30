package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.Serializable;

public class LawnMower extends GameElements{
    int lane;
    boolean activated = false;
    String activatedPath="file:src/sample/assets/lawnmowerActivated.gif";
    public LawnMower(int x, int y, int lane){
        super(x, y, "file:src/sample/assets/lawnmowerIdle.gif", 81, 77);
        this.lane=lane;
        checkZombie();
    }

    public void checkZombie()
    {
        Timeline findZombie = new Timeline(new KeyFrame(Duration.millis(500), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                for(int i = 0; i<GamePlayController.allZombies.size(); i++)
                {
                    if(GamePlayController.allZombies.get(i).getLane()==lane)
                    {
                        if(Math.abs(GamePlayController.allZombies.get(i).getX()-getX())<=100)
                        {
                            if(activated==false)
                            {
                                activate();
                                GamePlayController.allZombies.get(i).setHp(0);
                                activated = true;
                                GamePlayController.allZombies.get(i).getZombieAnimation().stop();
                            }
                            else
                            {
                                GamePlayController.allZombies.get(i).setHp(0);
                                GamePlayController.allZombies.get(i).getZombieAnimation().stop();
                            }
                        }
                        GamePlayController.allMowers.remove(this);
                    }
                }
            }
        }));
        findZombie.setCycleCount(Timeline.INDEFINITE);
        findZombie.play();
    }

    public void activate(){
        img.setImage(new Image(activatedPath, 81, 77, false, false));
        Timeline animation = new Timeline(new KeyFrame(Duration.millis(5), e -> moveMower()));
        animation.setCycleCount(1100);
        animation.play();
    }
    public void moveMower()
    {
        if(getX()<=1500)
        {
            setX(getX()+1);
        }
    }

}
