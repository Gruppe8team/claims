package claims.controllers.Customer;


import claims.models.Model;
import claims.models.NewUser;
import claims.models.Drivers.ClaimsDatabaseDriver;
import claims.views.CustomerMenuOptions;
import databases.UserDatabase;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EditController {

    public static NewUser newUser = new NewUser(1,"","Kyle","Williamson","218953901@gmail.com","Oct 14, 2003","999-999-9999","Male");

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
        name_lbl.setText(Model.getInstance().getCustomer().getFirstName().get()+" "+Model.getInstance().getCustomer().getLastName().get());
        username_lbl.setText("Hi, "+Model.getInstance().getCustomer().getFirstName().get());
        gender_lbl.setText("Gender: "+Model.getInstance().getCustomer().getGender().get());
        dob_lbl.setText("DOB: "+Model.getInstance().getCustomer().getAge().get());
        email_lbl.setText("Email: "+Model.getInstance().getCustomer().getEmail().get());
        phone_lbl.setText("Phone #: "+Model.getInstance().getCustomer().getPhoneNumber().get());

        firstname_field.setText(Model.getInstance().getCustomer().getFirstName().get());
        lastname_field.setText(Model.getInstance().getCustomer().getLastName().get());
        dob_field.setText(""+Model.getInstance().getCustomer().getAge().get());
        gender_field.setText(Model.getInstance().getCustomer().getGender().get());
        email_field.setText(Model.getInstance().getCustomer().getEmail().get());
        phone_field.setText(Model.getInstance().getCustomer().getPhoneNumber().get());
        password_field.setText(Model.getInstance().getCustomer().getPasswordKey().get());
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

            UserDatabase.deleteNewUser(newUser);
            newUser = new NewUser();
            System.out.println(newUser.toString());
            //new  HomeController().init();
            //Model.getInstance().getViewFactory().getCustomerSelectedMenuItem().set(CustomerMenuOptions.HOME);
            //initialize();
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
        if (firstname_field.getText().isEmpty()) {
            Model.getInstance().getCustomer().getFirstName().set(Model.getInstance().getCustomer().getFirstName().get());
        } else {
            Model.getInstance().getCustomer().getFirstName().set(firstname_field.getText());
        }
        if (lastname_field.getText().isEmpty()) {
            Model.getInstance().getCustomer().getLastName().set(Model.getInstance().getCustomer().getLastName().get());
        } else {
            Model.getInstance().getCustomer().getLastName().set(lastname_field.getText());
        }
        if (gender_field.getText().isEmpty()) {
            Model.getInstance().getCustomer().getGender().set(Model.getInstance().getCustomer().getGender().get());
        } else {
            Model.getInstance().getCustomer().getGender().set(gender_field.getText());
        }
        if (dob_field.getText().isEmpty()) {
            Model.getInstance().getCustomer().getAge().set(Model.getInstance().getCustomer().getAge().get());
        } else {
            Model.getInstance().getCustomer().getAge().set(Integer.parseInt(dob_field.getText()));
        }
        if (email_field.getText().isEmpty()) {
            Model.getInstance().getCustomer().getEmail().set(Model.getInstance().getCustomer().getEmail().get());
        } else {
            Model.getInstance().getCustomer().getEmail().set(email_field.getText());
        }
        if (phone_field.getText().isEmpty()) {
            Model.getInstance().getCustomer().getPhoneNumber().set(Model.getInstance().getCustomer().getPhoneNumber().get());
        } else {
            Model.getInstance().getCustomer().getPhoneNumber().set(phone_field.getText());
        }
        if (password_field.getText().isEmpty()) {
            Model.getInstance().getCustomer().getPasswordKey().set(Model.getInstance().getCustomer().getPasswordKey().get());
        } else {
            Model.getInstance().getCustomer().getPasswordKey().set(password_field.getText());;
        }

        name_lbl.setText(Model.getInstance().getCustomer().getFirstName().get()+" "+Model.getInstance().getCustomer().getLastName().get());
        username_lbl.setText("Hi, "+Model.getInstance().getCustomer().getFirstName().get());
        gender_lbl.setText("Gender: "+Model.getInstance().getCustomer().getGender().get());
        dob_lbl.setText("Age: "+Model.getInstance().getCustomer().getAge().get());
        email_lbl.setText("Email: "+Model.getInstance().getCustomer().getEmail().get());
        phone_lbl.setText("Phone #: "+Model.getInstance().getCustomer().getPhoneNumber().get());
        ClaimsDatabaseDriver.getInstance().updateCustomer(
        Model.getInstance().getCustomer().getUsername().get(), 
        Model.getInstance().getCustomer().getPasswordKey().get(),
        Model.getInstance().getCustomer().getFirstName().get(), 
        Model.getInstance().getCustomer().getLastName().get(), 
        Model.getInstance().getCustomer().getAge().get(), 
        Model.getInstance().getCustomer().getGender().get(), 
        Model.getInstance().getCustomer().getEmail().get(), 
        Model.getInstance().getCustomer().getPhoneNumber().get(),
        Model.getInstance().getCustomer().getAddress().get(),
        Model.getInstance().getCustomer().getUserID().get());
        Model.getInstance().getViewFactory().getCustomerSelectedMenuItem().set(CustomerMenuOptions.HOME);
    }

}

