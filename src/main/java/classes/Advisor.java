package classes;
public class Advisor extends User {
	
	public Advisor(int userID, String passwordKey, String firstName, String lastName, String email) {
        super(userID, passwordKey, firstName, lastName, email); // Call superclass constructor
        
	}
	
	 // Override toString method to include customer-specific information
    @Override
    public String toString() {
        return "Advisor{" +
                "userID=" + getUserID() +
                ", passwordKey='" + getPasswordKey() + '\'' +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", email='" + getEmail() + '\'' +
                '}';
    }
}