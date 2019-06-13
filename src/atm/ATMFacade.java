package atm;
// ATM.java
// Represents an automated teller machine

import atm.hardware.BankDatabase;
import atm.hardware.CashDispenser;
import atm.hardware.DepositSlot;
import atm.hardware.Keypad;
import atm.hardware.Screen;
import atm.transaction.BalanceInquiry;
import atm.transaction.Deposit;
import atm.transaction.Transaction;
import atm.transaction.Withdrawal;

public class ATMFacade 
{

	private BankDatabase bankDatabase; // account information database
	Session session;
	TransactionCreator transactionCreator;
	
	// no-argument ATM constructor initializes instance variables
	public ATMFacade()
	{
		this.bankDatabase = BankDatabase.getInstance();
	} 

	// start ATM 
	public void run()
	{
		// welcome and authenticate user; perform transactions
		while (true){
			session = new Session(bankDatabase);
			session.open();

			transactionCreator = new TransactionCreator(bankDatabase);
			transactionCreator.makeTransaction(session.getCurrentAccountNumber());
 
			session.close();
			
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