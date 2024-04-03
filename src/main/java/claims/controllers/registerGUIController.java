package claims.controllers;

import java.net.URL;

import claims.models.Model;
import claims.models.Drivers.ClaimsDatabaseDriver;
import claims.views.AccountType;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.Period;


public class registerGUIController implements Initializable {


    @FXML
    private Button Button_Cancel;

    @FXML
    private Button Button_Confirm;

    @FXML
    private ChoiceBox<String> selector;

    @FXML
    private ChoiceBox<AccountType> zapad;

    @FXML
    private TextField text_field_address;

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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Button_Cancel.setOnAction(event -> onCancel());
        Button_Confirm.setOnAction(event -> onConfirm());
        selector.setItems(FXCollections.observableArrayList("Male", "Female","Other"));
        selector.setValue("Male");
        zapad.setItems(FXCollections.observableArrayList(AccountType.CUSTOMER, AccountType.ADVISOR, AccountType.ADMIN));
        zapad.setValue(Model.getInstance().getViewFactory().getSelectedAccountType());
        zapad.valueProperty().addListener(observable -> Model.getInstance().getViewFactory().setSelectedAccountType(zapad.getValue()));
    }

    //cancel button functionality
    public void onCancel() {
        Stage stage = (Stage) Button_Cancel.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showLoginWindow();
    }

    //confirmation button functionality
    public void onConfirm() {
        int age = Period.between(text_field_dob.getValue(), LocalDate.now()).getYears();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Save Account");
        alert.setContentText("Are you sure you want to save this account?");
        ButtonType result = alert.showAndWait().orElse(ButtonType.CANCEL);
    
        if (result == ButtonType.OK) {
            if (!password_field.getText().equals(confirm_password_field.getText())) {
                // Handle password mismatch
                showErrorAlert("The passwords do not match.");
                return;
            }
            if (age < 18) {
                // Handle underage
                showErrorAlert("You must be at least 18 years old to register.");
                return;
            }
    
            // If passwords match and age is >= 18, proceed with account creation
            switch (Model.getInstance().getViewFactory().getSelectedAccountType()) {
                case CUSTOMER:
                    ClaimsDatabaseDriver.getInstance().addCustomer(
                        textfield_username.getText(), 
                        password_field.getText(), 
                        textfield_firstname.getText(), 
                        text_field_lastname.getText(), 
                        age, 
                        selector.getSelectionModel().getSelectedItem(), 
                        textfield_email.getText(), 
                        text_field_phonenumber.getText(), 
                        text_field_address.getText(), 
                        text_field_dob.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
                    );
                    break;
    
                case ADVISOR:
                    if (!textfield_administrative_code.getText().equals("advisor")) {
                        showErrorAlert("Invalid administrative code for advisor.");
                        return;
                    }
                    ClaimsDatabaseDriver.getInstance().addAdvisor(
                        textfield_username.getText(), 
                        password_field.getText(), 
                        textfield_firstname.getText(), 
                        text_field_lastname.getText(), 
                        selector.getSelectionModel().getSelectedItem(), 
                        textfield_email.getText(), 
                        text_field_phonenumber.getText(), 
                        text_field_address.getText(), 
                        text_field_dob.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
                    );
                    break;
    
                case ADMIN:
                    if (!textfield_administrative_code.getText().equals("admin")) {
                        showErrorAlert("Invalid administrative code for admin.");
                        return;
                    }
                    ClaimsDatabaseDriver.getInstance().addAdmin(
                        textfield_username.getText(), 
                        password_field.getText(), 
                        textfield_firstname.getText(), 
                        text_field_lastname.getText(), 
                        selector.getSelectionModel().getSelectedItem(), 
                        textfield_email.getText(), 
                        text_field_phonenumber.getText(), 
                        text_field_address.getText(), 
                        text_field_dob.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
                    );
                    break;
    
                default:
                    showErrorAlert("Please select a valid account type.");
                    break;
            }
        }
        // Close the current stage and open the login window
        closeAndOpenLogin();
    }
    
    private void showErrorAlert(String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Register Error");
        alert.setHeaderText("Invalid Credentials");
        alert.setContentText(content);
        alert.showAndWait();
        confirm_password_field.clear();
        password_field.clear();
        textfield_administrative_code.clear();
    }
    
    private void closeAndOpenLogin() {
        Stage stage = (Stage) Button_Confirm.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showLoginWindow(); 
    }
}

    
    // //registers administrator details
    // public void registerAdmin(String username, String password, String firstName, String lastName, 
	// 		String age, String gender, String email, String phone, String address, String birthDate) {
    	
    // 	try {
    //         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    //         alert.setTitle("Confirmation");
    //         alert.setHeaderText("Save Account");
    //         alert.setContentText("Are you sure you want to Save this account?");
    //         ButtonType result = alert.showAndWait().orElse(ButtonType.CANCEL);
    //         if (result == ButtonType.OK) {
    //             try {
    //                 NewUser newUser = new NewUser();
    //                 newUser.setUsername(username);
    //                 newUser.setPasswordKey(password);
    //                 newUser.setFirstName(firstName);
    //                 newUser.setLastName(lastName);
    //                 newUser.setAge(age);
    //                 newUser.setGender(gender);
    //                 newUser.setEmail(email);
    //                 newUser.setPhone(phone);
    //                 newUser.setAddr(address);
    //                 newUser.setDob(birthDate);
    //                 ClaimsDatabaseDriver.getInstance().addAdmin(newUser);
    //             }catch (Exception e) {
    //                 Alert alert1 = new Alert(Alert.AlertType.ERROR);
    //                 alert1.setTitle("Oh balls");
    //                 alert1.setHeaderText("CRITICAL ERROR");
    //                 alert1.setContentText("Something Went Wrong");
    //                 e.printStackTrace();
    //             }
    //         }
    //         Stage stage = (Stage) Button_Confirm.getScene().getWindow();
    //         Model.getInstance().getViewFactory().closeStage(stage);
    //         Model.getInstance().getViewFactory().showLoginWindow();
    //         }catch (Exception e) {
    //         Alert alert1 = new Alert(Alert.AlertType.ERROR);
    //         alert1.setTitle("Oh balls");
    //         alert1.setHeaderText("CRITICAL ERROR");
    //         alert1.setContentText("Something Went Wrong");
    //         e.printStackTrace();
    //     }
    	
    // }

    // //registers advisor details
    // public void registerAdvisor(String username, String password, String firstName, String lastName, 
	// 		String age, String gender, String email, String phone, String address, String birthDate) {
    // 	try {
    //         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    //         alert.setTitle("Confirmation");
    //         alert.setHeaderText("Save Account");
    //         alert.setContentText("Are you sure you want to Save this account?");
    //         ButtonType result = alert.showAndWait().orElse(ButtonType.CANCEL);
    //         if (result == ButtonType.OK) {
    //             try {
    //                 NewUser newUser = new NewUser();
    //                 newUser.setUsername(username);
    //                 newUser.setPasswordKey(password);
    //                 newUser.setFirstName(firstName);
    //                 newUser.setLastName(lastName);
    //                 newUser.setAge(age);
    //                 newUser.setGender(gender);
    //                 newUser.setEmail(email);
    //                 newUser.setPhone(phone);
    //                 newUser.setAddr(address);
    //                 newUser.setDob(birthDate);
    //                 ClaimsDatabaseDriver.getInstance().addAdvisor(newUser);
    //             }catch (Exception e) {
    //                 Alert alert1 = new Alert(Alert.AlertType.ERROR);
    //                 alert1.setTitle("Oh balls");
    //                 alert1.setHeaderText("CRITICAL ERROR");
    //                 alert1.setContentText("Something Went Wrong");
    //                 e.printStackTrace();
    //             }
    //         }
    //         Stage stage = (Stage) Button_Confirm.getScene().getWindow();
    //         Model.getInstance().getViewFactory().closeStage(stage);
    //         Model.getInstance().getViewFactory().showLoginWindow();
    //         }catch (Exception e) {
    //         Alert alert1 = new Alert(Alert.AlertType.ERROR);
    //         alert1.setTitle("Oh balls");
    //         alert1.setHeaderText("CRITICAL ERROR");
    //         alert1.setContentText("Something Went Wrong");
    //         e.printStackTrace();
    //     }
    // }

