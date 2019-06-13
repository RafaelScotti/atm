package atm;

public class Session {

	private BankDatabase db;
	private Screen screen;
	private Keypad keypad;

	private boolean userAuthenticated = false;
	private int currentAccountNumber = 0;

	public Session(BankDatabase db, Screen screen, Keypad keypad) {
		this.db = db;
		this.screen = screen;
		this.keypad = keypad;
	}

	void open() {
		login();
	}

	void close() {
		this.currentAccountNumber = 0;
		this.userAuthenticated = false;
	}
	
	
	public void login() {
		while (!userAuthenticated) {
			screen.displayMessageLine("\nWelcome!"); 

			screen.displayMessage("\nPlease enter your account number: ");
			int accountNumber = keypad.getInput(); // input account number

			screen.displayMessage("\nEnter your PIN: "); // prompt for PIN
			int pin = keypad.getInput(); // input PIN

			userAuthenticated = db.authenticateUser(accountNumber, pin);

			if (userAuthenticated) {
				this.currentAccountNumber = accountNumber; // save user's account #
			} // end if
			else
				screen.displayMessageLine("Invalid account number or PIN. Please try again.");
		}
		
	}

	public int getCurrentAccountNumber() {
		return this.currentAccountNumber;
	}
	

}
