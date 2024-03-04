package claims;


public class NewUser {

    private String dob;
    private String phone;
    private String gender;
    
    private int userID;
    private String passwordKey;

    private String firstName;
    private String lastName;

    private String email;
    
    

    public NewUser(int userID, String passwordKey, String firstName,
			String lastName, String email,String dob, String phone, String gender) {
		
		this.dob = dob;
		this.phone = phone;
		this.gender = gender;
		this.userID = userID;
		this.passwordKey = passwordKey;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
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
    
    
}
