package tests;

import claims.models.Advisor;
import claims.models.Customer;
import claims.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserStubDB {
	private static List<User> userDB;

	// initialize the userDB list
	public UserStubDB() {
		userDB = new ArrayList<>();
	}

	// add an advisor to the userDB list
	public void addAdvisor(Advisor advisor) {
		userDB.add(advisor);
	}

	// remove an advisor from the userDB list
	public void removeAdvisor(Advisor advisor) {
		userDB.remove(advisor);
	}

	// add a customer to the userDB list
	public void addCustomer(Customer customer) {
		userDB.add(customer);
	}

	// remove a customer from the userDB list
	public void removeCustomer(Customer customer) {
		userDB.remove(customer);
	}

	// to retrieve and display information about all users in the userDB list
	public static String readAllUsers() {
		StringBuilder userInfo = new StringBuilder();
		// loop through each user in the userDB list
		for (User user : userDB) {
			userInfo.append("ID: ").append(user.getUserID().getValue()).append("\n")
					.append("First Name: ").append(user.getFirstName().getValue()).append("\n")
					.append("Last Name: ").append(user.getLastName().getValue()).append("\n")
					.append("Email: ").append(user.getEmail().getValue()).append("\n");
			// to check if the user is an instance of Customer and append additional
			// information
			if (user instanceof Customer) {
				Customer customer = (Customer) user;
				userInfo.append("Phone Number: ").append(customer.getPhoneNumber().getValue()).append("\n")
						.append("Sex: ").append(customer.getGender().getValue()).append("\n")
						.append("Age: ").append(customer.getAge().getValue()).append("\n");
			}
		}

		return userInfo.toString();
	}

}
