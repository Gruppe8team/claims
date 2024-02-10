
/*
 * Created by: Julianna Silva
 * Basic initial implementation of the Vehicle class
 */

public class Vehicle {
	private Customer owner;
	private int vehicleID, year;
	private String type, make, model, colour, licensePlate, registration;
	
	public Vehicle() {}
	
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
	
	public String getOwnerDetails() {
        if (owner != null) {
            return "Owner ID: " + owner.getUserID() + ", Name: " + owner.getFirstName() + " " + owner.getLastName();
        } else {
            return "No owner assigned";
        }
    }

	public void setOwner(Customer owner) {
		this.owner = owner;
	}
	
	public int getVehicleID() {
		return vehicleID;
	}

	public void setVehicleID(int vehicleID) {
		this.vehicleID = vehicleID;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public String getRegistration() {
		return registration;
	}

	public void setRegistration(String registration) {
		this.registration = registration;
	}
	
}