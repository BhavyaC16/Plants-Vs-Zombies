package sample;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class Jalapeno extends Plant {
    public Jalapeno(int x, int y, Pane pane, int z, GridPane grid) {
        super(x, y, "file:src/sample/assets/jalapeno.gif", pane, 4,100,100, z, grid);
    }
    @Override
    public void attack(){
        //blast all the zombies around
    }
}
