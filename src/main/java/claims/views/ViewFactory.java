package claims.views;

import claims.controllers.Customer.CustomerController;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ViewFactory {
    //Customer Views
    private final StringProperty customerSelectedMenuItem;
    private AnchorPane homeView;
    private AnchorPane claimsView;

    public ViewFactory(){
        this.customerSelectedMenuItem = new SimpleStringProperty("");
    }

    public StringProperty getCustomerSelectedMenuItem() {
        return customerSelectedMenuItem;
    }

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

    public void showRegisterWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/claims/fxml/registerGUI.fxml"));
        createStage(loader);
    }

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
