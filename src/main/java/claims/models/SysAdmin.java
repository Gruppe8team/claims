
package claims.models;

/*
 * SysAdmin Class
 * For Management purposes
 */
public class SysAdmin extends User  {

    private boolean isActive;

    // Default constructor
    public SysAdmin() {
        super();
        this.isActive = false;
    }

    // Constructor with parameters
    public SysAdmin(int userID, String username, String passwordKey, String firstName, String lastName, String email, boolean isActive) {
        super(userID, username, passwordKey, firstName, lastName, email); // Call superclass constructor
        this.isActive = isActive;
    }

    public SysAdmin(SysAdmin sysAdmin){
        super(sysAdmin);
        this.isActive = sysAdmin.getIsActive();
    }

    private boolean getIsActive() {
        return isActive;
    }

}

