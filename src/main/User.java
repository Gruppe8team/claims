package main;
/**
 * This file was created by Cyrus Yang
 * A Skeletonized file of Superclass User for all points
 * Very Critical for building all the users information
 * Contains general information and general getters and setters
 * NOTE: This file should not be edited without consulting the Author
 */
public class User{

    // important indexes for the userSuperClass
    private int userID;
    private String passwordKey;

    private String firstName;
    private String lastName;

    private String email;

    // default construction for general technical operations, for setting default information.
    private User(){
        this.userID = 0;
        this.passwordKey = "";
        this.firstName = "";
        this.lastName = "";
        this.email = "";
    }

    // construction for general technical operations, for setting new accounts
    private User(int alfa, String bravo, String charlie, String delta, String echo){
        this.userID = alfa;
        this.passwordKey = bravo;
        this.firstName = charlie;
        this.lastName = delta;
        this.email = echo;
    }

    // ditto but for already given User object
    private User(User user){
        this.userID = user.getUserID();
        this.passwordKey = user.getPasswordKey();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
    }

    //for getting information when required. That is all
    private int getUserID(){
        return this.userID;
    }

    private String getPasswordKey(){
        return this.passwordKey;
    }
    private String getFirstName(){
        return this.firstName;
    }
    private String getLastName(){
        return this.lastName;
    }
    private String getEmail(){
        return this.email;
    }

    // important functions accounts (note we also need a create a new account option)
    // and possibly a change password option.
    private void changePassword(String delta){
        this.passwordKey = delta;
    }

    private void changeEmail(String emailChanged){
        this.email = emailChanged;
    }

    private void changeFirstName(String firstName){
        this.firstName = firstName;
    }

    private void changeLastName(String lastName){
        this.lastName = lastName;
    }


}
