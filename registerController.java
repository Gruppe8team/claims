package claimsGUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class registerController implements Initializable{
	
	@FXML
    private Button cancelButton;

    @FXML
    private Button confirmButton;
    
    private Stage stage;
    
    public void cancelPressed(ActionEvent e) throws IOException{
   
			Parent loginView = FXMLLoader.load(getClass().getResource("/claimsGUI/Login.fxml"));
			stage = (Stage) cancelButton.getScene().getWindow();
			stage.setScene(new Scene(loginView));
			stage.show();
		
    }
    
	
	@FXML
	private ChoiceBox<String> choiceBox = new ChoiceBox<>();
	
	private String[] gender = {"Male", "Female", "Other"};

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		choiceBox.getItems().addAll(gender);
	}
	
}
