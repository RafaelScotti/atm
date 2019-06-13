package atm.transaction;
// BalanceInquiry.java
// Represents a balance inquiry ATM transaction

import atm.BankDatabase;
import atm.hardware.Screen;

public class BalanceInquiry extends TransactionType
{

   public BalanceInquiry(int userAccountNumber, 
      BankDatabase atmBankDatabase)
   {
      super(userAccountNumber, atmBankDatabase);
      
   } // end BalanceInquiry constructor

   // performs the transaction
   @Override
   public void execute() {
      double availableBalance = getBankDatabase().getAvailableBalance(getAccountNumber());
      double totalBalance = getBankDatabase().getTotalBalance(getAccountNumber());
      
      // display the balance information on the screen
      Screen.getInstance().displayMessageLine("\nBalance Information:");
      Screen.getInstance().displayMessage(" - Available balance: "); 
      Screen.getInstance().displayDollarAmount(availableBalance);
      Screen.getInstance().displayMessage("\n - Total balance:     ");
      Screen.getInstance().displayDollarAmount(totalBalance);
      Screen.getInstance().displayMessageLine("");
   } // end method execute
   
   
} // end class BalanceInquiry



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