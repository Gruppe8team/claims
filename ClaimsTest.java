import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ClaimsTest {

	Claims claim1 = new Claims(1, 100 , 110, 2, "Open", "01/08/24", 
			"9:30AM", "Windshield cracked, bumper came off", "Client rear-ended third party, "
					+"third party has witnesses", "$500", null, true, false, false);

	Claims claim2 = new Claims(2, 200 , 210, 4, "Closed", "12/15/23", 
			"6:00AM", "Giant concrete slab smashed rear passenger seats, no injuries", 
			"Client was driving on highway 7, giant concrete slab fell from the sky, smashed car."
			, "$20000", "Made final payment, client satisfied", false, true, true);

	@Test
	void shouldAddandRemoveClaimstoDB() {
		claim1.setClaimID(1);
		claim1.setClientID(100);
		claim1.setAdvisorID(110);
		claim1.setPolicyID(2);
		claim1.setClaimStatus("Open");
		claim1.setDateFilled("01/08/24");
		claim1.setAccidentTime("9:30AM");
		claim1.setDamage("Windshield cracked, bumper came off");
		claim1.setTotalled(false);
		claim1.setClosed(false);
		claim1.setAtFault(true);
		claim1.setPayInfo("$500");
		claim1.setDescription("Client rear-ended third party, "+"third party has witnesses");
		claim1.setClosed(false);
		claim1.setClosureCond(null);
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
						"Driver at Fault: "+ claim1.isAtFault() + "\n" +
						"Payment Status: "+ claim1.getPayInfo() + "\n" +
						"Accident Description: "+ claim1.getDescription() + "\n" +
						"Claim Closed: "+ claim1.isClosed() + "\n"
						, ClaimsStubDB.readClaimInfo());

		ClaimsStubDB.removeClaim(claim1);
		assertEquals("", ClaimsStubDB.readClaimInfo());
	}



}
