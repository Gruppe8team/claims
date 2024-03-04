package claims.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import claims.models.Model;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class registerGUIController implements Initializable {

    @FXML
    private Button Button_Cancel;

    @FXML
    private Button Button_Confirm;

    @FXML
    private AnchorPane registerView;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        Button_Cancel.setOnAction(event -> Model.getInstance().getViewFactory().showLoginWindow());
    }
}

