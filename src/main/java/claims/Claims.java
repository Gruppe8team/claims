package src.main.java.claims;
public class Claims {
	
	private int claimID, clientID;
	private int advisorID, policyID;
	private String claimStatus, dateFilled, accidentTime, damage, description, payInfo, closureCond;
	private boolean atFault, totalled, closed;
	
	public Claims() {}
	
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

	public int getClaimID() {
		return claimID;
	}

	public void setClaimID(int claimID) {
		this.claimID = claimID;
	}

	public int getClientID() {
		return clientID;
	}

	public void setClientID(int clientID) {
		this.clientID = clientID;
	}

	public int getAdvisorID() {
		return advisorID;
	}

	public void setAdvisorID(int advisorID) {
		this.advisorID = advisorID;
	}

	public int getPolicyID() {
		return policyID;
	}

	public void setPolicyID(int policyID) {
		this.policyID = policyID;
	}

	public String getClaimStatus() {
		return claimStatus;
	}

	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}

	public String getDateFilled() {
		return dateFilled;
	}

	public void setDateFilled(String dateFilled) {
		this.dateFilled = dateFilled;
	}

	public String getAccidentTime() {
		return accidentTime;
	}

	public void setAccidentTime(String accidentTime) {
		this.accidentTime = accidentTime;
	}

	public String getDamage() {
		return damage;
	}

	public void setDamage(String damage) {
		this.damage = damage;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPayInfo() {
		return payInfo;
	}

	public void setPayInfo(String payInfo) {
		this.payInfo = payInfo;
	}

	public String getClosureCond() {
		return closureCond;
	}

	public void setClosureCond(String closureCond) {
		this.closureCond = closureCond;
	}

	public boolean isAtFault() {
		return atFault;
	}

	public void setAtFault(boolean atFault) {
		this.atFault = atFault;
	}

	public boolean isTotalled() {
		return totalled;
	}

	public void setTotalled(boolean totalled) {
		this.totalled = totalled;
	}
	
	public boolean isClosed() {
		return closed;
	}
	
	public void setClosed(boolean closed) {
		this.closed = closed;
	}

}