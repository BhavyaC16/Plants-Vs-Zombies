# Plants-Vs-Zombies 🌱🌵 Vs 🧟‍♂️🧟‍♀️
## Details
**Created by:
[Bhavya Chopra](https://www.github.com/BhavyaC16) and [Sonali Singhal](https://www.github.com/SonaliSinghal)**

This is a clone of the strategy video game, [Plants vs. Zombies](https://en.wikipedia.org/wiki/Plants_vs._Zombies), originally developed by PopCap Games.

A working demo of the game can be seen [here](https://www.youtube.com/watch?v=AgMRkRLPeFU).

Made as a part of project in Advanced Programming course at IIIT-Delhi.

Uses Java and JavaFx.

## Features
- 5 Levels with increasing difficulties
- 2 Themes (Night Mode and Day Mode)
- Plants Available: Sunflower, Pea Shooter, Cherry Bomb, Walnut, Repeater, Jalapeno
- Zombies Available: Normal Zombie, Conehead Zombie and Buckethead Zombie
- Almanac: Displays details and attack methods and power of each zombie and plant
- Shovel: Tool to shovel plants out of the grid
- Save Game and Restart Game options: User can save multiple game states, and reload them, or delete game progress
- Cool sound effects for all lawn interactions
- Lots of fun :P

## Implementation
- Navigation is via FXML files
- __Load Game__ menu is used to load multiple saved states of the game. Everytime a user saves a game, the game state is given an id, which is displayed as Game_ID along with the level on which the game was saved. 'Delete all progress' removes all the saved game states.
- __Level Menu__ can be used for starting a new game from the unlocked levels. A user cannot play a new level if they haven't won the all previous levels.
- __Exit Game__ saves all the progress and exits the game.
- __In Game Menu__: Allows the user to save the game, restart the game or exit to main menu.
- Levels become harder as the user progresses through the game. The cone and bucket zombies start appearing in subsequent levels, their frequency also increases. 
- Different menus on winning and losing a game. Winning tells the user about the new plant unlock and losing menu gives the message “Zombies ate your brains”
- After placing a plant, a plant is locked for sometime before it can be planted again.
- The __shovel__ can be used to remove a plant from the lawn.
- Sound effects have been added for all interactions on the lawn to enhance the experience.
- The users can also choose between the day and the night mode. Unlike the day mode, no sun tokens fall from the sky in the night mode, and sunflowers are the only source of sun tokens.

## Design Patterns
1. Singleton: For the database and for shovel feature, as we need only one reference through out the game.
2. Iterator - To ensure that Plant, Zombie and Lawnmower lists are accessed in a synchronized way.
3. Facade for menu based implementation


## Screenshots from the game
![alt_text](https://github.com/BhavyaC16/Plants-Vs-Zombies/blob/master/GameplayScreenshots/1.png)
![alt_text](https://github.com/BhavyaC16/Plants-Vs-Zombies/blob/master/GameplayScreenshots/4.png)
![alt_text](https://github.com/BhavyaC16/Plants-Vs-Zombies/blob/master/GameplayScreenshots/Arena.png)
![alt_text](https://github.com/BhavyaC16/Plants-Vs-Zombies/blob/master/GameplayScreenshots/2.png)
![alt_text](https://github.com/BhavyaC16/Plants-Vs-Zombies/blob/master/GameplayScreenshots/5.png)
![alt_text](https://github.com/BhavyaC16/Plants-Vs-Zombies/blob/master/GameplayScreenshots/3.png)

## How To play
### Executing the JAR File
To play the game, the following steps can be followed:
1. Clone this repository using the command: `git clone https://github.com/BhavyaC16/Plants-Vs-Zombies.git`
2. cd into the directory `Plant-Vs-Zombies-JAR` using: `cd PlantsVsZombies/Plant-Vs-Zombies-JAR`
3. Download the JavaFX SDK 11.0.2 from [here](https://gluonhq.com/products/javafx/), depending on your platform. Unzip and situate the folder `javafx-sdk-11.0.2` in `PlantsVsZombies/Plant-Vs-Zombies-JAR`
4. Execute the command `./PlantsVsZombies.sh` . Alternatively, execute the command `java --module-path ~/javafx-sdk-11.0.2/lib --add-modules javafx.controls,javafx.fxml,javafx.graphics,javafx.media -jar PlantVsZombies.jar`<br>
(Note: `--module-path` specifies the path to your JavaFX SDK 11 lib folder. The variable `LIB_PATH` in `PlantsVsZombies` holds the path to the lib folder, and can be updated accordingly.)

## Code and assets
Path to code: `PlantVsZombies/src/sample` <br>
Path to Images and sounds: `PlantVsZombies/src/sample/assets`

## License
### GNU General Public License v3.0
You may copy, distribute and modify the software as long as you track changes/dates in source files. Any modifications to or software including (via compiler) GPL-licensed code must also be made available under the GPL along with build & install instructions.
