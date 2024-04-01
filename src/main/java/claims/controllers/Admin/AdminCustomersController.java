package claims.controllers.Admin;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminCustomersController implements Initializable {

    @FXML
    private TableView<?> clm_table;

    @FXML
    private TableColumn<?, ?> userID_col;

    @FXML
    private TableColumn<?, ?> username_col;

    @FXML
    private TableColumn<?, ?> password_col;

    @FXML
    private TableColumn<?, ?> email_col;

    @FXML
    private TableColumn<?, ?> phone_col;

    @FXML
    private TableColumn<?, ?> dob_col;

    @FXML
    private TableColumn<?, ?> status_col;

    @FXML
    private Text titleText;

    @FXML
    private Text descriptionText;

    @FXML
    private TextField confirmationTextField;

    @FXML
    private Button executeButton;

    @FXML
    private Button abortButton;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
