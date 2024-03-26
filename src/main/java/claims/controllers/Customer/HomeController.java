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

    @FXML
    private ImageView zapad;

    public  void init(){
        btn_edit.setOnAction(event -> onEdit());

        acc_name.setText(newUser.getFirstName()+" "+newUser.getLastName());
        user_name.setText("Hi, "+newUser.getFirstName());
        acc_gender.setText("Gender: "+newUser.getGender());
        acc_dob.setText("DOB: "+newUser.getDob());
        acc_email.setText("Email: "+newUser.getEmail());
        acc_phonenumber.setText("Phone #: "+newUser.getPhone());
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        btn_edit.setOnAction(event -> onEdit());


        Image image = new Image(getClass().getResourceAsStream("/claims/fxml/logoV3.png"));
        zapad.setImage(image);
        acc_name.setText(newUser.getFirstName()+" "+newUser.getLastName());
        user_name.setText("Welcome, "+newUser.getFirstName());
        acc_gender.setText("Gender: "+newUser.getGender());
        acc_dob.setText("DoB: "+newUser.getDob());
        acc_email.setText("Email: "+newUser.getEmail());
        acc_phonenumber.setText("Phone: "+newUser.getPhone());
    }

    private void onEdit() {
        Model.getInstance().getViewFactory().getCustomerSelectedMenuItem().set(CustomerMenuOptions.EDIT);
    }

}
