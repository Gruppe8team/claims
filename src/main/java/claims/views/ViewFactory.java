package claims.views;

import claims.Advisor;
import claims.AdvisorMenuOptions;
import claims.CustomerMenuOptions;
import claims.controllers.Advisor.AdvisorController;
import claims.controllers.Customer.CustomerController;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ViewFactory {
    //Customer Views
    private final ObjectProperty<CustomerMenuOptions> customerSelectedMenuItem;
    private AnchorPane homeView;
    private AnchorPane claimsView;
    private AnchorPane insuranceView;
    private AnchorPane editView;

    //Adivisor Views
    private final ObjectProperty<AdvisorMenuOptions> advisorSelectedMenuItem;
    private AnchorPane advisorHomeView;
    private AnchorPane advisorClaimsView;
    private AnchorPane advisorPolicyView;

    public ViewFactory(){
        this.customerSelectedMenuItem = new SimpleObjectProperty<>();
        this.advisorSelectedMenuItem = new SimpleObjectProperty<>();
    }

    public ObjectProperty<CustomerMenuOptions> getCustomerSelectedMenuItem() {
        return customerSelectedMenuItem;
    }

    public ObjectProperty<AdvisorMenuOptions> getAdvisorSelectedMenuItem() {
        return advisorSelectedMenuItem;
    }

    //Customer Views
    public AnchorPane getHomeView() {
        if (homeView == null){
            try {
                homeView = new FXMLLoader(getClass().getResource("/claims/fxml/Home.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return homeView;
    }

    public AnchorPane getClaimsView() {
        if (claimsView == null){
            try {
                claimsView = new FXMLLoader(getClass().getResource("/claims/fxml/MyClaims.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return claimsView;
    }

    public AnchorPane getInsuranceView() {
        if (insuranceView == null){
            try {
                insuranceView = new FXMLLoader(getClass().getResource("/claims/fxml/MyInsurance.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return insuranceView;
    }

    public AnchorPane getEditView() {
        if (editView == null){
            try {
                editView = new FXMLLoader(getClass().getResource("/claims/fxml/UserAccountGUI.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return editView;
    }

    //Advisor Views
    public AnchorPane getAdvisorHomeView() {
        if (advisorHomeView == null){
            try {
                advisorHomeView = new FXMLLoader(getClass().getResource("/claims/fxml/AdvisorHome.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return advisorHomeView;
    }

    public AnchorPane getAdvisorClaimsView() {
        if (advisorClaimsView == null){
            try {
                advisorClaimsView = new FXMLLoader(getClass().getResource("/claims/fxml/AdvisorClaims.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return advisorClaimsView;
    }

    public AnchorPane getAdvisorPolicyView() {
        if (advisorPolicyView == null){
            try {
                advisorPolicyView = new FXMLLoader(getClass().getResource("/claims/fxml/AdvisorPolicy.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return advisorPolicyView;
    }

    //Windows
    public void showLoginWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/claims/fxml/Login.fxml"));
        createStage(loader);
    }

    public void showCustomerWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/claims/fxml/Customer.fxml"));
        CustomerController customerController = new CustomerController();
        loader.setController(customerController);
        createStage(loader);
    }

    public void showAdvisorWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/claims/fxml/Advisor.fxml"));
        AdvisorController advisorController = new AdvisorController();
        loader.setController(advisorController);
        createStage(loader);
    }

    public void showRegisterWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/claims/fxml/registerGUI.fxml"));
        createStage(loader);
    }

    //Stage Creation/Closing
    private void createStage(FXMLLoader loader) {
        Scene scene = null;
        try {
            scene = new Scene(loader.load());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("AutoClaim");
        stage.show();
    }

    public void closeStage(Stage stage) {
        stage.close();
    }
}
