package claims.controllers.Admin;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class AdminMenuController implements Initializable {
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
    
}
