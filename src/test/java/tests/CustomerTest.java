package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import claims.*;
import claims.models.Customer;
import claims.models.Vehicle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {
    
    private Customer customer;

    @BeforeEach
    void setUp() {
        ObservableList<Vehicle> vehicleObservableList = FXCollections.observableArrayList();
        customer = new Customer(1, "John", "pass123", "John", "Doe", "johndoe@example.com", "123 Main St", "555-1234", "Male", 30 , vehicleObservableList);
    }

    @Test
    void testDefaultConstructor() {
        Customer defaultCustomer = new Customer();
        assertNotNull(defaultCustomer);
        assertTrue(defaultCustomer.getVehicles().isEmpty());
    }

    @Test
    void testConstructorWithParameters() {
        assertEquals(1, customer.getUserID().getValue());
        assertEquals("pass123", customer.getPasswordKey().getValue());
        assertEquals("John", customer.getFirstName().getValue());
        assertEquals("Doe", customer.getLastName().getValue());
        assertEquals("johndoe@example.com", customer.getEmail().getValue());
        assertEquals("123 Main St", customer.getAddress().getValue());
        assertEquals("555-1234", customer.getPhoneNumber().getValue());
        assertEquals("Male", customer.getGender().getValue());
        assertEquals(30, customer.getAge().getValue());
    }

    @Test
    void testSetAddress() {
        String newAddress = "456 Main St";
        customer.setAddress(newAddress);
        assertEquals(newAddress, customer.getAddress().getValue());
    }

    @Test
    void testSetPhoneNumber() {
        String newPhoneNumber = "555-6789";
        customer.setPhoneNumber(newPhoneNumber);
        assertEquals(newPhoneNumber, customer.getPhoneNumber().getValue());
    }

    @Test
    void testSetgender() {
        String newgender = "Female";
        customer.setgender(newgender);
        assertEquals(newgender, customer.getGender().getValue());
    }

    @Test
    void testSetAge() {
        int newAge = 35;
        customer.setAge(newAge);
        assertEquals(newAge, customer.getAge().getValue());
    }

    @Test
    void testAddVehicle() {
        Vehicle vehicle = new Vehicle();
        customer.addVehicle(vehicle);
        assertNotNull(customer.getVehicles().get());
        assertFalse(customer.getVehicles().get().isEmpty());
        assertEquals(1, customer.getVehicles().get().size());
    }


    @Test
    void testRemoveVehicle() {
        Vehicle vehicle = new Vehicle(); // Assuming default constructor is defined
        customer.addVehicle(vehicle);
        customer.removeVehicle(vehicle);
        assertTrue(customer.getVehicles().getValue().isEmpty());
    }

    @Test
    void testToString() {
        String expectedString = "Customer{" +
                "userID=1" +
                ", passwordKey='pass123'" +
                ", firstName='John'" +
                ", lastName='Doe'" +
                ", email='johndoe@example.com'" +
                ", address='123 Main St'" +
                ", phoneNumber='555-1234'" +
                ", gender='Male'" +
                ", age=30" +
                ", vehicles=\n" +
                '}';
        assertEquals(expectedString, customer.toString().trim());
    }
}
