package atm;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BankDatabaseTest {

	@Test
	void testBankDatabase() {
		//fail("Not yet implemented");
		
	}

	@Test
	void testAuthenticateUser() {
		BankDatabase bd = new BankDatabase();
		assertEquals(true, bd.authenticateUser(12345, 54321));
		assertEquals(false, bd.authenticateUser(11111, 54321));
	}

	@Test
	void testGetAvailableBalance() {
		BankDatabase bd = new BankDatabase();
		assertEquals(1000, bd.getAvailableBalance(12345));
	}

	@Test
	void testGetTotalBalance() {
		BankDatabase bd = new BankDatabase();
		assertEquals(1200, bd.getTotalBalance(12345));
	}

	@Test
	void testCredit() {
		BankDatabase bd = new BankDatabase();
		double availableNow = bd.getAvailableBalance(12345);
		double totalNow = bd.getTotalBalance(12345);
		bd.credit(12345, 100); // 10000 = 100.00
		assertEquals(availableNow, bd.getAvailableBalance(12345));
		assertEquals(totalNow + 100, bd.getTotalBalance(12345));
	}

	@Test
	void testDebit() {
		BankDatabase bd = new BankDatabase();
		double availableNow = bd.getAvailableBalance(12345);
		double totalNow = bd.getTotalBalance(12345);
		bd.debit(12345, 100);
		assertEquals(availableNow - 100, bd.getAvailableBalance(12345));
		assertEquals(totalNow - 100, bd.getTotalBalance(12345));
	}

}
