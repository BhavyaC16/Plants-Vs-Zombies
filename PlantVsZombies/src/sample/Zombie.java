package sample;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Zombie implements Runnable{
    protected int hp;
    protected int x;
    protected int y;
    protected int attackPower;
    //protected String path;
    protected ImageView zombie;
    protected Image zombieImage;
    public Zombie(int hp, int ap,Image zombieImg,int x,int y){
        this.x = x;
        this.y = y;
        this.hp=hp;
        this.attackPower=ap;
       this.zombieImage = zombieImg;
       this.zombie = new ImageView();
       this.zombie.setImage(this.zombieImage);
    }
    public int getHp(){
        return this.hp;
    }
    public void setHp(int hp){
        this.hp=hp;
    }
    public void setLane(int lane){ this.y = lane; }
    public int getX(){ return this.x; }
    public int getY(){ return this.y; }
    public void checkCollisionWithPlant(){

    }
    public boolean checkReachedHouse(){
        if(this.x<=50)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public boolean isAlive()
    {
        if(this.hp>0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public void moveZombie(){
        AnimationTimer timer = new AnimationTimer()
        {
            double dx = -2;
            @Override
            public void handle(long now)
            {
                zombie.setLayoutX(zombie.getLayoutX()+dx);

                if(checkReachedHouse())
                {
                    //activate lawnmower or end game.
                }
                /*
                if(checkCollisionWithPlant())
                {
                    //make zombie wait (put sleep on thread for 8 seconds)
                    //make plant disappear and resume zombie.
                }
                */
                if(!isAlive())
                {
                    //kill zombie
                }
            }
        };
    }
    @Override
    public void run(){
        while(this.hp>0) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //if(this.hp==5)
            //Plant p=checkCollisionWithPlant();
            /*
            if(p!=null){
                while(p.getHp()>0) {
                    p.setHp(p.getHp()-this.attackPower);
                }
            }
            if(checkReachedHouse()){
                GamePlayController.gameWon=True;
            }
            */
            moveZombie();
        }
    }
}
