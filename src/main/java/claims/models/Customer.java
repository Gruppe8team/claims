package claims.models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Customer extends User {
    private final StringProperty address; // The address of the customer
    private final StringProperty phoneNumber; // The phone number of the customer
    private final StringProperty gender; // The gender of the customer
    private final IntegerProperty age; // The age of the customer
    private final ListProperty<Vehicle> vehicles; // The list of vehicles owned by the customer
    private final ObservableList<Vehicle> vehicleObservableList = FXCollections.observableArrayList();


    /**
     * Constructor with with specified attributes
     * @param userID the customer's user id 
     * @param username the customer's username
     * @param passwordKey the customer's password
     * @param firstName the customer's firstname
     * @param lastName the customer's lastname
     * @param email the customer's email address
     * @param address the customer's address
     * @param phoneNumber the customer's phone number
     * @param gender the customer's gender
     * @param age the customer's age
     * @param vehicles the customer's vechicles
     *  */ 

    public Customer() {
        super();
        this.address = new SimpleStringProperty(this, "Address", "");
        this.phoneNumber = new SimpleStringProperty(this, "Phone Number", "");
        this.gender = new SimpleStringProperty(this, "Gender", "");
        this.age = new SimpleIntegerProperty(this, "Age", 0);
        this.vehicles = new SimpleListProperty<Vehicle>(vehicleObservableList);
    }


    public Customer(int userID,  String username, String passwordKey, String firstName, String lastName, String email, String address, String phoneNumber, String gender, int age, ObservableList<Vehicle> vehicles) {
        super(userID, username, passwordKey, firstName, lastName, email); // Call superclass constructor
        this.address = new SimpleStringProperty(this, "Address", address);
        this.phoneNumber = new SimpleStringProperty(this, "Phone Number", phoneNumber);
        this.gender = new SimpleStringProperty(this, "Gender", gender);
        this.age = new SimpleIntegerProperty(this, "Age", age);
        this.vehicles = new SimpleListProperty<Vehicle>(this, "Vehicles", vehicles);
    }



    // Getter and setter methods for address
    public String getAddress() {
        return address.get();
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    // Gets the phone number of the customer
    public String getPhoneNumber() {
        return phoneNumber.get();
    }

    // sets the phone number of the customer
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }

    // gets the gender of the customer
    public String getGender() {
        return gender.get();
    }

    // sets the gender of a customer
    public void setGender(String gender) {
        this.gender.set(gender);
    }

    // gets the age of a customer
    public int getAge() {
        return age.get();
    }

    // sets the age of a customer
    public void setAge(int age) {
        this.age.set(age);
    }

    // adds a specific vehicle
    public void addVehicle(Vehicle vehicle) {
        this.vehicles.get().add(vehicle);
    }

    // removes a specific vehicle
    public void removeVehicle(Vehicle vehicle) {
        this.vehicles.remove(vehicle);
    }
    
    // returns vehicle list
    public ObservableList<Vehicle> getVehicles() {
        return vehicles.get();
    }

    

    
    @Override
    public String toString() {
        
        StringBuilder vehicleInfo = new StringBuilder();
        for (Vehicle vehicle : vehicles) {
            vehicleInfo.append(vehicle.toString()).append("\n"); // Append each vehicle's string representation
        }

        return "Customer{" +
                "userID=" + getUserID() +
                ", passwordKey='" + getPassword() + '\'' +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", address='" + getAddress() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                ", gender='" + getGender() + '\'' +
                ", age=" + getAge() +
                ", vehicles=\n" + vehicleInfo.toString() +
                '}';
    }

}