package atm.transaction;
// Withdrawal.java
// Represents a withdrawal ATM transaction

import atm.hardware.BankDatabase;
import atm.hardware.CashDispenser;
import atm.hardware.Keypad;
import atm.hardware.Screen;

public class Withdrawal extends TransactionType
{
   private int amount; // amount to withdraw

   // constant corresponding to menu option to cancel
   private final static int CANCELED = 6;

   public Withdrawal(int userAccountNumber, 
      BankDatabase atmBankDatabase)
   {
      // initialize superclass variables
      super(userAccountNumber,  atmBankDatabase);
   } 

   @Override
   public void execute()
   {
      boolean cashDispensed = false; // cash was not dispensed yet
      double availableBalance; // amount available for withdrawal
 

      // loop until cash is dispensed or the user cancels
      do
      {
         // obtain a chosen withdrawal amount from the user 
         amount = displayMenuOfAmounts();
         
         // check whether user chose a withdrawal amount or canceled
         if (amount != CANCELED)
         {
            // get available balance of account involved
            availableBalance = 
            		getBankDatabase().getAvailableBalance(getAccountNumber());
      
            // check whether the user has enough money in the account 
            if (amount <= availableBalance)
            {   
               // check whether the cash dispenser has enough money
               if (CashDispenser.getInstance().isSufficientCashAvailable(amount))
               {
                  // update the account involved to reflect the withdrawal
                  getBankDatabase().debit(getAccountNumber(), amount);
                  
                  CashDispenser.getInstance().dispenseCash(amount); // dispense cash
                  cashDispensed = true; // cash was dispensed

                  Screen.getInstance().displayMessageLine("\nYour cash has been" +
                     " dispensed. Please take your cash now.");
               } // end if
               else // cash dispenser does not have enough cash
            	   Screen.getInstance().displayMessageLine(
                     "\nInsufficient cash available in the ATM." +
                     "\n\nPlease choose a smaller amount.");
            } // end if
            else // not enough money available in user's account
            {
            	Screen.getInstance().displayMessageLine(
                  "\nInsufficient funds in your account." +
                  "\n\nPlease choose a smaller amount."); 
            } // end else
         } // end if
         else // user chose cancel menu option 
         {
        	 Screen.getInstance().displayMessageLine("\nCanceling transaction...");
            return; // return to main menu because user canceled
         } // end else
      } while (!cashDispensed);

   } // end method execute

   // display a menu of withdrawal amounts and the option to cancel;
   // return the chosen amount or 0 if the user chooses to cancel
   private int displayMenuOfAmounts()
   {
      int userChoice = 0; // local variable to store return value

                       //
      
      // array of amounts to correspond to menu numbers
      int[] amounts = {0, 20, 40, 60, 100, 200};

      // loop while no valid choice has been made
      while (userChoice == 0)
      {
         // display the menu
    	  Screen.getInstance().displayMessageLine("\nWithdrawal Menu:");
    	  Screen.getInstance().displayMessageLine("1 - $20");
    	  Screen.getInstance().displayMessageLine("2 - $40");
    	  Screen.getInstance().displayMessageLine("3 - $60");
    	  Screen.getInstance().displayMessageLine("4 - $100");
    	  Screen.getInstance().displayMessageLine("5 - $200");
    	  Screen.getInstance().displayMessageLine("6 - Cancel transaction");
    	  Screen.getInstance().displayMessage("\nChoose a withdrawal amount: ");

         int input = Keypad.getInstance().getInput(); // get user input through keypad

         // determine how to proceed based on the input value
         switch (input)
         {
            case 1: // if the user chose a withdrawal amount 
            case 2: // (i.e., chose option 1, 2, 3, 4 or 5), return the
            case 3: // corresponding amount from amounts array
            case 4:
            case 5:
               userChoice = amounts[input]; // save user's choice
               break;       
            case CANCELED: // the user chose to cancel
               userChoice = CANCELED; // save user's choice
               break;
            default: // the user did not enter a value from 1-6
            	Screen.getInstance().displayMessageLine(
                  "\nInvalid selection. Try again.");
         } // end switch
      } // end while

      return userChoice; // return withdrawal amount or CANCELED
   } // end method displayMenuOfAmounts
} // end class Withdrawal




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