package src.main.java.claims;
import java.util.ArrayList;
import java.util.List;


public class Customer extends User {
    private String address;
    private String phoneNumber;
    private String gender;
    private int age;
    private List<Vehicle> vehicles;

    // Default constructor
    public Customer() {
        super(); // Call superclass constructor
        this.address = "";
        this.phoneNumber = "";
        this.gender = "";
        this.age = 0;
        this.vehicles = new ArrayList<>();
        super.setTypeAccount(2);
    }

    // Constructor with parameters
    public Customer(int userID, String passwordKey, String firstName, String lastName, String email, String address, String phoneNumber, String gender, int age) {
        super(userID, passwordKey, firstName, lastName, email); // Call superclass constructor
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.age = age;
        this.vehicles = new ArrayList<>();
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

    // Getter and setter methods for phoneNumber
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getgender() {
        return gender;
    }

    public void setgender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void addVehicle(Vehicle vehicle) {
        this.vehicles.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        this.vehicles.remove(vehicle);
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    // Override toString method to include customer-specific information
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