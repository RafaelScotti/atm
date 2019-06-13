package atm.transaction;
// Transaction.java
// Abstract superclass Transaction represents an ATM transaction

import atm.BankDatabase;
import atm.Screen;

public abstract class TransactionType
{
	private int accountNumber;
	private BankDatabase bankDatabase; 
	private Screen screen;

	public TransactionType(int userAccountNumber, BankDatabase atmBankDatabase, Screen atmScreen)
	{
		accountNumber = userAccountNumber;
		bankDatabase = atmBankDatabase;
		this.screen = atmScreen;
	} 


	public int getAccountNumber()
	{
		return accountNumber; 
	}


	public Screen getScreen() {
		return screen;
	}


	public BankDatabase getBankDatabase()
	{
		return bankDatabase;
	} 


	abstract public void execute();
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