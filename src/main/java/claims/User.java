package claims;
/**
 * This file was created by Cyrus Yang
 * A Skeletonized file of Superclass User for all points
 * Very Critical for building all the users information
 * Contains general information and general getters and setters
 * NOTE: This file should not be edited without consulting the Author
 */


public class User {

    // important indexes for the userSuperClass
    private int userID;
    private String passwordKey;

    private String firstName;
    private String lastName;

    private String email;

    // default construction for general technical operations, for setting default information.
    public User() {
        this.userID = 0;
        this.passwordKey = "";
        this.firstName = "";
        this.lastName = "";
        this.email = "";
    }

    // construction for general technical operations, for setting new accounts
    public User(int userID, String pass, String fName, String lName, String email) {
        this.userID = userID;
        this.passwordKey = pass;
        this.firstName = fName;
        this.lastName = lName;
        this.email = email;
    }

    // ditto but for already given User object
    public User(User user) {
        this.userID = user.getUserID();
        this.passwordKey = user.getPasswordKey();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
    }

    //for getting information when required. That is all
    public int getUserID() {
        return this.userID;
    }

    public String getPasswordKey() {
        return this.passwordKey;
    }
    public String getFirstName() {
        return this.firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    public String getEmail() {
        return this.email;
    }

    // important functions accounts (note we also need a create a new account option)
    // and possibly a change password option.
    public void changePassword(String pass) {
        this.passwordKey = pass;
    }

    public void changeEmail(String email) {
        this.email = email;
    }

    public void changeFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void changeLastName(String lastName) {
        this.lastName = lastName;
    }


}
