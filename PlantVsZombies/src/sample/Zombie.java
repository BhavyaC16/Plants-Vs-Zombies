package sample;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public abstract class Zombie extends GameElements {

    protected int hp;
    protected int x;
    protected int y;
    protected int attackPower;
    protected int lane;

    public Zombie(int hp, int ap, String p, int x, int y, Pane pane, int width, int height, int lane) {
        super(x, y, p, pane, width, height);
        this.hp = hp;
        this.attackPower = ap;
        super.makeImage();
        this.lane = lane;
    }

    public int getHp() {
        return this.hp;
    }

    public int getLane() {
        return (this.lane);
    }

    public void setHp(int hp) {
        this.hp = hp;
        if (hp<=5) {
            img.setImage(new Image("file:src/sample/assets/normalzombie.gif", (double) 68,(double) 118,false,false));
            this.width=68;
            this.height=118;
        }
        if(hp<=0){
        }

    }

    public void roastZombie(){
        img.setImage(new Image("file:src/sample/assets/burntZombie.gif", (double) 68,(double) 118,false,false));
        //add code here to stop zombie animation
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

    public void checkCollisionWithPlant() {

    }

    public boolean checkReachedHouse() {
        if (this.x <= 240) {
            return true;
        } else {
            return false;
        }
    }

    public void moveZombie() {
        Timeline animation = new Timeline(new KeyFrame(Duration.millis(50), e -> zombieWalk()));
        animation.setCycleCount(1000);
        animation.play();
    }

    public void zombieWalk()
    {
        if(getX()>=240)
        {
            setX(getX()-1);
        }
    }
}