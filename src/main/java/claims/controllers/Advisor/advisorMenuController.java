package claims.controllers.Advisor;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import claims.models.Model;
import claims.views.AdvisorMenuOptions;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
