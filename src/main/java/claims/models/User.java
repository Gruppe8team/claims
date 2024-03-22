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
    public User(User user) {
        this.userID = user.getUserID();
        this.username = user.getUsername();
        this.passwordKey = user.getPasswordKey();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
    }

    public StringProperty getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    // for getting information when required. That is all
    public IntegerProperty getUserID() {
        return this.userID;
    }

    public StringProperty getPasswordKey() {
        return this.passwordKey;
    }

    public StringProperty getFirstName() {
        return this.firstName;
    }

    public StringProperty getLastName() {
        return this.lastName;
    }

    public StringProperty getEmail() {
        return this.email;
    }

    // important functions accounts (note we also need a create a new account
    // option)
    // and possibly a change password option.
    public void changePassword(String pass) {
        this.passwordKey.set(pass);
    }

    public void changeEmail(String email) {
        this.email.set(email);
    }

    public void changeFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public void changeLastName(String lastName) {
        this.lastName.set(lastName);
    }

}

