package atm;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CashDispenserTest {

	@Test
	void testGetInstance() {
		CashDispenser cd = CashDispenser.getInstance();
		assertEquals(cd, CashDispenser.getInstance());
	}

	@Test
	void testDispenseCash() {
		int amount = 40;
		int billsRequired = amount/20;
		assertEquals(2, billsRequired);
	}

	@Test
	void testIsSufficientCashAvailable() {
//		int amount = 20;
//		int count
	}

}
