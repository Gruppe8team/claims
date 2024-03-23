package claims.models.Drivers;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDatabaseDriver {
    private Connection conn;

    public CustomerDatabaseDriver() {
        try {
            this.conn = DriverManager.getConnection("jdbc:sqlite:Databases/customers.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Customer Section
    public ResultSet searchAllCustomers(){
        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = this.conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM customers");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet searchCustomerByAdvisorID(int advisorID){
        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = this.conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM customers WHERE AdvisorID="+advisorID+";");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    
    public ResultSet getCustomerDetails(String username, String password){
        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = this.conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM customers WHERE Username='"+username+"' AND Password='"+password+"';");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    
    public void removeCustomer(int clientID) {
        try {
            Statement statement = this.conn.createStatement();
            statement.executeUpdate("DELETE FROM customers WHERE ClientID=" + clientID + ";");
            System.out.println("Customer with ID " + clientID + " removed successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
