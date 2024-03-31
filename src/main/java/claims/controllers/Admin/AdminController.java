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
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().addListener((observableValue, oldVal, newVal) -> {
            switch (newVal) {
                case ADVISORS -> admin_parent.setCenter(Model.getInstance().getViewFactory().getAdminAdvisorsView());
                case CUSTOMERS -> admin_parent.setCenter(Model.getInstance().getViewFactory().getAdminCustomersView());
                case POLICY -> admin_parent.setCenter(Model.getInstance().getViewFactory().getAdvisorPolicyView());
                case CLAIMS -> admin_parent.setCenter(Model.getInstance().getViewFactory().getAdminClaimsView());
                default -> admin_parent.setCenter(Model.getInstance().getViewFactory().getAdminHomeView());
            }
        });
    }
}
