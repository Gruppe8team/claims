package claims;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import claims.models.Vehicle;

public class VehicleDAO {
	private Connection connection;

	public VehicleDAO() {
		// Initialize the connection to the database
		try {
			String url = "jdbc:sqlite:src/main/java/databases/vehicles.db";
            connection = DriverManager.getConnection(url);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Method to add a new vehicle into the database
	public void addVehicle(Vehicle vehicle) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"INSERT INTO vehicles (vehicleID, ownerID, year, type, make, model, colour, licensePlate, registration) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)"
					);
			preparedStatement.setInt(1, vehicle.getVehicleID());
			preparedStatement.setInt(2, vehicle.getOwner().getUserID().intValue()); // Assuming the owner has a userID attribute
			preparedStatement.setInt(3, vehicle.getYear());
			preparedStatement.setString(4, vehicle.getType());
			preparedStatement.setString(5, vehicle.getMake());
			preparedStatement.setString(6, vehicle.getModel());
			preparedStatement.setString(7, vehicle.getColour());
			preparedStatement.setString(8, vehicle.getLicensePlate());
			preparedStatement.setString(9, vehicle.getRegistration());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Method to delete a vehicle from the database
	public void deleteVehicle(int vehicleID) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"DELETE FROM vehicles WHERE vehicleID = ?"
					);
			preparedStatement.setInt(1, vehicleID);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Method to update vehicle information in the database
	public void updateVehicle(Vehicle vehicle) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"UPDATE vehicles SET ownerID = ?, year = ?, type = ?, make = ?, model = ?, colour = ?, licensePlate = ?, registration = ? WHERE vehicleID = ?"
					);
			preparedStatement.setInt(1, vehicle.getOwner().getUserID().intValue()); // Assuming the owner has a userID attribute
			preparedStatement.setInt(2, vehicle.getYear());
			preparedStatement.setString(3, vehicle.getType());
			preparedStatement.setString(4, vehicle.getMake());
			preparedStatement.setString(5, vehicle.getModel());
			preparedStatement.setString(6, vehicle.getColour());
			preparedStatement.setString(7, vehicle.getLicensePlate());
			preparedStatement.setString(8, vehicle.getRegistration());
			preparedStatement.setInt(9, vehicle.getVehicleID());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Method to retrieve a vehicle from the database by its ID
	public Vehicle getVehicleByID(int vehicleID) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"SELECT * FROM vehicles WHERE vehicleID = ?"
					);
			preparedStatement.setInt(1, vehicleID);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				// Assuming there's a constructor in Vehicle class that accepts all attributes
				return new Vehicle(resultSet.getInt("vehicleID"),
						null, // Owner will be fetched separately
						resultSet.getString("type"),
						resultSet.getString("make"),
						resultSet.getString("model"),
						resultSet.getString("colour"),
						resultSet.getString("licensePlate"),
						resultSet.getString("registration"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// Method to retrieve all vehicles from the database
	public List<Vehicle> getAllVehicles() {
		List<Vehicle> vehicles = new ArrayList<>();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM vehicles");

			while (resultSet.next()) {
				// Assuming there's a constructor in Vehicle class that accepts all attributes
				Vehicle vehicle = new Vehicle(resultSet.getInt("vehicleID"),
						null, // Owner will be fetched separately
						resultSet.getString("type"),
						resultSet.getString("make"),
						resultSet.getString("model"),
						resultSet.getString("colour"),
						resultSet.getString("licensePlate"),
						resultSet.getString("registration"));
				vehicles.add(vehicle);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vehicles;
	}
	public void closeConnection() {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}