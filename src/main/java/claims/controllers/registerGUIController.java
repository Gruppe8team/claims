package claims.controllers;

import java.net.URL;

import claims.models.Model;
import claims.models.NewUser;
import claims.models.Drivers.ClaimsDatabaseDriver;
import databases.UserDatabase;

import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import claims.userDAO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;


public class registerGUIController implements Initializable {


    @FXML
    private Button Button_Cancel;

    @FXML
    private Button Button_Confirm;

    @FXML
    private ChoiceBox<String> selector = new ChoiceBox<>();

    @FXML
    private ChoiceBox<String> zapad = new ChoiceBox<>();

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

    @FXML
    private TextField textfield_username;

    @FXML
    private TextField textfield_administrative_code;

    private String[] gender = {"Male", "Female", "BTR-80", "Finger", "Walrusian", "Neither"};

    private String[] typeOfUser = {"Admin", "Customer", "Advisor"};

    private static String dob;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Button_Cancel.setOnAction(event -> onCancel());
        Button_Confirm.setOnAction(event -> {
			try {
				onConfirm();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		});
        selector.getItems().addAll(gender);
        zapad.getItems().addAll(typeOfUser);

//Jaye's
        text_field_dob.valueProperty().addListener((obs, oldVal, newVal) -> {
            System.out.println("Selected date: " + newVal);
            dob = newVal.toString();
        });
//Jaye's
    }

    public void onCancel() {
        Stage stage = (Stage) Button_Cancel.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showLoginWindow();
    }

    public void onConfirm() throws SQLException{
        String first = textfield_firstname.getText();
        String last = text_field_lastname.getText();
        String email = textfield_email.getText();
        String phone = text_field_phonenumber.getText();
        String pass = password_field.getText();
        String confirm = confirm_password_field.getText();
        String address = text_field_address.getText();
        String gender = selector.getValue();
        String username = textfield_username.getText();
        String age = text_field_age.getText();
        String birth = text_field_dob.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String adminPass = textfield_administrative_code.getText();
        String userType =  zapad.getValue();


        switch(userType) {
        	case "Admin":
        		// Admin pass is 3131vTg6
        		if (pass.equals(confirm) && adminPass.equals("3131vTg6")) {
        			registerAdmin(username,pass,first,last,age,gender,email,phone,address,birth);
        		}else {
       			 Model.getInstance().getViewFactory().showRegisterErrorWindow();
                 confirm_password_field.clear();
                 password_field.clear();
                 textfield_administrative_code.clear();
        		}
        		break;
        		
        	case "Advisor":
        		// Advisor pass is 4N3g1UR0
        		if (pass.equals(confirm) && adminPass.equals("4N3g1UR0")) {
        			registerAdvisor(username,pass,first,last,age,gender,email,phone,address,birth);
        		}else {
       			 Model.getInstance().getViewFactory().showRegisterErrorWindow();
                 confirm_password_field.clear();
                 password_field.clear();
                 textfield_administrative_code.clear();
        		}
        		
        		break;
        		
        	case "Customer":
        		if (pass.equals(confirm)) {
        			registerCustomer(username,pass,first,last,age,gender,email,phone,address,birth);
        		}
        		else {
        			 Model.getInstance().getViewFactory().showRegisterErrorWindow();
                     confirm_password_field.clear();
                     password_field.clear();
                     textfield_administrative_code.clear();
        		}
        		break;
        	default:
        		 Model.getInstance().getViewFactory().showRegisterErrorWindow();
                 confirm_password_field.clear();
                 password_field.clear();
                 textfield_administrative_code.clear();
                 break;
        }   

    }
    
    
    public void registerAdmin(String username, String password, String firstName, String lastName, 
			String age, String gender, String email, String phone, String address, String birthDate) {
    	
    	try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("Save Account");
            alert.setContentText("Are you sure you want to Save this account?");
            ButtonType result = alert.showAndWait().orElse(ButtonType.CANCEL);
            if (result == ButtonType.OK) {
                try {
                    NewUser newUser = new NewUser();
                    newUser.setUsername(username);
                    newUser.setPasswordKey(password);
                    newUser.setFirstName(firstName);
                    newUser.setLastName(lastName);
                    newUser.setAge(age);
                    newUser.setGender(gender);
                    newUser.setEmail(email);
                    newUser.setPhone(phone);
                    newUser.setAddr(address);
                    newUser.setDob(birthDate);
                    ClaimsDatabaseDriver.getInstance().addAdmin(newUser);
                }catch (Exception e) {
                        e.printStackTrace();
                }
            }
            Stage stage = (Stage) Button_Confirm.getScene().getWindow();
            Model.getInstance().getViewFactory().closeStage(stage);
            Model.getInstance().getViewFactory().showLoginWindow();
            }catch (Exception e) {
            e.printStackTrace();
        }
    	
    }
    
    public void registerAdvisor(String username, String password, String firstName, String lastName, 
			String age, String gender, String email, String phone, String address, String birthDate) {
    	try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("Save Account");
            alert.setContentText("Are you sure you want to Save this account?");
            ButtonType result = alert.showAndWait().orElse(ButtonType.CANCEL);
            if (result == ButtonType.OK) {
                try {
                    NewUser newUser = new NewUser();
                    newUser.setUsername(username);
                    newUser.setPasswordKey(password);
                    newUser.setFirstName(firstName);
                    newUser.setLastName(lastName);
                    newUser.setAge(age);
                    newUser.setGender(gender);
                    newUser.setEmail(email);
                    newUser.setPhone(phone);
                    newUser.setAddr(address);
                    newUser.setDob(birthDate);
                    ClaimsDatabaseDriver.getInstance().addAdvisor(newUser);
                }catch (Exception e) {
                        e.printStackTrace();
                }
            }
            Stage stage = (Stage) Button_Confirm.getScene().getWindow();
            Model.getInstance().getViewFactory().closeStage(stage);
            Model.getInstance().getViewFactory().showLoginWindow();
            }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public void registerCustomer(String username, String password, String firstName, String lastName, 
    			String age, String gender, String email, String phone, String address, String birthDate) {
    	
    	try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("Save Account");
            alert.setContentText("Are you sure you want to Save this account?");
            ButtonType result = alert.showAndWait().orElse(ButtonType.CANCEL);
            if (result == ButtonType.OK) {
                try {
                    NewUser newUser = new NewUser();
                    newUser.setUsername(username);
                    newUser.setPasswordKey(password);
                    newUser.setFirstName(firstName);
                    newUser.setLastName(lastName);
                    newUser.setAge(age);
                    newUser.setGender(gender);
                    newUser.setEmail(email);
                    newUser.setPhone(phone);
                    newUser.setAddr(address);
                    newUser.setDob(birthDate);
                    ClaimsDatabaseDriver.getInstance().addCustomer(newUser);
                }catch (Exception e) {
                        e.printStackTrace();
                }
            }
            Stage stage = (Stage) Button_Confirm.getScene().getWindow();
            Model.getInstance().getViewFactory().closeStage(stage);
            Model.getInstance().getViewFactory().showLoginWindow();
            }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}

