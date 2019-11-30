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
                }
                else
                {
                    this.dx = -1;
                }
            }
        }
    }
}
