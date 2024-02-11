package classes;

import java.util.ArrayList;
import java.util.List;

public class Advisor extends User {
	private List<Customer> clients; // Assuming there is a Client class that extends User
        private List<Claims> managedClaims;

	public Advisor(int userID, String passwordKey, String firstName, String lastName, String email) {
        super(userID, passwordKey, firstName, lastName, email); // Call superclass constructor
        
        this.clients = new ArrayList<>();
        this.managedClaims = new ArrayList<>();
	}
	
        public void addClient(Customer client) {
                this.clients.add(client);
        }
        
        public void removeClient(Customer client) {
                this.clients.remove(client);
        }
        
        public void manageClaim(Claims claim) {
                this.managedClaims.add(claim);
        }
        
        public void unmanageClaim(Claims claim) {
                this.managedClaims.remove(claim);
        }
        
            // Getters and setters for new fields
        
        public List<Customer> getClients() {
                return clients;
        }
        
        public List<Claims> getManagedClaims() {
                return managedClaims;
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