package claims.controllers.Advisor;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import claims.models.Model;
import claims.models.Drivers.ClaimsDatabaseDriver;
import claims.models.Customer;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
    private TableColumn<Customer, StringProperty> email_col;

    @FXML
    private Label hi_lbl;

    @FXML
    private TableColumn<Customer, IntegerProperty> id_col;

    @FXML
    private TableColumn<Customer, StringProperty> name_col;

    @FXML
    private Label today_lbl;

    @FXML
    private ImageView logola;
    @FXML
    private TableView<Customer> clients_tableview;

    private ObservableList<Customer> customers = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){

        Image image = new Image(getClass().getResourceAsStream("/claims/fxml/logoV3.png"));
        logola.setImage(image);
        this.customers = Model.getInstance().getCustomers();
        id_col.setCellValueFactory(new PropertyValueFactory<>("userID"));
        name_col.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        email_col.setCellValueFactory(new PropertyValueFactory<>("email"));
        clients_tableview.setItems(this.customers);
    }

    
}
