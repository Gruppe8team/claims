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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;



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

	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}

    @FXML
    void Button_SignInClicked(ActionEvent event) {
        
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

    private boolean authenticate(String email, String password) {
        // Placeholder authentication logic
        // Replace this with actual authentication (e.g., checking a database)
        return "user@example.com".equals(email) && "password".equals(password);
    }
    
    private void loadDashboard() {
        // Load the dashboard or main area of the application
        // This could involve loading a new FXML scene or showing a dialog
        System.out.println("Authentication successful. Loading dashboard...");
    }

}
