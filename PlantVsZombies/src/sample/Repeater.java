package sample;

import javafx.scene.layout.Pane;

public class Repeater extends Shooter {
//    String path="./assets/repeater.png";
    public Repeater(int x, int y, Pane pane,int z) {
        super(x, y, "file:src/sample/assets/repeater.gif", pane, 8,60,62,z);
    }
    @Override
    public void attack(){
        super.attack();
        super.attack();
    }
}