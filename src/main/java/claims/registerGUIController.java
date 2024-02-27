package claims;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class registerGUIController {

    @FXML
    private Button Button_Cancel;

    @FXML
    private Button Button_Confirm;

    @FXML
    private AnchorPane registerView;

    @FXML
    void Button_CancelClicked(ActionEvent event) {
        try {
        // Load the registration view
        Parent LoginView = FXMLLoader.load(getClass().getResource("/claims/Login.fxml"));
        
        // Get the current stage (window)
        Stage currentStage = (Stage) Button_Cancel.getScene().getWindow();
        
        // Set the new scene on the current stage
        currentStage.setScene(new Scene(LoginView));
        currentStage.show();
    } catch (IOException e) {
        }
    }

    @FXML
    void Button_ConfirmClicked(ActionEvent event) {

    }

}
