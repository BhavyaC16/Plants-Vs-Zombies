package sample;

public abstract class Plant {
    String path;
    protected int hp;
    public Plant(){
        this.hp=20;
    }

    public abstract void attack(Zombie z);

    public int getHp(){
        return this.hp;
    }
    public void setHp(int n){
        this.hp-=n;
        if (this.hp==0){
            //disappear
            //remove from list
        }
    }

}
