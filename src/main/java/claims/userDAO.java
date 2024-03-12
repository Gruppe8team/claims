package claims;

import java.sql.*;

public class userDAO {
	 
	static String dbName;
	static String dbUsername;
	static String dbPassword;
	static String url;
	static String tableName;
	static Connection connection;

	
	public userDAO() throws SQLException {
		dbName = "claimsDB";
		dbUsername = "postgres";
		dbPassword = "$$admin468";
		url = "jdbc:postgresql://localhost:5432/" + dbName;
		tableName = "users";
		
		connection = DriverManager.getConnection(url,dbUsername,dbPassword);
		System.out.println("Success");
		
	}	
	
	
	public void getUserInfo() throws SQLException {
		String sql = "SELECT * FROM public."+tableName; 
		 
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()) {
			System.out.println(rs.getString("firstname"));
		}
	}

	
	public void addToTable(String FirstName,String LastName,String Email,String Phone,String Passkey,String Address,String Gender,String Age,String BirthDate) throws SQLException {
		
		String sql = "INSERT INTO "+tableName+"(FirstName, LastName, Email, Phone, Passkey,Address,Gender,Age,BirthDate)\r\n"
				+ "VALUES ('"+FirstName+"', '"+LastName+"', '"+Email+"', '"+Phone+"', '"+Passkey+"', '"+Address+"', '"+Gender+"', "+Age+", '"+BirthDate+"')";
		
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
	}
	
	public void removeFromTable(String FirstName,String LastName,String Email,String Phone,String Passkey,String Address,String Gender,String Age,String BirthDate) throws SQLException {
		
		String sql = "delete from "+tableName+ "VALUEs ('"+FirstName+"', '"+LastName+"', '"+Email+"', '"+Phone+"', '"+Passkey+"', '"+Address+"', '"+Gender+"', "+Age+", '"+BirthDate+"')";
		
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
	}
	
	public String getEmailInfo() throws SQLException {
		String sql = "SELECT * FROM public."+tableName; 
		 
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		return rs.getString("email");
	}
	
	public String getPasswordInfo() throws SQLException {
		String sql = "SELECT * FROM public."+tableName; 
		 
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		return rs.getString("passkey");
	}
	

	
//	public static void main(String[] args) throws SQLException {
//		
//		dbName = "claimsDB";
//		dbUsername = "postgres";
//		dbPassword = "$$admin468";
//		url = "jdbc:postgresql://localhost:5432/" + dbName;
//		tableName = "users";
//		
//		connection = DriverManager.getConnection(url,dbUsername,dbPassword);
//		System.out.println("Success");
//		 
//		String sql = "SELECT * FROM public."+tableName; 
//		 
//		Statement st = connection.createStatement();
//		ResultSet rs = st.executeQuery(sql);
//		
//		while(rs.next()) {
//			System.out.println(rs.getString("firstname"));
//		}
//		
//		connection.close();
//		
//	}
	
}
