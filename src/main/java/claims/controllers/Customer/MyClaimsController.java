package claims.controllers.Customer;

import java.net.URL;
import java.util.ResourceBundle;

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
    private TableColumn<?, ?> atfault_col;

    @FXML
    private TableColumn<?, ?> claimID_col;

    @FXML
    private Label clientname_lbl;

    @FXML
    private TableView<?> clm_table;

    @FXML
    private Label dam_lbl;

    @FXML
    private Label dam_lbl1;

    @FXML
    private Label dam_lbl11;

    @FXML
    private TableColumn<?, ?> damage_col;

    @FXML
    private TableColumn<?, ?> datefilled_col;

    @FXML
    private Label datefilled_lbl;

    @FXML
    private TextArea description_textarea;

    @FXML
    private CheckBox fault_checkbox;

    @FXML
    private TextArea notes_textarea;

    @FXML
    private TableColumn<?, ?> status_col;

    @FXML
    private Button submit_btn;

    @FXML
    private TableColumn<?, ?> timeofac_col;

    @FXML
    private TextField timeofac_txtfield;

    @FXML
    private CheckBox totalled_checkbox;

    @FXML
    private TableColumn<?, ?> totalled_col;

    @FXML
    private ChoiceBox<?> typeofdamage_choicebox;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
