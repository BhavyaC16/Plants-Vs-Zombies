package sample;

import javafx.scene.image.Image;

public class BucketZombie extends Zombie implements Runnable{
    //private Image bz = new Image("file:src/sample/assets/bucketheadzombie.gif",68,118,false,false);
    public BucketZombie(int x,int y){
        super(6,1,new Image("file:src/sample/assets/bucketheadzombie.gif",68,118,false,false),x,y);
    }
    @Override
    public void run()
    {
        super.run();
    }
}
