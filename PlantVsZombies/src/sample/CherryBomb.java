package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class CherryBomb extends Plant{

    private ArrayList<Zombie> roastedZombies;
    transient ImageView powie;

    public CherryBomb(int x, int y,int row,int col) {
        super(x, y, "file:src/sample/assets/anim_cherrybomb.gif", 4,90,68,row,col);

    }

    @Override
    public void makeImage(GridPane lawn){
        super.makeImage(lawn);
        powie=new ImageView(new Image("file:src/sample/assets/powie.gif",180,160,false,false));
        powie.setX(x-40);
        powie.setY(y-20);
        powie.setVisible(false);
        powie.setDisable(true);
        this.roastedZombies = new ArrayList<Zombie>();
    }

    @Override
    public void attack(Pane pane) {
        pane.getChildren().add(powie);
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(1800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            img.setVisible(false);
            img.setDisable(true);
            powie.setVisible(true);
            System.out.println("attacking");
            synchronized (GamePlayController.allZombies)
            {
                Iterator<Zombie> i = GamePlayController.allZombies.iterator();
                while(i.hasNext()) {
                    Zombie x = i.next();
                    if(x.getX()<=(getX()+250) && x.getX()>=(getX()-150))
                    {
                        if(x.getY()<=(getY()+250) && x.getY()>=(getY()-150)) {
                            roastedZombies.add(x);
                            x.roastZombie();
                        }
                    }
                }
            }
            for(int j = 0; j<GamePlayController.allPlants.size(); j++)
            {
                if(this==GamePlayController.allPlants.get(j))
                {
                    GamePlayController.allPlants.remove(j);
                    break;
                }
            }
            for(int k = 0; k<roastedZombies.size(); k++)
            {
                for(int m = 0; m<GamePlayController.allZombies.size(); m++)
                {
                    if(this.roastedZombies.get(k)==GamePlayController.allZombies.get(m))
                    {
                        GamePlayController.allZombies.remove(m);
                    }
                }
            }
            removepowie();
        });
        t.start();
    }

    public void removepowie(){
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(1250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ee");
            powie.setVisible(false);
        });
        t.start();
        this.setHp(0);
    }
}
