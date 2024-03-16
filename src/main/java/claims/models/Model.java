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

    // Admin Data Section

        private Model() {
        this.viewFactory = new ViewFactory();
        this.databaseDriver = new DatabaseDriver();
        // Customer Data Section
        this.customerLoginSuccessFlag = false;
        this.customer = new Customer(); // Fixed constructor error
        // Adivsor Data Section

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
                this.customerLoginSuccessFlag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
