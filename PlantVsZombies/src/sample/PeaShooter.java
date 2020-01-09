package sample;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class PeaShooter extends Shooter{
//    String path="./assets/peashooter.png";
    public PeaShooter(int x, int y,int row,int col) {
        super(x, y, "/assets/peashooter.gif", 100,60,62,row,col);
        this.path=getClass().getResource("/assets/peashooter.gif").toString();
    }

}
