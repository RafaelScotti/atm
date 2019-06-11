package ui;

import atm.IKeypad;
import atm.Keypad;

public class WithdrawalMenu extends TipoMenu { 

	IKeypad keypad = new Keypad();

	
	@Override
	int show() {
		int userChoice = -1; // local variable to store return value



		// array of amounts to correspond to menu numbers
		int[] amounts = {0, 20, 40, 60, 100, 200};

		// loop while no valid choice has been made
		while (userChoice == -1)
		{
			// display the menu

			System.out.println("\nWithdrawal Menu:");
			System.out.println("1 - $20");
			System.out.println("2 - $40");
			System.out.println("3 - $60");
			System.out.println("4 - $100");
			System.out.println("5 - $200");
			System.out.println("0 - Cancel transaction");
			System.out.print("\nChoose a withdrawal amount: ");

			int input = keypad.getInput(); // get user input through keypad

			
			switch (input)
			{
			case 0: // the user chose to cancel
				userChoice = 0; // save user's choice
				break;
			case 1: // if the user chose a withdrawal amount 
			case 2: // (i.e., chose option 1, 2, 3, 4 or 5), return the
			case 3: // corresponding amount from amounts array
			case 4:
			case 5:
				userChoice = amounts[input]; // save user's choice
				break;       
			
			default: // the user did not enter a value from 1-6
				System.out.println("\nInvalid selection. Try again.");
			} 
		} 

		return userChoice; // return withdrawal amount or CANCELED
	} // end method displayMenuOfAmount

}


