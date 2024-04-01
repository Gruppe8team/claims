package claims.models;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

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
    private final Admin admin;
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
        this.admin = new Admin();
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
                this.customer.setFirstName(resultSet.getString("FirstName"));
                this.customer.setLastName(resultSet.getString("LastName"));
                this.customer.setUsername(resultSet.getString("Username"));
                this.customer.setAddress(resultSet.getString("Address"));
                this.customer.setEmail(resultSet.getString("Email"));
                this.customer.setPhoneNumber(resultSet.getString("Phone"));
                this.customer.setUserID(resultSet.getInt("ClientID"));
                this.customer.setGender(resultSet.getString("Sex"));
                this.customer.setAge(resultSet.getInt("Age"));
                this.customer.setPassword(resultSet.getString("Password"));

                this.customerLoginSuccessFlag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }



    public ObservableList<Customer> getCustomersByAdvisor(int ID) {
        ObservableList<Customer> customers = FXCollections.observableArrayList();
        ResultSet resultSet = ClaimsDatabaseDriver.searchCustomerByAdvisorID(ID);
        try {
            while (resultSet.isBeforeFirst()) {
                Customer customer = new Customer();
                this.customer.setFirstName(resultSet.getString("FirstName"));
                this.customer.setLastName(resultSet.getString("LastName"));
                this.customer.setUsername(resultSet.getString("Username"));
                this.customer.setAddress(resultSet.getString("Address"));
                this.customer.setEmail(resultSet.getString("Email"));
                this.customer.setPhoneNumber(resultSet.getString("Phone"));
                this.customer.setUserID(resultSet.getInt("ClientID"));
                this.customer.setGender(resultSet.getString("Sex"));
                this.customer.setAge(resultSet.getInt("Age"));
                this.customer.setPassword(resultSet.getString("Password"));
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return customers;
    }

    public ObservableList<User> getCustomersForAdmin() {
        ObservableList<User> users = FXCollections.observableArrayList();
        ResultSet resultSet = ClaimsDatabaseDriver.getAllCustomers();
        try {
            while (resultSet.next()) {
                User user = new Customer();
                user.setUsername(resultSet.getString("Username"));
                user.setAddress(resultSet.getString("Address"));
                user.setEmail(resultSet.getString("Email"));
                user.setPhoneNumber(resultSet.getString("Phone"));
                user.setUserID(resultSet.getInt("ClientID"));
                user.setPassword(resultSet.getString("Password"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return users;
    }

    public ObservableList<User> getAdvisorsForAdmin() {
        ObservableList<User> users = FXCollections.observableArrayList();
        ResultSet resultSet = ClaimsDatabaseDriver.getAllAdvisors();
        try {
            while (resultSet.next()) {
                User user = new Advisor();
                user.setUsername(resultSet.getString("Username"));
                user.setAddress(resultSet.getString("Address"));
                user.setEmail(resultSet.getString("Email"));
                user.setPhoneNumber(resultSet.getString("Phone"));
                user.setUserID(resultSet.getInt("AdvisorID"));
                user.setPassword(resultSet.getString("Password"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return users;
    }


    public ObservableList<Claims> getClaimsByClient(int ID) {
        ObservableList<Claims> claims = FXCollections.observableArrayList();
        ResultSet resultSet = ClaimsDatabaseDriver.getClaimDetailsByClient(ID);
        try {
            while (resultSet.next()) {
                Claims claim = new Claims();
                claim.setClaimID(resultSet.getInt("ClaimID"));
                claim.setClientID(resultSet.getInt("ClientID"));
                claim.setAdvisorID(resultSet.getInt("AdvisorID"));
                claim.setPolicyID(resultSet.getInt("PolicyID"));
                claim.setClaimStatus(resultSet.getString("ClaimStatus"));
                claim.setAtFault(resultSet.getBoolean("At_Fault"));
                claim.setDateFiled(resultSet.getString("DateFiled"));
                claim.setAccidentTime(resultSet.getString("Accident_Time"));
                claim.setDamage(resultSet.getString("Damage"));
                claim.setDescription(resultSet.getString("Description"));
                claim.setPayInfo(resultSet.getString("PayInfo"));
                claim.setClosureCond(resultSet.getString("ClosureCond"));
                claim.setClosed(resultSet.getBoolean("Closed"));
                claims.add(claim);
            }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (resultSet != null) {
                    try {
                        resultSet.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
            return claims;    
    }

    public ObservableList<Claims> getClaimsByAdvisor(int ID) {
        ObservableList<Claims> claims = FXCollections.observableArrayList();
        ResultSet resultSet = ClaimsDatabaseDriver.getClaimDetailsByAdvisor(ID);
        try {
            while (resultSet.next()) {
                Claims claim = new Claims();
                claim.setClaimID(resultSet.getInt("ClaimID"));
                claim.setClientID(resultSet.getInt("ClientID"));
                claim.setAdvisorID(resultSet.getInt("AdvisorID"));
                claim.setPolicyID(resultSet.getInt("PolicyID"));
                claim.setClaimStatus(resultSet.getString("ClaimStatus"));
                claim.setAtFault(resultSet.getBoolean("At_Fault"));
                claim.setDateFiled(resultSet.getString("DateFiled"));
                claim.setAccidentTime(resultSet.getString("Accident_Time"));
                claim.setDamage(resultSet.getString("Damage"));
                claim.setDescription(resultSet.getString("Description"));
                claim.setPayInfo(resultSet.getString("PayInfo"));
                claim.setClosureCond(resultSet.getString("ClosureCond"));
                claim.setClosed(resultSet.getBoolean("Closed"));
                claims.add(claim);
            }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (resultSet != null) {
                    try {
                        resultSet.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
            return claims;    
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
                this.advisor.setFirstName(resultSet.getString("FirstName"));
                this.advisor.setLastName(resultSet.getString("LastName"));
                this.advisor.setUsername(resultSet.getString("Username"));
                this.advisor.setAddress(resultSet.getString("Address"));
                this.advisor.setEmail(resultSet.getString("Email"));
                this.advisor.setPhoneNumber(resultSet.getString("Phone"));
                this.advisor.setUserID(resultSet.getInt("AdvisorID"));
                this.advisor.setGender(resultSet.getString("Sex"));
                this.advisor.setDateOfBirth(LocalDate.parse(resultSet.getString("DOB")));
                this.advisor.setPassword(resultSet.getString("Password"));
                this.AdvisorLoginSuccessFlag = true;
            } 
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    // Admin Method Section

    public boolean getAdminLoginSuccessFlag() {
        return this.AdminLoginSuccessFlag;
    }

    public void setAdminLoginSuccessFlag(boolean flag) {
        this.AdminLoginSuccessFlag = flag;
    }

    public Admin getAdmin() {
        return this.admin;
    }

    public void evaluateAdminCred(String username, String password) {
        ResultSet resultSet = ClaimsDatabaseDriver.getAdminDetails(username, password);
        try {
            if (resultSet.isBeforeFirst()){
                this.admin.setUsername(resultSet.getString("Username"));
                this.admin.setPassword(resultSet.getString("Password"));
                this.admin.setUserID(resultSet.getInt("AdminID"));
                this.admin.setFirstName(resultSet.getString("FirstName"));
                this.admin.setLastName(resultSet.getString("LastName"));
                this.admin.setEmail(resultSet.getString("Email"));
                this.admin.setIsActive(resultSet.getBoolean("isActive"));
                this.AdminLoginSuccessFlag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void deleteUser(User user) {
        if (user instanceof Customer) {
            deleteCustomer((Customer) user);
        } else if (user instanceof Advisor) {
            deleteAdvisor((Advisor) user);
        }
    }

    private void deleteCustomer(Customer customer) {
        ClaimsDatabaseDriver.deleteCustomer(customer.getUserID());
    }

    private void deleteAdvisor(Advisor advisor) {
        ClaimsDatabaseDriver.deleteAdvisor(advisor.getUserID());
    }


    public void resetPassword(User user) {
        if (user instanceof Customer) {
            resetCustomerPassword((Customer) user);
        } else if (user instanceof Advisor) {
            resetAdvisorPassword((Advisor) user);
        }
    }

    private void resetAdvisorPassword(Advisor user) {
        ClaimsDatabaseDriver.resetAdvisorPassword(user.getUserID());
    }

    private void resetCustomerPassword(Customer user) {
        ClaimsDatabaseDriver.resetCustomerPassword(user.getUserID());
    }
}
