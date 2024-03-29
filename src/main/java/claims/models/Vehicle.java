package claims.models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Represents a vehicle with basic attributes.
 */
public class Vehicle {
    private IntegerProperty clientID;
    private IntegerProperty vehicleID;
    private IntegerProperty year;
    private StringProperty type;
    private StringProperty make;
    private StringProperty model;
    private StringProperty colour;
    private StringProperty licensePlate;
    private StringProperty registration;

    /**
     * Constructs an empty Vehicle object.
     */
    public Vehicle() {
        this.clientID = new SimpleIntegerProperty(this, "ClientID", 0);
        this.vehicleID = new SimpleIntegerProperty(this, "VehicleID", 0);;
        this.year = new SimpleIntegerProperty(this,"Year", 0);
        this.type = new SimpleStringProperty(this,"Type","");
        this.make = new SimpleStringProperty(this,"Make","");
        this.model = new SimpleStringProperty(this,"Model","");
        this.colour = new SimpleStringProperty(this,"Colour","");
        this.licensePlate = new SimpleStringProperty(this,"License Plate","");
        this.registration = new SimpleStringProperty(this,"Registration","");
    }

    /**
     * Constructs a Vehicle object with specified attributes.
     * 
     * @param vehicleID    The unique identifier for the vehicle.
     * @param clientID        The owner of the vehicle.
     * @param type         The type of vehicle.
     * @param make         The manufacturer of the vehicle.
     * @param model        The model of the vehicle.
     * @param colour       The color of the vehicle.
     * @param licensePlate The license plate number of the vehicle.
     * @param registration The registration information of the vehicle.
     */
    public Vehicle(int vehicleID, int clientID, int year, String type, String make, String model, String colour,
            String licensePlate, String registration) {
        this.vehicleID = new SimpleIntegerProperty(this, "VehicleID", vehicleID);
        this.clientID = new SimpleIntegerProperty(this, "ClientID", clientID);
        this.year = new SimpleIntegerProperty(this, "Year", year);  
        this.type = new SimpleStringProperty(this, "Type", type);
        this.make = new SimpleStringProperty(this, "Make", make);
        this.model = new SimpleStringProperty(this, "Model", model);
        this.colour = new SimpleStringProperty(this, "Colour", colour);
        this.licensePlate = new SimpleStringProperty(this, "License Plate", licensePlate);
        this.registration = new SimpleStringProperty(this, "Registration", registration);
    }

    
    public int getOwner() {
        return this.clientID.get();
    }

    /**
     * Sets the owner of the vehicle.
     * 
     * @param owner The owner of the vehicle.
     */
    public void setOwner(int clientID) {
        this.clientID.set(clientID);
    }

    /**
     * Retrieves the vehicle ID.
     * 
     * @return The unique identifier of the vehicle.
     */
    public int getVehicleID() {
        return vehicleID.get();
    }


    /**
     * Sets the vehicle ID.
     * 
     * @param vehicleID The unique identifier of the vehicle.
     */
    public void setVehicleID(int vehicleID) {
        this.vehicleID.set(vehicleID);
    }

    /**
     * Retrieves the manufacturing year of the vehicle.
     * 
     * @return The manufacturing year of the vehicle.
     */
    public int getYear() {
        return year.get();
    }

    /**
     * Sets the manufacturing year of the vehicle.
     * 
     * @param year The manufacturing year of the vehicle.
     */
    public void setYear(int year) {
        this.year.set(year);
    }

    /**
     * Retrieves the type of the vehicle.
     * 
     * @return The type of the vehicle.
     */
    public String getType() {
        return type.get();
    }

    /**
     * Sets the type of the vehicle.
     * 
     * @param type The type of the vehicle.
     */
    public void setType(String type) {
        this.type.set(type);
    }

    /**
     * Retrieves the manufacturer of the vehicle.
     * 
     * @return The manufacturer of the vehicle.
     */
    public String getMake() {
        return make.get();
    }

    /**
     * Sets the manufacturer of the vehicle.
     * 
     * @param make The manufacturer of the vehicle.
     */
    public void setMake(String make) {
        this.make.set(make);
    }

    /**
     * Retrieves the model of the vehicle.
     * 
     * @return The model of the vehicle.
     */
    public String getModel() {
        return model.get();
    }

    /**
     * Sets the model of the vehicle.
     * 
     * @param model The model of the vehicle.
     */
    public void setModel(String model) {
        this.model.set(model);
    }

    /**
     * Retrieves the color of the vehicle.
     * 
     * @return The color of the vehicle.
     */
    public String getColour() {
        return colour.get();
    }

    /**
     * Sets the color of the vehicle.
     * 
     * @param colour The color of the vehicle.
     */
    public void setColour(String colour) {
        this.colour.set(colour);
    }

    /**
     * Retrieves the license plate number of the vehicle.
     * @return The license plate number of the vehicle.
     */
    public String getLicensePlate() {
        return licensePlate.get();
    }

/**
     * Sets the license plate number of the vehicle.
     * @param licensePlate The license plate number of the vehicle.
     */
    public void setLicensePlate(String licensePlate) {
        this.licensePlate.set(licensePlate);
    }

    public String getRegistration() {
        return registration.get();
    }

    public void setRegistration(String registration) {
        this.registration.set(registration);
    }
}
