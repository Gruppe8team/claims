package claims.controllers.Customer;


import java.net.URL;
import java.util.ResourceBundle;

import claims.models.Model;
import claims.models.NewUser;
import claims.views.CustomerMenuOptions;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class HomeController implements Initializable {

    public static NewUser newUser = EditController.newUser;

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

    public void initialize(URL url, ResourceBundle resourceBundle) {
        btn_edit.setOnAction(event -> onEdit());
        init();
    }

    public  void init() {
        acc_name.setText(Model.getInstance().getCustomer().getFirstName().get()+" "+Model.getInstance().getCustomer().getLastName().get());
        user_name.setText("Welcome, "+Model.getInstance().getCustomer().getFirstName().get());
        acc_gender.setText("Gender: "+Model.getInstance().getCustomer().getGender().get());
        acc_dob.setText("DOB: "+Model.getInstance().getCustomer().getAge().get());
        acc_email.setText("Email: "+Model.getInstance().getCustomer().getEmail().get());
        acc_phonenumber.setText("Phone: "+Model.getInstance().getCustomer().getPhoneNumber().get());
    }

    private void onEdit() {
        Model.getInstance().getViewFactory().getCustomerSelectedMenuItem().set(CustomerMenuOptions.EDIT);
    }

}
