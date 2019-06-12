package atm;

import atm.transaction.Transaction;

public class ATMMenu {
	
	private static final int balance = 1;
	private static final int withdraw = 2;
	private static final int deposit = 3;
	private static final int exit = 4;

	public static void display() {
		System.out.println("\nMain menu:");
		System.out.println("1 - View my balance");
		System.out.println("2 - Withdraw cash");
		System.out.println("3 - Deposit funds");
		System.out.println("4 - Exit\n");
		
		
	}
	
	public static int getOption(Keypad k) {
		System.out.println("Enter a choice: ");
		
		switch (k.getInput()) {
		case 1:
			return balance;
		case 2:
			return withdraw;
		case 3:
			return deposit;
		case 4: 
			return exit;
		default:
			return -1;
			
		}	
	}
	
	public static int perform(Keypad k, Transaction t) {
		System.out.println("Enter a choice: ");
		
		switch (k.getInput()) {
		case balance:
			t.execute();
		case 2:
			return withdraw;
		case 3:
			return deposit;
		case 4: 
			return exit;
		default:
			return -1;
			
		}	
	}
	

}
