package claims;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ViewFactory {
    //Customer Views
    private AnchorPane homeView;

    public ViewFactory(){}

    public AnchorPane getHomeView() {
        if (homeView == null){
            try {
                homeView = new FXMLLoader(getClass().getResource("/claims/Home.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return homeView;
    }

    public void showLoginWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/claims/Login.fxml"));
        createStage(loader);
    }

    public void showCustomerWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/claims/Customer.fxml"));
        CustomerController customerController = new CustomerController();
        loader.setController(customerController);
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
}
