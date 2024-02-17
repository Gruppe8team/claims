package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import claims.*;

/**
 * A test class for the Vehicle class.
 * It tests basic implementation of the Vehicle class.
 */
class VehicleTest {
    // Create a customer for testing
    Customer John = new Customer(1, "pass123", "John", "Doe", "johndoe@example.com", "123 Main St", "555-1234", "Male", 30);
    // Create a vehicle with specific attributes for testing
    Vehicle car1 = new Vehicle(1, John, "Sports car", "Ferrari", "Roma", "Red", "AAA000", "Premium");
    // Create an empty vehicle for testing
    Vehicle car2 = new Vehicle();
    
    /**
     * Test case to validate retrieval of vehicle attributes.
     */
    @Test
    void getVehicleTest() {                
        assertEquals(1, car1.getVehicleID());
        assertEquals("Owner ID: " + John.getUserID() + ", Name: " + John.getFirstName() + " " + John.getLastName(), car1.getOwnerDetails());
        assertEquals("Sports car", car1.getType());
        assertEquals("Ferrari", car1.getMake());
        assertEquals("Roma", car1.getModel());
        assertEquals("Red", car1.getColour());
        assertEquals("AAA000", car1.getLicensePlate());
        assertEquals("Premium", car1.getRegistration());
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

        assertEquals(2, car2.getVehicleID());
        assertEquals("Owner ID: " + John.getUserID() + ", Name: " + John.getFirstName() + " " + John.getLastName(), car2.getOwnerDetails());
        assertEquals("Truck", car2.getType());
        assertEquals("Tesla", car2.getMake());
        assertEquals("Cybertruck", car2.getModel());
        assertEquals("Silver", car2.getColour());
        assertEquals("BBB111", car2.getLicensePlate());
        assertEquals("Standard", car2.getRegistration());        
    }
}
