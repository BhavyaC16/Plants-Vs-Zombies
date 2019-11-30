package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class LevelMenuController {

    @FXML
    private AnchorPane levelRoot;

    @FXML
    private ImageView level1button;

    @FXML
    private ImageView level2button;

    @FXML
    private ImageView level3button;

    @FXML
    private ImageView level4button;

    @FXML
    private ImageView level5button;

    @FXML
    private ImageView lock2;

    @FXML
    private ImageView lock3;

    @FXML
    private ImageView lock4;

    @FXML
    private ImageView lock5;

    @FXML
    private ImageView backbutton;

    public void initialize(){
        int l=Database.getInstance().getMaxLevel();
        System.out.println("level"+l);
        level2button.setDisable(true);
        level3button.setDisable(true);
        level4button.setDisable(true);
        level5button.setDisable(true);
        if(l>=2){
            lock2.setVisible(false);
            lock2.setDisable(true);
            level2button.setDisable(false);
        }
        if(l>=3){
            lock3.setVisible(false);
            lock3.setDisable(true);
            level3button.setDisable(false);
        }
        if(l>=4){
            lock4.setVisible(false);
            lock4.setDisable(true);
            level4button.setDisable(false);
        }
        if(l>=5){
            lock5.setVisible(false);
            lock5.setDisable(true);
            level5button.setDisable(false);
        }

    }
    @FXML
    void glowImage(MouseEvent event) throws IOException{
        Glow glow=new Glow();
        Node source = (Node) event.getSource();
        source.setEffect(glow);
        glow.setLevel(0.2);
    }

    @FXML
    void stopGlowing(MouseEvent event) throws IOException{
        Node source= (Node) event.getSource();
        Glow glow=(Glow) source.getEffect();
        source.setEffect(glow);
        glow.setLevel(0.0);
    }

    @FXML
    void launchLevel1(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GamePlay.fxml"));
        AnchorPane pane=fxmlLoader.load();
        GamePlayController controller = fxmlLoader.<GamePlayController>getController();
        controller.initData(1, new DataTable(1));
        levelRoot.getChildren().setAll(pane);

    }

    @FXML
    void launchLevel2(MouseEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GamePlay.fxml"));
        AnchorPane pane=fxmlLoader.load();
        GamePlayController controller = fxmlLoader.<GamePlayController>getController();
        controller.initData(2, new DataTable(2));
        levelRoot.getChildren().setAll(pane);

    }

    @FXML
    void launchLevel3(MouseEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GamePlay.fxml"));
        AnchorPane pane=fxmlLoader.load();
        GamePlayController controller = fxmlLoader.<GamePlayController>getController();
        controller.initData(3, new DataTable(3));
        levelRoot.getChildren().setAll(pane);

    }

    @FXML
    void launchLevel4(MouseEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GamePlay.fxml"));
        AnchorPane pane=fxmlLoader.load();
        GamePlayController controller = fxmlLoader.<GamePlayController>getController();
        controller.initData(4, new DataTable(4));
        levelRoot.getChildren().setAll(pane);

    }

    @FXML
    void launchLevel5(MouseEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GamePlay.fxml"));
        AnchorPane pane=fxmlLoader.load();
        GamePlayController controller = fxmlLoader.<GamePlayController>getController();
        controller.initData(5, new DataTable(5));
        levelRoot.getChildren().setAll(pane);
    }

    @FXML
    void loadPrevMenu(MouseEvent event) throws IOException{
        AnchorPane pane= FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        levelRoot.getChildren().setAll(pane);
    }

}