package claims;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;



public class LoginController implements Initializable {

    @FXML
    private Button Button_SignIn;

    @FXML
    private Button Button_SignUp;

    @FXML
    private TextField TextField_Email;

    @FXML
    private TextField TextField_Password;

    @FXML
	private ChoiceBox<String> choiceBox = new ChoiceBox<>();

	public void initialize(URL url, ResourceBundle resourceBundle) {
		Button_SignIn.setOnAction(event -> Model.getInstance().getViewFactory().showCustomerWindow());
	}

    @FXML
    void Button_SignUpClicked(ActionEvent event) {
        try {
        // Load the registration view
        Parent registerView = FXMLLoader.load(getClass().getResource("/claims/registerGUI.fxml"));
        
        // Get the current stage (window)
        Stage currentStage = (Stage) Button_SignUp.getScene().getWindow();
        
        // Set the new scene on the current stage
        currentStage.setScene(new Scene(registerView));
        currentStage.show();
    } catch (IOException e) {
        }
    }

}
