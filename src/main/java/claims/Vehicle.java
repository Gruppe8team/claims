package claims;

/**
 * Represents a vehicle with basic attributes.
 */
public class Vehicle {
    private Customer owner; // The owner of the vehicle
    private int vehicleID; // Unique identifier for the vehicle
    private int year; // The year the vehicle was manufactured
    private String type; // The type of vehicle (e.g., sedan, SUV, truck)
    private String make; // The manufacturer of the vehicle
    private String model; // The model of the vehicle
    private String colour; // The color of the vehicle
    private String licensePlate; // The license plate number of the vehicle
    private String registration; // The registration information of the vehicle

    /**
     * Constructs an empty Vehicle object.
     */
    public Vehicle() {}

    /**
     * Constructs a Vehicle object with specified attributes.
     * @param vehicleID The unique identifier for the vehicle.
     * @param owner The owner of the vehicle.
     * @param type The type of vehicle.
     * @param make The manufacturer of the vehicle.
     * @param model The model of the vehicle.
     * @param colour The color of the vehicle.
     * @param licensePlate The license plate number of the vehicle.
     * @param registration The registration information of the vehicle.
     */
    public Vehicle(int vehicleID, Customer owner, String type, String make, String model, String colour, String licensePlate, String registration) {
        this.vehicleID = vehicleID;
        this.owner = owner;
        this.type = type;
        this.make = make;
        this.model = model;
        this.colour = colour;
        this.licensePlate = licensePlate;
        this.registration = registration;
    }

    /**
     * Retrieves details of the vehicle owner.
     * @return A string representation of the vehicle owner details.
     */
    public String getOwnerDetails() {
        if (owner != null) {
            return "Owner ID: " + owner.getUserID() + ", Name: " + owner.getFirstName() + " " + owner.getLastName();
        } else {
            return "No owner assigned";
        }
    }

    /**
     * Sets the owner of the vehicle.
     * @param owner The owner of the vehicle.
     */
    public void setOwner(Customer owner) {
        this.owner = owner;
    }

    /**
     * Retrieves the vehicle ID.
     * @return The unique identifier of the vehicle.
     */
    public int getVehicleID() {
        return vehicleID;
    }

    /**
     * Sets the vehicle ID.
     * @param vehicleID The unique identifier of the vehicle.
     */
    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }

    /**
     * Retrieves the manufacturing year of the vehicle.
     * @return The manufacturing year of the vehicle.
     */
    public int getYear() {
        return year;
    }

    /**
     * Sets the manufacturing year of the vehicle.
     * @param year The manufacturing year of the vehicle.
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Retrieves the type of the vehicle.
     * @return The type of the vehicle.
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of the vehicle.
     * @param type The type of the vehicle.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Retrieves the manufacturer of the vehicle.
     * @return The manufacturer of the vehicle.
     */
    public String getMake() {
        return make;
    }

    /**
     * Sets the manufacturer of the vehicle.
     * @param make The manufacturer of the vehicle.
     */
    public void setMake(String make) {
        this.make = make;
    }

    /**
     * Retrieves the model of the vehicle.
     * @return The model of the vehicle.
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets the model of the vehicle.
     * @param model The model of the vehicle.
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Retrieves the color of the vehicle.
     * @return The color of the vehicle.
     */
    public String getColour() {
        return colour;
    }

    /**
     * Sets the color of the vehicle.
     * @param colour The color of the vehicle.
     */
    public void setColour(String colour) {
        this.colour = colour;
    }

    /**
     * Retrieves the license plate number of the vehicle.
     * @return The license plate number of the vehicle.
     */
    public String getLicensePlate() {
        return licensePlate;
    }

    /**
     * Sets the license plate number of the vehicle.
     * @param licensePlate The license plate number of the vehicle.
     */
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    /**
     * Retrieves the registration information of the vehicle.
     * @return The registration information of the vehicle.
     */
    public String getRegistration() {
        return registration;
    }

    /**
     * Sets the registration information of the vehicle.
     * @param registration The registration information of the vehicle.
     */
    public void setRegistration(String registration) {
        this.registration = registration;
    }
}
