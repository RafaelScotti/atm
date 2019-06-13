package atm;

import atm.hardware.Keypad;
import atm.menu.ATMMenu;
import atm.transaction.BalanceInquiry;
import atm.transaction.Deposit;
import atm.transaction.Transaction;
import atm.transaction.Withdrawal;

public class TransactionCreator {
	Transaction balance;
	Transaction deposit;
	Transaction withdraw;
	BankDatabase db;
	public TransactionCreator(BankDatabase bankDatabase) {
		db = BankDatabase.getInstance();
	}
	
	
	public void makeTransaction(int accountNumber) {
		
		boolean userExited = false;
		
		while(!userExited) {
			
			ShowTransactionOptions();
			
			 balance = new Transaction(new BalanceInquiry(accountNumber, db));
			 withdraw = new Transaction(new Withdrawal(accountNumber, db));
			 deposit = new Transaction(new Deposit(accountNumber, db));

			switch (getTransactionOption()){

			case 1: 
				balance.execute();
				break; 
			case 2: 
				withdraw.execute();
				break; 
			case 3:
				deposit.execute();
				break; 
			case 4: 
				System.out.println("\nExiting the system...");
				userExited = true;
				break;
			default: 
				System.out.println("\nYou did not enter a valid selection. Try again.");
				break;
			} 
		}
		
	}
	
	private void ShowTransactionOptions() {
		ATMMenu.display();
	}
	
	private int getTransactionOption() {
		return Keypad.getInstance().getInput();
	}
		
}

	

