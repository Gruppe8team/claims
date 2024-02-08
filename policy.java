package claimsDraft_1;

public class policy {

	public int policyID, clientID, vehicleID, policyNumber;
	public String startDate, endDate, coverageType, policyStatus;
	public double Premium, Deductible;
	
	// Default Constructor
	policy(){
		this.policyID = 0;
		this.policyNumber = 0;
		this.coverageType = "";
		this.policyStatus = "";
		this.Premium = 0.0;
	}
	
	// Constructor for unregistered policy 
	policy(int policyID, int policyNumber,String coverageType, String policyStatus, double Premium){
		
		this.policyID = policyID;
		this.policyNumber = policyNumber;
		this.coverageType = coverageType;
		this.policyStatus = policyStatus;
		this.Premium = Premium;
	}
	
	// Same but idk if the dates and deductibles set before a user registers for one
	policy(int policyID, int policyNumber,String startDate, String endDate, 
			String coverageType, String policyStatus, double Premium, double Deductible){
		
		this.policyID = policyID;
		this.policyNumber = policyNumber;
		this.startDate = startDate;
		this.endDate = endDate;
		this.coverageType = coverageType;
		this.policyStatus = policyStatus;
		this.Premium = Premium;
		this.Deductible = Deductible;
	}
	
	
	// Constructor for registered policy 
	policy(int policyID, int clientID,int vehicleID,int policyNumber,String startDate, String endDate, 
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
	
	
	// Idk if policy number is necessary for now
//	public int getPolicyNumber() {
//		return policyNumber;
//	}
//
//	public void setPolicyNumber(int policyNumber) {
//		this.policyNumber = policyNumber;
//	}
	
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
	
}
