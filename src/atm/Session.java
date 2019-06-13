package atm;

import atm.hardware.BankDatabase;
import atm.hardware.Keypad;
import atm.hardware.Screen;

public class Session {

	private BankDatabase db;
	private boolean userAuthenticated = false;
	private int currentAccountNumber = 0;

	public Session(BankDatabase db) {
		this.db = db;
	}

	void open() {
		login();
	}

	void close() {
		this.currentAccountNumber = 0;
		this.userAuthenticated = false;
		Screen.getInstance().displayMessageLine("\nThank you! Goodbye!");
	}
	
	
	public void login() {
		while (!userAuthenticated) {
			Screen.getInstance().displayMessageLine("\nWelcome!"); 

			Screen.getInstance().displayMessage("\nPlease enter your account number: ");
			int accountNumber = Keypad.getInstance().getInput();

			Screen.getInstance().displayMessage("\nEnter your PIN: ");
			int pin = Keypad.getInstance().getInput();

			userAuthenticated = db.authenticateUser(accountNumber, pin);

			if (userAuthenticated) {
				this.currentAccountNumber = accountNumber; 
			} // end if
			else
				Screen.getInstance().displayMessageLine("Invalid account number or PIN. Please try again.");
		}
		
	}

	public int getCurrentAccountNumber() {
		return this.currentAccountNumber;
	}
	

}
