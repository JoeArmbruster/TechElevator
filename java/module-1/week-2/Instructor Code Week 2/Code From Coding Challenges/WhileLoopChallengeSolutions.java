/* Online Java Compiler and Editor */
public class WhileLoopChallengeSolutions {

    public static void main(String []args) {

        /*
           Challenge #0: Display all numbers from 1 to 10
        */
        // System.out.println ("CHALLENGE 0:");
        // int count = 1; 
        // while (count <= 10) {
        //     System.out.println (count);
        //     count++;
        // }

        /*
            Challenge #1: Calculate the sum of all numbers from 1 to 10
        */
        // System.out.println ("CHALLENGE 1:");
        // int count = 1;
        // int sum = 0;
        // while (count <= 10) {
        //     sum += count;
        //     count++;
        // }
        // System.out.println ("SUM: " + sum);

        /*
            Challenge #2: Display all even numbers between 1 and 100
        */
        // System.out.println ("CHALLENGE 2:");
        // int count = 1; 
        // while (count <= 100) {
        //     if (count % 2 == 0) {
        //         System.out.println (count);
        //     }
        //     count++;
        // }
        

        /*
            Challenge #3: Display all numbersn between 1 and 100 that are NOT evenly divisible by 5
        */
        System.out.println ("CHALLENGE 3:");
        int count = 1; 
        while (count <= 100) {
            if (count % 5 != 0) {
                System.out.println (count);
            }
            count++;
        }
    }
}