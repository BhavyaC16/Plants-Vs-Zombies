package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class Almanac {
    @FXML
    private AnchorPane almanacPane;

    @FXML
    private ImageView entry;

    @FXML
    void bucketalmanac(MouseEvent event) {
        entry.setImage(new Image(getClass().getResource("/assets/almanac/buc.png").toString()));

    }

    @FXML
    void cherryalmanac(MouseEvent event) {
        entry.setImage(new Image(getClass().getResource("/assets/almanac/cher.png").toString()));

    }


    @FXML
    void sunalmanac(MouseEvent event) {
        entry.setImage(new Image(getClass().getResource("/assets/almanac/su.png").toString()));

    }

    @FXML
    void walnutalmanac(MouseEvent event) {
        entry.setImage(new Image(getClass().getResource("/assets/almanac/wal.png").toString()));

    }
    @FXML
    void jalapenoalmanac(MouseEvent event) {
        entry.setImage(new Image(getClass().getResource("/assets/almanac/jal.png").toString()));

    }

    @FXML
    void normalAlmanac(MouseEvent event) {
        entry.setImage(new Image(getClass().getResource("/assets/almanac/nor.png").toString()));

    }

    @FXML
    void peaalmanac(MouseEvent event) {
        entry.setImage(new Image(getClass().getResource("/assets/almanac/pee.png").toString()));

    }
    @FXML
    void repeateralmanac(MouseEvent event) {
        entry.setImage(new Image(getClass().getResource("/assets/almanac/rep.png").toString()));
    }
    @FXML
    void conealmanac(MouseEvent event) {
        entry.setImage(new Image(getClass().getResource("/assets/almanac/con.png").toString()));
    }


    @FXML
    void glowImage(MouseEvent event) throws IOException {
        Glow glow=new Glow();
        Node source = (Node) event.getSource();
        source.setEffect(glow);
        glow.setLevel(0.4);
    }

    @FXML
    void stopGlowing(MouseEvent event) throws IOException{
        Node source= (Node) event.getSource();
        Glow glow=(Glow) source.getEffect();
        source.setEffect(glow);
        glow.setLevel(0.0);
    }
    @FXML
    void loadPrevMenu(MouseEvent event) throws IOException{
        AnchorPane pane= FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        almanacPane.getChildren().setAll(pane);
    }

}

