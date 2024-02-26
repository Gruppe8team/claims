package tests;

import claims.*;
import java.util.ArrayList;
import java.util.List;

public class UserStubDB{
	private static List<User> userDB;
	//initailize the userDB list
	public UserStubDB(){
		userDB = new ArrayList<>();
	}
	//add an advisor to the userDB list
	public void addAdvisor(Advisor advisor) {
		userDB.add(advisor);
	}
	//remove an advisor from the userDB list
	public void removeAdvisor(Advisor advisor) {
		userDB.remove(advisor);
	}
	//add a customer to the userDB list
	public void addCustomer(Customer customer) {
		userDB.add(customer);
	}
	//remove a customer from the userDB list
	public void removeCustomer(Customer customer) {
		userDB.remove(customer);
	}
	//to retrieve and display information about all users in the userDB list
	public static String readAllUsers() {
		StringBuilder userInfo = new StringBuilder();
		// loop through each user in the userDB list
		for (User user : userDB) {
			userInfo.append("ID: ").append(user.getUserID()).append("\n")
			.append("First Name: ").append(user.getFirstName()).append("\n")
			.append("Last Name: ").append(user.getLastName()).append("\n")
			.append("Email: ").append(user.getEmail()).append("\n");
		// to check if the user is an instance of Customer and append additional information
			if (user instanceof Customer) {
	            Customer customer = (Customer) user;
	            userInfo.append("Phone Number: ").append(customer.getPhoneNumber()).append("\n")
	                    .append("Sex: ").append(customer.getgender()).append("\n")
	                    .append("Age: ").append(customer.getAge()).append("\n");
	        }
		}
		
		return userInfo.toString();
	}

		
	
}
