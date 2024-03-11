package claims.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import claims.models.Model;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
    private ChoiceBox selector;

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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Button_Confirm.setOnAction(event -> registerDetails());
        Button_Cancel.setOnAction(event -> onCancel());
    }

    public void onCancel() {
        Stage stage = (Stage) Button_Cancel.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showLoginWindow();
    }

    public void registerDetails() {
        Stage stage = (Stage) Button_Confirm.getScene().getWindow();

        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showLoginWindow();
    }
}

