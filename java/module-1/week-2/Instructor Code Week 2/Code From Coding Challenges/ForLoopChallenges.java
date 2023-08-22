
public class ForLoopChallenges {

    public static void main(String []args) {

        /*
           Challenge #0: Display all numbers from 1 to 10
        */
        System.out.println ("CHALLENGE 0:");
        for (int i = 1; i <= 10; i++) {
            System.out.println (i);
        }

        /*
            Challenge #1: Calculate the sum of all numbers from 1 to 10
        */
        System.out.println ("CHALLENGE 1:");
        int sum = 0; 
        for (int i = 1; i <= 10; i++) {
            sum += i;
        }
        System.out.println ("SUM: " + sum);

        /*
            Challenge #2: Display all even numbers between 1 and 100
        */
        System.out.println ("CHALLENGE 2:");
        for (int i = 2; i <= 100; i++) {
            System.out.println (i);
        }


        /*
            Challenge #3: Display all numbers between 1 and 100 that are NOT evenly divisible by 5
        */
        System.out.println ("CHALLENGE 3:");
               for (int i = 2; i <= 100; i++) {
                   if (i % 5 != 0) {
                       System.out.println (i);
                   }
                }
    }
}