package claims.controllers.Customer;


import databases.AdvisorsDatabase;
import databases.CustomerDatabase;
import claims.NewUser;
import claims.models.Model;
import claims.views.CustomerMenuOptions;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.beans.Visibility;

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

        name_lbl.setText(newUser.getFirstName()+" "+newUser.getLastName());
        username_lbl.setText("Hi, "+newUser.getFirstName());
        gender_lbl.setText("Gender: "+newUser.getGender());
        dob_lbl.setText("DOB: "+newUser.getDob());
        email_lbl.setText("Email: "+newUser.getEmail());
        phone_lbl.setText("Phone #: "+newUser.getPhone());


        addListeners();
    }

    private void addListeners() {
        save_btn.setOnAction(event -> onSave());
        cancel_btn.setOnAction(event -> onCancel());
        delete_btn.setOnAction(event -> onDelete());
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
        if(firstname_field.getText().isEmpty()) {
            newUser.setFirstName(newUser.getFirstName());
        } else {
            newUser.setFirstName(firstname_field.getText());
        }
        if(lastname_field.getText().isEmpty()) {
            newUser.setLastName(newUser.getLastName());
        } else {
            newUser.setLastName(lastname_field.getText());
        }
        if(gender_field.getText().isEmpty()) {
            newUser.setGender(newUser.getGender());
        } else {
            newUser.setGender(gender_field.getText());
        }
        if(dob_field.getText().isEmpty()) {
            newUser.setDob(newUser.getDob());
        } else {
            newUser.setDob(dob_field.getText());
        }
        if(email_field.getText().isEmpty()) {
            newUser.setEmail(newUser.getEmail());
        } else {
            newUser.setEmail(email_field.getText());
        }
        if(phone_field.getText().isEmpty()) {
            newUser.setPhone(newUser.getPhone());
        } else {
            newUser.setPhone(phone_field.getText());
        }
        name_lbl.setText(newUser.getFirstName()+" "+newUser.getLastName());
        username_lbl.setText("Hi, "+newUser.getFirstName());
        gender_lbl.setText("Gender: "+newUser.getGender());
        dob_lbl.setText("DOB: "+newUser.getDob());
        email_lbl.setText("Email: "+newUser.getEmail());
        phone_lbl.setText("Phone #: "+newUser.getPhone());
        Model.getInstance().getViewFactory().getCustomerSelectedMenuItem().set(CustomerMenuOptions.HOME);
    }

}

