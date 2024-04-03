package claims.controllers.Admin;

import java.net.URL;
import java.util.ResourceBundle;
import claims.models.Model;
import claims.views.AdminMenuOptions;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class AdminMenuController implements Initializable {
    @FXML
	private Button home_btn;
	
	@FXML
	private Button customers_btn;

    @FXML
    private ImageView vostok;
	@FXML
	private Button advisors_btn;
	
	@FXML
	private Button logout_btn;


	
	@Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
        image();
    }
	
	private void addListeners() {
        home_btn.setOnAction(event -> onHome());
        customers_btn.setOnAction(event -> onCustomers());
        advisors_btn.setOnAction(event -> onClaims());
        logout_btn.setOnAction(event -> onLogout());
    }

    private void onHome() {
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set(AdminMenuOptions.HOME);
    }

    private void onCustomers() {
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set(AdminMenuOptions.CUSTOMERS);
    }

    private void onClaims() {
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set(AdminMenuOptions.CLAIMS);
    }

    private void onPolicy() {
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set(AdminMenuOptions.POLICY);
    }

    private void image() {
        Image image = new Image(getClass().getResourceAsStream("/claims/fxml/logoV3.png"));
        this.vostok.setImage(image);
    }

    private void onLogout() {
        Model.getInstance().setAdminLoginSuccessFlag(false);
        Stage stage = (Stage) logout_btn.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showLoginWindow();
    }
    
}
