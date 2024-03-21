package claims.models.Drivers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdvisorDatabaseDriver {
    private Connection conn;

    public AdvisorDatabaseDriver() {
        try {
            this.conn = DriverManager.getConnection("jdbc:sqlite:Databases/advisors.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ResultSet getAllAdvisors(){
        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = this.conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM advisor");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet getAdvisorDetails(String username, String password){
        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = this.conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM advisors WHERE Username='"+username+"' AND Password='"+password+"';");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    
    public void removeAdvisor(int advisorID) {
        try {
            Statement statement = this.conn.createStatement();
            statement.executeUpdate("DELETE FROM advisors WHERE AdvisorID=" + advisorID + ";");
            System.out.println("Advisor with ID " + advisorID + " removed successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
