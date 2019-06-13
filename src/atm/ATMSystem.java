package atm;

import atm.transaction.BalanceInquiry;
import atm.transaction.Deposit;
import atm.transaction.Transaction;
import atm.transaction.Withdrawal;

public class ATMSystem {
	public ATMSystem() {
		
		Hardware keypad = new Hardware();
		
		Screen screen = Screen.getInstance();
		//Keypad keypad = Keypad.getInstance();
		CashDispenser cashDispenser = CashDispenser.getInstance(); 
		DepositSlot depositSlot = DepositSlot.getInstance(); 
		BankDatabase bankDatabase = new BankDatabase();
		
	}
	
	
	
	private void performBalance(int currentAccountNumber, BankDatabase bd, Screen screen) {
		Transaction balance = new Transaction(new BalanceInquiry(currentAccountNumber, bd, screen));
		balance.execute();
	}
	
	private void performDeposit(int currentAccountNumber, Keypad keypad, BankDatabase bankDatabase, DepositSlot depositSlot, Screen screen) {
		Transaction deposit = new Transaction(new Deposit(currentAccountNumber, keypad, bankDatabase, depositSlot, screen));
		deposit.execute();
	}
	
	private void performWithdraw(int currentAccountNumber, BankDatabase bankDatabase, Keypad keypad, CashDispenser cashDispenser, Screen screen) {
		Transaction withdraw = new Transaction(new Withdrawal(currentAccountNumber, bankDatabase, keypad, cashDispenser, screen));
		withdraw.execute();
	}
	
	
private void performTransactions() {
		

		boolean userExited = false; // user has not chosen to exit

		while (!userExited)
		{     
			//SHOW MENU
			ATMMenu.display();
			int mainMenuSelection = ATMMenu.getOption(keypad); //keypad.getInput();

			switch (mainMenuSelection){

			case 1: 
				performBalance(currentAccountNumber, bd, screen);
				break; 
			case 2: 
				withdraw.execute();
				break; 
			case 3:
				
				break; 
			case 4: // user chose to terminate session
				System.out.println("\nExiting the system...");
				userExited = true; // this ATM session should end
				break;
			default: 
				System.out.println(
						"\nYou did not enter a valid selection. Try again.");
				break;
			} 
		} // end while
	} 
	
	
}
