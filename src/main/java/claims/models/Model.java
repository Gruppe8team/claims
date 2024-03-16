package claims.models;


import java.sql.ResultSet;
import java.sql.SQLException;

import claims.views.AccountType;
import claims.views.ViewFactory;

public class Model {
    private static Model model;
    private final ViewFactory viewFactory;
    private final DatabaseDriver databaseDriver;
    private AccountType loginAccountType = AccountType.CUSTOMER;
    // Customer Data Section
    private final Customer customer;
    private boolean customerLoginSuccessFlag;
    // Adivsor Data Section
    private final Advisor advisor;
    private boolean AdvisorLoginSuccessFlag;
    // Admin Data Section
    private boolean AdminLoginSuccessFlag;

        private Model() {
        this.viewFactory = new ViewFactory();
        this.databaseDriver = new DatabaseDriver();
        // Customer Data Section
        this.customerLoginSuccessFlag = false;
        this.customer = new Customer(); // Fixed constructor error
        // Adivsor Data Section
        this.AdvisorLoginSuccessFlag = false;
        this.advisor = new Advisor();
        // Admin Data Section
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

    public DatabaseDriver getDatabaseDriver() {
        return databaseDriver;
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
        ResultSet resultSet = databaseDriver.getCustomerDetails(username, password);
        try {
            if (resultSet.isBeforeFirst()){
                this.customer.getFirstName().set(resultSet.getString("FirstName"));
                this.customer.getLastName().set(resultSet.getString("LastName"));
                this.customer.getUsername().set(resultSet.getString("Username"));
                this.customer.getAddress().set(resultSet.getString("Address"));
                this.customer.getEmail().set(resultSet.getString("Email"));
                this.customer.getPhoneNumber().set(resultSet.getString("PhoneNumber"));
                this.customer.getUserID().set(resultSet.getInt("ID"));
                this.customer.getgender().set(resultSet.getString("Gender"));
                this.customer.getAge().set(resultSet.getInt("Age"));
                this.customer.getPasswordKey().set(resultSet.getString("Password"));
                this.customerLoginSuccessFlag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
        ResultSet resultSet = databaseDriver.getAdvisorDetails(username, password);
        try {
            if (resultSet.isBeforeFirst()){
                this.advisor.getFirstName().set(resultSet.getString("FirstName"));
                this.advisor.getLastName().set(resultSet.getString("LastName"));
                this.advisor.getUsername().set(resultSet.getString("Username"));
                this.advisor.getEmail().set(resultSet.getString("Email"));
                this.advisor.getPasswordKey().set(resultSet.getString("Password"));

    }
}
