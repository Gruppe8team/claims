package claims.controllers;

import java.net.URL;

import claims.models.Model;
import claims.models.NewUser;
import databases.CustomerDatabase;

import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import claims.userDAO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;


public class ErrorLoginIssuesController implements Initializable {

    @FXML
    private Button Button_Ok;
    @FXML
    private TextFlow Text_flow;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Button_Ok.setOnAction(event -> onOK());
        Text t1 = new Text("Error! \n Password and Confirmation Do Not Match. Check and correct the fields to match.");
        Text_flow.getChildren().add(t1);
    }
    public void onOK() {
        Stage stage = (Stage) Button_Ok.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
    }
}
