package claims;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

public class ClaimsTest {


		Claims claim1 = new Claims(1, 100 , 110, 2, "Open", "01/08/24", 
				"9:30AM", "Windshield cracked, bumper came off", "Client rear-ended third party, "
						+"third party has witnesses", "$500", null, true, false, false);
		Claims claim2 = new Claims(2, 200 , 210, 4, "Closed", "12/15/23", 
				"6:00AM", "Giant concrete slab smashed rear passenger seats, no injuries", 
				"Client was driving on highway 7, giant concrete slab fell from the sky, smashed car."
						, "$20000", "Made final payment, client satisfied", false, true, true);
		Claims claim3 = new Claims();
	
		@Test
		void shouldGetClaimInfo(){
			
			assertEquals(1, claim1.getClaimID());
			assertEquals(100, claim1.getClientID());
			assertEquals(110, claim1.getAdvisorID());
			assertEquals(2, claim1.getPolicyID());
			assertEquals("Open", claim1.getClaimStatus());
			assertEquals("01/08/24", claim1.getDateFilled());
			assertEquals("9:30AM", claim1.getAccidentTime());
			assertEquals("Windshield cracked, bumper came off", claim1.getDamage());
			assertEquals(false, claim1.isTotalled());
			assertEquals(true, claim1.isAtFault());
			assertEquals("$500", claim1.getPayInfo());
			assertEquals("Client rear-ended third party, third party has witnesses", claim1.getDescription());
			assertEquals(false, claim1.isClosed());
			assertEquals(null,claim1.getClosureCond());
			
			assertEquals(2, claim2.getClaimID());
			assertEquals(200, claim2.getClientID());
			assertEquals(210, claim2.getAdvisorID());
			assertEquals(4, claim2.getPolicyID());
			assertEquals("Closed", claim2.getClaimStatus());
			assertEquals("12/15/23", claim2.getDateFilled());
			assertEquals("6:00AM", claim2.getAccidentTime());
			assertEquals("Giant concrete slab smashed rear passenger seats, no injuries", claim2.getDamage());
			assertEquals(true, claim2.isTotalled());
			assertEquals(false, claim2.isAtFault());
			assertEquals("$20000", claim2.getPayInfo());
			assertEquals("Client was driving on highway 7, giant concrete slab fell from the sky, smashed car.", claim2.getDescription());
			assertEquals(true, claim2.isClosed());
			assertEquals("Made final payment, client satisfied",claim2.getClosureCond());
		}
		
		@Test
		void shouldSetClaimInfo(){
			
			claim3.setClaimID(3);
			claim3.setClientID(300);
			claim3.setAdvisorID(310);
			claim3.setPolicyID(6);
			claim3.setClaimStatus("Open");
			claim3.setDateFilled("02/03/24");
			claim3.setAccidentTime("7:45PM");
			claim3.setDamage("Dents in car doors driver side");
			claim3.setTotalled(false);
			claim3.setAtFault(false);
			claim3.setPayInfo("$3000");
			claim3.setDescription("T-boned by SUV");
			claim3.setClosed(false);
			claim3.setClosureCond(null);
			
			assertEquals(3, claim3.getClaimID());
			assertEquals(300, claim3.getClientID());
			assertEquals(310, claim3.getAdvisorID());
			assertEquals(6, claim3.getPolicyID());
			assertEquals("Open", claim3.getClaimStatus());
			assertEquals("02/03/24", claim3.getDateFilled());
			assertEquals("7:45PM", claim3.getAccidentTime());
			assertEquals("Dents in car doors driver side", claim3.getDamage());
			assertEquals(false, claim3.isTotalled());
			assertEquals(false, claim3.isAtFault());
			assertEquals("$3000", claim3.getPayInfo());
			assertEquals("T-boned by SUV", claim3.getDescription());
			assertEquals(false, claim3.isClosed());
			assertEquals(null,claim3.getClosureCond());
			
		}

}
