import java.util.ArrayList;

/*
 * Created by: Julianna Silva
* Draft implementation of the Vehicle stub database
*/

public class VehicleStubDB {
	private static ArrayList<Vehicle> vehicleDB = new ArrayList<>();
	
	public static void addVehicle(Vehicle vehicle) {
		vehicleDB.add(vehicle);
	}
	
	public static void removeVehicle(Vehicle vehicle) {
		vehicleDB.remove(vehicle);
	}
	
	public static String readAllVehicles() {
		String vehicleInfo = "";
		for (Vehicle vehicle : vehicleDB) {
            vehicleInfo = vehicleInfo.concat("ID: " + vehicle.getVehicleID() + "\n" +
            					"Type: " + vehicle.getType() + "\n" +
            					"Make: " + vehicle.getMake() + "\n" +
            					"Model: " + vehicle.getModel() + "\n" +
            					"Colour: " + vehicle.getColour() + "\n" +
            					"License plate: " + vehicle.getLicensePlate() + "\n" +
            					"Registration: " + vehicle.getRegistration() + "\n");
        }
		return vehicleInfo;
	}
	
//	public static void main(String[] args) {
//		Vehicle car1 = new Vehicle(1, "Sports car", "Ferrari", "Roma", "Red", "AAA000", "Premium");
//		addVehicle(car1);
//		addVehicle(car1);
//		System.out.println(readAllVehicles());
//		removeVehicle(car1);
//		System.out.println("output" + readAllVehicles());
//    }

	
}
