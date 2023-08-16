/*
        MagicEightBall.java
        Casey McCullough
        Provides helpful feedback on yes-no questions asked by the user!
        v 1.0, lots of room for improvement!
*/

import java.util.Scanner;
import java.util.Random;

public class MagicEightBall {

    final static int NUMBER_OF_MESSAGES = 4;

    public static void main(String args[]) {

        Random generator = new Random();
        Scanner sc = new Scanner (System.in);
        String userInput;
        int randomNumber;
        String response;

        System.out.println("WELCOME TO THE MAGIC EIGHT BALL SIMULATOR 1.0!!");
        System.out.println ("Full of sage advice for those too cheap to buy an actual Magic Eight Ball!");
        System.out.print("\nI see that you have travelled far to get here.  \nPlease enter your question: ");

        userInput = sc.nextLine();
        System.out.print("\""+ userInput + "\"" + " . . . let me see . . .  \n\n");
        randomNumber = generator.nextInt(NUMBER_OF_MESSAGES);

        if (randomNumber == 0) {
            response = "Outlook Good";
        } else if (randomNumber == 1) {
            response = "Don't Count On It";
        } else if (randomNumber == 2) {
            response = "It Is Certain";
        } else if (randomNumber == 3) {
            response = "Reply Hazy, Try Again";
        } else // should not be possible if generating # 0-4.
        {
            response = "You seem to have broken your Magic Eight Ball. A curse upon your house!";
        }
        System.out.println (response);

    }

}


