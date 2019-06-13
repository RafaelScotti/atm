package atm.menu;

import atm.hardware.Screen;

public class ATMMenu {
	
	public static void display() {
		Screen.getInstance().displayMessageLine("\nMain menu:");
		Screen.getInstance().displayMessageLine("1 - View my balance");
		Screen.getInstance().displayMessageLine("2 - Withdraw cash");
		Screen.getInstance().displayMessageLine("3 - Deposit funds");
		Screen.getInstance().displayMessageLine("4 - Exit\n");
		
	}

}
