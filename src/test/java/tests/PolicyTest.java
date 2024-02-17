package tests;
import claims.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class PolicyTest {

	@Test
	void test1() {
		Policy a = new Policy();
		String expected = "PolicyID: 0\nClientID: 0\nVehicleID: 0\nPolicyNumber: 0\nStart Date: "
				+ "\nEnd Date: \nCoverage Type: "
				+ "\nPolicy Status: \nPremium: 0.0\nDeductible: 0.0";
		String result = a.toString();
		assertEquals(expected, result);
		
	}
	
	@Test
	void test2() {
		Policy a = new Policy(12345, 01, "Full", "Active", 75.75);
		String expected = "PolicyID: 12345\nClientID: 0\nVehicleID: 0\nPolicyNumber: 1\nStart Date: "
				+ "\nEnd Date: \nCoverage Type: Full"
				+ "\nPolicy Status: Active\nPremium: 75.75\nDeductible: 0.0";
		String result = a.toString();
		assertEquals(expected, result);
		
	}
	
	@Test
	void test3() {
		Policy a = new Policy(12345, 01, "Full", "Active", 75.75);
		a.setPolicyID(8972);
		a.setCoverageType("Half");
		
		String expected = "PolicyID: 8972\nClientID: 0\nVehicleID: 0\nPolicyNumber: 1\nStart Date: "
				+ "\nEnd Date: \nCoverage Type: Half"
				+ "\nPolicy Status: Active\nPremium: 75.75\nDeductible: 0.0";
		String result = a.toString();
		assertEquals(expected, result);
		
	}
	
	@Test
	void test4() {
		Policy a = new Policy(98263, 18, "Half", "Inactive", 21.92);
		a.setDeductible(829.03);
		a.setClientID(11223);
		
		String expected = "PolicyID: 98263\nClientID: 11223\nVehicleID: 0\nPolicyNumber: 18\nStart Date: "
				+ "\nEnd Date: \nCoverage Type: Half"
				+ "\nPolicy Status: Inactive\nPremium: 21.92\nDeductible: 829.03";
		String result = a.toString();
		assertEquals(expected, result);
		
	}
	
	@Test
	void test5() {
		Policy a = new Policy(98665, 8, "Half", "Active", 82.09);
		Policy b = new Policy(a.getPolicyID(), a.getPolicyNumber(), a.getCoverageType(),a.getPolicyStatus(),a.getPremium());
		b.setPolicyID(98765);
		b.setClientID(13579);
		b.setVehicleID(24680);
		b.setStartDate("17/08/2019");
		b.setEndDate("9/04/2022");
		b.setCoverageType("Full");
		b.setDeductible(12.01);
		
		String expected = "PolicyID: 98765\nClientID: 13579\nVehicleID: 24680\nPolicyNumber: 8\nStart Date: 17/08/2019"
				+ "\nEnd Date: 9/04/2022\nCoverage Type: Full"
				+ "\nPolicy Status: Active\nPremium: 82.09\nDeductible: 12.01";
		String result = b.toString();
		assertEquals(expected, result);
		
	}
	
	
	

}
