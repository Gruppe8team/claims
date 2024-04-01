package claims.models;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
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
    private final IntegerProperty userID;
    private final StringProperty username;
    private final StringProperty passwordKey;
    private final StringProperty address;
    private final StringProperty phoneNumber;
    private final StringProperty gender;
    private final ObjectProperty<LocalDate> dateOfBirth;
    private final StringProperty firstName;
    private final StringProperty lastName;

    private final StringProperty email;

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
        this.address = new SimpleStringProperty(this, "Address", "");
        this.phoneNumber = new SimpleStringProperty(this, "Phone Number", "");
        this.gender = new SimpleStringProperty(this, "Gender", "");
        this.dateOfBirth = new SimpleObjectProperty<LocalDate>(this, "Date of Birth", LocalDate.now());
        
    }
    // information.

    // construction for general technical operations, for setting new accounts
    public User(int userID, String username, String pass, String fName, String lName, String email, String address, String phoneNumber, String gender, LocalDate dateOfBirth) {
        this.userID = new SimpleIntegerProperty(this, "User ID", userID);
        this.username = new SimpleStringProperty(this, "Username", username);
        this.passwordKey = new SimpleStringProperty(this, "Password", pass);
        this.firstName = new SimpleStringProperty(this, "First Name", fName);
        this.lastName = new SimpleStringProperty(this, "Last Name", lName);
        this.email = new SimpleStringProperty(this, "Email", email);
        this.address = new SimpleStringProperty(this, "Address", address);
        this.phoneNumber = new SimpleStringProperty(this, "Phone Number", phoneNumber);
        this.gender = new SimpleStringProperty(this, "Gender", gender);
        this.dateOfBirth = new SimpleObjectProperty<LocalDate>(this, "Date of Birth", dateOfBirth);
    }

    public String getUsername() {
        return this.username.get();
    }

    public StringProperty usernameProperty() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    // for getting information when required. That is all
    public int getUserID() {
        return this.userID.get();
    }

    public IntegerProperty userIDProperty() {
        return this.userID;
    }

    public String getPassword() {
        return this.passwordKey.get();
    }

    public StringProperty passwordProperty() {
        return this.passwordKey;
    }

    public String getFirstName() {
        return this.firstName.get();
    }

    public StringProperty firstNameProperty() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName.get();
    }

    public StringProperty lastNameProperty() {
        return this.lastName;
    }

    public String getEmail() {
        return this.email.get();
    }

    public StringProperty emailProperty() {
        return this.email;
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

    public String getAddress() {
        return this.address.get();
    }

    public StringProperty addressProperty() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public String getPhoneNumber() {
        return this.phoneNumber.get();
    }

    public StringProperty phoneNumberProperty() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }

    public String getGender() {
        return this.gender.get();
    }

    public StringProperty genderProperty() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender.set(gender);
    }

    public LocalDate getDateOfBirth() {
        return this.dateOfBirth.get();
    }

    public ObjectProperty<LocalDate> dateOfBirthProperty() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth.set(dateOfBirth);
    }

}

