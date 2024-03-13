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
        acc_type_selector.setItems(FXCollections.observableArrayList(AccountType.CUSTOMER, AccountType.ADVISOR, AccountType.ADMIN));;
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
        Model.getInstance().getViewFactory().showCustomerWindow();
    		
    }

    public void onRegister() {
        Stage stage = (Stage) Button_SignIn.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showRegisterWindow();
    }

}
