package claims.controllers.Advisor;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import claims.models.Model;
import claims.models.NewUser;
import claims.models.Drivers.ClaimsDatabaseDriver;
import claims.views.AdvisorMenuOptions;
import claims.views.CustomerMenuOptions;
import databases.UserDatabase;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AdvisorEditController {

    @FXML
    private Label acc_btn;

    @FXML
    private Button cancel_btn;

    @FXML
    private Button delete_btn;

    @FXML
    private TextField dob_field;

    @FXML
    private Label dob_lbl;

    @FXML
    private Button edit_btn;

    @FXML
    private TextField email_field;

    @FXML
    private Label email_lbl;

    @FXML
    private TextField firstname_field;

    @FXML
    private TextField gender_field;
    @FXML
    private TextField password_field;


    @FXML
    private Label gender_lbl;

    @FXML
    private TextField lastname_field;

    @FXML
    private Label name_lbl;

    @FXML
    private TextField phone_field;

    @FXML
    private Label phone_lbl;

    @FXML
    private Button save_btn;

    @FXML
    private Label today_lbl;

    @FXML
    private Text username_lbl;


    public void initialize() {
        addListeners();
        init();
    }

    private void addListeners() {
        save_btn.setOnAction(event -> onSave());
        cancel_btn.setOnAction(event -> onCancel());
        delete_btn.setOnAction(event -> onDelete());
    }

    private void init() {
        name_lbl.setText(Model.getInstance().getAdvisor().getFirstName() + " "
                + Model.getInstance().getAdvisor().getLastName());
        username_lbl.setText("Hi, " + Model.getInstance().getAdvisor().getFirstName());
        gender_lbl.setText("Gender: " + Model.getInstance().getAdvisor().getGender());
        dob_lbl.setText("DOB: " + Model.getInstance().getAdvisor().getDateOfBirth());
        email_lbl.setText("Email: " + Model.getInstance().getAdvisor().getEmail());
        phone_lbl.setText("Phone #: " + Model.getInstance().getAdvisor().getPhoneNumber());

        firstname_field.setText(Model.getInstance().getAdvisor().getFirstName());
        lastname_field.setText(Model.getInstance().getAdvisor().getLastName());
        dob_field.setText("" + Model.getInstance().getAdvisor().getDateOfBirth());
        gender_field.setText(Model.getInstance().getAdvisor().getGender());
        email_field.setText(Model.getInstance().getAdvisor().getEmail());
        phone_field.setText(Model.getInstance().getAdvisor().getPhoneNumber());
        password_field.setText(Model.getInstance().getAdvisor().getPassword());
    }

    private void onCancel() {
        Model.getInstance().getViewFactory().getCustomerSelectedMenuItem().set(CustomerMenuOptions.HOME);
    }

    private void onDelete() {
        deleteAccount();
    }






    private void deleteAccount() {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Delete Account");
        alert.setContentText("Are you sure you want to delete this account?");

        ButtonType result = alert.showAndWait().orElse(ButtonType.CANCEL);
        if (result == ButtonType.OK) {
            ClaimsDatabaseDriver.getInstance().removeAdvisor(Model.getInstance().getAdvisor().getUserID());
            
            Stage stage = (Stage) delete_btn.getScene().getWindow();
            Model.getInstance().getViewFactory().closeStage(stage);

            Model.getInstance().getViewFactory().showLoginWindow();
            try {

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void onSave() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Information Saved");
        ButtonType result = alert.showAndWait().orElse(ButtonType.CANCEL);
        if (result == ButtonType.OK) {
            updateAccount();
        }


    }

    private void updateAccount() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        if (firstname_field.getText().isEmpty()) {
            Model.getInstance().getAdvisor().setFirstName(Model.getInstance().getAdvisor().getFirstName());
        } else {
            Model.getInstance().getAdvisor().setFirstName(firstname_field.getText());
        }
        if (lastname_field.getText().isEmpty()) {
            Model.getInstance().getAdvisor().setLastName(Model.getInstance().getAdvisor().getLastName());
        } else {
            Model.getInstance().getAdvisor().setLastName(lastname_field.getText());
        }
        if (gender_field.getText().isEmpty()) {
            Model.getInstance().getAdvisor().setGender(Model.getInstance().getAdvisor().getGender());
        } else {
            Model.getInstance().getAdvisor().setGender(gender_field.getText());
        }
        if (dob_field.getText().isEmpty()) {
            Model.getInstance().getAdvisor().setDateOfBirth(Model.getInstance().getAdvisor().getDateOfBirth());
        } else {
            Model.getInstance().getAdvisor().setDateOfBirth(LocalDate.parse(dob_field.getText()));
        }
        if (email_field.getText().isEmpty()) {
            Model.getInstance().getAdvisor().setEmail(Model.getInstance().getAdvisor().getEmail());
        } else {
            Model.getInstance().getAdvisor().setEmail(email_field.getText());
        }
        if (phone_field.getText().isEmpty()) {
            Model.getInstance().getAdvisor().setPhoneNumber(Model.getInstance().getAdvisor().getPhoneNumber());
        } else {
            Model.getInstance().getAdvisor().setPhoneNumber(phone_field.getText());
        }
        if (password_field.getText().isEmpty()) {
            Model.getInstance().getAdvisor().setPassword(Model.getInstance().getAdvisor().getPassword());
        } else {
            Model.getInstance().getAdvisor().setPassword(password_field.getText());
        }


        name_lbl.setText(
                Model.getInstance().getAdvisor().getFirstName() + " " + Model.getInstance().getAdvisor().getLastName());
        username_lbl.setText("Hi, " + Model.getInstance().getAdvisor().getFirstName());
        gender_lbl.setText("Gender: " + Model.getInstance().getAdvisor().getGender());
        dob_lbl.setText("Age: " + Model.getInstance().getAdvisor().getDateOfBirth());
        email_lbl.setText("Email: " + Model.getInstance().getAdvisor().getEmail());
        phone_lbl.setText("Phone #: " + Model.getInstance().getAdvisor().getPhoneNumber());
        ClaimsDatabaseDriver.getInstance().updateAdvisor(
                Model.getInstance().getAdvisor().getUsername(),
                Model.getInstance().getAdvisor().getPassword(),
                Model.getInstance().getAdvisor().getFirstName(),
                Model.getInstance().getAdvisor().getLastName(),
                (Model.getInstance().getAdvisor().getDateOfBirth()).format(formatter),
                Model.getInstance().getAdvisor().getGender(),
                Model.getInstance().getAdvisor().getEmail(),
                Model.getInstance().getAdvisor().getPhoneNumber(),
                Model.getInstance().getAdvisor().getAddress(),
                Model.getInstance().getAdvisor().getUserID());

        Model.getInstance().getViewFactory().getAdvisorSelectedMenuItem().set(AdvisorMenuOptions.HOME);
    }

}

