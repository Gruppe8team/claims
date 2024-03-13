package claims.controllers.Admin;

import java.net.URL;
import java.util.ResourceBundle;

import claims.models.Model;
import claims.views.AdminMenuOptions;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class AdminMenuController implements Initializable {
    @FXML
	private Button home_btn;
	
	@FXML
	private Button customers_btn;
	
	@FXML
	private Button advisors_btn;

    @FXML
    private Button claims_btn;

    @FXML
    private Button policy_btn;
	
	@FXML
	private Button logout_btn;
	
	@Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
    }
	
	private void addListeners() {
        home_btn.setOnAction(event -> onHome());
        customers_btn.setOnAction(event -> onCustomers());
        advisors_btn.setOnAction(event -> onAdvisors());
        claims_btn.setOnAction(event -> onClaims());
        policy_btn.setOnAction(event -> onPolicy());
        logout_btn.setOnAction(event -> onLogout());
    }

    private void onHome() {
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set(AdminMenuOptions.HOME);
    }

    private void onCustomers() {
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set(AdminMenuOptions.CUSTOMERS);
    }

    private void onAdvisors() {
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set(AdminMenuOptions.ADVISORS);
    }

    private void onClaims() {
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set(AdminMenuOptions.CLAIMS);
    }

    private void onPolicy() {
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set(AdminMenuOptions.POLICY);
    }

    private void onLogout() {
        
    }
    
}
