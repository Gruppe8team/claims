package claims.models.Drivers;

import java.sql.Statement;

import claims.models.Customer;
import claims.models.NewUser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClaimsDatabaseDriver {
    private Connection conn;
    private static ClaimsDatabaseDriver claimsDatabaseDriver;

    public ClaimsDatabaseDriver() {
        try {
        	Class.forName("org.sqlite.JDBC");
            this.conn = DriverManager.getConnection("jdbc:sqlite:Databases/claims.db");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static synchronized ClaimsDatabaseDriver getInstance() {
        if (claimsDatabaseDriver == null) {
            claimsDatabaseDriver = new ClaimsDatabaseDriver();
        }
        return claimsDatabaseDriver;
    }

    //Customer Section
    
    
    
    public void addCustomer(NewUser user) {

    	String sql = "INSERT INTO Customers"
				+ "(Username, Password, Firstname, Lastname, Age,Sex,Email,Phone,Address)\r\n"
				+ "VALUES ('"+user.getUsername()+"', '"+user.getPasswordKey()+"', '"+user.getFirstName()+"', '"+user.getLastName()+"',"
						+ " '"+user.getAge()+"', '"+user.getGender()+"', '"+user.getEmail()+"', "+user.getPhone()+", '"+user.getAddr()+"')";
    	
		
		try {
			Statement st = conn.createStatement();
			int rs = st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
 
    
    public ResultSet searchAllCustomers(){
        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = this.conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Customers");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet searchCustomerByAdvisorID() {
        ResultSet resultSet = null;
        // Use try-with-resources to ensure proper closure of resources
        try (PreparedStatement preparedStatement = this.conn.prepareStatement("SELECT * FROM Customers")) {
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    
    public ResultSet getCustomerDetails(String username, String password){
        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = this.conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Customers WHERE Username='"+username+"' AND Password='"+password+"';");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    
    public void removeCustomer(int clientID) {
        try {
            Statement statement = this.conn.createStatement();
            statement.executeUpdate("DELETE FROM Customers WHERE ClientID=" + clientID + ";");
            System.out.println("Customer with ID " + clientID + " removed successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCustomer(String username, String password, String firstName, String lastName, int age, String sex, String email, String phone, String address, int clientId) {
        String sql = "UPDATE Customers SET Username=?, Password=?, FirstName=?, LastName=?, " +
        "Age=?, Sex=?, Email=?, Phone=?, Address=? WHERE ClientID=?";
        try (PreparedStatement pstmt = this.conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, firstName);
            pstmt.setString(4, lastName);
            pstmt.setInt(5, age);
            pstmt.setString(6, sex);
            pstmt.setString(7, email);
            pstmt.setString(8, phone);
            pstmt.setString(9, address);
            pstmt.setInt(10, clientId);
            int affectedRows = pstmt.executeUpdate();
            
            if (affectedRows > 0) {
                System.out.println("Update successful.");
            } else {
                System.out.println("Update failed. No rows affected.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Advisor Section
    
    public void addAdvisor(NewUser user) {

    	String sql = "INSERT INTO Advisors"
				+ "(Username, Password, Firstname, Lastname,Email)\r\n"
				+ "VALUES ('"+user.getUsername()+"', '"+user.getPasswordKey()+"', '"+user.getFirstName()+"', '"+user.getLastName()+"','"
						+user.getEmail()+"')";
		
		try {
			Statement st = conn.createStatement();
			int rs = st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

    public ResultSet getAllAdvisors(){
        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = this.conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Advisors");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet getAdvisorDetails(String username, String password){
        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = this.conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Advisors WHERE Username='"+username+"' AND Password='"+password+"';");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    
    public void removeAdvisor(int advisorID) {
        try {
            Statement statement = this.conn.createStatement();
            statement.executeUpdate("DELETE FROM Advisors WHERE AdvisorID=" + advisorID + ";");
            System.out.println("Advisor with ID " + advisorID + " removed successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Vehicle Section

    public ResultSet getAllVehicles(){
        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = this.conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Vehicles");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    
    public ResultSet getCustomerVehicles(Customer customer){
    	Statement statement;
        ResultSet resultSet = null;
        try {
            statement = this.conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Vehicles WHERE ownerID='"+customer.getUserID()+";");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    
    public void removeVehicle(int vehicleID) {
        try {
            Statement statement = this.conn.createStatement();
            statement.executeUpdate("DELETE FROM Vehicles WHERE VehicleID=" + vehicleID + ";");
            System.out.println("Vehicles with ID " + vehicleID + " removed successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Claim Section

    public ResultSet getAllClaims(){
        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = this.conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Claims");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    
    public ResultSet getClaimDetails(int claimID){
        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = this.conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Claims WHERE ClaimID="+claimID+";");  
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    
    public void removeClaim(int claimID) {
        try {
            Statement statement = this.conn.createStatement();
            statement.executeUpdate("DELETE FROM Claims WHERE ClaimID=" + claimID + ";");
            System.out.println("Claim with ID " + claimID + " removed successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Policy Section

    public ResultSet getAllPolicies(){
        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = this.conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Policies");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    
    public ResultSet getPolicyDetails(int policyNumber){
        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = this.conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Policies WHERE PolicyNumber='"+policyNumber);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    //Admin Section
    
    public void addAdmin(NewUser user) {

    	String sql = "INSERT INTO Admins"
				+ "(Username, Password, Firstname, Lastname,Email)\r\n"
				+ "VALUES ('"+user.getUsername()+"', '"+user.getPasswordKey()+"', '"+user.getFirstName()+"', '"+user.getLastName()+"','"
						+user.getEmail()+"')";
		
		try {
			Statement st = conn.createStatement();
			int rs = st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
    
    public ResultSet getAllAdmins(){
        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = this.conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Admins");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    
    public ResultSet getAdminDetails(String username, String password){
        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = this.conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Admins WHERE Username='"+username+"' AND Password='"+password+"';");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}
