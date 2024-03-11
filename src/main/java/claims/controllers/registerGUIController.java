package claims.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import claims.Advisor;
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
    private ChoiceBox<String> selector = new ChoiceBox<>();

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
        selector.getItems().add("Advisor");
        selector.getItems().add("Customer");
        selector.getItems().add("SysAdmin");
        selector.getItems().add("Choose..");
        selector.setValue("Choose..");
        Button_Confirm.setOnAction(event -> registerDetails());
        Button_Cancel.setOnAction(event -> onCancel());

    }

    private void getChoice(ChoiceBox<String> choiceBox) {
        String choice = choiceBox.getValue();
        if (choice.equals("Advisor")){

        }else if (choice.equals("Customer")){

        }else if (choice.equals("SysAdmin")){

        }else{
throw new RuntimeException();
        }
    }

    public void onCancel() {
        Stage stage = (Stage) Button_Cancel.getScene().getWindow();

        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showLoginWindow();
    }

    public void registerDetails() {
        Stage stage = (Stage) Button_Confirm.getScene().getWindow();
        getChoice(selector);
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showLoginWindow();
    }
}

