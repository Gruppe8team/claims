package tests;

import claims.views.AccountType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

//Steps to test User Types GUI:
//Open the application's login page.
//Verify that the login page displays options for selecting different user types.
//Select each available user type from the dropdown menu.
//Verify that the login page updates accordingly for each selected user type.
//Proceed with logging in for each user type and verify successful authentication.

public class UserTypeTest {
	//sample data for testing

	int userID = 1;
	String passwordKey = "123456";
	String firstName = "Jaye";
	String lastName = "Chen";
	String email = "jiayec@my.yorku.ca";
	String dob = "2023-01";
	String phone = "010-11111";
	String gender = "mail";
	AccountType customer = AccountType.CUSTOMER;
	AccountType advisor = AccountType.ADVISOR;
	AccountType admin = AccountType.ADMIN;
	//create a new advisor for testing
	NewUserTest customerInfo = new NewUserTest(userID, passwordKey,
			firstName, lastName, email, dob, phone, gender, customer);

	NewUserTest advisorInfo = new NewUserTest(userID, passwordKey,
			firstName, lastName, email, dob, phone, gender, advisor);

	NewUserTest adminInfo = new NewUserTest(userID, passwordKey, firstName,
			lastName, email, dob, phone, gender, admin);


	//AccountType userType = AccountType.CUSTOMER;

	//test toString	method
	@Test
	public void testToCustomer() {

		//assert
		assertEquals(customer,customerInfo.getUserType());
		assertNotEquals(advisor,customerInfo.getUserType());
		assertNotEquals(admin,customerInfo.getUserType());

	}



	@Test
	public void testToAdvisor() {

		//assert
		assertEquals(advisor,advisorInfo.getUserType());
		assertNotEquals(customer,advisorInfo.getUserType());
		assertNotEquals(admin,advisorInfo.getUserType());
	}

	@Test
	public void testToAdmin() {

		//assert
		assertEquals(admin,adminInfo.getUserType());
		assertNotEquals(advisor,adminInfo.getUserType());
		assertNotEquals(customer,adminInfo.getUserType());
	}

	class NewUserTest {

		private String dob;
		private String phone;
		private String gender;

		private int userID;
		private String passwordKey;

		private String firstName;
		private String lastName;

		private String email;

		private AccountType userType;


		public NewUserTest(int userID, String passwordKey, String firstName,
						   String lastName, String email, String dob, String phone, String gender, AccountType userType) {

			this.dob = dob;
			this.phone = phone;
			this.gender = gender;
			this.userID = userID;
			this.passwordKey = passwordKey;
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.userType = userType;
		}

		public NewUserTest() {
			this.dob = null;
			this.phone = null;
			this.gender = null;
			this.userID = 000000000;
			this.passwordKey = null;
			this.firstName = null;
			this.lastName = null;
			this.email = null;
			this.userType = null;
		}


		public int getUserID() {
			return userID;
		}


		public void setUserID(int userID) {
			this.userID = userID;
		}


		public String getPasswordKey() {
			return passwordKey;
		}


		public void setPasswordKey(String passwordKey) {
			this.passwordKey = passwordKey;
		}


		public String getFirstName() {
			return firstName;
		}


		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}


		public String getLastName() {
			return lastName;
		}


		public void setLastName(String lastName) {
			this.lastName = lastName;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public String getDob() {
			return dob;
		}

		public void setDob(String dob) {
			this.dob = dob;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public AccountType getUserType() {
			return userType;
		}

		public void setUserType(AccountType userType) {
			this.userType = userType;
		}
	}


}
