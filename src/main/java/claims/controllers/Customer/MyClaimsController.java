package claims.controllers.Customer;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.ResourceBundle;

import claims.models.Claims;
import claims.models.Model;
import claims.models.Drivers.ClaimsDatabaseDriver;
import javafx.application.Platform;
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
import javafx.stage.Stage;
import javafx.util.converter.LocalDateTimeStringConverter;

public class MyClaimsController implements Initializable {
    
	Random random = new Random();
    @FXML
    private DatePicker Dayofac_Datepicker;

    @FXML
    private TableColumn<Claims, Boolean> atfault_col;

    @FXML
    private TableColumn<Claims, Number> claimID_col;

    @FXML
    private Label clientname_lbl;

    @FXML
    private TableView<Claims> clm_table;

    @FXML
    private Label dam_lbl;

    @FXML
    private Label dam_lbl1;

    @FXML
    private Label dam_lbl11;

    @FXML
    private TableColumn<Claims, String> damage_col;

    @FXML
    private TableColumn<Claims, LocalDate> datefilled_col;

    @FXML
    private Label datefilled_lbl;

    @FXML
    private TextArea description_textarea;

    @FXML
    private CheckBox fault_checkbox;

    @FXML
    private TextArea notes_textarea;

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
    private TextField typeofdamage_txtfield;

    
  //submit button functionality
    public void onSubmit() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Submit New Claim");
        alert.setContentText("Are you sure you want to submit this new claim?");
        ButtonType result = alert.showAndWait().orElse(ButtonType.CANCEL);
        if (result == ButtonType.OK) {
        	int claimID = random.nextInt(1000) + 1;
            String claimStatus = "Pending"; // Assuming default status is "Pending"
            int atFault = fault_checkbox.isSelected() ? 1 : 0; // Assuming checkbox is used to determine fault
            String dateFilled = LocalDate.now().toString(); // Assuming current date is used as the date filed
            String accidentTime = timeofac_txtfield.getText(); // Assuming time of accident is entered in the text field
            String damage = typeofdamage_txtfield.getText(); // Assuming damage type is entered in the text field
            int totalledVehicle = totalled_checkbox.isSelected() ? 1 : 0; // Assuming checkbox is used to determine if the vehicle is totalled
            String description = description_textarea.getText();
            String payInfo = ""; // Assuming pay information is not provided initially
            String closureCond = ""; // Assuming closure condition is not provided initially
            int closed = 0; // Assuming claim is not closed initially

            // Now, call the addClaim method with the extracted values
            ClaimsDatabaseDriver.getInstance().addClaim(
            	claimID,	
                claimStatus, 
                atFault, 
                dateFilled, 
                accidentTime, 
                damage, 
                totalledVehicle, 
                description, 
                payInfo, 
                closureCond, 
                closed
            );
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    	submit_btn.setOnAction(event -> onSubmit());
    	populateClaimsTable();
    }

    public void populateClaimsTable() {
        claimID_col.setCellValueFactory(cellData -> cellData.getValue().claimIDProperty());
        damage_col.setCellValueFactory(cellData -> cellData.getValue().damageProperty());
        datefilled_col.setCellValueFactory(cellData -> cellData.getValue().dateFiledProperty());
        status_col.setCellValueFactory(cellData -> cellData.getValue().claimStatusProperty());
        atfault_col.setCellValueFactory(cellData -> cellData.getValue().atFaultProperty());
        totalled_col.setCellValueFactory(cellData -> cellData.getValue().totalledProperty());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd,  HH:mm");
        timeofac_col.setCellFactory(tc -> new TextFieldTableCell<>(new LocalDateTimeStringConverter(formatter, null)));
        timeofac_col.setCellValueFactory(cellData -> cellData.getValue().accidentTimeProperty());


        Platform.runLater(() -> clm_table.setItems(Model.getInstance().getClaimsByClient(Model.getInstance().getCustomer().getUserID())));
    }
}
