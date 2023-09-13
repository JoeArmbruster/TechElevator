package com.company;//********************************************************************
// Fraction.java 
// Casey McCullough
// Represents one Fraction number with a numerator and denominator.

// Write the following class
// Test your methods by adding the appropriate code to FractionDemo
// then running FractionDemo
//********************************************************************

public class Fraction
{
   // 1. PROVIDE INSTANCE DATA BELOW
   private int numerator;
   private int denominator;

    // 2. WRITE THE CONSTRUCTOR BELOW
 public Fraction (int numerator, int denominator)
 {
    this.numerator = numerator;
    this.denominator = denominator;
     
  }
 
  // 3. WRITE ANOTHER CONSTRUCTOR 
  // THAT ACCEPTS ONLY ONE INT PARAMETER
  // PASSING IN A "5" FOR EXAMPLE, 
  // SHOULD RESULT IN A FRACTION WITH VALUE 5/1.

    public Fraction (int numerator) {
     this.numerator = numerator;
     this.denominator = 1;
    }

    // 4. WRITE GETTER (ACCESSOR) METHODS FOR ALL YOUR INSTANCE DATA

    public int getNumerator (){
     return numerator;
    }

    public int getDenominator() {
     return denominator;
    }
 
 // 5. WRITE SETTER (MUTATOR) METHODS FOR ALL YOUR INSTANCE DATA

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }


    //  6. WRITE THE METHODS BELOW

    //6a. Returns this Fraction number as a string.
    //-----------------------------------------------------------------
    public String toString ()
    {
        return numerator + " / " + denominator;
    }

    //-----------------------------------------------------------------
    // 6b. Returns the reciprocal of this Fraction number.
    //-----------------------------------------------------------------

    public  Fraction reciprocal () {

        Fraction recip = new Fraction (this.denominator, this.numerator);
        return recip;
    }
     //-----------------------------------------------------------------
     // 6c. Determines if this Fraction number is equal to the one passed
     // as a parameter. Assumes they are both reduced.
     //-----------------------------------------------------------------
    public boolean equals (Fraction op2)
 {
	return false;
 }

 //-----------------------------------------------------------------
 // 6d. Returns this Fraction's decimal equivalent
 //-----------------------------------------------------------------

 public double toDecimal ()
 {
     return 0.;
 }
 

 }
