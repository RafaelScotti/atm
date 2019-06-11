package atm;

import ui.LoginMenu;
import ui.MainMenu;
import ui.Menu;

// ATM.java
// Represents an automated teller machine

public class ATM 
{
	private boolean userAuthenticated; // whether user is authenticated
	private int currentAccountNumber; // current user's account number
	private IKeypad keypad; // ATM's keypad
	private CashDispenser cashDispenser; // ATM's cash dispenser
	private DepositSlot depositSlot; // ATM's deposit slot
	private BankDatabase bankDatabase; // account information database
	private Menu mainMenu;
	private Menu loginMenu;

	// constants corresponding to main menu options
	private static final int BALANCE_INQUIRY = 1;
	private static final int WITHDRAWAL = 2;
	private static final int DEPOSIT = 3;
	private static final int EXIT = 4;

	// no-argument ATM constructor initializes instance variables
	public ATM() 
	{
		mainMenu = new Menu(new MainMenu());
		loginMenu = new Menu(new LoginMenu());
		
		userAuthenticated = false; // user is not authenticated to start
		currentAccountNumber = 0; // no current account number to start
		
		keypad = new Keypad(); // create keypad 
		cashDispenser = new CashDispenser(); // create cash dispenser
		depositSlot = new DepositSlot(); // create deposit slot
		bankDatabase = new BankDatabase(); // create acct info database
	} // end no-argument ATM constructor

	// start ATM 
	public void run()
	{
		// welcome and authenticate user; perform transactions
		while (true)
		{
			// loop while user is not yet authenticated
			while (!userAuthenticated) 
			{
			   System.out.println("Welcome!");
				authenticateUser(); // authenticate user
			} // end while

			performTransactions(); // user is now authenticated 
			userAuthenticated = false; // reset before next ATM session
			currentAccountNumber = 0; // reset before next ATM session 
			System.out.println("\nThank you! Goodbye!");
		} // end while   
	} // end method run

	// attempts to authenticate user against database
	private void authenticateUser() 
	{
		System.out.println("\nPlease enter your account number: ");
		int accountNumber = keypad.getInput(); // input account number
		System.out.println("\nEnter your PIN: "); // prompt for PIN
		int pin = keypad.getInput(); // input PIN

		// set userAuthenticated to boolean value returned by database
		userAuthenticated = 
				bankDatabase.authenticateUser(accountNumber, pin);

		// check whether authentication succeeded
		if (userAuthenticated)
		{
			currentAccountNumber = accountNumber; // save user's account #
		} 
		else
			System.out.println("Invalid account number or PIN. Please try again.");
	} 


	private void performTransactions() 
	{
		// local variable to store transaction currently being processed
		Transaction currentTransaction = null;

		boolean userExited = false; // user has not chosen to exit

		// loop while user has not chosen option to exit system
		while (!userExited)
		{     
			// show main menu and get user selection
			int mainMenuSelection = mainMenu.show();

			// decide how to proceed based on user's menu selection
			switch (mainMenuSelection){
			// user chose to perform one of three transaction types
				case BALANCE_INQUIRY: 
					currentTransaction = new BalanceInquiry(currentAccountNumber, bankDatabase);
					currentTransaction.execute();
					break;
				case WITHDRAWAL: 
					currentTransaction = new Withdrawal(currentAccountNumber, bankDatabase, cashDispenser);
					currentTransaction.execute();
					break;
				case DEPOSIT:
					currentTransaction = new Deposit(currentAccountNumber, bankDatabase, keypad, depositSlot);
					currentTransaction.execute();
					break;					
				case EXIT: // user chose to terminate session
					System.out.println("\nExiting the system...");
					userExited = true; // this ATM session should end
					break;
				default: // user did not enter an integer from 1-4
					System.out.println("\nYou did not enter a valid selection. Try again.");
					break;
			} // end switch
		} // end while
	} // end method performTransactions

	// display the main menu and return an input selection
//	private int displayMainMenu()
//	{
//		mainMenu.show();
//		return keypad.getInput(); // return user's selection
//	} // end method displayMainMenu
	
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