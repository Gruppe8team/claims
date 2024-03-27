package databases;

import java.sql.*;
import java.util.Random;

import claims.models.NewUser;

public class UserDatabase {
	private static String dbName = "claims_customerdb";
	private static String dbUser = "postgres";
	private static String userPassword = "postgres";
	private static String url = "jdbc:postgresql://localhost:5433/" + dbName;

	public static void main(String[] args) {
		String sql = "select * from customer where userid = 8111";
		NewUser user = getUser(sql);
		if(user.getUserID() == 0){
			//fail
			System.out.println("null");
		}
		//saveNewUser(user);
		//user.setFirstName("new");
		//updateNewUser(user);
		deleteNewUser(user);
		System.out.println(user);
	}

	public static void saveNewUser(NewUser user) {

		String sql = "INSERT INTO customer(\n" +
				"\tuserid, passwordkey, firstname, lastname, email, address, phonenumber, gender, age,username,usertype,addr)\n" +
				"\tVALUES ("+getUserId()+", \'"+user.getPasswordKey()+"\', \'"+user.getFirstName()+"\'," +
				" \'"+user.getLastName()+"\', \'"+user.getEmail()+"\', \'"+user.getDob()+"\', \'"+user.getPhone()+"\'," +
				" \'"+user.getGender()+"\', 12, \'"+user.getUsername()+"\',\'"+user.getUserType()+"\',\'"+user.getAddr()+"\');";
		System.out.println(sql);
		executeSql(sql);

	}

	public static void updateNewUser(NewUser user) {

		String sql = "UPDATE customer\n" +
				"\tSET passwordkey=\'"+user.getPasswordKey()+"\', firstname=\'"+user.getFirstName()+"\', " +
				"lastname=\'"+user.getLastName()+"\', email=\'"+user.getEmail()+"\', " +
				"address=\'"+user.getDob()+"\', phonenumber=\'"+user.getPhone()+"\', gender=\'"+user.getGender()+"\', age=12\n" +
				"\tWHERE userid = "+user.getUserID()+";";
		System.out.println(sql);
		executeSql(sql);

	}

	public static void deleteNewUser(NewUser user) {

		String sql = "DELETE FROM customer\n" +
				"\tWHERE userid = "+user.getUserID()+";";
		System.out.println(sql);
		executeSql(sql);

	}

	public static int getUserId(){
		Random random = new Random();
		int min = 1000;
		int max = 9999;
		int randomNumber = random.nextInt(max - min + 1) + min;
		return randomNumber;
	}

	public static Connection getConnection(){
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, dbUser, userPassword);
			System.out.println("Connected_to_the_PostgreSQL_server_successfully.");

			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void executeSql(String sql){
		Connection connection = getConnection();
		//Statement statement1 = connection.createStatement();
		try {
			Statement statement = connection.createStatement();
			statement.execute(sql);
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static NewUser getUser(String sql){
		Connection connection = getConnection();

		ResultSet resultSet = null;
		try {
			Statement statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			//Print table
			System.out.println("Advisor_Info:");
			System.out.println("userid_|_passwordkey_|_firstname_|_lastname_|_email");
			NewUser newUser = new NewUser();
			while (resultSet.next()) {

				newUser.setUserID(resultSet.getInt("userid"));
				newUser.setPasswordKey(resultSet.getString("passwordkey"));
				newUser.setFirstName(resultSet.getString("firstname"));
				newUser.setLastName(resultSet.getString("lastname"));
				newUser.setPhone(resultSet.getString("phonenumber"));
				newUser.setEmail(resultSet.getString("email"));
				newUser.setGender(resultSet.getString("gender"));
				newUser.setDob(resultSet.getString("address"));
				System.out.println(resultSet.getInt("userid")
						+ "_|_" + resultSet.getString("passwordkey")
						+ "_|_" + resultSet.getString("firstname")
						+ "_|_" + resultSet.getString("lastname")
						+ "_|_" + resultSet.getString("email"));
				return newUser;
			}

			connection.close();
			return newUser;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

}
