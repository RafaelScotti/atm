package atm;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import atm.hardware.CashDispenser;

class CashDispenserTest {

	@Test
	void testGetInstance() {
		CashDispenser cd = CashDispenser.getInstance();
		assertEquals(cd, CashDispenser.getInstance());
	}

	@Test
	void testDispenseCash() {
		
	}

	@Test
	void testIsSufficientCashAvailable() {
		CashDispenser cd = CashDispenser.getInstance();	
		//it starts with 500 bills
		assertEquals(true, cd.isSufficientCashAvailable(100));
	}

}
