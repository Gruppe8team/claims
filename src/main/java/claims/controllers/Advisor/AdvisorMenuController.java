package claims.controllers.Advisor;

import java.net.URL;
import java.util.ResourceBundle;

import claims.models.Model;
import claims.views.AdvisorMenuOptions;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class AdvisorMenuController implements Initializable {
	
	@FXML
	private Button home_btn;
	
	@FXML
	private Button policy_btn;
	
	@FXML
	private Button claims_btn;
	
	@FXML
	private Button logout_btn;

    @FXML
    private ImageView zapad;
	
	@Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
        image();
    }
	
	private void addListeners() {
        claims_btn.setOnAction(event -> onClaims());
        policy_btn.setOnAction(event -> onPolicy());
        logout_btn.setOnAction(event -> onLogout());
        home_btn.setOnAction(event -> onHome());
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

    private void image() {
        Image image = new Image(getClass().getResourceAsStream("/claims/fxml/logoV3.png"));
        this.zapad.setImage(image);
    }

    private void onLogout() {
        Model.getInstance().setAdvisorLoginSuccessFlag(false);
    	Stage stage = (Stage) logout_btn.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showLoginWindow();
    }
	
	

}
