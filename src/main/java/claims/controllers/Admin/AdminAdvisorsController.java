package claims.controllers.Admin;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import claims.models.Model;
import claims.models.Drivers.AdvisorDatabaseDriver;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class AdminAdvisorsController implements Initializable {
    public BorderPane admin_parent;
    AdvisorDatabaseDriver add = new AdvisorDatabaseDriver();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().addListener((observableValue, oldVal, newVal) -> {
            switch (newVal) {
                case ADVISORS -> {
                    admin_parent.setCenter(Model.getInstance().getViewFactory().getAdminAdvisorsView());
                    populateAdvisorsView();
                }
            }
        });
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
