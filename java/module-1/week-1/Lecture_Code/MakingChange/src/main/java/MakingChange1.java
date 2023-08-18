/**
 MakingChange1.java
 Casey McCullough
 6/28/19
 Converts a given number of cents into equivalent change (in dollars, quarters, etc.)
*/

import java.util.Scanner; 

public class MakingChange1 {

    public static void main (String[] args){

        double value;
        int cents;
        int dollars, quarters, dimes, nickels, pennies;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print ("What is the value in dollars? "); 
        value = sc.nextDouble(); 
        
        // puts in int format as cents
        cents = (int) (value * 100); // 12.51 --> 1251.0 --> 1251
        dollars = cents / 100; // 1251 / 100 --> 12
        //cents = cents - dollars * 100; // 1251 - 12 * 100 = 1251 - 1200 = 51
        cents = cents % 100; // 1251 % 100
        
        // identify values for each currency type
        dollars = cents / 100;
        cents %= 100;
        
        quarters = cents / 25;
        cents %= 25;
        
        dimes = cents / 10;
        cents %= 10;
        
        nickels = cents / 5;
        cents %= 5;
        
        pennies = cents;
        
        // share results with proper grammar
        System.out.println ("Results: "); 
        
        if (dollars > 0)
        {
          System.out.print (dollars);
          if (dollars == 1)
          {
            System.out.println (" dollar");
          }
          else
          {
            System.out.println (" dollars");
          }
        }
        
        if (quarters > 0)
        {
          System.out.print (quarters);
          if (quarters == 1)
          {
            System.out.println (" quarter");
          }
          else
          {
            System.out.println (" quarters");
          }
        }
        
        if (dimes > 0)
        {
          System.out.print (dimes);
          if (dimes == 1)
          {
            System.out.println (" dime");
          }
          else
          {
            System.out.println (" dimes");
          }
        }
        
        if (nickels > 0)
        {
          System.out.print (nickels);
          if (nickels == 1)
            System.out.println (" nickel");
          else
            System.out.println (" nickels");
        }
        
        if (pennies > 0)
        {
          System.out.print (pennies);
          if (pennies == 1)
          {
            System.out.println (" penny");
          }
          else
          {
            System.out.println (" pennies");
          }
        }
              

    } // End main

} // End MakingChange1