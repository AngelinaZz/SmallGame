import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sun.applet.Main;

import javax.jws.soap.SOAPBinding;
import java.io.InputStream;

public class StringEvent {
    String juqing;
    String talkerName;
    String backImgSrc;
    String humanImgSrc;
    boolean isHumanVisible = false;

    static String userNameTotal;

    int index;
    Stage newStage = new Stage();
    Dialog dialog = new Dialog();

    public StringEvent(String juqing, int i) {
        this.juqing = juqing;
        this.index = i;
        this.talkerName = "???";
        this.backImgSrc = null;
        this.humanImgSrc = null;
    }

    public StringEvent(String juqing, String talkerName, int i) {
        this.juqing = juqing;
        this.talkerName = talkerName;
        this.index = i;
    }

    public void setBackImgSrc(String imgSrc) {
        this.backImgSrc = imgSrc;
    }

    public void setHumanImgSrc(String humanImgSrc) {
        this.humanImgSrc = humanImgSrc;
    }

    public void setHumanImgVisible(boolean b) {
        this.isHumanVisible = b;
    }

    public void setTalkerName(String talkerName) {
        this.talkerName = talkerName;
    }

    public void getIndexEvent() {
        if (index == 0) {
        } else if (index == 1) { //事件1
            System.out.println("src" + this.backImgSrc);

            MainPaneController.back_img_src = "jiaoshi.jpg" ;

            try {
                SelectPaneController.setDialogPaneContent("无视她", "回应一个微笑", "开始攻略她");
                SelectPaneController selectPaneController = (SelectPaneController) replaceAnotherSceneContent("selectPane.fxml", 321, 224);
                selectPaneController.button1.setOnAction((ActionEvent e) -> {
                    selectPaneController.button1.getScene().getWindow().hide();
                    // StageSingleton.index++;
                    try {
                        MainPaneController mainPaneController = (MainPaneController) StageSingleton.replaceSceneContent("mainPane.fxml");
                        //  this.setBackImgSrc("jiaoshi.jpg");
                        StageSingleton.index++;
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                });
                selectPaneController.button2.setOnAction((ActionEvent e) -> {
                    selectPaneController.button2.getScene().getWindow().hide();
                    // StageSingleton.index++;
                    try {
                        MainPaneController mainPaneController = (MainPaneController) StageSingleton.replaceSceneContent("mainPane.fxml");

                        StageSingleton.index++;
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                });
                selectPaneController.button3.setOnAction((ActionEvent e) -> {
                    try {
                        MainPaneController mainPaneController = (MainPaneController) StageSingleton.replaceSceneContent("mainPane.fxml");
                        mainPaneController.continueButton.getScene().getWindow().hide();
                        selectPaneController.button3.getScene().getWindow().hide();
                        StageSingleton.index++;
                        dialog.errorInfoDialog("吃我铁拳制裁，游戏结束从头开始！洗涅！");
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (index == 2) {
            try {
                PageController pageController = (PageController) replaceAnotherSceneContent("page.fxml", 333, 441);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    private Initializable replaceAnotherSceneContent(String fxml, double width, double height) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        InputStream in = MainApp.class.getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(MainApp.class.getResource(fxml));
        Pane page;
        try {
            page = (Pane) loader.load(in);
        } finally {
            in.close();
        }
        Scene scene = new Scene(page, width, height);
        newStage.setTitle("选择");
        newStage.setScene(scene);
        newStage.sizeToScene();
        newStage.setResizable(false);
        newStage.show();
        return (Initializable) loader.getController();
    }
}
