package claims.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import claims.controllers.Customer.EditController;
import claims.models.Model;
import claims.models.NewUser;
import claims.views.AccountType;
import databases.CustomerDatabase;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;



public class LoginController implements Initializable {

    @FXML
    private Button Button_SignIn;

    @FXML
    private ImageView vostok;

    @FXML
    private Button Button_SignUp;

    @FXML
    private TextField TextField_Username;

    @FXML
    private PasswordField PasswordField_Password;

    @FXML
    private ChoiceBox<AccountType> acc_type_selector;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        acc_type_selector.setItems(FXCollections.observableArrayList(AccountType.CUSTOMER, AccountType.ADVISOR, AccountType.ADMIN));
        acc_type_selector.setValue(Model.getInstance().getViewFactory().getLoginAccountType());
        acc_type_selector.valueProperty().addListener(observable -> Model.getInstance().getViewFactory().setLoginAccountType(acc_type_selector.getValue()));
        Button_SignIn.setOnAction(event -> onLogin());
        Button_SignUp.setOnAction(event -> onRegister());

        Image image = new Image(getClass().getResourceAsStream("/claims/fxml/logoV3.png"));
        vostok.setImage(image);

    }


    private void onLogin() {


        // if (acc_type_selector.getValue() != AccountType.CUSTOMER){
        //     Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        //     alert.setTitle("Confirmation");
        //     alert.setHeaderText("Title");
        //     alert.setContentText("Account or password error");
        //     ButtonType result = alert.showAndWait().orElse(ButtonType.CANCEL);
        //     if (result == ButtonType.OK) {
        //     }
        //     return;

        // }
        // NewUser newUser = new NewUser();
        // newUser.setPasswordKey(TextField_Password.getText());
        // newUser.setEmail(TextField_Email.getText());
        // String sql = "select * from customer where email = \'"+newUser.getEmail()+"\' " +
        //         "and passwordkey = \'"+newUser.getPasswordKey()+"\'";
        // NewUser user = CustomerDatabase.getUser(sql);
        // if(user.getUserID() == 0 || "".equals(newUser.getPasswordKey()) || "".equals(newUser.getEmail())){
        //     //Fail
        //     System.out.println("null");
        //     Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        //     alert.setTitle("Confirmation");
        //     alert.setHeaderText("Title");
        //     alert.setContentText("Account or password error");
        //     ButtonType result = alert.showAndWait().orElse(ButtonType.CANCEL);
        //     if (result == ButtonType.OK) {
        //     }
        //     return;
        // }
        // EditController.newUser = user;
        NewUser newUser = new NewUser();
        newUser.setPasswordKey(PasswordField_Password.getText());
        newUser.setEmail(TextField_Username.getText());
        if (Model.getInstance().getViewFactory().getLoginAccountType() == AccountType.CUSTOMER) {
            //Evalute login credentials

            newUser.setUserType("Customer");
            String sql = "select * from customer where email = \'"+newUser.getEmail()+"\' " +
                    "and passwordkey = \'"+newUser.getPasswordKey()+"\'" +
                    "and usertype = \'"+newUser.getUserType()+"\'";
            NewUser user = CustomerDatabase.getUser(sql);
            if(user.getUserID() == 0){
                //Fail
                System.out.println("null");
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation");
                alert.setHeaderText("Title");
                alert.setContentText("Account or password error");
                ButtonType result = alert.showAndWait().orElse(ButtonType.CANCEL);
                if (result == ButtonType.OK) {
                }
                return;
            }
            EditController.newUser = user;
            Model.getInstance().getViewFactory().showCustomerWindow();
            Stage stage = (Stage) Button_SignIn.getScene().getWindow();
            Model.getInstance().getViewFactory().closeStage(stage);
        } else if (Model.getInstance().getViewFactory().getLoginAccountType() == AccountType.ADVISOR) {
            newUser.setUserType("Advisor");
            String sql = "select * from customer where email = \'"+newUser.getEmail()+"\' " +
                    "and passwordkey = \'"+newUser.getPasswordKey()+"\'" +
                    "and usertype = \'"+newUser.getUserType()+"\'";
            NewUser user = CustomerDatabase.getUser(sql);
            if(user.getUserID() == 0){
                //Fail
                System.out.println("null");
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation");
                alert.setHeaderText("Title");
                alert.setContentText("Account or password error");
                ButtonType result = alert.showAndWait().orElse(ButtonType.CANCEL);
                if (result == ButtonType.OK) {
                }
                return;
            }
            EditController.newUser = user;
            //Model.getInstance().evaluateAdvisorCred(TextField_Username.getText(), PasswordField_Password.getText());
            Model.getInstance().getViewFactory().showAdvisorWindow();
            Stage stage = (Stage) Button_SignIn.getScene().getWindow();
            Model.getInstance().getViewFactory().closeStage(stage);
        } else if (Model.getInstance().getViewFactory().getLoginAccountType() == AccountType.ADMIN) {
            newUser.setUserType("Admin");
            String sql = "select * from customer where email = \'"+newUser.getEmail()+"\' " +
                    "and passwordkey = \'"+newUser.getPasswordKey()+"\'" +
                    "and usertype = \'"+newUser.getUserType()+"\'";
            NewUser user = CustomerDatabase.getUser(sql);
            if(user.getUserID() == 0){
                //Fail
                System.out.println("null");
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation");
                alert.setHeaderText("Title");
                alert.setContentText("Account or password error");
                ButtonType result = alert.showAndWait().orElse(ButtonType.CANCEL);
                if (result == ButtonType.OK) {
                }
                return;
            }
            EditController.newUser = user;
            Model.getInstance().getViewFactory().showAdminWindow();
            Stage stage = (Stage) Button_SignIn.getScene().getWindow();
            Model.getInstance().getViewFactory().closeStage(stage);
        }

    }

    public void onRegister() {
        Stage stage = (Stage) Button_SignIn.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showRegisterWindow();
    }

}
