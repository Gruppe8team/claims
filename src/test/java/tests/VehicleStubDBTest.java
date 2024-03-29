package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import claims.*;
import claims.models.Customer;
import claims.models.Vehicle;

/**
 * A test class for adding and removing a vehicle from the mock database.
 */
class VehicleStubDBTest {
    // Create a customer for testing
    // Create a vehicle for testing
    Vehicle car1 = new Vehicle(1, 1, 2, "Sports car", "Ferrari", "Roma", "Red", "AAA000", "Premium");

    /**
     * Test case to add and then remove a vehicle from the mock database.
     */
    @Test
    void addDelVehicleToDBTest() {
        // Add vehicle to the database
        VehicleStubDB.addVehicle(car1);
        // Check if the vehicle has been added correctly
        assertEquals("ID: " + car1.getVehicleID() + "\n" +
                    "Type: " + car1.getType() + "\n" +
                    "Make: " + car1.getMake() + "\n" +
                    "Model: " + car1.getModel() + "\n" +
                    "Colour: " + car1.getColour() + "\n" +
                    "License plate: " + car1.getLicensePlate() + "\n" +
                    "Registration: " + car1.getRegistration() + "\n", 
                    VehicleStubDB.readAllVehicles());
        // Remove vehicle from the database
        VehicleStubDB.removeVehicle(car1);
        // Check if the vehicle has been removed successfully
        assertEquals("", VehicleStubDB.readAllVehicles());
    }
    
//    @Test
//    void deleteVehicleDBTest() {
//        VehicleStubDB.removeVehicle(car1);
//        assertEquals("", VehicleStubDB.readAllVehicles());
//    }

}
