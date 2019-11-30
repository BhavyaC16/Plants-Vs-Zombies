package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Pea extends GameElements{
    private int lane;
    private int plantPosition;
    private Timeline peaAnimation;
    private static int peaID=0;
    private boolean flag;
    private int thispea;
    public Pea(int x, int y, Pane pane, int plantPosition, int lane) {
        super(x, y, "file:src/sample/assets/pea.png", pane,20,20);
        super.makeImage();
        this.plantPosition = plantPosition;
        this.lane = lane;
        thispea = peaID++;
        this.flag = false;
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
        checkZombieCollision();
    }

    public void shootPea(){
        Timeline animation = new Timeline(new KeyFrame(Duration.millis(5), e -> movePea()));
        animation.setCycleCount(1050);
        animation.play();
        this.peaAnimation = animation;
    }

    public void checkZombieCollision()
    {
        for(int i = 0; i<GamePlayController.allZombies.size(); i++)
        {
            //System.out.println("lane"+lane);
            if(GamePlayController.allZombies.get(i).getLane() == lane && !flag)
            {
                //System.out.println("Zombie in my lane"+lane);
                //System.out.println(GamePlayController.allZombies.get(i).getLane());
                if(Math.abs(GamePlayController.allZombies.get(i).getX()-getX())<=1 && !flag)
                {
                    this.flag = true;
                    GamePlayController.allZombies.get(i).setHp(GamePlayController.allZombies.get(i).getHp()-1);
                    img.setVisible(false);
                    img.setDisable(true);
                    peaAnimation.stop();
                }
            }
        }
    }

}
