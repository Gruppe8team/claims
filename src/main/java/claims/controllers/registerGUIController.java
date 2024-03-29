package claims.controllers;

import java.net.URL;

import claims.models.Model;
import claims.models.NewUser;
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
        Button_Confirm.setOnAction(event -> onConfirm());
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

    public void onConfirm() {
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


        if (!userType.equals("Admin")){
            adminPass = "NOT_ADMIN";
        }
        if ((pass.equals(confirm)) && (adminPass.equals("NOT_ADMIN") || adminPass.equals("3131vTg6") || adminPass.equals("4N3g1UR0"))) {
            try {
                userDAO dao = new userDAO();
                dao.addToTable(first, last, email, phone, pass, address, gender, age, birth);
                System.out.println("DAO Good");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("Save Account");
            alert.setContentText("Are you sure you want to Save this account?");
            ButtonType result = alert.showAndWait().orElse(ButtonType.CANCEL);
            if (result == ButtonType.OK) {
                try {
                    NewUser newUser = new NewUser();
                    newUser.setPasswordKey(password_field.getText());
                    newUser.setFirstName(textfield_firstname.getText());
                    newUser.setLastName(text_field_lastname.getText());
                    newUser.setPhone(text_field_phonenumber.getText());
                    newUser.setEmail(textfield_email.getText());
                    newUser.setGender(gender);
                    newUser.setDob(dob);
                    newUser.setUsername(username);
                    newUser.setAddr(address);
                    newUser.setUserType(userType);
                    UserDatabase.saveNewUser(newUser);
                }catch (Exception e) {
                        e.printStackTrace();
                    }

        } }catch (Exception e) {
            e.printStackTrace();
        }

        Stage stage = (Stage) Button_Confirm.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showLoginWindow();
        }else {
            Model.getInstance().getViewFactory().showRegisterErrorWindow();
            confirm_password_field.clear();
            password_field.clear();
            textfield_administrative_code.clear();
        }

    }

}

