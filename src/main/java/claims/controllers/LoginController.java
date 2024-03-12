package application;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
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
	private ChoiceBox<String> acc_type_selector = new ChoiceBox<>();
    
    private String[] acc_type = {"Client", "Advisor"};

    @Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		Button_SignIn.setOnAction(event -> onLogin());
        Button_SignUp.setOnAction(event -> onRegister());
        acc_type_selector.getItems().addAll(acc_type);
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
	    
// Jaye's 
        NewUser newUser = new NewUser();
        newUser.setPasswordKey(TextField_Password.getText());
        newUser.setEmail(TextField_Email.getText());
        String sql = "select * from customer where email = \'"+newUser.getEmail()+"\' " +
                "and passwordkey = \'"+newUser.getPasswordKey()+"\'";
        NewUser user = CustomerDatabase.getUser(sql);
        if(user.getUserID() == 0 || "".equals(newUser.getPasswordKey()) || "".equals(newUser.getEmail())){
            //failure
            System.out.println("null");
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("Title");
            alert.setContentText("Your email or password might be incorrect");
            ButtonType result = alert.showAndWait().orElse(ButtonType.CANCEL);
            if (result == ButtonType.OK) {
            }
            return;
        }
        NewUserAccountGUIController.newUser = user;
//Jaye's   
    	
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
