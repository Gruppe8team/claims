package claims.controllers;

import java.net.URL;
import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import claims.models.Model;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class registerGUIController implements Initializable {
	

    @FXML
    private Button Button_Cancel;

    @FXML
    private Button Button_Confirm;

    @FXML
    private ChoiceBox<String> selector = new ChoiceBox<>();

    @FXML
    private TextField text_field_address;

    @FXML
    private TextField text_field_age;

    @FXML
    private PasswordField confirm_password_field;

    @FXML
    private DatePicker text_field_dob;

    @FXML
    private TextField text_field_lastname;

    @FXML
    private PasswordField password_field;

    @FXML
    private TextField text_field_phonenumber;

    @FXML
    private TextField textfield_email;

    @FXML
    private TextField textfield_firstname;
    
    private String[] gender = {"Male", "Female"};


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Button_Cancel.setOnAction(event -> onCancel());
        Button_Confirm.setOnAction(event -> onConfirm());
        selector.getItems().addAll(gender);
    }

    public void onCancel() {
        Stage stage = (Stage) Button_Cancel.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showLoginWindow();
    }
    
    public void onConfirm() {
    	
    	String first = textfield_firstname.getText();
    	String last = text_field_lastname.getText();
    	String email = textfield_email.getText();
    	String phone = text_field_phonenumber.getText();
    	String pass = password_field.getText();
    	String address = text_field_address.getText();
    	String gender = selector.getValue();
    	String age = text_field_age.getText();
        String passConfirm = confirm_password_field.getText();
    	String birth = text_field_dob.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    	
    	
    	try {
			application.userDAO dao = new application.userDAO();
			dao.addToTable(first, last, email, phone, pass, address, gender, age, birth);
			System.out.println("DAO Good");
		} catch (SQLException e) {
			e.printStackTrace();
		}
        Stage stage = (Stage) Button_Confirm.getScene().getWindow();

        if(pass.equals(passConfirm)){
            Model.getInstance().getViewFactory().closeStage(stage);
            Model.getInstance().getViewFactory().showLoginWindow();
        } else {
            Model.getInstance().getViewFactory().showLoginWindow();
        }


    	
    }
    
}

