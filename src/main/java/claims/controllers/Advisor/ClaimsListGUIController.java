package claims.controllers.Advisor;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import java.net.URL;

import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class ClaimsListGUIController implements Initializable{
	
	//Dummy claims for now.
	@FXML
	private ListView<String> claimsList;
	private Label claimLabel;
	private String[] openedClaims = {"Johnson","Mrs.Falander","Accident Ivan"};
	private String currentOpenedClaim;
	
	
	public void back(ActionEvent e) throws Exception{
	System.out.println("Returned to prev menu(replace with real stuff)");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		claimsList.getItems().addAll(openedClaims);
		claimsList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){

			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				currentOpenedClaim = claimsList.getSelectionModel().getSelectedItem();
				claimLabel.setText("Selected "+currentOpenedClaim+"'s Claim");
				
			
		
			}});}
	
}
