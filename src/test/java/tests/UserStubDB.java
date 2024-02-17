package tests;

import claims.*;
import java.util.ArrayList;
import java.util.List;

public class UserStubDB{
	private static List<User> userDB;
	
	public UserStubDB(){
		userDB = new ArrayList<>();
	}
	
	public void addAdvisor(Advisor advisor) {
		userDB.add(advisor);
	}
	
	public void removeAdvisor(Advisor advisor) {
		userDB.remove(advisor);
	}
	
	public void addCustomer(Customer customer) {
		userDB.add(customer);
	}
	
	public void removeCustomer(Customer customer) {
		userDB.remove(customer);
	}
	
	public static String readAllUsers() {
		StringBuilder userInfo = new StringBuilder();
		
		for (User user : userDB) {
			userInfo.append("ID: ").append(user.getUserID()).append("\n")
			.append("First Name: ").append(user.getUserID()).append("\n")
			.append("Last Name: ").append(user.getUserID()).append("\n")
			.append("Email: ").append(user.getUserID()).append("\n");

			if (user instanceof Customer) {
	            Customer customer = (Customer) user;
	            userInfo.append("Phone number: ").append(customer.getPhoneNumber()).append("\n")
	                    .append("Sex: ").append(customer.getgender()).append("\n")
	                    .append("Age: ").append(customer.getAge()).append("\n");
	        }
		}
		
		return userInfo.toString();
	}

		
	
}