
package claims.models;

import java.time.LocalDate;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

/*
 * SysAdmin Class
 * For Management purposes
 */
public class Admin extends User  {

    private BooleanProperty isActive;

    // Default constructor
    public Admin() {
        super();
        this.isActive = new SimpleBooleanProperty(this, "isActive", false);
    }

    // Constructor with parameters
    public Admin(int userID, String username, String passwordKey, String firstName, String lastName, String email, String address, String phoneNumber, String gender, LocalDate dateOfBirth, boolean isActive) {
        super(userID, username, passwordKey, firstName, lastName, email, address, phoneNumber, gender, dateOfBirth); // Call superclass constructor
        this.isActive = new SimpleBooleanProperty(this, "isActive", isActive);
    }

    public boolean getIsActive() {
        return isActive.get();
    }

    public void setIsActive(boolean isActive) {
        this.isActive.set(isActive);
    }

}

