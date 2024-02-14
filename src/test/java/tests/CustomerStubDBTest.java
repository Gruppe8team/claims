package tests;

import claims.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class CustomerStubDBTest {

    private CustomerStubDB db;

    @BeforeEach
    void setUp() {
        db = new CustomerStubDB();
        // Setup some default customers for testing
        db.addCustomer(new Customer(1, "test123", "John", "Doe", "john@example.com", "123 Main St", "555-1234", "Male", 30));
        db.addCustomer(new Customer(2, "pass456", "Jane", "Doe", "jane@example.com", "456 Park Ave", "555-5678", "Female", 25));
    }

    @Test
    void testAddCustomer() {
        assertEquals(2, db.getAllCustomers().size());
        db.addCustomer(new Customer(3, "password789", "Jim", "Beam", "jim@example.com", "789 Elm St", "555-6789", "Male", 40));
        assertEquals(3, db.getAllCustomers().size());
    }

    @Test
    void testRemoveCustomer() {
        assertTrue(db.removeCustomer(1));
        assertFalse(db.removeCustomer(3)); // ID 3 does not exist
        assertEquals(1, db.getAllCustomers().size());
    }

    @Test
    void testUpdateCustomer() {
        Customer updatedCustomer = new Customer(1, "newpass123", "John", "Doe", "johnny@example.com", "123 Main St", "555-1234", "Male", 31);
        assertTrue(db.updateCustomer(1, updatedCustomer));
        assertEquals("johnny@example.com", db.getCustomer(1).getEmail());
    }

    @Test
    void testFindCustomersByAddress() {
        List<Customer> customers = db.findCustomersByAddress("123 Main St");
        assertEquals(1, customers.size());
        assertEquals("John", customers.get(0).getFirstName());
    }

    @Test
    void testQueryCustomers() {
        List<Customer> maleCustomers = db.queryCustomers(customer -> "Male".equals(customer.getSex()));
        assertEquals(1, maleCustomers.size());
        assertEquals("John", maleCustomers.get(0).getFirstName());
    }

    @Test
    void testFindCustomersByPhoneNumber() {
        List<Customer> result = db.findCustomersByPhoneNumber("555-1234");
        assertEquals(1, result.size());
        assertEquals("John", result.get(0).getFirstName());
    }

    @Test
    void testFindCustomersByAgeRange() {
        List<Customer> result = db.findCustomersByAgeRange(20, 30);
        assertEquals(2, result.size());
        assertEquals("John", result.get(0).getFirstName());
    }

    @Test
    void testUpdateCustomerEmail() {
        assertTrue(db.updateCustomerEmail(1, "newemail@example.com"));
        Customer customer = db.getCustomer(1);
        assertEquals("newemail@example.com", customer.getEmail());
    }

    @Test
    void testAddCustomers() {
        db.addCustomers(Arrays.asList(
            new Customer(3, "unique123", "Alice", "Wonder", "alice@example.com", "111 Alice Ln", "555-0001", "Female", 28),
            new Customer(4, "unique456", "Bob", "Builder", "bob@example.com", "222 Bob St", "555-0002", "Male", 35)
        ));
        assertEquals(4, db.getAllCustomers().size());
    }

    @Test
    void testRemoveCustomers() {
        db.removeCustomers(Arrays.asList(1, 2));
        assertEquals(0, db.getAllCustomers().size());
    }

    @Test
    void testCountCustomers() {
        assertEquals(2, db.countCustomers());
    }

    @Test
    void testFindCustomersWithoutVehicles() {
        // Assuming Customer class has a method to add vehicles and initially no vehicles are added
        assertEquals(2, db.findCustomersWithoutVehicles().size());
        
        // Simulate adding a vehicle to a customer for demonstration
        // Assume there's a method in Customer for adding vehicles, e.g., customer.addVehicle(new Vehicle(...));
    }

}
