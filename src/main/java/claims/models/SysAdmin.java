
package claims.models;

/*
 * SysAdmin Class
 * For Management purposes
 */
public class SysAdmin extends User  {

    private boolean isActive;

    // Constructor with parameters
    public SysAdmin(int userID, String passwordKey, String firstName, String lastName, String email, boolean isActive) {
        super(userID, passwordKey, firstName, lastName, email); // Call superclass constructor
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

