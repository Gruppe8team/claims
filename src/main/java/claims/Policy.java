package src.main.java.claims;

public class Policy {

	public int policyID, clientID, vehicleID, policyNumber;
	public String startDate, endDate, coverageType, policyStatus;
	public double Premium, Deductible;
	
	// Default Constructor
	public Policy() {
		this.policyID = 0;
		this.clientID = 0;
		this.vehicleID = 0;
		this.policyNumber = 0;
		this.startDate ="";
		this.endDate = "";
		this.coverageType = "";
		this.policyStatus = "";
		this.Premium = 0.0;
		this.Deductible = 0.0;
		
		
	}
	
	// Constructor for unregistered policy 
	public Policy(int policyID, int policyNumber,String coverageType, String policyStatus, double Premium){
		
		this.policyID = policyID;
		this.clientID = 0;
		this.vehicleID = 0;
		this.policyNumber = policyNumber;
		this.startDate ="";
		this.endDate = "";
		this.coverageType = coverageType;
		this.policyStatus = policyStatus;
		this.Premium = Premium;
		this.Deductible = 0.0;
	}
	
	// Same but idk if the dates and deductibles set before a user registers for one
	public Policy(int policyID, int policyNumber,String startDate, String endDate, 
			String coverageType, String policyStatus, double Premium, double Deductible){
		
		this.policyID = policyID;
		this.clientID = 0;
		this.vehicleID = 0;
		this.policyNumber = policyNumber;
		this.startDate = startDate;
		this.endDate = endDate;
		this.coverageType = coverageType;
		this.policyStatus = policyStatus;
		this.Premium = Premium;
		this.Deductible = Deductible;
	}
	
	
	// Constructor for registered policy 
	public Policy(int policyID, int clientID,int vehicleID,int policyNumber,String startDate, String endDate, 
			String coverageType, String policyStatus, double Premium, double Deductible){
		
		this.policyID = policyID;
		this.clientID = clientID;
		this.vehicleID = vehicleID;
		this.policyNumber = policyNumber;
		this.startDate = startDate;
		this.endDate = endDate;
		this.coverageType = coverageType;
		this.policyStatus = policyStatus;
		this.Premium = Premium;
		this.Deductible = Deductible;
	}
	

	public int getPolicyID() {
		return policyID;
	}

	// Function to make an ID for the policies?
	public void setPolicyID(int policyID) {
		this.policyID = policyID;
	}

	public int getClientID() {
		return clientID;
	}

	public void setClientID(int clientID) {
		this.clientID = clientID;
	}

	public int getVehicleID() {
		return vehicleID;
	}

	public void setVehicleID(int vehicleID) {
		this.vehicleID = vehicleID;
	}
	
	
	public int getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(int policyNumber) {
		this.policyNumber = policyNumber;
	}
	
	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getCoverageType() {
		return coverageType;
	}

	public void setCoverageType(String coverageType) {
		this.coverageType = coverageType;
	}

	public String getPolicyStatus() {
		return policyStatus;
	}

	public void setPolicyStatus(String policyStatus) {
		this.policyStatus = policyStatus;
	}

	public double getPremium() {
		return Premium;
	}

	public void setPremium(double premium) {
		Premium = premium;
	}

	public double getDeductible() {
		return Deductible;
	}

	public void setDeductible(double deductible) {
		Deductible = deductible;
	}
	
	@Override 
	public String toString(){
		
		return "PolicyID: "+policyID+"\nClientID: "+clientID+"\nVehicleID: "+vehicleID+"\nPolicyNumber: "+policyNumber+
				"\nStart Date: "+startDate+"\nEnd Date: "+endDate+"\nCoverage Type: "+coverageType+"\nPolicy Status: "+policyStatus+
				"\nPremium: "+Premium+"\nDeductible: "+Deductible;
	}
}
