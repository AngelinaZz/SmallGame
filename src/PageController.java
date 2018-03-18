import com.sun.org.apache.xalan.internal.xsltc.compiler.util.TestGenerator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.jws.soap.SOAPBinding;
import java.net.URL;
import java.util.ResourceBundle;

public class PageController implements Initializable {
    Dialog dialog = new Dialog();

    @FXML
    TextField nameField;

    @FXML
    Button saveButton;

    @FXML
    public void saveButtonAction(ActionEvent e) {
        if (nameField == null || nameField.getText() == null || nameField.getText().trim().equals("")) {
            dialog.errorInfoDialog("信息不能为空");
            return;
        }
        UserName.setInstance(nameField.getText().trim());
        System.out.println("username" + UserName.getInstance());
        for (int i = 0; i < StageSingleton.stringList.length; i++) {
            if (StageSingleton.stringList[i].talkerName == null || StageSingleton.stringList[i].talkerName.equals("") || StageSingleton.stringList[i].talkerName.equals("???")) {
                StageSingleton.stringList[i].talkerName = UserName.getInstance();
            }
            if (StageSingleton.stringList[i].juqing.contains("#")) {
                String[] str = StageSingleton.stringList[i].juqing.split("#");
                StageSingleton.stringList[i].juqing = str[0] + nameField.getText().trim() + " " + str[1];
            }
        }
        saveButton.getScene().getWindow().hide();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
