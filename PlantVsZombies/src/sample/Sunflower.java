package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Sunflower extends Plant{
    public Sunflower(int x, int y, Pane pane,int z){
        super(x,y,"file:src/sample/assets/sunflower.gif",pane,6,73,74,z);
    }
    public void produceSun(){

    }
}
