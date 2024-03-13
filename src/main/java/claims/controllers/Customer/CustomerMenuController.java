package claims.controllers.Customer;

import java.net.URL;
import java.util.ResourceBundle;

import claims.models.Model;
import claims.views.CustomerMenuOptions;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class CustomerMenuController implements Initializable {

    @FXML
    public Button home_btn;
    
    @FXML
    public Button insurance_btn;

    @FXML
    public Button claims_btn;

    @FXML
    public Button logout_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
    }

    private void addListeners() {
        home_btn.setOnAction(event -> onHome());
        claims_btn.setOnAction(event -> onClaims());
        insurance_btn.setOnAction(event -> onInsurance());
    }

    private void onHome() {
        Model.getInstance().getViewFactory().getCustomerSelectedMenuItem().set(CustomerMenuOptions.HOME);
    }

    private void onClaims() {
        Model.getInstance().getViewFactory().getCustomerSelectedMenuItem().set(CustomerMenuOptions.CLAIMS);
    }

    private void onInsurance() {
        Model.getInstance().getViewFactory().getCustomerSelectedMenuItem().set(CustomerMenuOptions.INSURANCE);
    }
}
