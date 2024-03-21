
package claims.models;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

/*
 * SysAdmin Class
 * For Management purposes
 */
public class SysAdmin extends User  {

    private BooleanProperty isActive;

    // Default constructor
    public SysAdmin() {
        super();
        this.isActive = new SimpleBooleanProperty(this, "isActive", false);
    }

    // Constructor with parameters
    public SysAdmin(int userID, String username, String passwordKey, String firstName, String lastName, String email, boolean isActive) {
        super(userID, username, passwordKey, firstName, lastName, email); // Call superclass constructor
        this.isActive = new SimpleBooleanProperty(this, "isActive", isActive);
    }

    public SysAdmin(SysAdmin sysAdmin){
        super(sysAdmin);
        this.isActive = sysAdmin.getIsActive();
    }

    public BooleanProperty getIsActive() {
        return isActive;
    }

}

