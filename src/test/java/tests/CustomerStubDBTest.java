package tests;

import claims.*;
import claims.models.Customer;
import claims.models.Vehicle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
        ObservableList<Vehicle> vehicleObservableList = FXCollections.observableArrayList();
        // Setup some default customers for testing
        db.addCustomer(new Customer(1, "John", "test123", "John", "Doe", "john@example.com", "123 Main St", "555-1234",
                "Male", 30, vehicleObservableList));
        db.addCustomer(new Customer(2, "Jane", "pass456", "Jane", "Doe", "jane@example.com", "456 Park Ave", "555-5678",
                "Female", 25, vehicleObservableList));
    }

    @Test
    void testAddCustomer() {
        ObservableList<Vehicle> vehicleObservableList = FXCollections.observableArrayList();
        assertEquals(2, db.getAllCustomers().size());
        db.addCustomer(new Customer(3, "password789", "Jim", "Beam", "jim@example.com", "789 Elm St", "555-6789",
                "Male", null, 40, vehicleObservableList));
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
        ObservableList<Vehicle> vehicleObservableList = FXCollections.observableArrayList();
        Customer updatedCustomer = new Customer(1, "John", "newpass123", "John", "Doe", "johnny@example.com",
                "123 Main St", "555-1234", "Male", 31, vehicleObservableList);
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
        List<Customer> maleCustomers = db.queryCustomers(customer -> "Male" == customer.getGender());
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
        ObservableList<Vehicle> vehicleObservableList = FXCollections.observableArrayList();
        db.addCustomers(Arrays.asList(
                new Customer(3, "unique123", "Alice", "Wonder", "alice@example.com", "111 Alice Ln", "555-0001",
                        "Female", null, 28, vehicleObservableList),
                new Customer(4, "unique456", "Bob", "Builder", "bob@example.com", "222 Bob St", "555-0002", "Male",
                        null, 35, vehicleObservableList)));
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
        assertEquals(2, db.findCustomersWithoutVehicles().size());
    }
}