package atm;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class AccountTest {

	Account acc;

	@Test
	void testAccount() {
		fail("not yet implemented");
	}

	@Test
	void testValidatePIN() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAvailableBalance() {
		acc = new Account(12345, 54321, 1000, 1200);
		assertEquals(1000, acc.getAvailableBalance());
	}

	@Test
	void testGetTotalBalance() {
		acc = new Account(12345, 54321, 1000, 1200);
		assertEquals(1200, acc.getTotalBalance());
	}

	@Test
	void testCredit() {
		acc = new Account(12345, 54321, 1000, 1200);
		acc.credit(100);
		assertEquals(1000, acc.getAvailableBalance());
		assertEquals(1300, acc.getTotalBalance());
	}

	@Test
	void testDebit() {
		acc = new Account(12345, 54321, 1000, 1200);
		acc.debit(100);
		assertEquals(900, acc.getAvailableBalance());
		assertEquals(1100, acc.getTotalBalance());
	}

	@Test
	void testGetAccountNumber() {
		acc = new Account(12345, 54321, 1000, 1200);
		assertEquals(12345, acc.getAccountNumber());
	}

}
