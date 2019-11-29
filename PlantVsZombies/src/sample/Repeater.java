package sample;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class Repeater extends Shooter {
//    String path="./assets/repeater.png";
    public Repeater(int x, int y, Pane pane, GridPane grid,int row,int col) {
        super(x, y, "file:src/sample/assets/repeater.gif", pane, 8,60,62,grid,row,col);
    }
    @Override
    public void attack(){
        super.attack();
        Pea pea2=Pea.getPea(x,y,pane);
        pea2.img.setVisible(false);
        pea2.img.setDisable(true);
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
