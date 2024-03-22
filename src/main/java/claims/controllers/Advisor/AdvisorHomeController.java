package claims.controllers.Advisor;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class AdvisorHomeController implements Initializable {
    
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

    @FXML
    private ListView<?> clm_listview;

    @FXML
    private TableColumn<?, ?> email_col;

    @FXML
    private Label hi_lbl;

    @FXML
    private TableColumn<?, ?> id_col;

    @FXML
    private TableColumn<?, ?> name_col;

    @FXML
    private Label today_lbl;

    @FXML
    private TableView<?> clients_tableview;
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){}
}
