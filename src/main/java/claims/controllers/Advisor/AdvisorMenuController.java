package claims.controllers.Advisor;

import java.net.URL;
import java.util.ResourceBundle;

import claims.models.Model;
import claims.views.AdvisorMenuOptions;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class AdvisorMenuController implements Initializable {
	
	@FXML
	private Button home_btn;
	
	@FXML
	private Button policy_btn;
	
	@FXML
	private Button claims_btn;
	
	@FXML
	private Button logout_btn;
	
	@Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
    }
	
	private void addListeners() {
        home_btn.setOnAction(event -> onHome());
        claims_btn.setOnAction(event -> onClaims());
        policy_btn.setOnAction(event -> onPolicy());
        logout_btn.setOnAction(event -> onLogout());
    }
	
	private void onHome() {
        Model.getInstance().getViewFactory().getAdvisorSelectedMenuItem().set(AdvisorMenuOptions.HOME);
    }

    private void onClaims() {
        System.out.println("onClaims");
        Model.getInstance().getViewFactory().getAdvisorSelectedMenuItem().set(AdvisorMenuOptions.CLAIMS);
    }

    private void onPolicy() {
        Model.getInstance().getViewFactory().getAdvisorSelectedMenuItem().set(AdvisorMenuOptions.POLICY);
    }

    private void onLogout() {
        
    }
	
	

}
