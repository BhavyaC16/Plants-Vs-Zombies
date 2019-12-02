package sample;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class Wallnut extends Plant{
    public Wallnut(int x, int y,int row,int col) {
        super(x, y, "file:src/sample/assets/walnut_full_life.gif", 1500,60,75,row,col);
        this.path="file:src/sample/assets/walnut_full_life.gif";

    }

}
