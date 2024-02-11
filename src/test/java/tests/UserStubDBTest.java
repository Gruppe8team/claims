package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import classes.Advisor;
import classes.Customer;
import databases.UserStubDB;

public class UserStubDBTest{
	
	private UserStubDB userStubDB;
	
	@BeforeEach
	public void initialization() {
		userStubDB = new UserStubDB();
	}
	
	@Test
	public void testAddAdvisorAndRead() {
		Advisor advisor = new Advisor(1,"x","Jaye","Chen","jiayec@my.yorku.ca");
		userStubDB.addAdvisor(advisor);
		
		String expected = "ID: 1\n"+
				"First Name: Jaye\n"+
				"Last Name: Chen\n"+
				"Email: jiayec@my.yorku.ca\n";
		
		assertEquals(expected,UserStubDB.readAllUsers());
	}
	
	@Test
	public void testRemoveAdvisorAndRead() {
		Advisor advisor = new Advisor(1,"x","Jaye","Chen","jiayec@my.yorku.ca");
		userStubDB.addAdvisor(advisor);
		
		userStubDB.removeAdvisor(advisor);
		
		assertEquals("",UserStubDB.readAllUsers());
	}
	
	@Test
	public void testAddCustomerAndRead() {
		Customer customer = new Customer(2, "x","JJ","CC","jjcc@my.yorku.ca", "2 keele rd", "1234567890", "M", 23) ;
		userStubDB.addCustomer(customer);
		
		String expected = "ID: 2\n"+
				"First Name: JJ\n"+
				"Last Name: CC\n"+
				"Email: jjcc@my.yorku.ca\n"+
				"Phone Number: 1234567890\n"+
				"Sex: M\n"+
				"Age: 23\n";
		
		assertEquals(expected,UserStubDB.readAllUsers());
	}
	
	@Test
	public void testRemoveCustomerAndRead() {
		Customer customer = new Customer(2, "x","JJ","CC","jjcc@my.yorku.ca", "2 keele rd", "1234567890", "M", 23) ;
		userStubDB.addCustomer(customer);
		
		userStubDB.removeCustomer(customer);
		
		assertEquals("",UserStubDB.readAllUsers());
	}
}