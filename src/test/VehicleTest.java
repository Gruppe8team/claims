package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Vehicle;

/*
 * Created by: Julianna Silva
 * Testing basic implementation of the Vehicle class
 */

class VehicleTest {

	Vehicle car1 = new Vehicle(1, "Sports car", "Ferrari", "Roma", "Red", "AAA000", "Premium");
	Vehicle car2 = new Vehicle();
	
	@Test
	void getVehicleTest() {
				
		assertEquals(1, car1.getVehicleID());
		assertEquals("Sports car", car1.getType());
		assertEquals("Ferrari", car1.getMake());
		assertEquals("Roma", car1.getModel());
		assertEquals("Red", car1.getColour());
		assertEquals("AAA000", car1.getLicensePlate());
		assertEquals("Premium", car1.getRegistration());
	}
	
	@Test
	void setVehicleInfoTest() {
		
		car2.setVehicleID(2);
		car2.setType("Truck");
		car2.setMake("Tesla");
		car2.setModel("Cybertruck");
		car2.setColour("Silver");
		car2.setLicensePlate("BBB111");
		car2.setRegistration("Standard");

		assertEquals(2, car2.getVehicleID());
		assertEquals("Truck", car2.getType());
		assertEquals("Tesla", car2.getMake());
		assertEquals("Cybertruck", car2.getModel());
		assertEquals("Silver", car2.getColour());
		assertEquals("BBB111", car2.getLicensePlate());
		assertEquals("Standard", car2.getRegistration());
		
	}

}
