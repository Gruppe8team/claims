package claims.controllers.Advisor;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;

public class AdvisorHomeController {
    
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
}
