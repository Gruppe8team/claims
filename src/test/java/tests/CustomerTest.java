package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class CustomerTest {
    
    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer(1, "pass123", "John", "Doe", "johndoe@example.com", "123 Main St", "555-1234", "Male", 30);
    }

    @Test
    void testAddVehicle() {
        Vehicle vehicle  = new Vehicle();
        customer.addVehicle(vehicle);
        assertFalse(customer.getVehicles().isEmpty());
        assertEquals(1, customer.getVechicles().size());
    }

    @Test
    void testRemoveVehicle() {
        Vehicle vehicle = new Vehicle(); // Assuming default constructor is defined
        customer.addVehicle(vehicle);
        customer.removeVehicle(vehicle);
        assertTrue(customer.getVehicles().isEmpty());
    }
}
