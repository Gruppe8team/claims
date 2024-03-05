package claims.controllers.Customer;

import java.net.URL;
import java.util.ResourceBundle;

import claims.models.Model;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class CustomerMenuController {

    @FXML
    private Button home_btn;
    
    @FXML
    private Button Insurance_btn;

    @FXML
    private Button claims_btn;

    @FXML
    private Button logout_btn;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
    }

    private void addListeners() {
        home_btn.setOnAction(event -> onHome());
        claims_btn.setOnAction(event -> onClaims());
    }

    private void onHome() {
        Model.getInstance().getViewFactory().getCustomerSelectedMenuItem().set("Home");
    }

    private void onClaims() {
        Model.getInstance().getViewFactory().getCustomerSelectedMenuItem().set("MyClaims");
    }
}
