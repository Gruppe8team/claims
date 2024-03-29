package claims.controllers.Customer;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;

import claims.models.Claims;
import claims.models.Model;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MyClaimsController implements Initializable {
    
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
    private TableColumn<Claims, LocalTime> timeofac_col;

    @FXML
    private TextField timeofac_txtfield;

    @FXML
    private CheckBox totalled_checkbox;

    @FXML
    private TableColumn<Claims, Boolean> totalled_col;

    @FXML
    private ChoiceBox<?> typeofdamage_choicebox;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        populateClaimsTable();
    }

    public void populateClaimsTable() {
        claimID_col.setCellValueFactory(cellData -> cellData.getValue().claimIDProperty());
        damage_col.setCellValueFactory(cellData -> cellData.getValue().damageProperty());
        datefilled_col.setCellValueFactory(cellData -> cellData.getValue().dateFiledProperty());
        status_col.setCellValueFactory(cellData -> cellData.getValue().claimStatusProperty());
        atfault_col.setCellValueFactory(cellData -> cellData.getValue().atFaultProperty());
        totalled_col.setCellValueFactory(cellData -> cellData.getValue().totalledProperty());
        timeofac_col.setCellValueFactory(cellData -> cellData.getValue().accidentTimeProperty());

        Platform.runLater(() -> clm_table.setItems(Model.getInstance().getClaims(Model.getInstance().getCustomer().getUserID())));
    }
}
