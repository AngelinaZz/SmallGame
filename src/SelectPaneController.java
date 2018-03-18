import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class SelectPaneController implements Initializable {

    @FXML
    Button button1, button2, button3; //三个选项

    static String str1 = "", str2 = "", str3 = "";

    public static void setDialogPaneContent(String s1, String s2, String s3) {
        str1 = s1;
        str2 = s2;
        str3 = s3;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        button1.setText(str1);
        button2.setText(str2);
        button3.setText(str3);
    }
}
