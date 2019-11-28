package sample;

import javafx.scene.layout.Pane;

public class Repeater extends Shooter {
//    String path="./assets/repeater.png";
    public Repeater(int x, int y, Pane pane) {
        super(x, y, "file:src/sample/assets/repeater.gif", pane, 8);
    }
    @Override
    public void attack(){
        super.attack();
        super.attack();
    }
}
