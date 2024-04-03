package claims.controllers.Customer;

import java.net.URL;
import java.util.ResourceBundle;
import claims.models.Model;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

public class CustomerController implements Initializable {
    public BorderPane customer_parent;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Model.getInstance().getViewFactory().getCustomerSelectedMenuItem().addListener((observableValue, oldVal, newVal) -> {
            switch (newVal) {
                case HOME -> customer_parent.setCenter(Model.getInstance().getViewFactory().getHomeView());
                case EDIT -> customer_parent.setCenter(Model.getInstance().getViewFactory().getEditView());
                case INSURANCE -> customer_parent.setCenter(Model.getInstance().getViewFactory().getInsuranceView());
                case CLAIMS -> customer_parent.setCenter(Model.getInstance().getViewFactory().getClaimsView());
                default -> customer_parent.setCenter(Model.getInstance().getViewFactory().getHomeView());
            }
        });
    }
    
}
