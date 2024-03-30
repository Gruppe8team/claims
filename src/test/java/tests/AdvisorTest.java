package tests;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import claims.models.Advisor;
public class AdvisorTest{
	//sample data for testing
	int userID = 1;
	String username = "jchen";
	String passwordKey = "x";
	String firstName = "Jaye";
	String lastName = "Chen";
	String email = "jiayec@my.yorku.ca";


	//create a new advisor for testing
	Advisor jaye = new Advisor(userID, username, passwordKey, firstName, lastName, email, "address", "1234567890", "Male", LocalDate.of(1990, 10, 10));
	
	String expectedToString = "Advisor{" +
            "userID=" + userID +
            ", passwordKey='" + passwordKey + '\'' +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", email='" + email + '\'' +
            '}';
//test toString	method
@Test
public void testToString(){
	
	//assert
	assertEquals(expectedToString, jaye.toString());
}
			
}
