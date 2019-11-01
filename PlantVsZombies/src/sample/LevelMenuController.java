package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
    private ImageView backbutton;

    @FXML
    void launchLevel1(MouseEvent event) throws IOException {
    	AnchorPane pane= FXMLLoader.load(getClass().getResource("GamePlay.fxml"));
        levelRoot.getChildren().setAll(pane);

    }

    @FXML
    void launchLevel2(MouseEvent event) throws IOException{
    	AnchorPane pane= FXMLLoader.load(getClass().getResource("GamePlay.fxml"));
        levelRoot.getChildren().setAll(pane);

    }

    @FXML
    void launchLevel3(MouseEvent event) throws IOException{
    	AnchorPane pane= FXMLLoader.load(getClass().getResource("GamePlay.fxml"));
        levelRoot.getChildren().setAll(pane);

    }

    @FXML
    void launchLevel4(MouseEvent event) throws IOException{
    	AnchorPane pane= FXMLLoader.load(getClass().getResource("GamePlay.fxml"));
        levelRoot.getChildren().setAll(pane);

    }

    @FXML
    void launchLevel5(MouseEvent event) throws IOException{
    	AnchorPane pane= FXMLLoader.load(getClass().getResource("GamePlay.fxml"));
        levelRoot.getChildren().setAll(pane);
    }

    @FXML
    void loadPrevMenu(MouseEvent event) throws IOException{
        AnchorPane pane= FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        levelRoot.getChildren().setAll(pane);
    }

}