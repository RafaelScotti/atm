package atm;
// Withdrawal.java
// Represents a withdrawal ATM transaction
import ui.WithdrawalMenu;
import ui.Menu;

public class Withdrawal extends Transaction
{
	Menu withdrawalMenu = new Menu(new WithdrawalMenu());

	
   private int amount; // amount to withdraw
   private CashDispenser cashDispenser; // reference to cash dispenser

   // constant corresponding to menu option to cancel
   private final static int CANCELED = 0;

   // Withdrawal constructor
   public Withdrawal(int userAccountNumber, 
      BankDatabase atmBankDatabase, 
      CashDispenser atmCashDispenser)
   {
      // initialize superclass variables
      super(userAccountNumber, atmBankDatabase);
      
      // initialize references to keypad and cash dispenser
      
      cashDispenser = atmCashDispenser;
   } // end Withdrawal constructor

   // perform transaction
   @Override
   public void execute()
   {
      boolean cashDispensed = false; // cash was not dispensed yet
      double availableBalance; // amount available for withdrawal

      // get references to bank database and screen
      BankDatabase bankDatabase = getBankDatabase(); 
      

      // loop until cash is dispensed or the user cancels
      do
      {
         // obtain a chosen withdrawal amount from the user 
         amount = withdrawalMenu.show();
         
         // check whether user chose a withdrawal amount or canceled
         if (amount != CANCELED)
         {
            // get available balance of account involved
            availableBalance = 
               bankDatabase.getAvailableBalance(getAccountNumber());
      
            // check whether the user has enough money in the account 
            if (amount <= availableBalance)
            {   
               // check whether the cash dispenser has enough money
               if (cashDispenser.isSufficientCashAvailable(amount))
               {
                  // update the account involved to reflect the withdrawal
                  bankDatabase.debit(getAccountNumber(), amount);
                  
                  cashDispenser.dispenseCash(amount); // dispense cash
                  cashDispensed = true; // cash was dispensed

                  // instruct user to take cash
                  
                  System.out.println("\nYour cash has been" +
                     " dispensed. Please take your cash now.");
               } // end if
               else // cash dispenser does not have enough cash
            	   System.out.println(
                     "\nInsufficient cash available in the ATM." +
                     "\n\nPlease choose a smaller amount.");
            } // end if
            else // not enough money available in user's account
            {
            	System.out.println(
                  "\nInsufficient funds in your account." +
                  "\n\nPlease choose a smaller amount."); 
            } // end else
         } // end if
         else // user chose cancel menu option 
         {
        	 System.out.println("\nCanceling transaction...");
            return; // return to main menu because user canceled
         } // end else
      } while (!cashDispensed);
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