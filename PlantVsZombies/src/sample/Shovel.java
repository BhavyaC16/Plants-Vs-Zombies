package sample;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.effect.Glow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class Shovel extends GameElements{
    private static boolean isDisabled=true;
    private static Shovel shovel;

    private Shovel(){
        super(500,10,"/assets/Shovel.png",60,60);
        this.path = getClass().getResource("/assets/Shovel.png").toString();
    }
    public boolean isIsDisabled(){
        return isDisabled;
    }

    public static Shovel getInstance(){
        if (shovel==null){
            shovel=new Shovel();

        }
        return shovel;
    }

    @Override
    public void makeImage(Pane p)
    {
        super.makeImage(p);
        shovel.img.setOnMouseClicked(e-> {
            shovel.isDisabled = false;
            shovel.enable();
            SidebarElement.setCardSelectedToNull();
        });
    }

    public void enable(){
        Glow glow=new Glow();
        shovel.img.setEffect(glow);
        glow.setLevel(0.4);
    }

    public void disable(){
        if (!isDisabled){
            Glow glow=(Glow) shovel.img.getEffect();
            glow.setLevel(0.0);
            shovel.isDisabled=true;
        }
    }
}
