package claims.controllers.Advisor;

import java.net.URL;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ResourceBundle;

import claims.models.Model;
import claims.models.Drivers.ClaimsDatabaseDriver;
import claims.models.Claims;
import claims.models.Customer;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AdvisorHomeController implements Initializable {
    
    // FXML fields for account info
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
    private Button btn_edit;

    // FXML fields for clients list

    @FXML
    private TableColumn<Customer, String> email_col;

    @FXML
    private Label hi_lbl;

    @FXML
    private TableColumn<Customer, Number> id_col;

    @FXML
    private TableColumn<Customer, String> name_col;

    @FXML
    private Label today_lbl;

    @FXML
    private TableView<Customer> clients_tableview;

    // FXML fields for claims list
    @FXML
    private TableColumn<Claims, Number> client_col;

    @FXML
    private TableColumn<Claims, Number> clm_col;

    @FXML
    private TableView<Claims> clm_tableview;

    @FXML
    private TableColumn<Claims, String> damage_col;

    @FXML
    private TableColumn<Claims, LocalDate> datefiled_col;

    @FXML
    private TableColumn<Claims, String> status_col;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){

        
    }

    public void initializeTableColumns() {
        id_col.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        name_col.setCellValueFactory();
        email_col.setCellValueFactory();

        client_col.setCellFactory(null);
        clm_col.setCellFactory(null);
        damage_col.setCellFactory(null);
        datefiled_col.setCellFactory(null);
        status_col.setCellFactory(null);

        clients_tableview.setItems();
        clm_tableview.setItems();
    }

    
}
