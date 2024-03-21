package tests;
import claims.*;
import claims.models.Claims;

import java.util.ArrayList;


public class ClaimsStubDB {
	//Creates array list to contain claim information
	private static ArrayList<Claims> claimsDB = new ArrayList<>();
	//adds claim to database
	// @param claim The claim to add.
	public static void addClaim(Claims claim) {
		claimsDB.add(claim);
	}
	//removes claim from database
	// @param claim The claim to remove.
	public static void removeClaim(Claims claim) {
		claimsDB.remove(claim);
	}
	//Reads claim information
	//@return returns string containing claim information and identification. 
	public static String readClaimInfo() {
		String claimInfo = "";
		for (Claims claim : claimsDB) {
            claimInfo = claimInfo.concat(
            					"Claim ID: " + claim.getClaimID().getValue() + "\n" +
							"Client ID: " + claim.getClientID().getValue() + "\n" +
							"Advisor ID: " + claim.getAdvisorID().getValue() + "\n" +
							"Policy ID: " + claim.getPolicyID().getValue() + "\n" +
							"Current Claim Status: " + claim.getClaimStatus().getValue() + "\n" +
							"Claim Date: " + claim.getDateFilled().getValue() + "\n" +
							"Time of Accident: " + claim.getAccidentTime().getValue() + "\n" +
							"Vehicle Damages: " + claim.getDamage().getValue() + "\n" +
							"Write-off: " + claim.isTotalled() + "\n" +
							"Driver at Fault: " + claim.isAtFault() + "\n" +
							"Payment Status: " + claim.getPayInfo().getValue() + "\n" +
							"Accident Description: " + claim.getDescription().getValue() + "\n" +
							"Claim Closed: " + claim.isClosed() + "\n"

            					);
	//If claim is closed, adds claim closure description
            if(claim.isClosed()) {
            	claimInfo = claimInfo.concat(
            					"Conditions of Closure: "+ claim.getClosureCond().getValue());
            	
            }
            					        }
		return claimInfo;
	}

}
