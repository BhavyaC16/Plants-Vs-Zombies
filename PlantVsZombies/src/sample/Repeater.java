package sample;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class Repeater extends Shooter {
//    String path="./assets/repeater.png";
    public Repeater(int x, int y, Pane pane, int z, GridPane grid,int row,int col) {
        super(x, y, "file:src/sample/assets/repeater.gif", pane, 8,60,62,z,grid,row,col);
    }
    @Override
    public void attack(){
        super.attack();
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.start();
        super.attack();
    }
}
