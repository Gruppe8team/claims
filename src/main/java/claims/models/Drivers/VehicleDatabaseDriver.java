package claims.models.Drivers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class VehicleDatabaseDriver {
    private Connection conn;

    public VehicleDatabaseDriver() {
        try {
            this.conn = DriverManager.getConnection("jdbc:sqlite:vehicles.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
