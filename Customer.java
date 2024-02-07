public class Customer extends User {
    private String address;
    private String phoneNumber;
    private String sex;
    private int age;
    // private vechicle[] 

    // Default constructor
    public Customer() {
        super(); // Call superclass constructor
        this.address = "";
        this.phoneNumber = "";
        this.sex = "";
        this.age = 0;
    }

    // Constructor with parameters
    public Customer(int userID, String passwordKey, String firstName, String lastName, String email, String address, String phoneNumber, String sex, int age) {
        super(userID, passwordKey, firstName, lastName, email); // Call superclass constructor
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
        this.age = age;
    }

    // Getter and setter methods for address
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Getter and setter methods for phoneNumber
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Override toString method to include customer-specific information
    @Override
    public String toString() {
        return "Customer{" +
                "userID=" + getUserID() +
                ", passwordKey='" + getPasswordKey() + '\'' +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}