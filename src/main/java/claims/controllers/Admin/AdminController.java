package claims.controllers.Admin;

import java.net.URL;
import java.util.ResourceBundle;

import claims.models.Model;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

public class AdminController implements Initializable {
    public BorderPane admin_parent;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Model.getInstance().getViewFactory().getAdvisorSelectedMenuItem().addListener((observableValue, oldVal, newVal) -> {
            switch (newVal) {
                case POLICY -> admin_parent.setCenter(Model.getInstance().getViewFactory().getAdvisorPolicyView());
                case CLAIMS -> admin_parent.setCenter(Model.getInstance().getViewFactory().getAdvisorClaimsView());
                default -> admin_parent.setCenter(Model.getInstance().getViewFactory().getAdminHomeView());
            }
        });
    }
}
