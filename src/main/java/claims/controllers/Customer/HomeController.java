package claims.controllers.Customer;


import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import claims.models.Claims;
import claims.models.Customer;
import claims.models.Model;
import claims.views.CustomerMenuOptions;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;

public class HomeController implements Initializable {


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
    private Label login_date;

    @FXML
    private Text user_name;

    @FXML
    private Button btn_edit;

    @FXML
    private TableColumn<Claims, Number> claimID_col;

    @FXML
    private TableView<Claims> claims_tbl;

    @FXML
    private TableColumn<Claims, String> damage_col;

    @FXML
    private TableColumn<Claims, LocalDate> datefilled_col;

    @FXML
    private TableColumn<Claims, String> status_col;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        btn_edit.setOnAction(event -> onEdit());
        init();
        populateClaimsTable();
    }

    public void init() {
        Customer customer = Model.getInstance().getCustomer();
        acc_name.textProperty().bind(customer.firstNameProperty().concat(" ").concat(customer.lastNameProperty()));
        user_name.textProperty().bind(Bindings.concat("Hi, ", customer.firstNameProperty()));
        acc_gender.textProperty().bind(Bindings.concat("Gender: ", customer.genderProperty()));
        acc_dob.textProperty().bind(Bindings.concat("Age: ", customer.ageProperty().asString()));
        acc_email.textProperty().bind(Bindings.concat("Email: ", customer.emailProperty()));
        acc_phonenumber.textProperty().bind(Bindings.concat("Phone #: ", customer.phoneNumberProperty()));
    }


    private void onEdit() {
        Model.getInstance().getViewFactory().getCustomerSelectedMenuItem().set(CustomerMenuOptions.EDIT);
    }

    public void populateClaimsTable() {
        claimID_col.setCellValueFactory(cellData -> cellData.getValue().claimIDProperty());
        damage_col.setCellValueFactory(cellData -> cellData.getValue().damageProperty());
        datefilled_col.setCellValueFactory(cellData -> cellData.getValue().dateFiledProperty());
        status_col.setCellValueFactory(cellData -> cellData.getValue().claimStatusProperty());

        Platform.runLater(() -> claims_tbl.setItems(Model.getInstance().getClaimsByClient(Model.getInstance().getCustomer().getUserID())));
    }

}
