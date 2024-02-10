package classes;

import java.sql.Date;

public class Claims {
	
	private int claimID, clientID, advisorID, policyID;
	private Date accidentDate, dateFilled;
	private String claimStatus, damage, description, payInfo, closureCond;
	private boolean atFault, totalled;
	
	public Claims() {
		this.claimID = 0;
		this.clientID = 0;
		this.advisorID = 0;
		this.policyID = 0;
		this.dateFilled = null;
		this.accidentDate = null;
		this.payInfo = "";
		this.closureCond = "";
		this.claimStatus = "";
		this.description = "";
		this.damage = "";
		this.atFault = false;
		this.totalled = false;
	}
	
	public Claims(int claimID, int clientID, int advisorID, int policyID, String claimStatus,
			Date dateFilled, Date accidentDate, String damage, String description, String payInfo,
			String closureCond, boolean atFault, boolean totalled) {
		
				this.claimID = claimID;
				this.clientID = clientID;
				this.advisorID = advisorID;
				this.policyID = policyID;
				this.dateFilled = dateFilled;
				this.accidentDate = accidentDate;
				this.payInfo = payInfo;
				this.closureCond = closureCond;
				this.claimStatus = claimStatus;
				this.description = description;
				this.damage = damage;
				this.atFault = atFault;
				this.totalled = totalled;
		
	}

	public int getClaimID() {
		return this.claimID;
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

	public Date getDateFilled() {
		return dateFilled;
	}

	public void setDateFilled(Date dateFilled) {
		this.dateFilled = dateFilled;
	}

	public Date getAccidentDate() {
		return accidentDate;
	}

	public void setAccidentTime(Date accidentDate) {
		this.accidentDate = accidentDate;
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
	
	

}
