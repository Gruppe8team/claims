package claims.views;

import claims.controllers.Admin.AdminController;
import claims.controllers.Advisor.AdvisorController;
import claims.controllers.Customer.CustomerController;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ViewFactory {
    private AccountType loginAccountType;

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

    //Admin Views
    private final ObjectProperty<AdminMenuOptions> adminSelectedMenuItem;
    private AnchorPane adminHomeView;
    private AnchorPane adminCustomersView;
    private AnchorPane adminAdvisorsView;
    private AnchorPane adminClaimsView;
    private AnchorPane adminPolicyView;

    public ViewFactory(){
        this.loginAccountType = AccountType.CUSTOMER;
        this.customerSelectedMenuItem = new SimpleObjectProperty<>();
        this.advisorSelectedMenuItem = new SimpleObjectProperty<>();
        this.adminSelectedMenuItem = new SimpleObjectProperty<>();
    }

    public AccountType getLoginAccountType() {
        return loginAccountType;
    }

    public void setLoginAccountType(AccountType accountType) {
        this.loginAccountType = accountType;
    }

    public ObjectProperty<CustomerMenuOptions> getCustomerSelectedMenuItem() {
        return customerSelectedMenuItem;
    }

    public ObjectProperty<AdvisorMenuOptions> getAdvisorSelectedMenuItem() {
        return advisorSelectedMenuItem;
    }

    public ObjectProperty<AdminMenuOptions> getAdminSelectedMenuItem() {
        return adminSelectedMenuItem;
    }

    //Customer Views
    public AnchorPane getHomeView() {
        if (homeView == null){
            try {
                homeView = new FXMLLoader(getClass().getResource("/claims/fxml/Customer/Home.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return homeView;
    }

    public AnchorPane getClaimsView() {
        if (claimsView == null){
            try {
                claimsView = new FXMLLoader(getClass().getResource("/claims/fxml/Customer/MyClaims.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return claimsView;
    }

    public AnchorPane getInsuranceView() {
        if (insuranceView == null){
            try {
                insuranceView = new FXMLLoader(getClass().getResource("/claims/fxml/Customer/MyInsurance.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return insuranceView;
    }

    public AnchorPane getEditView() {
        if (editView == null){
            try {
                editView = new FXMLLoader(getClass().getResource("/claims/fxml/Customer/Edit.fxml")).load();
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
                advisorHomeView = new FXMLLoader(getClass().getResource("/claims/fxml/Advisor/AdvisorHome.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return advisorHomeView;
    }

    public AnchorPane getAdvisorClaimsView() {
        if (advisorClaimsView == null){
            try {
                advisorClaimsView = new FXMLLoader(getClass().getResource("/claims/fxml/Advisor/AdvisorClaims.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return advisorClaimsView;
    }

    public AnchorPane getAdvisorPolicyView() {
        if (advisorPolicyView == null){
            try {
                advisorPolicyView = new FXMLLoader(getClass().getResource("/claims/fxml/Advisor/AdvisorPolicy.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return advisorPolicyView;
    }

    //Admin Views
    public AnchorPane getAdminHomeView() {
        if (adminHomeView == null){
            try {
                adminHomeView = new FXMLLoader(getClass().getResource("/claims/fxml/Admin/AdminHome.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return adminHomeView;
    }

    public AnchorPane getAdminCustomersView() {
        if (adminCustomersView == null){
            try {
                adminCustomersView = new FXMLLoader(getClass().getResource("/claims/fxml/Admin/AdminCustomers.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return adminCustomersView;
    }

    public AnchorPane getAdminAdvisorsView() {
        if (adminAdvisorsView == null){
            try {
                adminAdvisorsView = new FXMLLoader(getClass().getResource("/claims/fxml/Admin/AdminAdvisors.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return adminAdvisorsView;
    }

    public AnchorPane getAdminClaimsView() {
        if (adminClaimsView == null){
            try {
                adminClaimsView = new FXMLLoader(getClass().getResource("/claims/fxml/Admin/AdminClaims.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return adminClaimsView;
    }

    public AnchorPane getAdminPolicyView() {
        if (adminPolicyView == null){
            try {
                adminPolicyView = new FXMLLoader(getClass().getResource("/claims/fxml/Admin/AdminPolicy.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return adminPolicyView;
    }

    //Windows
    public void showLoginWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/claims/fxml/Login.fxml"));
        createStage(loader);
    }

    public void showCustomerWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/claims/fxml/Customer/Customer.fxml"));
        CustomerController customerController = new CustomerController();
        loader.setController(customerController);
        createStage(loader);
    }

    public void showAdvisorWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/claims/fxml/Advisor/Advisor.fxml"));
        AdvisorController advisorController = new AdvisorController();
        loader.setController(advisorController);
        createStage(loader);
    }

    public void showAdminWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/claims/fxml/Admin/Admin.fxml"));
        AdminController adminController = new AdminController();
        loader.setController(adminController);
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
