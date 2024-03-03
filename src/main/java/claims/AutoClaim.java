package claims;
import javafx.application.Application;
import javafx.stage.Stage;

public class AutoClaim extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        ViewFactory viewFactory = new ViewFactory();
        viewFactory.showLoginWindow();
    }

}
