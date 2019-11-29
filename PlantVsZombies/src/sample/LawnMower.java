package sample;

import javafx.scene.layout.Pane;

public class LawnMower extends GameElements{
    int lane;
    String activatedPath="file:src/sample/assets/lawnmowerActivated.gif";
    public LawnMower(int x, int y, Pane pane, int lane){
        super(x, y, "file:src/sample/assets/lawnmowerIdle.gif", pane, 81, 77);
        super.makeImage();
        this.lane=lane;
    }
    public void activate(){

    }
}
