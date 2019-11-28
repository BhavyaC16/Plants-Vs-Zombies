package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Sunflower extends Plant{
    public Sunflower(int x, int y, Pane pane){
        super(x,y,"file:src/sample/assets/sunflower.gif",pane,6);
    }
    public void produceSun(){

    }
}
