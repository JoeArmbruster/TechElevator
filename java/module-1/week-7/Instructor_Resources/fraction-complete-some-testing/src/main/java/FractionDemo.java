public class FractionDemo
{
    public static void main(String[] args) {
        
        Fraction f1 = new Fraction (2,3); // calls to what?
        Fraction f2 = new Fraction (2, 3);
        Fraction f3 = f1;


        if (f1.equals(f2)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }

    }
    
}