/*
        MagicEightBall.java
        Casey McCullough
        Provides helpful feedback on yes-no questions asked by the user!
*/

import java.util.Scanner;
import java.util.Random;

public class MagicEightBall2 {

    public static void main(String args[]) {

        Random generator = new Random();
        Scanner sc = new Scanner (System.in);
        String userInput;
        int randomNumber;



        String [] responses = {"Outlook Good",
                "Outlook Not So Good",
                "My Reply Is No",
                "Don't Count On It",
                "Mr. M says no way",
                "You May Rely On It",
                "Ask Again Later",
                "Most Likely",
                "Cannot Predict Now",
                "Yes",
                "Yes Definitely",
                "Better Not Tell You Now",
                "It Is Certain",
                "Very Doubtful",
                "It Is Decidedly So",
                "Concentrate and Ask Again",
                "Signs Point to Yes",
                "My Sources Say No",
                "Without a Doubt",
                "Reply Hazy, Try Again",
                "As I See It, Yes",
                "Not On My Watch",
                "Hell Yeah",
                "Yeah, right.  And the Cardinals will win too!",
                "I better not tell you" ,
                "Don't waste my time with such trivia!",
                "You wish!",
                "Who cares"
        };

        System.out.println("WELCOME TO THE MAGIC EIGHT BALL SIMULATOR 1.0!!");
        System.out.println ("Full of sage advice for those too cheap to buy an actual Magic Eight Ball!");
        System.out.print("\nI see that you have travelled far to get here.  \nPlease enter your question: ");

        userInput = sc.nextLine();
        System.out.print("\" "+ userInput + "\"" + " . . . let me see . . .  \n\n");
        randomNumber = generator.nextInt(responses.length);

        System.out.println (responses[randomNumber]);

    }

}


