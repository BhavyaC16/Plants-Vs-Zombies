package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class CherryBomb extends Plant{

    private ArrayList<Zombie> roastedZombies;
    transient ImageView powie;

    public CherryBomb(int x, int y,int row,int col) {
        super(x, y, "/assets/anim_cherrybomb.gif", 4,90,68,row,col);
        this.path = getClass().getResource("/assets/anim_cherrybomb.gif").toString();
    }

    @Override
    public void makeImage(GridPane lawn){
        super.makeImage(lawn);
        powie=new ImageView(new Image(getClass().getResource("/assets/powie.gif").toString(),180,160,false,false));
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
            Media explode = new Media(getClass().getResource("/assets/sounds/cherrybomb.wav").toString());
            MediaPlayer mediaPlayer = new MediaPlayer(explode);
            mediaPlayer.setAutoPlay(true);
            mediaPlayer.play();
            img.setVisible(false);
            img.setDisable(true);
            powie.setVisible(true);
            //System.out.println("attacking");
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
            powie.setVisible(false);
        });
        t.start();
        this.setHp(0);
    }
}
