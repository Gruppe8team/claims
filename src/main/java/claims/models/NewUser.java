package claims.models;


public class NewUser {

	private String dob;
	private String phone;
	private String gender;
	private String age;

	private int userID;
	private String passwordKey;

	private String firstName;
	private String lastName;

	private String email;
	private String username;
	private String userType;
	private String addr;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public NewUser(int userID, String passwordKey, String firstName,
				   String lastName, String email, String dob, String phone, String gender) {

		this.dob = dob;
		this.phone = phone;
		this.gender = gender;
		this.userID = userID;
		this.passwordKey = passwordKey;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public NewUser() {
		this.dob = null;
		this.phone = null;
		this.gender = null;
		this.userID = 000000000;
		this.passwordKey = null;
		this.firstName = null;
		this.lastName = null;
		this.email = null;
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
	
	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "NewUser{" +
				"dob='" + dob + '\'' +
				", phone='" + phone + '\'' +
				", gender='" + gender + '\'' +
				", userID=" + userID +
				", passwordKey='" + passwordKey + '\'' +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", email='" + email + '\'' +
				'}';
	}

}
