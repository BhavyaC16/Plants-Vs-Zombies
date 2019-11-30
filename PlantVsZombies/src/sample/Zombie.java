package sample;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import java.io.Serializable;

public abstract class Zombie extends GameElements {

    protected int hp;
    protected int x;
    protected int y;
    protected int attackPower;
    protected int lane;
    protected int dx;
    transient protected Timeline zombieAnimation;

    public Zombie(int hp, int ap, String p, int x, int y, int width, int height, int lane) {
        super(x, y, p, width, height);
        this.hp = hp;
        this.attackPower = ap;
//        super.makeImage();
        this.lane = lane;
        this.dx = -1;
    }

    public int getHp() {
        return this.hp;
    }

    public int getLane() {
        return (this.lane);
    }

    public void setHp(int hp) {
        this.hp = hp;
        if(hp<=0){
            GamePlayController.numZombiesKilled+=1;
            this.img.setVisible(false);
            this.img.setDisable(true);
            this.zombieAnimation.stop();
            for(int i = 0; i<GamePlayController.allZombies.size(); i++)
            {
                if(this==GamePlayController.allZombies.get(i))
                {
                    GamePlayController.allZombies.remove(i);
                    System.out.println("removed");
                    break;
                }
            }
        }
        if (hp<=7) {
            img.setImage(new Image("file:src/sample/assets/normalzombie.gif", (double) 68,(double) 118,false,false));
            this.width=68;
            this.height=118;
        }
    }

    public void roastZombie(){
        img.setImage(new Image("file:src/sample/assets/burntZombie.gif", (double) 68,(double) 118,false,false));
        this.dx=0;
        this.hp = 0;
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            img.setVisible(false);
            img.setDisable(true);
        });
        t.start();

    }

    public void setLane(int lane) {
        this.y = lane;
    }

    public void checkReachedHouse() {
        if (img.getX() <= 220) {
            GamePlayController.wonGame = -1;
        }
    }

    public void moveZombie() {
        Timeline animation = new Timeline(new KeyFrame(Duration.millis(70), e -> zombieWalk()));
        animation.setCycleCount(1000);
        animation.play();
        this.zombieAnimation = animation;
    }

    public void zombieWalk()
    {
        if(getX()>220 && this.hp>0)
        {
            setX(getX()+this.dx);
            eatPlant();
            checkReachedHouse();
        }
    }

    public Timeline getZombieAnimation()
    {
        return this.zombieAnimation;
    }

    public void eatPlant()
    {
        for(int i = 0; i<GamePlayController.allPlants.size(); i++)
        {
            if(GamePlayController.allPlants.get(i).row == getLane())
            {
                if (Math.abs(GamePlayController.allPlants.get(i).getX()-img.getX())<=50)
                {
                    this.dx = 0;
                    GamePlayController.allPlants.get(i).setHp(GamePlayController.allPlants.get(i).getHp()-this.attackPower);
                    if(GamePlayController.allPlants.get(i).getHp()==0)
                    {
                        GamePlayController.allPlants.get(i).img.setVisible(false);
                        GamePlayController.allPlants.get(i).img.setDisable(true);
                        GamePlayController.allPlants.remove(i);
                        this.dx = -1;
                    }
                }
                else
                {
                    this.dx = -1;
                }
            }
        }
    }
}