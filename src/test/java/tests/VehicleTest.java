package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import claims.*;
import claims.models.Customer;
import claims.models.Vehicle;
import javafx.beans.property.ObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * A test class for the Vehicle class.
 * It tests basic implementation of the Vehicle class.
 */
class VehicleTest {
    // Create a customer for testing
    ObservableList<Vehicle> vehicleObservableList = FXCollections.observableArrayList();
    Customer John = new Customer(1, "John", "pass123", "John", "Doe", "johndoe@example.com", "123 Main St", "555-1234", "Male", 30, vehicleObservableList);
    // Create a vehicle with specific attributes for testing
    Vehicle car1 = new Vehicle(1, John, 2,"Sports car", "Ferrari", "Roma", "Red", "AAA000", "Premium");
    // Create an empty vehicle for testing
    Vehicle car2 = new Vehicle();
    
    /**
     * Test case to validate retrieval of vehicle attributes.
     */
    @Test
    void getVehicleTest() {
        assertEquals(1, car1.getVehicleID().getValue());
        assertEquals("Owner ID: " + John.getUserID().getValue() + ", Name: " + John.getFirstName().getValue() + " "
                + John.getLastName().getValue(), car1.getOwnerDetails());
        assertEquals("Sports car", car1.getType().getValue());
        assertEquals("Ferrari", car1.getMake().getValue());
        assertEquals("Roma", car1.getModel().getValue());
        assertEquals("Red", car1.getColour().getValue());
        assertEquals("AAA000", car1.getLicensePlate().getValue());
        assertEquals("Premium", car1.getRegistration().getValue());
    }

    
    /**
     * Test case to validate setting of vehicle attributes.
     */
    @Test
    void setVehicleInfoTest() {        
        assertNotNull(car2);
        
        car2.setVehicleID(2);
        car2.setOwner(John);
        car2.setType("Truck");
        car2.setMake("Tesla");
        car2.setModel("Cybertruck");
        car2.setColour("Silver");
        car2.setLicensePlate("BBB111");
        car2.setRegistration("Standard");

        assertEquals(2, car2.getVehicleID().getValue());
        assertEquals("Owner ID: " + John.getUserID().getValue() + ", Name: " + John.getFirstName().getValue() + " "
                + John.getLastName().getValue(), car2.getOwnerDetails());
        assertEquals("Truck", car2.getType().getValue());
        assertEquals("Tesla", car2.getMake().getValue());
        assertEquals("Cybertruck", car2.getModel().getValue());
        assertEquals("Silver", car2.getColour().getValue());
        assertEquals("BBB111", car2.getLicensePlate().getValue());
        assertEquals("Standard", car2.getRegistration().getValue());
    }
}
