package claims.controllers.Admin;

import claims.models.Advisor;
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
import java.util.Optional;
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
    private Button execute;

    @FXML
    private Button abort;

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

        execute.setOnAction(event -> deleteAccount());
        abort.setOnAction(event -> resetPassword());
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

    private void deleteAccount() {
        User selectedUser = clm_table.getSelectionModel().getSelectedItem();
        if (selectedUser != null) {
            Alert confirmationAlert = new Alert(Alert.AlertType.WARNING);
            confirmationAlert.setTitle("Confirmation");
            confirmationAlert.setHeaderText("Delete Account");
            confirmationAlert.setContentText("Are you sure you want to delete this account?");
            Optional<ButtonType> result = confirmationAlert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                Model.getInstance().deleteUser(selectedUser);
                Alert userAlert = new Alert(Alert.AlertType.INFORMATION);
                userAlert.setContentText("Action Successful!");
                userAlert.showAndWait();
                if (selectedUser instanceof Customer) {
                    updateViewForCustomer();
                } else if (selectedUser instanceof Advisor) {
                    updateViewForAdvisor();
                }
            }
        } else {
            Alert userAlert = new Alert(Alert.AlertType.ERROR);
            userAlert.setContentText("No User Was Selected");
            userAlert.showAndWait();
        }
    }

    private void resetPassword() {
        User selectedUser = clm_table.getSelectionModel().getSelectedItem();
        if (selectedUser != null) {
            // Perform reset password operation for selected user
            // Example: Model.getInstance().resetPassword(selectedUser);
            // You need to implement resetPassword method in your Model class
            // Refresh TableView after password reset
            populateTableView();
        } else {
            // Inform user to select a user before resetting password
            // Example: Alert userAlert = new Alert(Alert.AlertType.WARNING);
            // userAlert.setContentText("Please select a user to reset password.");
            // userAlert.showAndWait();
        }
    }
}