package claims.controllers;

import claims.NewUser;
import claims.models.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.beans.Visibility;

public class NewUserAccountGUIController {

    private NewUser newUser = new NewUser(1,"","Kyle","Williamson","218953901@gmail.com","Oct 14, 2003","999-999-9999","Male");

    @FXML
    private Label name;
    @FXML
    private Text user_name;

    @FXML
    private Label gender;

    @FXML
    private Label dob;

    @FXML
    private Label email;

    @FXML
    private Label phone;
    @FXML
    private HBox visibility;
    @FXML
    private HBox visibility2;
    @FXML
    private HBox visibility3;
    @FXML
    private HBox visibility4;
    @FXML
    private Button visibility5;
    @FXML
    private Button visibility6;
    @FXML
    private Button visibility7;
    @FXML
    private HBox visibility8;
    @FXML
    private HBox visibility9;

    @FXML
    private Text visibility10;

    @FXML
    private TextField FirstName;
    @FXML
    private TextField LastName;
    @FXML
    private TextField dob1;
    @FXML
    private TextField gender1;

    @FXML
    private TextField email1;

    @FXML
    private TextField phone1;

    public void initialize() {

        name.setText(newUser.getFirstName()+" "+newUser.getLastName());
        user_name.setText("Hi, "+newUser.getFirstName());
        gender.setText("Gender: "+newUser.getGender());
        dob.setText("DOB: "+newUser.getDob());
        email.setText("Email: "+newUser.getEmail());
        phone.setText("Phone #: "+newUser.getPhone());

        hide();
    }

    public void hide(){
        visibility.setVisible(false);
        visibility2.setVisible(false);
        visibility3.setVisible(false);
        visibility4.setVisible(false);
        visibility5.setVisible(false);
        visibility6.setVisible(false);
        visibility7.setVisible(false);
        visibility8.setVisible(false);
        visibility9.setVisible(false);
        visibility10.setVisible(false);

    }
    public void show(){
        visibility.setVisible(true);
        visibility2.setVisible(true);
        visibility3.setVisible(true);
        visibility4.setVisible(true);
        visibility5.setVisible(true);
        visibility6.setVisible(true);
        visibility7.setVisible(true);
        visibility8.setVisible(true);
        visibility9.setVisible(true);
        visibility10.setVisible(true);
    }



    @FXML
    private void editAccount(ActionEvent event) {

        System.out.println("Edit Account Button Clicked");
        showEditAccountDialog();
    }

    @FXML
    private void stopAccount(ActionEvent event) {

        hide();
    }
    @FXML
    private void stopAccount1() throws Exception {
        newUser = new NewUser();
        System.out.println(newUser.toString());
        initialize();
        Model.getInstance().getViewFactory().showLoginWindow();

    }

    @FXML
    private void deleteAccount(ActionEvent event) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Delete Account");
        alert.setContentText("Are you sure you want to delete this account?");

        ButtonType result = alert.showAndWait().orElse(ButtonType.CANCEL);
        if (result == ButtonType.OK) {

            try {
                stopAccount1();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void deleteAccountLogic() {

        System.out.println("Delete Account Logic Executed");
    }

    private void showEditAccountDialog() {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Edit Account");
        FirstName.setText(newUser.getFirstName());
        LastName.setText(newUser.getLastName());
        dob1.setText(newUser.getDob());
        gender1.setText(newUser.getGender());
        email1.setText(newUser.getEmail());
        phone1.setText(newUser.getPhone());
        show();
        //alert.set

    }

    @FXML
    private void saveEditAccountDialog( ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Information Saved");
        //alert.setContentText("Are you sure you want to delete this account?");

        ButtonType result = alert.showAndWait().orElse(ButtonType.CANCEL);
        if (result == ButtonType.OK) {
        }
        newUser.setFirstName(FirstName.getText());
        newUser.setLastName(LastName.getText());
        newUser.setDob(dob1.getText());
        newUser.setGender(gender1.getText());
        newUser.setEmail(email1.getText());
        newUser.setPhone(phone1.getText());
        System.out.println(newUser.toString());
        initialize();


    }
}
