package claims.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import claims.models.Model;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;



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
	private ChoiceBox acc_type_selector;

    @Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		Button_SignIn.setOnAction(event -> onLogin());
        Button_SignUp.setOnAction(event -> onRegister());
	}


    private void onLogin() {
        Stage stage = (Stage) Button_SignIn.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showCustomerWindow();
    }

    public void onRegister() {
        Stage stage = (Stage) Button_SignIn.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showRegisterWindow();
    }

}
