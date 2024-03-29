package claims.controllers.Customer;


import java.net.URL;
import java.util.ResourceBundle;

import claims.models.Claims;
import claims.models.Model;
import claims.models.NewUser;
import claims.views.CustomerMenuOptions;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    private ListView<?> claims_listview;

    @FXML
    private Label login_date;

    @FXML
    private Text user_name;

    @FXML
    private Button btn_edit;

    @FXML
    private TableColumn<Claims, Integer> claimID_col;

    @FXML
    private TableView<Claims> claims_tbl;

    @FXML
    private TableColumn<Claims, String> damage_col;

    @FXML
    private TableColumn<Claims, String> datefilled_col;

    @FXML
    private TableColumn<Claims, String> status_col;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        btn_edit.setOnAction(event -> onEdit());
        init();
    }

    public void init() {
        acc_name.setText(Model.getInstance().getCustomer().getFirstName() + " "
                + Model.getInstance().getCustomer().getLastName());
        user_name.setText("Welcome, " + Model.getInstance().getCustomer().getFirstName());
        acc_gender.setText("Gender: " + Model.getInstance().getCustomer().getGender());
        acc_dob.setText("Age: " + Model.getInstance().getCustomer().getAge());
        acc_email.setText("Email: " + Model.getInstance().getCustomer().getEmail());
        acc_phonenumber.setText("Phone: " + Model.getInstance().getCustomer().getPhoneNumber());
    }


    private void onEdit() {
        Model.getInstance().getViewFactory().getCustomerSelectedMenuItem().set(CustomerMenuOptions.EDIT);
    }

    public void populateClaimsTable() {

    }

}
