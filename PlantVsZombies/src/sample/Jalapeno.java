package sample;

import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class Jalapeno extends Plant {
    private ArrayList<Zombie> roastedZombies;
    transient private ImageView[] fireViews;

    public Jalapeno(int x, int y,int row,int col) {
        super(x, y, "file:src/sample/assets/jalapeno.gif", 4,100,100,row,col);
        System.out.println("Placed plant");
        fireViews=new ImageView[9];;
    }
    @Override
    public void makeImage(GridPane lawn){
        super.makeImage(lawn);
        for(int i=0;i<9;i++){
            fireViews[i]=new ImageView(new Image("file:src/sample/assets/jalapenoFire.gif",(double) 100, (double) 100, false,false));
            fireViews[i].setDisable(true);
            fireViews[i].setVisible(false);
            lawn.add(fireViews[i],i,this.row,1,1);
            this.roastedZombies = new ArrayList<Zombie>();
        }
    }

    @Override
    public void attack(Pane pane) {
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(1650);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            img.setVisible(false);
            img.setDisable(true);
            for(int i=0;i<9;i++){
                fireViews[i].setVisible(true);
            }
            for(int i = 0; i<GamePlayController.allZombies.size(); i++)
            {
                if(row == GamePlayController.allZombies.get(i).getLane())
                {
                    GamePlayController.allZombies.get(i).roastZombie();
                }
            }
            for(int j = 0; j<GamePlayController.allPlants.size(); j++)
            {
                if(this==GamePlayController.allPlants.get(j))
                {
                    GamePlayController.allPlants.remove(j);
                }
            }
            for(int k = 0; k<this.roastedZombies.size(); k++)
            {
                for(int m = 0; m<GamePlayController.allZombies.size(); m++)
                {
                    if(roastedZombies.get(k)==GamePlayController.allZombies.get(m))
                    {
                        GamePlayController.allZombies.remove(m);
                    }
                }
            }
            removefire();
        });
        t.start();
    }

   public void removefire(){
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for(int i=0;i<9;i++) {
                fireViews[i].setVisible(false);
                fireViews[i].setDisable(true);
            }
        });
        t.start();
    }

}
