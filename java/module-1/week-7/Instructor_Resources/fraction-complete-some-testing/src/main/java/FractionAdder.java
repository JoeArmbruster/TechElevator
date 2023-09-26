import java.util.Scanner;

public class FractionAdder {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numerator1, numerator2;
        int denominator1, denominator2;
        Fraction f1 = null;
        Fraction f2 = null;

        while (f1 == null) {
            System.out.print("Please enter the first numerator: ");

            numerator1 = sc.nextInt();

            System.out.print("Please enter the first denominator: ");
            denominator1 = sc.nextInt();

            try {
                f1 = new Fraction(numerator1, denominator1);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
