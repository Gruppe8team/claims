package claims.controllers.Advisor;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import claims.models.Model;
import claims.views.AdvisorMenuOptions;
import claims.views.CustomerMenuOptions;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class advisorMenuController implements Initializable {
	
	@FXML
	private Button homeButton;
	
	@FXML
	private Button policyButton;
	
	@FXML
	private Button claimsButton;
	
	@FXML
	private Button logoutButton;
	
	@Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
    }
	
	private void addListeners() {
        homeButton.setOnAction(event -> onHome());
        claimsButton.setOnAction(event -> onClaims());
        policyButton.setOnAction(event -> onPolicy());
    }
	
	private void onHome() {
        Model.getInstance().getViewFactory().getAdvisorSelectedMenuItem().set(AdvisorMenuOptions.HOME);
    }

    private void onClaims() {
        Model.getInstance().getViewFactory().getAdvisorSelectedMenuItem().set(AdvisorMenuOptions.CLAIMS);
    }

    private void onPolicy() {
        Model.getInstance().getViewFactory().getAdvisorSelectedMenuItem().set(AdvisorMenuOptions.POLICY);
    }
	
	

}
