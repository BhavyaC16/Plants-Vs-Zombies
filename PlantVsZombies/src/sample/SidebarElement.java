package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.HashMap;

public class SidebarElement extends GameElements{
    private static int cardSelected=-1;
    private int timeoutTime;
    private boolean isDisabled=false;
    private String associatedPlant;
    private static ImageView selectedBorder;
//    private static SidebarElement selectedElement;
    private static HashMap<Integer,SidebarElement> allElements;
    public SidebarElement(int x,int y,String path,Pane pane){
        super(x,y,path,pane);
    }

    public static void getSideBarElements(int level,Pane pane){
        String path;
        int x;
        int y;
        selectedBorder =new ImageView(new Image("file:src/sample/assets/selectedCardBorder.png",100.0,64.0,false,false));
        pane.getChildren().add(selectedBorder);
        selectedBorder.setVisible(false);
        selectedBorder.setDisable(true);

        allElements=new HashMap<Integer, SidebarElement>();
        if(level>=1){
            path="file:src/sample/assets/sunflowerCard.png";
            x=24;
            y=79;
            SidebarElement sunflowerCard=new SidebarElement(x,y,path,pane);
            sunflowerCard.timeoutTime=5000;
            sunflowerCard.associatedPlant="Sunflower";
            Image sunflowerImage = new Image(path, 97, 58, false, false);
            allElements.put(1,sunflowerCard);
            sunflowerCard.img.setImage(sunflowerImage);
            sunflowerCard.img.setOnMouseClicked(e->{
                if (!sunflowerCard.isDisabled){
                    System.out.println("SUnflowerclcked");
//                    cardSelected=1;
                    setCardSelected(1);

//                    selectedElement=sunflowerCard;
                }
            });
        }
        if(level>=1){
            path="file:src/sample/assets/peashooterCard.png";
            x=22;
            y=147;
            SidebarElement peashooterCard=new SidebarElement(x,y,path,pane);
            peashooterCard.timeoutTime=6000;
            peashooterCard.associatedPlant="PeaShooter";
            allElements.put(2,peashooterCard);
            Image peashooterImage = new Image(path, 97, 58, false, false);
            peashooterCard.img.setImage(peashooterImage);
            peashooterCard.img.setOnMouseClicked(e->{
                if (!peashooterCard.isDisabled){
                    System.out.println("pealcked");
//                    cardSelected=2;
                      setCardSelected(2);
//                    selectedElement=peashooterCard;
                }
            });
        }
        if (level>=2){
            path="file:src/sample/assets/wallnutCard.png";
            x=22;
            y=217;
            SidebarElement wallnutCard=new SidebarElement(x,y,path,pane);
            wallnutCard.timeoutTime=7000;
            wallnutCard.associatedPlant="Wallnut";
            allElements.put(3,wallnutCard);
            Image wallnutImage = new Image(path, 97, 58, false, false);
            wallnutCard.img.setImage(wallnutImage);
            wallnutCard.img.setOnMouseClicked(e->{
                if (!wallnutCard.isDisabled) {
//                    cardSelected=3;
                    setCardSelected(3);
//                    selectedElement=wallnutCard;
                }
            });
        }
        if (level>=3) {
            path="file:src/sample/assets/cherrybombCard.png";
            x=22;
            y=284;
            SidebarElement cherrybombCard=new SidebarElement(x,y,path,pane);
            cherrybombCard.timeoutTime=8000;
            cherrybombCard.associatedPlant="CherryBomb";
            allElements.put(4,cherrybombCard);
            Image cherrybombImage = new Image(path, 97, 58, false, false);
            cherrybombCard.img.setImage(cherrybombImage);
            cherrybombCard.img.setOnMouseClicked(e->{
                if (!cherrybombCard.isDisabled) {
                    System.out.println("CherryBomb clicked");
//                    cardSelected=3;
                    setCardSelected(4);
//                    selectedElement=cherrybombCard;
                }
            });
        }
        if(level>=4) {
            path="file:src/sample/assets/repeater.png";
            x=23;
            y=352;
            SidebarElement repeaterCard=new SidebarElement(x,y,path,pane);
            repeaterCard.timeoutTime=9000;
            repeaterCard.associatedPlant="Repeater";
            allElements.put(5,repeaterCard);
            repeaterCard.img.setOnMouseClicked(e->{
                if (!repeaterCard.isDisabled){
                    System.out.println("repeater clicked");
//                    cardSelected=5;
                    setCardSelected(5);
//                    selectedElement=repeaterCard;
                }
            });
        }
        if (level>=5) {
            path="file:src/sample/assets/jalapenoCard.png";
            x=24;
            y=410;
            SidebarElement jalapenoCard=new SidebarElement(x,y,path,pane);
            jalapenoCard.timeoutTime=10000;
            jalapenoCard.associatedPlant="Jalapeno";
            allElements.put(6,jalapenoCard);
            Image jalapenoImage = new Image(path, 97, 58, false, false);
            jalapenoCard.img.setImage(jalapenoImage);
            jalapenoCard.img.setOnMouseClicked(e->{
                if (!jalapenoCard.isDisabled) {
                    System.out.println("Jalapeno clicked");
//                    cardSelected=6;
                    setCardSelected(6);

//                    selectedElement=jalapenoCard;
                }
            });

        }
    }

    public static int getCardSelected() {
        return cardSelected;
    }
    private static void setCardSelected(int i){
        cardSelected=i;
        selectedBorder.setVisible(true);
        selectedBorder.setX(allElements.get(cardSelected).getX());
        selectedBorder.setY(allElements.get(cardSelected).getY());
    }
    public static void setCardSelectedToNull(){
        cardSelected=-1;
        selectedBorder.setVisible(false);
    }
//    public static SidebarElement getSelectedElement(){
//        return selectedElement;
//    }
//    public static void setSelectedElementToNull(){
//        selectedElement=null;
//    }
    public static SidebarElement getElement(int x){
        if (allElements.containsKey(x)) return allElements.get(x);
        else return null;
    }

    public void setDisabledOn(){
        this.isDisabled=true;
        ImageView im =new ImageView(new Image("file:src/sample/assets/lock.png",50.0,50.0,false,false));
        im.setX(this.getX()+10);
        im.setY(this.getY());
        this.pane.getChildren().add(im);
        System.out.println("Added lock image");

        Thread t = new Thread(() -> {
            try {
                System.out.println("now disabled");
                Thread.sleep(this.timeoutTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.isDisabled=false;
            System.out.println("Now not disabled");
            im.setVisible(false);
            im.setDisable(true);
        });
        t.start();

    }
}
