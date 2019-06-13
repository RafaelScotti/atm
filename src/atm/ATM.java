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

	// no-argument ATM constructor initializes instance variables
	public ATM()
	{
		userAuthenticated = false; // user is not authenticated to start
		currentAccountNumber = 0; // no current account number to start

		screen = Screen.getInstance();
		keypad = Keypad.getInstance(); 
		cashDispenser = CashDispenser.getInstance(); 
		depositSlot = DepositSlot.getInstance(); 
		bankDatabase = new BankDatabase();
	} 

	// start ATM 
	public void run()
	{
		// welcome and authenticate user; perform transactions
		while (true){
			// loop while user is not yet authenticated
			login();
			performTransactions(); // user is now authenticated 
			userAuthenticated = false; // reset before next ATM session
			currentAccountNumber = 0; // reset before next ATM session 
			screen.displayMessageLine("\nThank you! Goodbye!");
		} 
	} 


	public void login() {
		while (!userAuthenticated) {
			screen.displayMessageLine("\nWelcome!"); 
			authenticateUser();
		}
	}


	private void authenticateUser() {

		screen.displayMessage("\nPlease enter your account number: ");
		int accountNumber = keypad.getInput(); // input account number
		screen.displayMessage("\nEnter your PIN: "); // prompt for PIN
		int pin = keypad.getInput(); // input PIN

		userAuthenticated = bankDatabase.authenticateUser(accountNumber, pin);

		if (userAuthenticated) {
			currentAccountNumber = accountNumber; // save user's account #
		} // end if
		else
			screen.displayMessageLine("Invalid account number or PIN. Please try again.");
	} 

	
	

} // end class ATM



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