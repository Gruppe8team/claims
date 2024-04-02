package claims;

import claims.models.Model;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class AutoClaim extends Application {

    @Override
    public void start(Stage stage) {
        Model.getInstance().getViewFactory().showLoginWindow();
    }

    public static void main(String[] args) {
        launch(args);
    }


    public static void exitApplication() {
        Platform.exit();
    }
}
