package claims.models.Drivers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PolicyDatabaseDriver {
    private Connection conn;

    public PolicyDatabaseDriver() {
        try {
            this.conn = DriverManager.getConnection("jdbc:sqlite:Databases/policies.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
