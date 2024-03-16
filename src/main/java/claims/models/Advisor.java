package claims.models;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Advisor extends User {
	private ListProperty<Customer> clients; // Assuming there is a Client class that extends User
        private ListProperty<Claims> claims;
	//to initailize an advisor object

        public Advisor() {
                super();
                ObservableList<Customer> customerObservableList = FXCollections.observableArrayList();
                this.clients = new SimpleListProperty<Customer>(customerObservableList);
                ObservableList<Claims> claimsObservableList = FXCollections.observableArrayList();
                this.claims = new SimpleListProperty<Claims>(claimsObservableList);
                
        }

	public Advisor(int userID, String username, String passwordKey, String firstName, String lastName, String email) {
                super(userID, username, passwordKey, firstName, lastName, email); // Call superclass constructor
                this.clients = new SimpleListProperty<Customer>();
                this.claims = new SimpleListProperty<Claims>();
	}

        public Advisor(Advisor advisor) {
                super(advisor); // Call superclass constructor
                this.clients = advisor.getClients();
                this.claims = advisor.getClaims();
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
                this.claims.add(claim);
        }
        //unmanage a claim by adding it to the list of managed claims
        public void unmanageClaim(Claims claim) {
                this.claims.remove(claim);
        }
        
            // Getters and setters for new fields
        
        public ListProperty<Customer> getClients() {
                return clients;
        }
        
        public ListProperty<Claims> getClaims() {
                return claims;
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
