package claims.controllers;

import claims.NewUser;
import claims.models.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.beans.Visibility;

public class NewUserAccountGUIController {

    private NewUser newUser = new NewUser(1,"","Kyle","Williamson","218953901@gmail.com","Oct 14, 2003","999-999-9999","Male");

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
    }

}
