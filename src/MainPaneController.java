import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class MainPaneController implements Initializable {

   // static String backImgSrc;
    Stage newStage = new Stage();
    Dialog dialog = new Dialog();

    static String back_img_src = "001.jpg";
    static String labelContent = "";

    @FXML
    public Button continueButton;

    @FXML
    public Label nameLabel, juqingLabel; //姓名栏和剧情栏

    @FXML
    public ImageView backImg, humanImg;  //背景图片和任务图片


    @FXML
    public void continueAction(ActionEvent e) {
        if (StageSingleton.index < StageSingleton.stringList.length) {
            StringEvent stringEvent = StageSingleton.stringList[StageSingleton.index];
            stringEvent.getIndexEvent();
            labelContent = stringEvent.juqing;
            juqingLabel.setText(labelContent);
            nameLabel.setText(stringEvent.talkerName);
            if (stringEvent.backImgSrc != null) {
                backImg.setImage(new Image(stringEvent.backImgSrc));
            }
            if (stringEvent.isHumanVisible == false) {
                humanImg.setVisible(false);
            } else {
                humanImg.setVisible(true);
            }
            if (stringEvent.humanImgSrc != null) {
                humanImg.setImage(new Image(stringEvent.humanImgSrc));
            }
            StageSingleton.index++;
        } else {
            dialog.infoDialog("Happy End");
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (StageSingleton.index < StageSingleton.stringList.length) {
            StringEvent stringEvent = StageSingleton.stringList[StageSingleton.index];
            stringEvent.getIndexEvent();
            labelContent = stringEvent.juqing;
            juqingLabel.setText(labelContent);
            backImg.setImage(new Image(back_img_src));
            nameLabel.setText(stringEvent.talkerName);
        } else {
            dialog.infoDialog("Happy End");
        }

    }
}
