package claims.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseDriver {
    private Connection conn;

    public DatabaseDriver() {
        try {
            this.conn = DriverManager.getConnection("jdbc:sqlite:claims.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Customer Section
    public Customer getCustomerDetails(String email){
        Customer customer = null;
        //Query to fetch customer details from database using email
        //Map results to customer object
        return customer;
    }

    //Advisor Section


    //Admin Section


    //Utility Methods
}
