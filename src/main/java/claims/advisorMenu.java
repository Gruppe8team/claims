package claimsGUI;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class advisorMenu extends Application{


	@Override
	public void start(Stage primaryStage) throws Exception {
		
		try {
            Parent root = FXMLLoader.load(getClass().getResource("advisorMenu.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setTitle("Advisor Menu");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
        }
		
	}
	
	public static void main(String[] args) {
		 launch(args);
	}

}
