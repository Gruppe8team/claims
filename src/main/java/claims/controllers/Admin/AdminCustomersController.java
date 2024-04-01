package claims.controllers.Admin;

import claims.models.Customer;
import claims.models.NewUser;
import claims.views.AccountType;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
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
    private TextField code;

    @FXML
    private Button executeButton;

    @FXML
    private Button abortButton;

    @FXML
    private ChoiceBox<String> UserType;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        UserType.setItems(FXCollections.observableArrayList("Advisor", "Customer", "-Select TypeOfUser-"));
        UserType.setValue("-Select TypeOfUser-");
        populateTableView();
    }

    private void populateTableView() {
        // Clear existing items in the TableView



    }


}
