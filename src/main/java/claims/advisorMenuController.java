package claimsGUI;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class advisorMenuController {
	
	@FXML
	private Button homeButton;
	
	@FXML
	private Button policyButton;
	
	@FXML
	private Button claimsButton;
	
	@FXML
	private Button logoutButton;
	
	@FXML
	private Button homeBack;
	
	@FXML
	private Button policyBack;
	
	@FXML
	private Button claimsBack;
	
	private Stage stage;
	
	
	
	public void homeButtonPressed(ActionEvent e) throws IOException{
		
		Parent homeDashboardView = FXMLLoader.load(getClass().getResource("AdvisorHomeDashboard.fxml"));
		stage = (Stage) homeButton.getScene().getWindow();
		stage.setScene(new Scene(homeDashboardView));
		stage.show();
		
	}
	
	public void policyButtonPressed(ActionEvent e) throws IOException{
		Parent policyDashboardView = FXMLLoader.load(getClass().getResource("AdvisorPolicyDashboard.fxml"));
		stage = (Stage) policyButton.getScene().getWindow();
		stage.setScene(new Scene(policyDashboardView));
		stage.show();
	}
	
	public void cliamsButtonPressed(ActionEvent e) throws IOException {
		Parent claimsDashboardView = FXMLLoader.load(getClass().getResource("AdvisorClaimsDashboard.fxml"));
		stage = (Stage) claimsButton.getScene().getWindow();
		stage.setScene(new Scene(claimsDashboardView));
		stage.show();
	}

	public void logoutButtonPressed(ActionEvent e) throws IOException{
		Parent loginView = FXMLLoader.load(getClass().getResource("Login.fxml"));
		stage = (Stage) logoutButton.getScene().getWindow();
		stage.setScene(new Scene(loginView));
		stage.show();
	}

	public void homeBackPressed(ActionEvent e) throws IOException{
		Parent MenuView = FXMLLoader.load(getClass().getResource("AdvisorMenu.fxml"));
		stage = (Stage) homeBack.getScene().getWindow();
		stage.setScene(new Scene(MenuView));
		stage.show();
	}
	
	public void policyBackPressed(ActionEvent e) throws IOException {
		Parent MenuView = FXMLLoader.load(getClass().getResource("AdvisorMenu.fxml"));
		stage = (Stage) policyBack.getScene().getWindow();
		stage.setScene(new Scene(MenuView));
		stage.show();
	}

	public void claimsBackPressed(ActionEvent e) throws IOException{
		Parent MenuView = FXMLLoader.load(getClass().getResource("AdvisorMenu.fxml"));
		stage = (Stage) claimsBack.getScene().getWindow();
		stage.setScene(new Scene(MenuView));
		stage.show();
	}
	
	
	

}
