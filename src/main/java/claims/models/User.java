package claims.models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * This file was created by Cyrus Yang
 * A Skeletonized file of Superclass User for all points
 * Very Critical for building all the users information
 * Contains general information and general getters and setters
 * NOTE: This file should not be edited without consulting the Author
 */

public abstract class User {

    // important indexes for the userSuperClass
    protected final IntegerProperty userID;
    protected final StringProperty username;
    protected final StringProperty passwordKey;

    protected final StringProperty firstName;
    protected final StringProperty lastName;

    protected final StringProperty email;

    /**
     * Data for secret typeAccount directory parts:
     * 0 - Default user type (limited access)
     * 1 - Advisor (Access for the advisor side of things)
     * 2 - Customer (Access to policy changes and others)
     * 3 - SysAdmin (Access to the management system (Iteration 2 integration to be
     * added))
     * 4 - Disabled/Inactive (Will prompt to contact system admin when occurs)
     */

    // default construction for general technical operations, for setting default
    public User() {
        this.userID = new SimpleIntegerProperty(this, "User ID", 0);
        this.username = new SimpleStringProperty(this, "Username", "");
        this.passwordKey = new SimpleStringProperty(this, "Password", "");
        this.firstName = new SimpleStringProperty(this, "First Name", "");
        this.lastName = new SimpleStringProperty(this, "Last Name", "");
        this.email = new SimpleStringProperty(this, "Email", "");
    }
    // information.

    // construction for general technical operations, for setting new accounts
    public User(int userID, String username, String pass, String fName, String lName, String email) {
        this.userID = new SimpleIntegerProperty(this, "User ID", userID);
        this.username = new SimpleStringProperty(this, "Username", username);
        this.passwordKey = new SimpleStringProperty(this, "Password", pass);
        this.firstName = new SimpleStringProperty(this, "First Name", fName);
        this.lastName = new SimpleStringProperty(this, "Last Name", lName);
        this.email = new SimpleStringProperty(this, "Email", email);
    }

    // ditto but for already given User object

    public String getUsername() {
        return this.username.get();
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    // for getting information when required. That is all
    public int getUserID() {
        return this.userID.get();
    }

    public String getPassword() {
        return this.passwordKey.get();
    }

    public String getFirstName() {
        return this.firstName.get();
    }

    public String getLastName() {
        return this.lastName.get();
    }

    public String getEmail() {
        return this.email.get();
    }

    public void setUserID(int userID) {
        this.userID.set(userID);
    }

    public void setPassword(String pass) {
        this.passwordKey.set(pass);
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

}

