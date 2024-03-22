package claims.models.Drivers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClaimDatabaseDriver {
    private Connection conn;

    public ClaimDatabaseDriver() {
        try {
            this.conn = DriverManager.getConnection("jdbc:sqlite:Databases/claims.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ResultSet getAllClaims(){
        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = this.conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM claims");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    
    public ResultSet getClaimDetails(int claimID){
        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = this.conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM claims WHERE ClaimID="+claimID+";");  
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    
    public void removeClaim(int claimID) {
        try {
            Statement statement = this.conn.createStatement();
            statement.executeUpdate("DELETE FROM claims WHERE ClaimID=" + claimID + ";");
            System.out.println("Claim with ID " + claimID + " removed successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
