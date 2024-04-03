package claims.controllers.Customer;

import claims.AutoClaim;
import claims.models.Customer;
import claims.models.Model;
import claims.models.Drivers.ClaimsDatabaseDriver;
import claims.views.CustomerMenuOptions;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EditController {

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
        delete_btn.setOnAction(event -> deleteAccount());
    }

    private void init() {
        Customer customer = Model.getInstance().getCustomer();
        name_lbl.textProperty().bind(customer.firstNameProperty().concat(" ").concat(customer.lastNameProperty()));
        username_lbl.textProperty().bind(Bindings.concat("Hi, ", customer.firstNameProperty()));
        gender_lbl.textProperty().bind(Bindings.concat("Gender: ", customer.genderProperty()));
        dob_lbl.textProperty().bind(Bindings.concat("Age: ", customer.ageProperty().asString()));
        email_lbl.textProperty().bind(Bindings.concat("Email: ", customer.emailProperty()));
        phone_lbl.textProperty().bind(Bindings.concat("Phone #: ", customer.phoneNumberProperty()));

        firstname_field.setText(customer.getFirstName());
        lastname_field.setText(customer.getLastName());
        dob_field.setText("" + customer.getAge());
        gender_field.setText(customer.getGender());
        email_field.setText(customer.getEmail());
        phone_field.setText(customer.getPhoneNumber());
        password_field.setText(customer.getPassword());

    }

    private void onCancel() {
        Model.getInstance().getViewFactory().getCustomerSelectedMenuItem().set(CustomerMenuOptions.HOME);
    }


    private void deleteAccount() {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Delete Account");
        alert.setContentText("Are you sure you want to delete this account?");

        ButtonType result = alert.showAndWait().orElse(ButtonType.CANCEL);
        if (result == ButtonType.OK) {
            ClaimsDatabaseDriver.getInstance().removeCustomer(Model.getInstance().getCustomer().getUserID());
            
            Stage stage = (Stage) delete_btn.getScene().getWindow();
            Model.getInstance().getViewFactory().closeStage(stage);
            AutoClaim.exitApplication();
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
        if (firstname_field.getText().isEmpty()) {
            Model.getInstance().getCustomer().setFirstName(Model.getInstance().getCustomer().getFirstName());
        } else {
            Model.getInstance().getCustomer().setFirstName(firstname_field.getText());
        }
        if (lastname_field.getText().isEmpty()) {
            Model.getInstance().getCustomer().setLastName(Model.getInstance().getCustomer().getLastName());
        } else {
            Model.getInstance().getCustomer().setLastName(lastname_field.getText());
        }
        if (gender_field.getText().isEmpty()) {
            Model.getInstance().getCustomer().setGender(Model.getInstance().getCustomer().getGender());
        } else {
            Model.getInstance().getCustomer().setGender(gender_field.getText());
        }
        if (dob_field.getText().isEmpty()) {
            Model.getInstance().getCustomer().setAge(Model.getInstance().getCustomer().getAge());
        } else {
            Model.getInstance().getCustomer().setAge(Integer.parseInt(dob_field.getText()));
        }
        if (email_field.getText().isEmpty()) {
            Model.getInstance().getCustomer().setEmail(Model.getInstance().getCustomer().getEmail());
        } else {
            Model.getInstance().getCustomer().setEmail(email_field.getText());
        }
        if (phone_field.getText().isEmpty()) {
            Model.getInstance().getCustomer().setPhoneNumber(Model.getInstance().getCustomer().getPhoneNumber());
        } else {
            Model.getInstance().getCustomer().setPhoneNumber(phone_field.getText());
        }
        if (password_field.getText().isEmpty()) {
            Model.getInstance().getCustomer().setPassword(Model.getInstance().getCustomer().getPassword());
        } else {
            Model.getInstance().getCustomer().setPassword(password_field.getText());
        }

        name_lbl.setText(Model.getInstance().getCustomer().getFirstName()+" "+Model.getInstance().getCustomer().getLastName());
        username_lbl.setText("Hi, "+Model.getInstance().getCustomer().getFirstName());
        gender_lbl.setText("Gender: "+Model.getInstance().getCustomer().getGender());
        dob_lbl.setText("Age: "+Model.getInstance().getCustomer().getAge());
        email_lbl.setText("Email: "+Model.getInstance().getCustomer().getEmail());
        phone_lbl.setText("Phone #: "+Model.getInstance().getCustomer().getPhoneNumber());
        ClaimsDatabaseDriver.getInstance().updateCustomer(
        Model.getInstance().getCustomer().getUsername(),
        Model.getInstance().getCustomer().getPassword(),
        Model.getInstance().getCustomer().getFirstName(),
        Model.getInstance().getCustomer().getLastName(),
        Model.getInstance().getCustomer().getAge(),
        Model.getInstance().getCustomer().getGender(),
        Model.getInstance().getCustomer().getEmail(),
        Model.getInstance().getCustomer().getPhoneNumber(),
        Model.getInstance().getCustomer().getAddress(),
        Model.getInstance().getCustomer().getUserID());
        Model.getInstance().getViewFactory().getCustomerSelectedMenuItem().set(CustomerMenuOptions.HOME);
    }

}

