package claims.controllers;

import java.net.URL;

import claims.models.Model;
import claims.models.NewUser;
import databases.CustomerDatabase;

import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import claims.userDAO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
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
    private TextField text_field_confirm;

    @FXML
    private DatePicker text_field_dob;

    @FXML
    private TextField text_field_lastname;

    @FXML
    private TextField text_field_password;

    @FXML
    private TextField text_field_phonenumber;

    @FXML
    private TextField textfield_email;

    @FXML
    private TextField textfield_firstname;

    private String[] gender = {"Male", "Female", "Other"};

    private static String dob;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Button_Cancel.setOnAction(event -> onCancel());
        Button_Confirm.setOnAction(event -> onConfirm());
        selector.getItems().addAll(gender);

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

    public void onConfirm() {

    	String first = textfield_firstname.getText();
    	String last = text_field_lastname.getText();
    	String email = textfield_email.getText();
    	String phone = text_field_phonenumber.getText();
    	String pass = text_field_password.getText();
    	String address = text_field_address.getText();
    	String gender = selector.getValue();
    	String age = text_field_age.getText();
    	String birth = text_field_dob.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));


    	try {
			userDAO dao = new userDAO();
			dao.addToTable(first, last, email, phone, pass, address, gender, age, birth);
			System.out.println("DAO Good");
		} catch (SQLException e) {
			e.printStackTrace();
		}

    	//customer
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Save Account");
        alert.setContentText("Are you sure you want to Save this account?");

        ButtonType result = alert.showAndWait().orElse(ButtonType.CANCEL);
        if (result == ButtonType.OK) {

            try {
                NewUser newUser = new NewUser();
                newUser.setPasswordKey(text_field_password.getText());
                newUser.setFirstName(textfield_firstname.getText());
                newUser.setLastName(text_field_lastname.getText());
                newUser.setPhone(text_field_phonenumber.getText());
                newUser.setEmail(textfield_email.getText());
                newUser.setGender(text_field_age.getText());
                newUser.setDob(dob);
                CustomerDatabase.saveNewUser(newUser);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    	Stage stage = (Stage) Button_Confirm.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showLoginWindow();

    }

    //Jaye's
    @FXML
    public void onSave() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Save Account");
        alert.setContentText("Are you sure you want to Save this account?");

        ButtonType result = alert.showAndWait().orElse(ButtonType.CANCEL);
        if (result == ButtonType.OK) {

            try {
                NewUser newUser = new NewUser();
                newUser.setPasswordKey(text_field_password.getText());
                newUser.setFirstName(textfield_firstname.getText());
                newUser.setLastName(text_field_lastname.getText());
                newUser.setPhone(text_field_phonenumber.getText());
                newUser.setEmail(textfield_email.getText());
                newUser.setGender(text_field_age.getText());
                newUser.setDob(dob);
                CustomerDatabase.saveNewUser(newUser);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Stage stage = (Stage) Button_Cancel.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showLoginWindow();
    }
//Jaye's

}

