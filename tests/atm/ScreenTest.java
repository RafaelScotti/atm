package atm;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ScreenTest {

	@Test
	void testGetInstance() {
		Screen s = Screen.getInstance();
		assertEquals(s, Screen.getInstance());
	}
	

	@Test
	void testDisplayDollarAmount() {
		//fail("Not yet implemented");
	}

}
