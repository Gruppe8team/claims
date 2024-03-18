package claims.models;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Policy {

	public IntegerProperty policyID, clientID, vehicleID, policyNumber;
	public StringProperty startDate, endDate, coverageType, policyStatus;
	public DoubleProperty Premium, Deductible;
	
	// Default Constructor
	public Policy() {
		this.policyID = new SimpleIntegerProperty(this, "Policy ID", 0);
		this.clientID = new SimpleIntegerProperty(this, "Client ID", 0);
		this.vehicleID = new SimpleIntegerProperty(this, "Vehicle ID", 0);
		this.policyNumber = new SimpleIntegerProperty(this, "Policy Number", 0);
		this.startDate = new SimpleStringProperty(this, "Start Date", "");
		this.endDate = new SimpleStringProperty(this, "End Date", "");
		this.coverageType = new SimpleStringProperty(this, "Coverage Type", "");
		this.policyStatus = new SimpleStringProperty(this, "Policy Status", "");
		this.Premium = new SimpleDoubleProperty(this, "Premium", 0.0);
		this.Deductible = new SimpleDoubleProperty(this, "Deductible", 0.0);
		
		
	}
	
	// Constructor for unregistered policy 
	public Policy(int policyID, int policyNumber,String coverageType, String policyStatus, double Premium){
		
		this.policyID = new SimpleIntegerProperty(this, "Policy ID", policyID);
		this.clientID = new SimpleIntegerProperty(this, "Client ID", 0);
		this.vehicleID = new SimpleIntegerProperty(this, "Vehicle ID", 0);
		this.policyNumber = new SimpleIntegerProperty(this, "Policy Number", policyNumber);
		this.startDate = new SimpleStringProperty(this, "Start Date", "");
		this.endDate = new SimpleStringProperty(this, "End Date", "");
		this.coverageType = new SimpleStringProperty(this, "Coverage Type", coverageType);
		this.policyStatus = new SimpleStringProperty(this, "Policy Status", policyStatus);
		this.Premium = new SimpleDoubleProperty(this, "Premium", Premium);
		this.Deductible = new SimpleDoubleProperty(this, "Deductible", 0);
	}
	
	// Same but idk if the dates and deductibles set before a user registers for one
	public Policy(int policyID, int policyNumber,String startDate, String endDate, 
			String coverageType, String policyStatus, double Premium, double Deductible){
		
		this.policyID = new SimpleIntegerProperty(this, "Policy ID", policyID);
		this.clientID = new SimpleIntegerProperty(this, "Client ID", 0);
		this.vehicleID = new SimpleIntegerProperty(this, "Vehicle ID", 0);
		this.policyNumber = new SimpleIntegerProperty(this, "Policy Number", policyNumber);
		this.startDate = new SimpleStringProperty(this, "Start Date", startDate);
		this.endDate = new SimpleStringProperty(this, "End Date", endDate);
		this.coverageType = new SimpleStringProperty(this, "Coverage Type", coverageType);
		this.policyStatus = new SimpleStringProperty(this, "Policy Status", policyStatus);
		this.Premium = new SimpleDoubleProperty(this, "Premium", Premium);
		this.Deductible = new SimpleDoubleProperty(this, "Deductible", Deductible);
	}
	
	
	// Constructor for registered policy 
	// public Policy(int policyID, int clientID,int vehicleID,int policyNumber,String startDate, String endDate, 
	// 		String coverageType, String policyStatus, double Premium, double Deductible){
		
	// 	this.policyID = new SimpleIntegerProperty(this, "Policy ID", policyID);
	// 	this.clientID = ;
	// 	this.vehicleID = vehicleID;
	// 	this.policyNumber = policyNumber;
	// 	this.startDate = startDate;
	// 	this.endDate = endDate;
	// 	this.coverageType = coverageType;
	// 	this.policyStatus = policyStatus;
	// 	this.Premium = Premium;
	// 	this.Deductible = Deductible;
	// }
	

	public IntegerProperty getPolicyID() {
		return policyID;
	}

	// Function to make an ID for the policies?
	public void setPolicyID(int policyID) {
		this.policyID.set(policyID);
	}

	public IntegerProperty getClientID() {
		return clientID;
	}

	public void setClientID(int clientID) {
		this.clientID.set(clientID);
	}

	public IntegerProperty getVehicleID() {
		return vehicleID;
	}

	public void setVehicleID(int vehicleID) {
		this.vehicleID.set(vehicleID);
	}
	
	
	public IntegerProperty getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(int policyNumber) {
		this.policyNumber.set(policyNumber);
	}
	
	public StringProperty getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate.set(startDate);
	}

	public StringProperty getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate.set(endDate);
	}

	public StringProperty getCoverageType() {
		return coverageType;
	}

	public void setCoverageType(String coverageType) {
		this.coverageType.set(coverageType);
	}

	public StringProperty getPolicyStatus() {
		return policyStatus;
	}

	public void setPolicyStatus(String policyStatus) {
		this.policyStatus.set(policyStatus);
	}

	public DoubleProperty getPremium() {
		return Premium;
	}

	public void setPremium(double premium) {
		this.Premium.set(premium);
	}

	public DoubleProperty getDeductible() {
		return Deductible;
	}

	public void setDeductible(double deductible) {
		this.Deductible.set(deductible);
	}
	
	@Override 
	public String toString(){
		
		return "PolicyID: "+policyID+"\nClientID: "+clientID+"\nVehicleID: "+vehicleID+"\nPolicyNumber: "+policyNumber+
				"\nStart Date: "+startDate+"\nEnd Date: "+endDate+"\nCoverage Type: "+coverageType+"\nPolicy Status: "+policyStatus+
				"\nPremium: "+Premium+"\nDeductible: "+Deductible;
	}
}
