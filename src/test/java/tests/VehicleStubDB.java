package tests;

import java.util.ArrayList;
import claims.*;

/**
 * A mock database for storing Vehicle objects.
 */
public class VehicleStubDB {
    private static ArrayList<Vehicle> vehicleDB = new ArrayList<>(); // The database to store vehicles

    /**
     * Adds a vehicle to the database.
     * @param vehicle The vehicle to add.
     */
    public static void addVehicle(Vehicle vehicle) {
        vehicleDB.add(vehicle);
    }

    /**
     * Removes a vehicle from the database.
     * @param vehicle The vehicle to remove.
     */
    public static void removeVehicle(Vehicle vehicle) {
        vehicleDB.remove(vehicle);
    }

    /**
     * Reads all vehicles stored in the database.
     * @return A string containing information about all vehicles in the database.
     */
    public static String readAllVehicles() {
        String vehicleInfo = "";
        for (Vehicle vehicle : vehicleDB) {
            vehicleInfo = vehicleInfo.concat("ID: " + vehicle.getVehicleID() + "\n" +
                                "Type: " + vehicle.getType() + "\n" +
                                "Make: " + vehicle.getMake() + "\n" +
                                "Model: " + vehicle.getModel() + "\n" +
                                "Colour: " + vehicle.getColour() + "\n" +
                                "License plate: " + vehicle.getLicensePlate() + "\n" +
                                "Registration: " + vehicle.getRegistration() + "\n");
        }
        return vehicleInfo;
    }

//    public static void main(String[] args) {
//        Vehicle car1 = new Vehicle(1, "Sports car", "Ferrari", "Roma", "Red", "AAA000", "Premium");
//        addVehicle(car1);
//        addVehicle(car1);
//        System.out.println(readAllVehicles());
//        removeVehicle(car1);
//        System.out.println("output" + readAllVehicles());
//    }
}
