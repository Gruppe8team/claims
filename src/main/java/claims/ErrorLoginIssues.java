package claims;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class ErrorLoginIssues extends Application{


    @Override
    public void start(Stage primaryStage){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("errorLoginIssues.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setTitle("Kyle Please Add the Details");
            primaryStage.setScene(scene);
            primaryStage.show();
        }catch(Exception e) {
        }

    }


    public static void main(String[] args) {
        launch(args);
    }


}