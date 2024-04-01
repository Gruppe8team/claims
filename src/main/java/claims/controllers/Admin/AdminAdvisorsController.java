package claims.controllers.Admin;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import claims.models.Model;
import claims.models.Drivers.ClaimsDatabaseDriver;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class AdminAdvisorsController implements Initializable {
    public BorderPane admin_parent;
    
    
    ClaimsDatabaseDriver add = new ClaimsDatabaseDriver();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        
    }

    private void populateAdvisorsView() {
        try (
             ResultSet rs = add.getAllAdvisors()) {
            while (rs.next()) {
                String advisorFirstName = rs.getString("firstName");
                String advisorLastName = rs.getString("lastName");
                String advisorEmail = rs.getString("email");
                // Populate UI components with advisor data
                admin_parent.getChildren().add(new Label("Advisor: " + advisorFirstName + advisorLastName + "\n" +
                										"Email: " + advisorEmail + "\n"))	;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database errors
        }
    }
}
