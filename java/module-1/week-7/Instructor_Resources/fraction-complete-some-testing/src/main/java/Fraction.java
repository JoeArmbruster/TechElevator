//********************************************************************
// Fraction.java 
// Casey McCullough
// Modification 7/16/19
// Represents one Fraction number with a numerator and denominator.
//********************************************************************

public class Fraction
{
    private int numerator;
    private int denominator;
   
    //-----------------------------------------------------------------
    // Sets up the fraction number by ensuring a nonzero denominator
    // and making only the numerator signed.
    //-----------------------------------------------------------------
    
 public Fraction (int numerator, int denominator)
 {
   this.numerator = numerator;
   
   if (denominator == 0) // ensures denominator is not zero
     throw new IllegalArgumentException(
            "Denominator cannot be zero");
   else
     this.denominator = denominator;

   simplify();
     
  }
 
  public Fraction (int numerator)
 {
   this.numerator = numerator;
   this.denominator = 1;
  }
 
 
  // 4. WRITE ACCESSOR METHODS FOR ALL YOUR INSTANCE DATA
 public int getNumerator ()
 {
   return numerator;
 }
 
  public int getDenominator ()
 {
   return denominator;
 }
 
 // 5. WRITE MUTATOR METHODS FOR ALL YOUR INSTANCE DATA

  public void setNumerator (int numerator)
  {
      this.numerator = numerator;
      simplify();
  }

  public void setDenominator (int denominator)
  {
       if (denominator != 0)
            this.denominator = denominator;
       simplify();
  }
  
    //-----------------------------------------------------------------
    // Returns the reciprocal of this Fraction number.
    //-----------------------------------------------------------------
    public Fraction reciprocal ()
    {
        return new Fraction (denominator, numerator);
    }

 //-----------------------------------------------------------------
 // Determines if this Fraction number is equal to the one passed
 // as a parameter. Assumes they are both reduced.
 //-----------------------------------------------------------------
 public boolean equals (Fraction op2)
 {
   return this.numerator == op2.getNumerator() && denominator == op2.getDenominator();
 }
 
 //-----------------------------------------------------------------
 // Returns this Fraction number as a string.
 //-----------------------------------------------------------------

 @Override
 public String toString ()
 {
    if (denominator == 1)
        return "" + numerator;
    else
        return  numerator + " / " + denominator;
    
 }

 //-----------------------------------------------------------------
 // Returns this Fraction's decimal equivalent
 //-----------------------------------------------------------------

 public double toDecimal ()
 {
    return (double) numerator / denominator;
 }
 
  //-----------------------------------------------------------------
   //  Adds this Fraction to the one passed as a parameter.
   //  A common denominator is found by multiplying the individual
   //  denominators.
   //-----------------------------------------------------------------
   public Fraction add (Fraction op2)
   {
      int commonDenominator = denominator * op2.getDenominator();
      int numerator1 = numerator * op2.getDenominator();
      int numerator2 = op2.getNumerator() * denominator;
      int sum = numerator1 + numerator2;

      return new Fraction (sum, commonDenominator);
   }

   //-----------------------------------------------------------------
   //  Subtracts the rational number passed as a parameter from this
   //  rational number.
   //-----------------------------------------------------------------
   public Fraction subtract (Fraction op2)
   {
      int commonDenominator = denominator * op2.getDenominator();
      int numerator1 = numerator * op2.getDenominator();
      int numerator2 = op2.getNumerator() * denominator;
      int difference = numerator1 - numerator2;

      return new Fraction (difference, commonDenominator);
   }

 
 Fraction multiply (Fraction f1)
 {
      int n = this.getNumerator() * f1.getNumerator();
      int d = this.getDenominator() * f1.getDenominator();
      return new Fraction (n, d);
 }
 
  Fraction divide (Fraction f1)
 {
       // multiply by the reciprocal of f1
      int n = this.getNumerator() * f1.getDenominator();
      int d = this.getDenominator() * f1.getNumerator();
      return new Fraction (n, d);
 }
 
  //-----------------------------------------------------------------
 // Simplifies the Fraction by dividing by gcd
 //-----------------------------------------------------------------

 private void simplify ()
 {
     // simplify negative. If fraction is negative, it should be reflected in the numerator (only)
     if (denominator < 0)
     {
         numerator *= -1;
         denominator *= -1;
     }

     // divide numerator and denominator by greatest common divisor
     if (numerator != 0)
    {
        int divisor = gcd (Math.abs(numerator), Math.abs(denominator));
        numerator /= divisor;
        denominator /= divisor;
    }
     else // numerator is zero.
     {
         denominator = 1; // zero stored as 0/1
     }
     
      
 }
 
   private static int gcd (int n1, int n2)
   {
        int rem, low, high;
        // identify high / low number 
        if (n1 > n2)
        {
             high = n1;
             low = n2;
        }
        else
        {
             high = n2;
             low = n1;
        }
         
        /* use Euclid's Algorithm to identify GCD
         * 
         * 1. get remainder of high % low
         * if remainder is 0, then low is the gcd
         * otherwise
         * high gets value from low
         * low gets value from remainder
         * repeat
         */
        
        rem = high % low;
        
        while (rem != 0)
        {
             high = low;
             low = rem;
             rem = high % low;
        }
    return low; 
                                                 
   }
 
 
 }
