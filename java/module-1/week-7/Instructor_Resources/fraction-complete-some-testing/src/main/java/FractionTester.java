import java.util.Scanner; 

public class FractionTester
{
    public static void main(String[] args) {
        
        
        final int NUM_FRACTIONS = 4; 
        
        Fraction[] testFractions = getUserFractions(NUM_FRACTIONS);
        
        for (int i = 0; i < testFractions.length; i++)
        {
         System.out.println (testFractions[i]);
        }
        
              
        // 1. write decimal()
        
        //System.out.println ("Decimal value: " + f1.decimal());
        //System.out.println ("Decimal value: " + f2.decimal());
        
      
        // System.out.println (f1.decimal());
       
    }
    
    public static Fraction[] getUserFractions (int requested)
    {
        Scanner sc = new Scanner (System.in);
        Fraction[] result = new Fraction[requested];
        
        int numValidFractions = 0;
        
        while (numValidFractions < requested)
        {
           System.out.print("\tNumerator: ");
           int n = sc.nextInt();
           System.out.print("\tDenominator: ");
           int d = sc.nextInt();
           
           try
           {   
            result[numValidFractions] = new Fraction(n, d); // calls to what? 
            numValidFractions++;
           }
           catch (IllegalArgumentException e)
           {
            System.out.println ("-->Invalid Fraction.  Please try again: ");
           }
           
        
        }
        return result; 
 
    
    }
    
     
  /**
   * This method tests creating a fraction from a numerator and denominator. It catches any exceptions and shows them to the user. 
   *
   * @param num - the numerator of the fraction to create. 
   * @param den - the denominator of the fraction to create. 
   */   
  public static Fraction testFractionCreate( int num, int den )
  {
    Fraction f = null; 
    try
    {
      f = new Fraction( num, den ); 
    }
    catch ( ArithmeticException e )
    {
      System.out.println("Error creating the fraction " + num + " / " + den + " because " + e.toString() );
    }
    return f; 
  }
    
}