package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Vehicle;
import resources.VehicleStubDB;

/*
 * Created by: Julianna Silva
 * Testing basic methods for the Vehicle stub DB
 */

class VehicleStubDBTest {

	Vehicle car1 = new Vehicle(1, "Sports car", "Ferrari", "Roma", "Red", "AAA000", "Premium");
	
	@Test
	void addVehicleToDBTest() {
		VehicleStubDB.addVehicle(car1);
		assertEquals(VehicleStubDB.readAllVehicles(), "ID: " + car1.getVehicleID() + "\n" +
            					"Type: " + car1.getType() + "\n" +
            					"Make: " + car1.getMake() + "\n" +
            					"Model: " + car1.getModel() + "\n" +
            					"Colour: " + car1.getColour() + "\n" +
            					"License plate: " + car1.getLicensePlate() + "\n" +
            					"Registration: " + car1.getRegistration() + "\n");
	}
	
//	@Test
	void deleteVehicleDBTest() {
		VehicleStubDB.addVehicle(car1);
		VehicleStubDB.removeVehicle(car1);
		assertEquals(VehicleStubDB.readAllVehicles(), "");
	}

}
