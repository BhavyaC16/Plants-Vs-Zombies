package sample;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class Wallnut extends Plant{
    public Wallnut(int x, int y,int row,int col) {
        super(x, y, "/assets/walnut_full_life.gif", 400,60,75,row,col);
        this.path=getClass().getResource("/assets/walnut_full_life.gif").toString();
    }
    public void checkHp()
    {
        if(getHp()<=0)
        {
            setHp(0);
            GamePlayController.allPlants.remove(this);
            img.setVisible(false);
            img.setDisable(true);
        }
    }

}