//     //registers customer details
//     public void registerCustomer(String username, String password, String firstName, String lastName, 
//     			String age, String gender, String email, String phone, String address, String birthDate) {

//         try {
//             Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//             alert.setTitle("Confirmation");
//             alert.setHeaderText("Save Account");
//             alert.setContentText("Are you sure you want to Save this account?");
//             ButtonType result = alert.showAndWait().orElse(ButtonType.CANCEL);
//             if (result == ButtonType.OK) {
//                 try {
//                     NewUser newUser = new NewUser();
//                     newUser.setUsername(username);
//                     newUser.setPasswordKey(password);
//                     newUser.setFirstName(firstName);
//                     newUser.setLastName(lastName);
//                     newUser.setAge(age);
//                     newUser.setGender(gender);
//                     newUser.setEmail(email);
//                     newUser.setPhone(phone);
//                     newUser.setAddr(address);
//                     newUser.setDob(birthDate);
//                     ClaimsDatabaseDriver.getInstance().addCustomer(newUser);
//                 } catch (Exception e) {
//                     Alert alert1 = new Alert(Alert.AlertType.ERROR);
//                     alert1.setTitle("Oh balls");
//                     alert1.setHeaderText("CRITICAL ERROR");
//                     alert1.setContentText("Something Went Wrong");
//                     e.printStackTrace();
//                 }
//             }
//             Stage stage = (Stage) Button_Confirm.getScene().getWindow();
//             Model.getInstance().getViewFactory().closeStage(stage);
//             Model.getInstance().getViewFactory().showLoginWindow();
//         } catch (Exception e) {
//             Alert alert1 = new Alert(Alert.AlertType.ERROR);
//             alert1.setTitle("Oh balls");
//             alert1.setHeaderText("CRITICAL ERROR");
//             alert1.setContentText("Something Went Wrong");
//             e.printStackTrace();
//         }
//     }
// }

