package tests;


import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import claims.*;
import claims.models.Claims;

import org.junit.jupiter.api.Test;

class ClaimsStubDBTest {
	//Creates new empty claim to be set
	Claims claim1 = new Claims(0, 0, 0, 0, null, null, null, null, null, null, null, false, false, false);
	//Tests the addition and removal of claims from the database
	@Test
	void shouldAddandRemoveClaimstoDB() {
		// Sets claim information
		claim1.setClaimID(1);
		claim1.setClientID(100);
		claim1.setAdvisorID(110);
		claim1.setPolicyID(2);
		claim1.setClaimStatus("Closed");
		claim1.setDateFiled("2024-10-01");
		claim1.setAccidentTime("9:30AM");
		claim1.setDamage("Windshield cracked, bumper came off");
		claim1.setTotalled(false);
		claim1.setAtFault(true);
		claim1.setPayInfo("$500");
		claim1.setDescription("Client rear-ended third party, " + "third party has witnesses");
		claim1.setClosed(true);
		claim1.setClosureCond("Made final Payment");
		ClaimsStubDB.addClaim(claim1);
		assertEquals(
				"Claim ID: " + claim1.getClaimID() + "\n" +
						"Client ID: " + claim1.getClientID() + "\n" +
						"Advisor ID: " + claim1.getAdvisorID() + "\n" +
						"Policy ID: " + claim1.getPolicyID() + "\n" +
						"Current Claim Status: " + claim1.getClaimStatus() + "\n" +
						"Claim Date: " + claim1.getDateFilled() + "\n" +
						"Time of Accident: " + claim1.getAccidentTime() + "\n" +
						"Vehicle Damages: " + claim1.getDamage() + "\n" +
						"Write-off: " + claim1.isTotalled() + "\n" +
						"Driver at Fault: " + claim1.isAtFault() + "\n" +
						"Payment Status: " + claim1.getPayInfo() + "\n" +
						"Accident Description: " + claim1.getDescription() + "\n" +
						"Claim Closed: " + claim1.isClosed() + "\n" +
						"Conditions of Closure: " + claim1.getClosureCond() + "\n",

				ClaimsStubDB.readClaimInfo());

		ClaimsStubDB.removeClaim(claim1);

		assertEquals("", ClaimsStubDB.readClaimInfo());
	}

	
}
