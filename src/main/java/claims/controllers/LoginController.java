package claims.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import claims.models.Model;
import claims.views.AccountType;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;



public class LoginController implements Initializable {

    @FXML
    private Button Button_SignIn;

    @FXML
    private Button Button_SignUp;

    @FXML
    private TextField TextField_Username;

    @FXML
    private PasswordField PasswordField_Password;

    @FXML
	private ChoiceBox<AccountType> acc_type_selector;

    @Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
        acc_type_selector.setItems(FXCollections.observableArrayList(AccountType.CUSTOMER, AccountType.ADVISOR, AccountType.ADMIN));
        acc_type_selector.setValue(Model.getInstance().getViewFactory().getLoginAccountType());
        acc_type_selector.valueProperty().addListener(observable -> Model.getInstance().getViewFactory().setLoginAccountType(acc_type_selector.getValue()));
		Button_SignIn.setOnAction(event -> onLogin());
        Button_SignUp.setOnAction(event -> onRegister());

	}


    private void onLogin() {


        // if (acc_type_selector.getValue() != AccountType.CUSTOMER){
        //     Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        //     alert.setTitle("Confirmation");
        //     alert.setHeaderText("Title");
        //     alert.setContentText("Account or password error");
        //     ButtonType result = alert.showAndWait().orElse(ButtonType.CANCEL);
        //     if (result == ButtonType.OK) {
        //     }
        //     return;

        // }
        // NewUser newUser = new NewUser();
        // newUser.setPasswordKey(TextField_Password.getText());
        // newUser.setEmail(TextField_Email.getText());
        // String sql = "select * from customer where email = \'"+newUser.getEmail()+"\' " +
        //         "and passwordkey = \'"+newUser.getPasswordKey()+"\'";
        // NewUser user = CustomerDatabase.getUser(sql);
        // if(user.getUserID() == 0 || "".equals(newUser.getPasswordKey()) || "".equals(newUser.getEmail())){
        //     //登陆失败
        //     System.out.println("null");
        //     Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        //     alert.setTitle("Confirmation");
        //     alert.setHeaderText("Title");
        //     alert.setContentText("Account or password error");
        //     ButtonType result = alert.showAndWait().orElse(ButtonType.CANCEL);
        //     if (result == ButtonType.OK) {
        //     }
        //     return;
        // }
        // EditController.newUser = user;



    	
        
        if (Model.getInstance().getViewFactory().getLoginAccountType() == AccountType.CUSTOMER) {
            Model.getInstance().getViewFactory().showCustomerWindow();
            Stage stage = (Stage) Button_SignIn.getScene().getWindow();
            Model.getInstance().getViewFactory().closeStage(stage);
            //Evalute login credentials
            // Model.getInstance().evaluateClientCred(TextField_Username.getText(), PasswordField_Password.getText());
            // if (Model.getInstance().getCustomerLoginSuccessFlag()) {
            //     Model.getInstance().getViewFactory().showCustomerWindow();
            //     Model.getInstance().getViewFactory().closeStage(stage);
            // } else {
            //     TextField_Username.setText("");
            //     PasswordField_Password.setText("");
            //     Alert alert = new Alert(Alert.AlertType.ERROR);
            //     alert.setTitle("Login Error");
            //     alert.setHeaderText("Invalid Credentials");
            //     alert.setContentText("Please check your username and password");
            //     alert.showAndWait();
            // }
        } else if (Model.getInstance().getViewFactory().getLoginAccountType() == AccountType.ADVISOR) {
            Model.getInstance().evaluateAdvisorCred(TextField_Username.getText(), PasswordField_Password.getText());
            if (Model.getInstance().getAdvisorLoginSuccessFlag()) {
                Model.getInstance().getViewFactory().showAdvisorWindow();
                Stage stage = (Stage) Button_SignIn.getScene().getWindow();
                Model.getInstance().getViewFactory().closeStage(stage);
            } else {
                TextField_Username.setText("");
                PasswordField_Password.setText("");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Login Error");
                alert.setHeaderText("Invalid Credentials");
                alert.setContentText("Please check your username and password");
                alert.showAndWait();
            }
        } else if (Model.getInstance().getViewFactory().getLoginAccountType() == AccountType.ADMIN) {
            Model.getInstance().evaluateAdminCred(TextField_Username.getText(), PasswordField_Password.getText());
            if (Model.getInstance().getAdminLoginSuccessFlag()) {
                Model.getInstance().getViewFactory().showAdminWindow();
                Stage stage = (Stage) Button_SignIn.getScene().getWindow();
                Model.getInstance().getViewFactory().closeStage(stage);
            } else {
                TextField_Username.setText("");
                PasswordField_Password.setText("");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Login Error");
                alert.setHeaderText("Invalid Credentials");
                alert.setContentText("Please check your username and password");
                alert.showAndWait();
            }
        }

    }

    public void onRegister() {
        Stage stage = (Stage) Button_SignIn.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showRegisterWindow();
    }

}
