package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Vehicle;

class VehicleTest {

	@Test
	void createVehicleTest() {
		
		Vehicle car1 = new Vehicle(1, "Sports car", "Ferrari", "Roma", "Red", "AAA000", "Premium");
		
		assertEquals(1, car1.getVehicleID());
		assertEquals("Sports car", car1.getType());
		assertEquals("Ferrari", car1.getMake());
		assertEquals("Roma", car1.getModel());
		assertEquals("Red", car1.getColour());
		assertEquals("AAA000", car1.getLicensePlate());
		assertEquals("Premium", car1.getRegistration());
	}

}
