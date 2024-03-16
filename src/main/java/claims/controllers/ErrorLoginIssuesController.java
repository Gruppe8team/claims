package claims.controllers;

import javafx.fxml.Initializable;
import java.net.URL;

import claims.models.Model;
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
import javafx.stage.Stage;


public class ErrorLoginIssuesController implements Initializable {

    @FXML
    private Button Button_Ok;
    @FXML
    private Button Text_flow;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Button_Ok.setOnAction(event -> onCancel());

    }
    public void onCancel() {
        Stage stage = (Stage) Button_Ok.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showLoginWindow();
    }
}
