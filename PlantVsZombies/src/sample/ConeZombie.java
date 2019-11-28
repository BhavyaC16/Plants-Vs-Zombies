package sample;

import javafx.scene.image.Image;

public class ConeZombie extends Zombie implements Runnable{
    //private Image cz;
    public ConeZombie(int x,int y){
        //this.cz = new Image("file:src/sample/assets/coneheadzombie.gif",133,122,false,false);
        super(6,1,new Image("file:src/sample/assets/coneheadzombie.gif",133,122,false,false),x,y);
    }
}
