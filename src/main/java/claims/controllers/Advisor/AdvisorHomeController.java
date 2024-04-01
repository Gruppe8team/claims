package claims.controllers.Advisor;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import claims.models.Model;
import claims.views.AdvisorMenuOptions;
import claims.models.Advisor;
import claims.models.Claims;
import claims.models.Customer;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

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
        initializeTableColumns();
        init();
        btn_edit.setOnAction(event -> onEdit());
    }

    private void onEdit() {
        Model.getInstance().getViewFactory().getAdvisorSelectedMenuItem().set(AdvisorMenuOptions.EDIT);
    }

    public void init() {
        Advisor advisor = Model.getInstance().getAdvisor();
        acc_name.textProperty().bind(advisor.firstNameProperty().concat(" ").concat(advisor.lastNameProperty()));
        hi_lbl.textProperty().bind(Bindings.concat("Welcome, ", advisor.firstNameProperty()));
        acc_gender.textProperty().bind(Bindings.concat("Gender: ", advisor.genderProperty()));
        acc_dob.textProperty().bind(Bindings.concat("DOB: ", advisor.dateOfBirthProperty().asString()));
        acc_email.textProperty().bind(Bindings.concat("Email: ", advisor.emailProperty()));
        acc_phonenumber.textProperty().bind(Bindings.concat("Phone #: ", advisor.phoneNumberProperty()));
    }

    public void initializeTableColumns() {
        id_col.setCellValueFactory(cellData -> cellData.getValue().userIDProperty());
        name_col.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        email_col.setCellValueFactory(cellData -> cellData.getValue().emailProperty());

        client_col.setCellValueFactory(cellData -> cellData.getValue().clientIDProperty());
        clm_col.setCellValueFactory(cellData -> cellData.getValue().claimIDProperty());
        damage_col.setCellValueFactory(cellData -> cellData.getValue().damageProperty());
        datefiled_col.setCellValueFactory(cellData -> cellData.getValue().dateFiledProperty());
       status_col.setCellValueFactory(cellData -> cellData.getValue().claimStatusProperty());

        Platform.runLater(() -> clients_tableview.setItems(Model.getInstance().getCustomersByAdvisor(Model.getInstance().getAdvisor().getUserID())));
        Platform.runLater(() -> clm_tableview.setItems(Model.getInstance().getClaimsByAdvisor(Model.getInstance().getAdvisor().getUserID())));
    }

    
}
