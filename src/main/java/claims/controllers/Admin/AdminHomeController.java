package claims.controllers.Admin;


import claims.models.Model;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

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

    @FXML
    private Text sot;

    @FXML
    private Button btn_edit1;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        init();
    }

    public void init() {
        sot.setText("Hola, " + Model.getInstance().getAdmin().getFirstName());
        acc_name.setText(Model.getInstance().getAdmin().getFirstName() + " "
                + Model.getInstance().getAdmin().getLastName());
        acc_gender.setText("Gender: " + Model.getInstance().getAdmin().getGender());
        acc_email.setText("Email: " + Model.getInstance().getAdmin().getEmail());
        acc_phonenumber.setText("Phone: " + Model.getInstance().getAdmin().getPhoneNumber());
        acc_dob.setText("DoB:" + Model.getInstance().getAdmin().getDateOfBirth());
        btn_edit1.setOnAction(event -> onEdit());
    }

    private void onEdit() {
        Alert alert1 = new Alert(Alert.AlertType.WARNING);
        alert1.setTitle("Administrative Warning");
        alert1.setHeaderText("WARNING");
        alert1.setContentText("Administrators Are Forbidden from changing their information");
        ButtonType result = alert1.showAndWait().orElse(ButtonType.CANCEL);
    }

    private void initializeTableColumns() {

    }

}
    

