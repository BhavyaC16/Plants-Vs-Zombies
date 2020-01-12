package sample;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;
import java.io.Serializable;
import java.util.Iterator;

public abstract class Zombie extends GameElements {

    protected int hp;
    protected int x;
    protected int y;
    protected int attackPower;
    protected int lane;
    protected int dx;
    transient protected Timeline zombieAnimation;
    protected boolean reachedPlant = false;
    protected boolean isEating = false;
    protected transient Timeline chomping;

    public Zombie(int hp, int ap, String p, int x, int y, int width, int height, int lane) {
        super(x, y, p, width, height);
        this.hp = hp;
        this.attackPower = ap;
        this.lane = lane;
        this.dx = -1;
        this.chomping = new Timeline();
    }

    public int getHp() {
        return this.hp;
    }

    public int getLane() {
        return (this.lane);
    }

    public void setHp(int hp) {
        this.hp = hp;
        if(hp<=0){
            GamePlayController.numZombiesKilled+=1;
            this.img.setVisible(false);
            this.img.setDisable(true);
            this.zombieAnimation.stop();
            if(this.chomping!=null)
            {
                this.chomping.stop();
            }
            for(int i = 0; i<GamePlayController.allZombies.size(); i++)
            {
                if(this==GamePlayController.allZombies.get(i))
                {
                    GamePlayController.allZombies.remove(i);
                    Media yuck = new Media(getClass().getResource("/assets/sounds/yuck.wav").toString());
                    MediaPlayer mediaPlayer = new MediaPlayer(yuck);
                    mediaPlayer.setAutoPlay(true);
                    mediaPlayer.play();
                    //System.out.println("removed");
                    break;
                }
            }
        }
        if (hp<=7) {
            img.setImage(new Image(getClass().getResource("/assets/normalzombie.gif").toString(), (double) 68,(double) 118,false,false));
            this.width=68;
            this.height=118;
        }
    }

    public void roastZombie(){
        img.setImage(new Image(getClass().getResource("/assets/burntZombie.gif").toString(), (double) 68,(double) 118,false,false));
        this.dx=0;
        this.hp = 0;
        this.chomping.stop();
        GamePlayController.numZombiesKilled+=1;
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            img.setVisible(false);
            img.setDisable(true);
        });
        t.start();

    }

    public void setLane(int lane) {
        this.y = lane;
    }

    public void checkReachedHouse() {
        if (img.getX() <= 220) {
            GamePlayController.wonGame = -1;
            Media brainz = new Media(getClass().getResource("/assets/sounds/brainz.wav").toString());
            MediaPlayer mediaPlayer = new MediaPlayer(brainz);
            mediaPlayer.setAutoPlay(true);
            mediaPlayer.play();
        }
    }

    public void moveZombie() {
        Timeline animation = new Timeline(new KeyFrame(Duration.millis(70), e -> zombieWalk()));
        animation.setCycleCount(Animation.INDEFINITE);
        animation.play();
        this.zombieAnimation = animation;
        GamePlayController.animationTimelines.add(animation);
    }

    public void zombieWalk()
    {
        if(getX()>220 && this.hp>0)
        {
            setX(getX()+this.dx);
            try{
                eatPlant();
            }
            catch(java.util.ConcurrentModificationException e)
            {
                //System.out.println("killed plant");
            }
            checkReachedHouse();
        }
    }

    public Timeline getZombieAnimation()
    {
        return this.zombieAnimation;
    }

    public void chompPlant()
    {
        Media chomp = new Media(getClass().getResource("/assets/sounds/chomp.wav").toString());
        MediaPlayer mediaPlayer = new MediaPlayer(chomp);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setStartTime(Duration.seconds(0));
        mediaPlayer.setStopTime(Duration.seconds(1));
        mediaPlayer.setCycleCount(1);
        mediaPlayer.play();
    }

    public void eatPlant()
    {
        int foundPlant = 0;
        synchronized (GamePlayController.allPlants)
        {
            Iterator<Plant> i = GamePlayController.allPlants.iterator();
            while(i.hasNext())
            {
                Plant p = i.next();
                if(p.row == getLane())
                {
                    if (Math.abs(p.getX()-img.getX())<=50)
                    {
                        foundPlant=1;

                        if(reachedPlant==false)
                        {
                            reachedPlant = true;
                            isEating = true;
                        }
                        if(isEating)
                        {
                            Timeline chomp = new Timeline(new KeyFrame(Duration.millis(1000), e -> chompPlant()));
                            chomp.setCycleCount(1000);
                            chomp.play();
                            this.dx = 0;
                            this.chomping = chomp;
                            GamePlayController.animationTimelines.add(chomp);
                            isEating = false;
                        }
                        if(foundPlant==1)
                        {
                            this.dx = 0;
                            p.setHp(p.getHp()-this.attackPower);
                            if(p.getHp()<=0)
                            {
                                p.setHp(0);
                                GamePlayController.allPlants.remove(p);
                                p.img.setVisible(false);
                                p.img.setDisable(true);
                                this.dx = -1;
                                this.reachedPlant = false;
                                this.chomping.stop();
                            }
                        }
                    }
                    else
                    {
                        this.dx = -1;
                        this.reachedPlant = false;
                        if(this.chomping!=null)
                        {
                            this.chomping.stop();
                        }
                    }
                }
                else
                {
                    this.dx = -1;
                }
            }
        }
        if(foundPlant==0)
        {
            this.dx = -1;
            if(this.chomping!=null)
            {
                this.chomping.stop();
            }
            this.reachedPlant=false;
        }
    }
}