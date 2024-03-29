package databases;
import java.sql.*;
public class AdvisorsDatabase {
	public static void main(String[] args) {
		String dbName = "advisors";
		String dbUser = "postgres";
		String userPassword = "Sh3ld0n1a";
		String url = "jdbc:postgresql://localhost:5432/" + dbName ;
		
		try {
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/advisors", "postgres", "Sh3ld0n1a");
			System.out.println("Connected_to_the_PostgreSQL_server_successfully.");
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Advisors");
			
			//Print table
			System.out.println("Advisor_Info:");
			System.out.println("userid_|_passwordkey_|_firstname_|_lastname_|_email");
			while (resultSet.next()) {
			System.out.println(resultSet.getInt("userid") + "_|_" + resultSet.getString("passwordkey")+"_|_"+resultSet.getString("firstname")+"_|_"+resultSet.getString("lastname")+"_|_"+resultSet.getString("email"));
			}
			connection.close();
			
		} catch(SQLException e) {
			System.out.println("Connection_Failure");
			e.printStackTrace();
		}
		
		
		}


}
