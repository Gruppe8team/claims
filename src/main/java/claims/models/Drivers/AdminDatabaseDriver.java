package claims.models.Drivers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminDatabaseDriver {
    private Connection conn;

    public AdminDatabaseDriver() {
        try {
            this.conn = DriverManager.getConnection("jdbc:sqlite:admins.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getAdminDetails(String username, String password){
        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = this.conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM admins WHERE Username='"+username+"' AND Password='"+password+"';");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}
