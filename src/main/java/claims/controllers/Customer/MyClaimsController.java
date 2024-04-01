package claims.controllers.Customer;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ResourceBundle;

import claims.models.Claims;
import claims.models.Customer;
import claims.models.Model;
import claims.models.Drivers.ClaimsDatabaseDriver;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.LocalDateTimeStringConverter;

public class MyClaimsController implements Initializable {
    
    @FXML
    private DatePicker Dayofac_Datepicker;

    @FXML
    private TableColumn<Claims, Boolean> atfault_col;

    @FXML
    private TableColumn<Claims, Number> claimID_col;

    @FXML
    private TableView<Claims> clm_table;

    @FXML
    private TableColumn<Claims, String> damage_col;

    @FXML
    private TableColumn<Claims, LocalDate> datefilled_col;

    @FXML
    private TextArea description_textarea;

    @FXML
    private CheckBox fault_checkbox;

    @FXML
    private TableColumn<Claims, String> status_col;

    @FXML
    private Button submit_btn;

    @FXML
    private TableColumn<Claims, LocalDateTime> timeofac_col;

    @FXML
    private TextField timeofac_txtfield;

    @FXML
    private CheckBox totalled_checkbox;

    @FXML
    private TableColumn<Claims, Boolean> totalled_col;

    @FXML
    private ChoiceBox<String> typeofdamage_choicebox;

    @FXML
    private Label client_lbl;

    @FXML
    private Label damage_lbl;

    @FXML
    private Label description_lbl;
    
    private static int value;
    private static int totalled;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        submit_btn.setOnAction(event -> onConfirm());
        populateClaimsTable();
        typeofdamage_choicebox.setItems(FXCollections.observableArrayList("Front-End", "Rear-End","Side","Totalled"));
        typeofdamage_choicebox.setValue("Front-End");
        fault_checkbox.setSelected(false);
        fault_checkbox.setOnAction(event -> {
             value = fault_checkbox.isSelected() ? 1 : 0;
        });
        totalled_checkbox.setSelected(false);
        totalled_checkbox.setOnAction(event -> {
             totalled = totalled_checkbox.isSelected() ? 1 : 0;
        });
    }

    private int getFaultSelect() {
        return value;
    }

    private int getTotalledSelect() {
        return totalled;
    }

    public void onConfirm() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Register Claim");
        alert.setContentText("Are you sure you want to register this claim?");
        ButtonType result = alert.showAndWait().orElse(ButtonType.CANCEL);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        if (result == ButtonType.OK) {
            if (isValidTimeFormat(timeofac_txtfield.getText())==false) {
                showErrorAlert("The time format is not correct.");
                return;
            }
            if (description_textarea.getText().isEmpty()) {
                showErrorAlert("The description is required.");
                return;
            }
            if (typeofdamage_choicebox.getValue().equals("Totalled") && totalled_checkbox.isSelected()==false) {
                showErrorAlert("The totalled checkbox must be selected.");
                return;
            }
            if (Dayofac_Datepicker.getValue()==null) {
                showErrorAlert("The date is required.");
                return;
            }
            if (Dayofac_Datepicker.getValue().isAfter(LocalDate.now())) {
                showErrorAlert("The date cannot be after today.");
                return;
            }
            ClaimsDatabaseDriver.getInstance().registerClaim(
            getFaultSelect(), 
            Dayofac_Datepicker.getValue().format(formatter), 
            timeofac_txtfield.getText(), 
            typeofdamage_choicebox.getSelectionModel().getSelectedItem(), 
            getTotalledSelect(), 
            description_textarea.getText());
            Platform.runLater(() -> {
                populateClaimsTable();
                timeofac_txtfield.clear();
                description_textarea.clear();
                typeofdamage_choicebox.setValue("Front-End");
                fault_checkbox.setSelected(false);
                totalled_checkbox.setSelected(false);
            });
        }
    }

    public boolean isValidTimeFormat(String time) {
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        try {
            LocalTime.parse(time, timeFormatter);
            return true; // The time is in the correct format
        } catch (DateTimeParseException e) {
            return false; // The time is not in the correct format
        }
    }

    private void showErrorAlert(String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Register Error");
        alert.setHeaderText("Invalid Infomation");
        alert.setContentText(content);
        alert.showAndWait();
        timeofac_txtfield.clear();
    }

    public void populateClaimsTable() {
        Customer customer = Model.getInstance().getCustomer();
        claimID_col.setCellValueFactory(cellData -> cellData.getValue().claimIDProperty());
        damage_col.setCellValueFactory(cellData -> cellData.getValue().damageProperty());
        datefilled_col.setCellValueFactory(cellData -> cellData.getValue().dateFiledProperty());
        status_col.setCellValueFactory(cellData -> cellData.getValue().claimStatusProperty());
        atfault_col.setCellValueFactory(cellData -> cellData.getValue().atFaultProperty());
        totalled_col.setCellValueFactory(cellData -> cellData.getValue().totalledProperty());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd,  HH:mm");
        timeofac_col.setCellFactory(tc -> new TextFieldTableCell<>(new LocalDateTimeStringConverter(formatter, null)));
        timeofac_col.setCellValueFactory(cellData -> cellData.getValue().accidentTimeProperty());


        Platform.runLater(() -> clm_table.setItems(Model.getInstance().getClaimsByClient(customer.getUserID())));
    }
}
