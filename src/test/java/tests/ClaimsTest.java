package tests;
import claims.*;
import claims.models.Claims;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class ClaimsTest {
	//Creates empty claim object
	Claims claim1 = new Claims(0, 0, 0, 0, null, null, null, null, null, null, null, false, false, false);
	//Creates filled object
	Claims claim2 = new Claims(2, 200, 210, 4, "Closed", LocalDate.parse("2023-10-20"), "6:00AM", "Giant concrete slab smashed rear passenger seats, no injuries", "Client was driving on highway 7, giant concrete slab fell from the sky, smashed car.", "$20000", "Made final payment, client satisfied", false, true, true);
	//Tests setting the claim information
	@Test
	void setClaimInfoTest() {
		claim1.setClaimID(1);
		claim1.setClientID(100);
		claim1.setAdvisorID(110);
		claim1.setPolicyID(2);
		claim1.setClaimStatus("Open");
		claim1.setDateFiled("2024-10-30");
		claim1.setAccidentTime("9:30AM");
		claim1.setDamage("Windshield cracked, bumper came off");
		claim1.setTotalled(false);
		claim1.setClosed(false);
		claim1.setAtFault(true);
		claim1.setPayInfo("$500");
		claim1.setDescription("Client rear-ended third party, third party has witnesses");
		claim1.setClosureCond(null);
		assertEquals(1, claim1.getClaimID());
		assertEquals(100, claim1.getClientID());
		assertEquals(110, claim1.getAdvisorID());
		assertEquals(2, claim1.getPolicyID());
		assertEquals("Open", claim1.getClaimStatus());
		assertEquals(LocalDate.parse("2024-10-30"), claim1.getDateFilled());
		assertEquals("9:30AM", claim1.getAccidentTime());
		assertEquals("Windshield cracked, bumper came off", claim1.getDamage());
		assertFalse(claim1.isTotalled());
		assertFalse(claim1.isClosed());
		assertTrue(claim1.isAtFault());
		assertEquals("$500", claim1.getPayInfo());
		assertEquals("Client rear-ended third party, third party has witnesses", claim1.getDescription());
		assertNull(claim1.getClosureCond());

	}

	// Tests getting the claim information
	@Test
	void getClaimInfoTest() {
		assertEquals(2, claim2.getClaimID());
		assertEquals(200, claim2.getClientID());
		assertEquals(210, claim2.getAdvisorID());
		assertEquals(4, claim2.getPolicyID());
		assertEquals("Closed", claim2.getClaimStatus());
		// assertEquals("2023-10-20", claim2.getDateFilled().getValue());
		assertEquals("6:00AM", claim2.getAccidentTime());
		assertEquals("Giant concrete slab smashed rear passenger seats, no injuries", claim2.getDamage());
		assertTrue(claim2.isTotalled());
		assertTrue(claim2.isClosed());
		assertFalse(claim2.isAtFault());
		assertEquals("$20000", claim2.getPayInfo());
		assertEquals("Client was driving on highway 7, giant concrete slab fell from the sky, smashed car.",
				claim2.getDescription());
		assertEquals("Made final payment, client satisfied", claim2.getClosureCond());

	}



}
