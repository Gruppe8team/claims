package claims.models.Drivers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PolicyDatabaseDriver {
    private Connection conn;

    public PolicyDatabaseDriver() {
        try {
            this.conn = DriverManager.getConnection("jdbc:sqlite:Databases/policies.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ResultSet getAllPolicies(){
        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = this.conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM policies");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}
