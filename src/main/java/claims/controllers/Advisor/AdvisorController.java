package claims.controllers.Advisor;

import java.net.URL;
import java.util.ResourceBundle;
import claims.models.Model;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

public class AdvisorController implements Initializable {
    public BorderPane advisor_parent;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().addListener((observableValue, oldVal, newVal) -> {
            switch (newVal) {
                case POLICY -> advisor_parent.setCenter(Model.getInstance().getViewFactory().getAdvisorPolicyView());
                case CLAIMS -> advisor_parent.setCenter(Model.getInstance().getViewFactory().getAdvisorClaimsView());
                default -> advisor_parent.setCenter(Model.getInstance().getViewFactory().getAdvisorHomeView());
            }
        });
    }
}
