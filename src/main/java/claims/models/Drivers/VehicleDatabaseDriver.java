package claims.models.Drivers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VehicleDatabaseDriver {
    private Connection conn;

    public VehicleDatabaseDriver() {
        try {
            this.conn = DriverManager.getConnection("jdbc:sqlite:Databases/vehicles.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ResultSet getAllVehicles(){
        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = this.conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM vehicles");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}
