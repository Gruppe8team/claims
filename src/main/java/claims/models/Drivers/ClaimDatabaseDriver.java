package claims.models.Drivers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ClaimDatabaseDriver {
    private Connection conn;

    public ClaimDatabaseDriver() {
        try {
            this.conn = DriverManager.getConnection("jdbc:sqlite:Databases/claims.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
