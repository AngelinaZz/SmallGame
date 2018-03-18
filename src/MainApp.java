import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.InputStream;

public class MainApp extends Application {
    // MainApp application = new MainApp();
    private Stage stage;

    public void start(Stage primaryStage) {
        StageSingleton.setStage(primaryStage);
        stage = StageSingleton.getStage();
        // stage = primaryStage;
        stage.setTitle("恋与小二羊");
        stage.setHeight(456);
        stage.setWidth(600);
        toTest();
        stage.show();

    }

    public void toTest(){
        try {
            MainPaneController mainPaneController = (MainPaneController) replaceSceneContent("mainPane.fxml");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 用来打开fxml文件
     *
     * @param fxml
     * @return
     * @throws Exception
     */
    private Initializable replaceSceneContent(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        // InputStream in =
        // Thread.currentThread().getContextClassLoader().getResourceAsStream(fxml);
        InputStream in = MainApp.class.getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(MainApp.class.getResource(fxml));
        Pane page;
        try {
            page = (Pane) loader.load(in);
        } finally {
            in.close();
        }
        Scene scene = new Scene(page, 600, 456);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.setResizable(false);
        return (Initializable) loader.getController();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
