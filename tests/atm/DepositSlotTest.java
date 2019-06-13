package atm;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import atm.hardware.DepositSlot;

class DepositSlotTest {

	@Test
	void testGetInstanse() {
		DepositSlot ds = DepositSlot.getInstance();
		assertEquals(ds, DepositSlot.getInstance());
	}

	@Test
	void testIsEnvelopeReceived() {
		DepositSlot ds = DepositSlot.getInstance();
		assertEquals(true, ds.isEnvelopeReceived());
	}

}
