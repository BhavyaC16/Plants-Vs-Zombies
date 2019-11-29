package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class LawnMower extends GameElements{
    int lane;
    String activatedPath="file:src/sample/assets/lawnmowerActivated.gif";
    public LawnMower(int x, int y, Pane pane, int lane){
        super(x, y, "file:src/sample/assets/lawnmowerIdle.gif", pane, 81, 77);
        super.makeImage();
        this.lane=lane;
    }
    public void activate(){
        img.setImage(new Image(activatedPath, 81, 77, false, false));
        Timeline animation = new Timeline(new KeyFrame(Duration.millis(5), e -> moveMower()));
        animation.setCycleCount(1100);
        animation.play();
    }
    public void moveMower()
    {
        if(getX()<=1100)
        {
            setX(getX()+1);
        }
    }
}
