package atm;
// ATM.java
// Represents an automated teller machine

import atm.transaction.BalanceInquiry;
import atm.transaction.Deposit;
import atm.transaction.Transaction;
import atm.transaction.Withdrawal;

public class ATM 
{
	private boolean userAuthenticated; // whether user is authenticated
	private int currentAccountNumber; // current user's account number

	private Screen screen; // ATM's screen
	private Keypad keypad; // ATM's keypad
	private CashDispenser cashDispenser; // ATM's cash dispenser
	private DepositSlot depositSlot; // ATM's deposit slot
	private BankDatabase bankDatabase; // account information database

	private Transaction balance;
	private Transaction deposit;
	private Transaction withdraw;

	Session session;

	// no-argument ATM constructor initializes instance variables
	public ATM()
	{
		userAuthenticated = false; // user is not authenticated to start
		currentAccountNumber = 0; // no current account number to start
		screen = Screen.getInstance();
		keypad = Keypad.getInstance(); 
		cashDispenser = CashDispenser.getInstance(); 
		depositSlot = DepositSlot.getInstance(); 
		bankDatabase = BankDatabase.getInstance();

	} 

	// start ATM 
	public void run()
	{
		// welcome and authenticate user; perform transactions
		while (true){
			session = new Session(bankDatabase, screen, keypad);
			session.open();

			this.currentAccountNumber = session.getCurrentAccountNumber();
			

			balance = new Transaction(new BalanceInquiry(currentAccountNumber, bankDatabase, screen));
			deposit = new Transaction(new Deposit(currentAccountNumber, keypad, bankDatabase, depositSlot, screen));
			withdraw = new Transaction(new Withdrawal(currentAccountNumber, bankDatabase, keypad, cashDispenser, screen));


			performTransactions(); // user is now authenticated 

			this.userAuthenticated = false; // reset before next ATM session
			currentAccountNumber = 0; // reset before next ATM session 

			session.close();
			screen.displayMessageLine("\nThank you! Goodbye!");
		} 
	} 


	private void performTransactions() {

		boolean userExited = false; // user has not chosen to exit
		
		while (!userExited)	{     
			ATMMenu.display();
			int mainMenuSelection = ATMMenu.getOption(keypad); //keypad.getInput();

			switch (mainMenuSelection){

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

} 



/**************************************************************************
 * (C) Copyright 1992-2014 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/