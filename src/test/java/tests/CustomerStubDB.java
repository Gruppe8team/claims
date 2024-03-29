package tests;

import claims.models.Customer;

import java.util.function.Predicate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CustomerStubDB {
    private final Map<Integer, Customer> customers = new HashMap<>(); // Using userID as key

    // Method to add a customer
    public void addCustomer(Customer customer) {
        customers.put(customer.getUserID(), customer);
    }

    // Method to remove a customer
    public boolean removeCustomer(int userID) {
        if (customers.containsKey(userID)) {
            customers.remove(userID);
            return true;
        }
        return false;
    }

    // Method to update a customer
    public boolean updateCustomer(int userID, Customer updatedCustomer) {
        if (customers.containsKey(userID)) {
            customers.put(userID, updatedCustomer);
            return true;
        }
        return false;
    }

    // Method to retrieve a customer by userID
    public Customer getCustomer(int userID) {
        return customers.get(userID);
    }

    // Method to retrieve all customers
    public List<Customer> getAllCustomers() {
        return new ArrayList<>(customers.values());
    }

    public List<Customer> findCustomersByAddress(String address) {
        return customers.values().stream()
                .filter(customer -> customer.getAddress().equals(address))
                .collect(Collectors.toList());
    }

    public List<Customer> findCustomersBygender(String gender) {
        return customers.values().stream()
                .filter(customer -> customer.getGender().equals(gender))
                .collect(Collectors.toList());
    }

    public List<Customer> findCustomersByPhoneNumber(String phoneNumber) {
        return customers.values().stream()
                .filter(customer -> customer.getPhoneNumber().equals(phoneNumber))
                .collect(Collectors.toList());
    }

    public List<Customer> findCustomersByAgeRange(int minAge, int maxAge) {
        return customers.values().stream()
                .filter(customer -> customer.getAge() >= minAge
                        && customer.getAge() <= maxAge)
                .collect(Collectors.toList());
    }

    public boolean updateCustomerEmail(int userID, String newEmail) {
        Customer customer = customers.get(userID);
        if (customer != null) {
            customer.setEmail(newEmail); // Assuming there's a setEmail method in Customer
            return true;
        }
        return false;
    }

    public void addCustomers(List<Customer> newCustomers) {
        newCustomers.forEach(customer -> customers.put(customer.getUserID(), customer));
    }

    public void removeCustomers(List<Integer> userIDs) {
        userIDs.forEach(customers::remove);
    }

    public int countCustomers() {
        return customers.size();
    }

    public List<Customer> findCustomersWithoutVehicles() {
        return customers.values().stream()
                .filter(customer -> customer.getVehicles().isEmpty())
                .collect(Collectors.toList());
    }

    public List<Customer> queryCustomers(Predicate<Customer> condition) {
        return customers.values().stream()
                .filter(condition)
                .collect(Collectors.toList());
    }

}
