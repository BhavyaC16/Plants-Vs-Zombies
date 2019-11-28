package sample;

import javafx.scene.image.Image;

public class NormalZombie extends Zombie implements Runnable{
    //private Image nz;
    public NormalZombie(int x,int y){
        //this.nz = new Image("file:src/sample/assets/normalzombie.gif",68,118,false,false);
        super(5,1,new Image("file:src/sample/assets/normalzombie.gif",68,118,false,false),x,y);
    }
}
