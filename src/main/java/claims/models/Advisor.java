package claims.models;

import java.util.ArrayList;
import java.util.List;

public class Advisor extends User {
	private List<Customer> clients; // Assuming there is a Client class that extends User
        private List<Claims> managedClaims;
	//to initailize an advisor object
	public Advisor(int userID, String passwordKey, String firstName, String lastName, String email) {
        super(userID, passwordKey, firstName, lastName, email); // Call superclass constructor
        this.clients = new ArrayList<>();
        this.managedClaims = new ArrayList<>();
	}

    public Advisor(Advisor advisor) {
                super(advisor); // Call superclass constructor
                this.clients = new ArrayList<Customer>();
                this.managedClaims = new ArrayList<Claims>();
    }
	//add a client to the client list
        public void addClient(Customer client) {
                this.clients.add(client);
        }
        //remove a client to the client list
        public void removeClient(Customer client) {
                this.clients.remove(client);
        }
        //manage a claim by adding it to the list of managed claims
        public void manageClaim(Claims claim) {
                this.managedClaims.add(claim);
        }
        //unmanage a claim by adding it to the list of managed claims
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
