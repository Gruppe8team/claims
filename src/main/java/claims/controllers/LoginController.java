package claims.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import claims.models.Model;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;



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


}
