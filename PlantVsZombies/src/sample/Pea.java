package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Pea extends GameElements{
    String path="./assets/pea.png";

    private int plantPosition;
    public Pea(int x, int y, Pane pane, int plantPosition) {
        super(x, y, "file:src/sample/assets/pea.png", pane,20,20);
        super.makeImage();
        this.plantPosition = plantPosition;
    }

    public void movePea(){
        if(x<=1050)
        {
            setX(getX()+1);
        }
        if(this.plantPosition>getX())
        {
            img.setVisible(false);
        }
        else
        {
            img.setVisible(true);
        }
    }

    public void shootPea(){
        Timeline animation = new Timeline(new KeyFrame(Duration.millis(5), e -> movePea()));
        animation.setCycleCount(1050);
        animation.play();

    }

}
