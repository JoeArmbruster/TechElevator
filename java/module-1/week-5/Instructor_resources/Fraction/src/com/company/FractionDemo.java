package com.company;

public class FractionDemo
{
    public static void main(String[] args) {

        Fraction f1 = new Fraction(2, 3); // calls to what?
        Fraction f2 = new Fraction(3);
        Fraction f1Reciprocal = f1.reciprocal();

        Fraction f2Reciprocal = new Fraction (f2.getDenominator(), f2.getNumerator());


        System.out.println(f1);
        System.out.println(f2);
        System.out.println(f1Reciprocal);
        System.out.println(f2Reciprocal);
    }
        

}