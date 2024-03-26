package claims.models;


import java.sql.ResultSet;
import java.sql.SQLException;
import claims.models.Drivers.ClaimsDatabaseDriver;
import claims.views.AccountType;
import claims.views.ViewFactory;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Model {
    private static Model model;
    private final ViewFactory viewFactory;
    private final ClaimsDatabaseDriver ClaimsDatabaseDriver;
    private AccountType loginAccountType = AccountType.CUSTOMER;
    // Customer Data Section
    private final Customer customer;
    private boolean customerLoginSuccessFlag;
    private ObservableList<Customer> customerList;
    // Adivsor Data Section
    private final Advisor advisor;
    private boolean AdvisorLoginSuccessFlag;
    // Admin Data Section
    private final SysAdmin admin;
    private boolean AdminLoginSuccessFlag;

        private Model() {
        this.viewFactory = new ViewFactory();
        this.ClaimsDatabaseDriver = new ClaimsDatabaseDriver();
        // Customer Data Section
        this.customerLoginSuccessFlag = false;
        this.customer = new Customer(); // Fixed constructor error
        this.customerList = FXCollections.observableArrayList();
        // Adivsor Data Section
        this.AdvisorLoginSuccessFlag = false;
        this.advisor = new Advisor();
        // Admin Data Section
        this.AdminLoginSuccessFlag = false;
        this.admin = new SysAdmin();
    }


    public static synchronized Model getInstance() {
        if (model == null) {
            model = new Model();
        }
        return model;
    }

    public ViewFactory getViewFactory() {
        return viewFactory;
    }

    public ClaimsDatabaseDriver getClaimsDatabaseDriver() {
        return ClaimsDatabaseDriver;
    }

    public AccountType getLoginAccountType() {
        return loginAccountType;
    }

    public void setLoginAccountType(AccountType loginAccountType){
        this.loginAccountType = loginAccountType;
    }

    // Customer Method Section

    public boolean getCustomerLoginSuccessFlag() {
        return this.customerLoginSuccessFlag;
    }
    public void setCustomerLoginSuccessFlag(boolean flag) {
        this.customerLoginSuccessFlag = flag;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void evaluateClientCred(String username, String password) {
        ResultSet resultSet = ClaimsDatabaseDriver.getCustomerDetails(username, password);
        try {
            if (resultSet.isBeforeFirst()){
                this.customer.getFirstName().set(resultSet.getString("FirstName"));
                this.customer.getLastName().set(resultSet.getString("LastName"));
                this.customer.getUsername().set(resultSet.getString("Username"));
                this.customer.getAddress().set(resultSet.getString("Address"));
                this.customer.getEmail().set(resultSet.getString("Email"));
                this.customer.getPhoneNumber().set(resultSet.getString("Phone"));
                this.customer.getUserID().set(resultSet.getInt("ClientID"));
                this.customer.getGender().set(resultSet.getString("Sex"));
                this.customer.getAge().set(resultSet.getInt("Age"));
                this.customer.getPasswordKey().set(resultSet.getString("Password"));                
                this.customerLoginSuccessFlag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ObservableList<Customer> getCustomers() {
        ObservableList<Customer> customers = FXCollections.observableArrayList();
        ResultSet resultSet = ClaimsDatabaseDriver.searchCustomerByAdvisorID();
        try {
            while (resultSet.isBeforeFirst()) {
                Customer customer = new Customer();
                this.customer.getFirstName().set(resultSet.getString("FirstName"));
                this.customer.getLastName().set(resultSet.getString("LastName"));
                this.customer.getUsername().set(resultSet.getString("Username"));
                this.customer.getAddress().set(resultSet.getString("Address"));
                this.customer.getEmail().set(resultSet.getString("Email"));
                this.customer.getPhoneNumber().set(resultSet.getString("Phone"));
                this.customer.getUserID().set(resultSet.getInt("ClientID"));
                this.customer.getGender().set(resultSet.getString("Sex"));
                this.customer.getAge().set(resultSet.getInt("Age"));
                this.customer.getPasswordKey().set(resultSet.getString("Password"));  
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;    
    }


    public ObservableList<Customer> getCustomerList() {
        return this.customerList;
    }

    // Advisor Method Section

    public boolean getAdvisorLoginSuccessFlag() {
        return this.AdvisorLoginSuccessFlag;
    }

    public void setAdvisorLoginSuccessFlag(boolean flag) {
        this.AdvisorLoginSuccessFlag = flag;
    }

    public Advisor getAdvisor() {
        return this.advisor;
    }

    public void evaluateAdvisorCred(String username, String password) {
        ResultSet resultSet = ClaimsDatabaseDriver.getAdvisorDetails(username, password);
        try {
            if (resultSet.isBeforeFirst()){
                this.advisor.getFirstName().set(resultSet.getString("FirstName"));
                this.advisor.getLastName().set(resultSet.getString("LastName"));
                this.advisor.getUsername().set(resultSet.getString("Username"));
                this.advisor.getEmail().set(resultSet.getString("Email"));
                this.advisor.getPasswordKey().set(resultSet.getString("Password"));
                this.advisor.getUserID().set(resultSet.getInt("AdvisorID"));
                this.AdvisorLoginSuccessFlag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // Admin Method Section

    public boolean getAdminLoginSuccessFlag() {
        return this.AdminLoginSuccessFlag;
    }

    public void setAdminLoginSuccessFlag(boolean flag) {
        this.AdminLoginSuccessFlag = flag;
    }

    public SysAdmin getAdmin() {
        return this.admin;
    }

    public void evaluateAdminCred(String username, String password) {
        ResultSet resultSet = ClaimsDatabaseDriver.getAdminDetails(username, password);
        try {
            if (resultSet.isBeforeFirst()){
                this.admin.getUsername().set(resultSet.getString("Username"));
                this.admin.getPasswordKey().set(resultSet.getString("Password"));
                this.admin.getUserID().set(resultSet.getInt("ID"));
                this.admin.getFirstName().set(resultSet.getString("FirstName"));
                this.admin.getLastName().set(resultSet.getString("LastName"));
                this.admin.getEmail().set(resultSet.getString("Email"));
                this.admin.getIsActive().set(resultSet.getBoolean("isActive"));
                this.AdminLoginSuccessFlag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
