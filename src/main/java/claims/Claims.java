package claims;
public class Claims {
	
	private int claimID, clientID; //Identification for the claim and client.
	private int advisorID, policyID; //Identification for the advisor and the policy.
	private String claimStatus, dateFilled, accidentTime, damage, description, payInfo, closureCond; /*Description of the claim status, date claim was opened,
 													time of accident, description of damages, description of accident details,
	      												payment info, description of closure(if closed)*/
	private boolean atFault, totalled, closed; //Boolean for whether or not client is at fault, the vehicle is totaled, if claim is closed.
     /**
     * Constructs an empty Claim object.
     */
	public Claims() {}
     /**
     * @param claimID identification of claim
     * @param clientID identification of client
     * @param advisorID identification of advisor
     * @param policyID identification of policy
     * @param claimStatus description of claim status
     * @param dateFilled date claim info was filled
     * @param accidentTime time of accident
     * @param damage description of damages
     * @param description description of accident
     * @param payInfo payment information
     * @param closureCond conditions of closure
     * @param atFault whether or not client is at fault
     * @param totalled whether or not vehicle is totalled
     * @param closed whether or not claim is closed
     */
	public Claims(int claimID, int clientID, int advisorID, int policyID, String claimStatus,
			String dateFilled, String accidentTime, String damage, String description, String payInfo,
			String closureCond, boolean atFault, boolean totalled, boolean closed) {
		
		this.claimID = claimID;
		this.clientID = clientID;
		this.advisorID = advisorID;
		this.policyID = policyID;
		this.claimStatus = claimStatus;
		this.dateFilled = dateFilled;
		this.accidentTime = accidentTime;
		this.damage = damage;
		this.description = description;
		this.payInfo = payInfo;
		this.closureCond = closureCond;
		this.atFault = atFault;
		this.totalled = totalled;
		this.closed = closed;
		
	}
	//Gets claim ID
	public int getClaimID() {
		return claimID;
	}
	//Sets claim id
	public void setClaimID(int claimID) {
		this.claimID = claimID;
	}
	//gets client id
	public int getClientID() {
		return clientID;
	}
	//Sets client id
	public void setClientID(int clientID) {
		this.clientID = clientID;
	}
	//Gets advisor id
	public int getAdvisorID() {
		return advisorID;
	}
	//Sets advisor id
	public void setAdvisorID(int advisorID) {
		this.advisorID = advisorID;
	}
	//Gets policy id
	public int getPolicyID() {
		return policyID;
	}
	//Sets policy id
	public void setPolicyID(int policyID) {
		this.policyID = policyID;
	}
	//Gets claims status
	public String getClaimStatus() {
		return claimStatus;
	}
	//Sets claims status
	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}
	//Gets date filled
	public String getDateFilled() {
		return dateFilled;
	}
	//Sets date filled
	public void setDateFilled(String dateFilled) {
		this.dateFilled = dateFilled;
	}
	//Gets time of accident
	public String getAccidentTime() {
		return accidentTime;
	}
	//Sets time of accident
	public void setAccidentTime(String accidentTime) {
		this.accidentTime = accidentTime;
	}
	//Gets damage description
	public String getDamage() {
		return damage;
	}
	//Sets damage description
	public void setDamage(String damage) {
		this.damage = damage;
	}
	//Gets accident description
	public String getDescription() {
		return description;
	}
	//Sets accident description
	public void setDescription(String description) {
		this.description = description;
	}
	//Gets payment info
	public String getPayInfo() {
		return payInfo;
	}
	//Sets payment info
	public void setPayInfo(String payInfo) {
		this.payInfo = payInfo;
	}
	//Gets condition of closure
	public String getClosureCond() {
		return closureCond;
	}
	//Sets condition of closure
	public void setClosureCond(String closureCond) {
		this.closureCond = closureCond;
	}
	//Gets whether client is at fault
	public boolean isAtFault() {
		return atFault;
	}
	//Sets fault status
	public void setAtFault(boolean atFault) {
		this.atFault = atFault;
	}
	//Gets whether the vehicle is totalled
	public boolean isTotalled() {
		return totalled;
	}
	//Sets totalled status
	public void setTotalled(boolean totalled) {
		this.totalled = totalled;
	}
	//Gets closure status of claim
	public boolean isClosed() {
		return closed;
	}
	//Sets closure status of claim
	public void setClosed(boolean closed) {
		this.closed = closed;
	}

}
