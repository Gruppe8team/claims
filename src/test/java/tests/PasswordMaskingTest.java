package tests;

import claims.models.NewUser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


//Steps to Test Password Masking in GUI:
//Open the application's login page.
//Enter a valid username.
//Enter a valid password.
//Verify that the password field displays '*' characters instead of the actual password characters.
//Log in and verify successful authentication.

public class PasswordMaskingTest {
    //sample data for testing
    int userID = 1;
    String passwordKey = "123456";
    String firstName = "Jaye";
    String lastName = "Chen";
    String email = "jiayec@my.yorku.ca";
    String dob = "2023-01";
    String phone = "010-11111";
    String gender = "male";


    //create a new advisor for testing
    NewUser jaye = new NewUser(userID, passwordKey, firstName, lastName, email, dob, phone, gender);

    String expectedPassword = "123456";


    //test toString	method
    @Test
    public void testCorrectPassword() {

        //assert
        assertEquals(expectedPassword, jaye.getPasswordKey());
    }

    @Test
    public void testCorrectEmailPassword() {

        //assert
        assertEquals(expectedPassword, jaye.getPasswordKey());

		String email = "jiayec@my.yorku.ca";
		assertEquals(email, jaye.getEmail());

		System.out.println("User information matched");


	}

	@Test
	public void testIncrorrectPassword() {

		//assert
		assertEquals(expectedPassword, jaye.getPasswordKey());

		String email = "jiayec@my.yorku.sa";
		assertNotEquals(email,jaye.getEmail());


	}

}
