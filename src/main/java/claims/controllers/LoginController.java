package claims.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import claims.models.Model;
import claims.views.AccountType;
import javafx.collections.FXCollections;
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
    	
//    	String email; 
//    	String password;
//    	
//    	
//    	if(acc_type_selector.getValue() == acc_type[0]) {
//    		try {
//        		customerDAO cusdao = new customerDAO();
//        		email = cusdao.getEmailInfo();
//        		
//        		Stage stage = (Stage) Button_SignIn.getScene().getWindow();
//    	        Model.getInstance().getViewFactory().closeStage(stage);
//    	        Model.getInstance().getViewFactory().showCustomerWindow();
//        	}catch(SQLException e) {
//        		e.printStackTrace();
//        	}
//    	}
//    	else if (acc_type_selector.getValue() == acc_type[1]) {
//    		try {
//        		advisorDAO advdao = new advisorDAO();
//        		email = advdao.getEmailInfo();
//        		
//        		
//        		
//        		Stage stage = (Stage) Button_SignIn.getScene().getWindow();
//                Model.getInstance().getViewFactory().closeStage(stage);
//                Model.getInstance().getViewFactory().showAdvisorMenu();
//        		
//        	}catch(SQLException e) {
//        		e.printStackTrace();
//        	}
//    	}
    	
    	Stage stage = (Stage) Button_SignIn.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        if (Model.getInstance().getViewFactory().getLoginAccountType() == AccountType.CUSTOMER) {
            Model.getInstance().getViewFactory().showCustomerWindow();
        } else if (Model.getInstance().getViewFactory().getLoginAccountType() == AccountType.ADVISOR) {
            Model.getInstance().getViewFactory().showAdvisorWindow();
        } else if (Model.getInstance().getViewFactory().getLoginAccountType() == AccountType.ADMIN) {
            Model.getInstance().getViewFactory().showAdminWindow();
        }
    		
    }

    public void onRegister() {
        Stage stage = (Stage) Button_SignIn.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showRegisterWindow();
    }

}
