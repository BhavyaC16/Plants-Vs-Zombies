package sample;

import javafx.scene.layout.Pane;

import java.util.Iterator;

public class ConeZombie extends Zombie {
    public ConeZombie(int x, int y, int lane) {
        super(14, 1, "file:src/sample/assets/coneheadzombie.gif", x, y, 133, 122, lane);
    }
    @Override
    public void eatPlant()
    {
        synchronized (GamePlayController.allPlants)
        {
            Iterator<Plant> i = GamePlayController.allPlants.iterator();
            while(i.hasNext())
            {
                Plant p = i.next();
                if(p.row == getLane())
                {
                    if (Math.abs(p.getX()-img.getX())<=25)
                    {
                        this.dx = 0;
                        p.setHp(p.getHp()-this.attackPower);
                        if(p.getHp()==0)
                        {
                            p.img.setVisible(false);
                            p.img.setDisable(true);
                            GamePlayController.allPlants.remove(p);
                            this.dx = -1;
                        }
                    }
                    else
                    {
                        this.dx = -1;
                    }
                }
            }
        }
    }
}
