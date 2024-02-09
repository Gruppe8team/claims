import java.util.ArrayList;

public class ClaimsStubDB {
	
	private static ArrayList<Claims> claimsDB = new ArrayList<>();
	
	public static void addClaim(Claims claim) {
		claimsDB.add(claim);
	}
	public static void removeClaim(Claims claim) {
		claimsDB.remove(claim);
	}
	
	public static String readClaimInfo() {
		String claimInfo = "";
		for (Claims claim : claimsDB) {
            claimInfo = claimInfo.concat(
            					"Claim ID: " + claim.getClaimID() + "\n" +
            					"Client ID: " + claim.getClientID() + "\n" +
            					"Advisor ID: " + claim.getAdvisorID() + "\n" +
            					"Policy ID: " + claim.getPolicyID() + "\n" +
            					"Current Claim Status: " + claim.getClaimStatus() + "\n" +
            					"Claim Date: " + claim.getDateFilled() + "\n" +
            					"Time of Accident: " + claim.getAccidentTime() + "\n" +
            					"Vehicle Damages: " + claim.getDamage() + "\n" +
            					"Write-off: " + claim.isTotalled() + "\n" +
            					"Driver at Fault: "+ claim.isAtFault() + "\n" +
            					"Payment Status: "+ claim.getPayInfo() + "\n" +
            					"Accident Description: "+ claim.getDescription() + "\n" +
            					"Claim Closed: "+ claim.isClosed() + "\n"
            					);
            if(claim.isClosed()) {
            	claimInfo = claimInfo.concat(
            					"Conditions of Closure: "+ claim.getClosureCond());
            	
            }
            					        }
		return claimInfo;
	}

}
