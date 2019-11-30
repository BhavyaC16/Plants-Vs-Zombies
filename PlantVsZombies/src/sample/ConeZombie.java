package sample;

import javafx.scene.layout.Pane;

public class ConeZombie extends Zombie {
    public ConeZombie(int x, int y, int lane) {
        super(14, 1, "file:src/sample/assets/coneheadzombie.gif", x, y, 133, 122, lane);
    }
    @Override
    public void eatPlant()
    {
        for(int i = 0; i<GamePlayController.allPlants.size(); i++)
        {
            if(GamePlayController.allPlants.get(i).row == getLane())
            {
                if (Math.abs(GamePlayController.allPlants.get(i).getX()-img.getX())<=25)
                {
                    this.dx = 0;
                    GamePlayController.allPlants.get(i).setHp(GamePlayController.allPlants.get(i).getHp()-this.attackPower);
                    if(GamePlayController.allPlants.get(i).getHp()==0)
                    {
                        GamePlayController.allPlants.get(i).img.setVisible(false);
                        GamePlayController.allPlants.get(i).img.setDisable(true);
                        GamePlayController.allPlants.remove(i);
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
