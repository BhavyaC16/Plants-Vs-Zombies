package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.util.Iterator;

public class ConeZombie extends Zombie {
    public ConeZombie(int x, int y, int lane) {
        super(14, 1, "file:src/sample/assets/coneheadzombie.gif", x, y, 133, 122, lane);
        this.path = "file:src/sample/assets/coneheadzombie.gif";
    }
    @Override
    public void eatPlant()
    {
        synchronized (GamePlayController.allPlants)
        {
            Iterator<Plant> i = GamePlayController.allPlants.iterator();
            while(i.hasNext())
            {
                Plant p = i.next();
                if(p.row == getLane())
                {
                    if (Math.abs(p.getX()-img.getX())<=25)
                    {
                        if(reachedPlant==false)
                        {
                            reachedPlant = true;
                            isEating = true;
                        }
                        if(isEating)
                        {
                            Timeline chomp = new Timeline(new KeyFrame(Duration.millis(1000), e -> chompPlant()));
                            chomp.setCycleCount(1000);
                            chomp.play();
                            this.chomping = chomp;
                            GamePlayController.animationTimelines.add(chomp);
                            isEating = false;
                        }
                        this.dx = 0;
                        p.setHp(p.getHp()-this.attackPower);
                        if(p.getHp()==0)
                        {
                            p.img.setVisible(false);
                            p.img.setDisable(true);
                            GamePlayController.allPlants.remove(p);
                            this.dx = -1;
                            this.reachedPlant = false;
                            this.chomping.stop();
                        }
                    }
                    else
                    {
                        this.dx = -1;
                        this.reachedPlant = false;
                        this.chomping.stop();
                    }
                }
            }
            if(reachedPlant==false)
            {
                this.dx = -1;
            }
        }
    }
}
