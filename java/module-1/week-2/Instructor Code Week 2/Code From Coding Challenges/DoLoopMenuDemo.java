/*
 Demonstrates an application of the Do-While Loop, 
 Specifically the retrieval of a valid input 
*/

import java.util.Scanner;

public class DoLoopMenuDemo {

 public static void main(String args[]) {
  
     int userChoice = 0;
     Scanner sc = new Scanner (System.in);
 
     do
     {   
         System.out.println ("Welcome to McATM");
         System.out.println ("*** MENU ***");
         System.out.println ("1) Withdrawal");  
         System.out.println ("2) Deposit");
         System.out.println  ("3) Check Balance");
         System.out.println ("4) Transfer Funds");
         System.out.println ("5) Quit ");
         
         System.out.print ("Please enter a valid choice (1-5)");
         userChoice = sc.nextInt();
         
         if (userChoice < 1 || userChoice > 5)
             System.out.println ("\nINVALID ENTRY, please try again");
     
     }while (userChoice < 1 || userChoice > 5);
     
     // user can only get here by entering a valid option
     
     // insert code that responds to options 1-5 appropriately 
     
     System.out.println ("Thanks for dropping by.  We'll add that feature later.");
 }
}
