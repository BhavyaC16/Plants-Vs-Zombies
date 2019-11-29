package sample;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class PeaShooter extends Shooter{
//    String path="./assets/peashooter.png";
    private PeaShooter(int x, int y, Pane pane, int z, GridPane grid,int row,int col) {
        super(x, y, "file:src/sample/assets/peashooter.gif", pane, 7,60,62,z, grid,row,col);
    }
    public void attack(){
       Pea pea = Pea.getPea(x,y,pane);
       pea.throwpea();
    }

}
