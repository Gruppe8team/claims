package claims.controllers.Admin;


import claims.models.Model;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminHomeController implements Initializable {
    @FXML
    private Label acc_dob;

    @FXML
    private Label acc_email;

    @FXML
    private Label acc_gender;

    @FXML
    private Label acc_name;

    @FXML
    private Label acc_phonenumber;

    @FXML
    private Label acc_signupdate;

    @FXML
    private Label acc_type;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        init();
    }

    public void init() {
        acc_name.setText(Model.getInstance().getAdmin().getFirstName() + " "
                + Model.getInstance().getAdmin().getLastName());
        acc_gender.setText("Gender: " + Model.getInstance().getAdmin().getGender());
        acc_email.setText("Email: " + Model.getInstance().getAdmin().getEmail());
        acc_phonenumber.setText("Phone: " + Model.getInstance().getAdmin().getPhoneNumber());
    }

    private void initializeTableColumns() {

    }

}
    

