package claims.models;
import java.util.ArrayList;
import java.util.List;


public class Customer extends User {
    private String address; // The address of the customer
    private String phoneNumber; // The phone number of the customer
    private String gender; // The gender of the customer
    private int age; // The age of the customer
    private List<Vehicle> vehicles; // The list of vehicles owned by the customer

    // Default constructor
    public Customer() {
        super(); // Call superclass constructor
        this.address = "";
        this.phoneNumber = "";
        this.gender = "";
        this.age = 0;
        this.vehicles = new ArrayList<Vehicle>();
        super.setTypeAccount(2);
    }

    /**
     * Constructor with with specified attributes
     * @param userID the customer's user id 
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
    public Customer(int userID, String passwordKey, String firstName, String lastName, String email, String address, String phoneNumber, String gender, int age) {
        super(userID, passwordKey, firstName, lastName, email); // Call superclass constructor
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.age = age;
        this.vehicles = new ArrayList<Vehicle>();
        super.setTypeAccount(2);
    }

    // Deep Copying Constructor
    public Customer(Customer customer) {
        super(customer); // Call superclass constructor
        this.address = customer.getAddress();
        this.phoneNumber = customer.getPhoneNumber();
        this.gender = customer.getgender();
        this.age = customer.getAge();
        this.vehicles = customer.getVehicles();
    }

    // Getter and setter methods for address
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Gets the phone number of the customer
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // sets the phone number of the customer
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // gets the gender of the customer
    public String getgender() {
        return gender;
    }

    // sets the gender of a customer
    public void setgender(String gender) {
        this.gender = gender;
    }

    // gets the age of a customer
    public int getAge() {
        return age;
    }

    // sets the age of a customer
    public void setAge(int age) {
        this.age = age;
    }

    // adds a specific vehicle
    public void addVehicle(Vehicle vehicle) {
        this.vehicles.add(vehicle);
    }

    // removes a specific vehicle
    public void removeVehicle(Vehicle vehicle) {
        this.vehicles.remove(vehicle);
    }
    
    // returns vehicle list
    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    
    @Override
    public String toString() {
        
        StringBuilder vehicleInfo = new StringBuilder();
        for (Vehicle vehicle : vehicles) {
            vehicleInfo.append(vehicle.toString()).append("\n"); // Append each vehicle's string representation
        }

        return "Customer{" +
                "userID=" + getUserID() + 
                ", passwordKey='" + getPasswordKey() + '\'' +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", vehicles=\n" + vehicleInfo.toString() +
                '}';
    }
}