package sample;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

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
        //add code for displaying zombie
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

    }

    //    public Plant checkCollisionWithPlant(){
//
//    }
    public void setLane(int lane) {
        this.y = lane;
    }

    public void checkCollisionWithPlant() {

    }

    public boolean checkReachedHouse() {
        if (this.x <= 50) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isAlive() {
        if (this.hp > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void moveZombie() {
        Thread t = new Thread(() -> {
            while (this.hp > 0) {
                try {
                    //System.out.println("running");
                    setX(getX() - 1);
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }
}