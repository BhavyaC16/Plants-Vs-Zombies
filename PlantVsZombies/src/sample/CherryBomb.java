package sample;

import javafx.scene.layout.Pane;

public class CherryBomb extends Plant{
//    String path="./assets/cherryBomb.gif";
    public CherryBomb(int x, int y, Pane pane) {
        super(x, y, "file:src/sample/assets/cherryBomb.gif", pane, 4);
        System.out.println("Adding a cherr");
    }
    @Override
    public void attack(){
        //blast all the zombies around
    }
}
