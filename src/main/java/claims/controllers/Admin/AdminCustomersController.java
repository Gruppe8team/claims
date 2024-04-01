package claims.controllers.Admin;

import claims.models.Customer;
import claims.models.Model;
import claims.models.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminCustomersController implements Initializable {

    @FXML
    private TableView<User> clm_table;

    @FXML
    private TableColumn<User, String> userID_col;

    @FXML
    private TableColumn<User, String> username_col;

    @FXML
    private TableColumn<User, String> password_col;

    @FXML
    private TableColumn<User, String> email_col;


    @FXML
    private TextField code;

    @FXML
    private Button executeButton;

    @FXML
    private Button abortButton;

    @FXML
    private ChoiceBox<String> UserType;

    @FXML
    private Text selectedCustomerDetails;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        UserType.setItems(FXCollections.observableArrayList("Advisor", "Customer", "-Select TypeOfUser-"));
        UserType.setValue("-Select TypeOfUser-");
        populateTableView();

        UserType.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if ("Advisor".equals(newVal)) {
                updateViewForAdvisor();
            } else if ("Customer".equals(newVal)) {
                updateViewForCustomer();
            } else {
                populateTableView();
            }
        });
    }

    private void populateTableView() {
        clm_table.getColumns().clear();
        clm_table.getColumns().addAll(userID_col, username_col, password_col, email_col);

    }


    private void updateViewForAdvisor() {
        ObservableList<User> advisors = Model.getInstance().getAdvisorsForAdmin();
        clm_table.getColumns().clear();
        clm_table.getColumns().addAll(userID_col, username_col, password_col, email_col);
        userID_col.setCellValueFactory(new PropertyValueFactory<>("userID"));
        username_col.setCellValueFactory(new PropertyValueFactory<>("username"));
        password_col.setCellValueFactory(new PropertyValueFactory<>("password"));
        email_col.setCellValueFactory(new PropertyValueFactory<>("email"));
        clm_table.setItems(advisors);

    }

    private void updateViewForCustomer() {
        ObservableList<User> customers = Model.getInstance().getCustomersForAdmin();
        clm_table.getColumns().clear();
        clm_table.getColumns().addAll(userID_col, username_col, password_col, email_col);
        userID_col.setCellValueFactory(new PropertyValueFactory<>("userID"));
        username_col.setCellValueFactory(new PropertyValueFactory<>("username"));
        password_col.setCellValueFactory(new PropertyValueFactory<>("password"));
        email_col.setCellValueFactory(new PropertyValueFactory<>("email"));
        clm_table.setItems(customers);
    }
}