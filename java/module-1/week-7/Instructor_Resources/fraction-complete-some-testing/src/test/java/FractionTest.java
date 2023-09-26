import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FractionTest {

    final static double DELTA = 0.0001;

    @Test
    public void constructor_creates_Fraction_with_correct_values() {
        // Arrange

        // Act
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(5);

        // Assert
        Assert.assertEquals("constructor doesn't set numerator correctly", 3, f1.getNumerator());
        Assert.assertEquals("constructor doesn't set denominator correctly", 2, f1.getDenominator());
        Assert.assertEquals("one-argument constructor doesn't set correct numerator", 5, f2.getNumerator());
        Assert.assertEquals("one-argument constructor doesn't set denominator to 1", 1, f2.getDenominator());
    }

    @Test
    public void constructor_deals_with_negative_values_correctly() {
        // Arrange

        // Act
        Fraction f1 = new Fraction (1, -2);
        Fraction f2 = new Fraction (-1, -3);

        Assert.assertEquals("constructor doesn't move negative from denominator to numerator", -1, f1.getNumerator());
        Assert.assertEquals("constructor doesn't move negative from denominator to numerator", 2, f1.getDenominator());
        Assert.assertTrue("constructor doesn't change - / - to + / +", f2.getNumerator() > 0 && f2.getDenominator() > 0 );
    }

    @Test
    public void constructor__correctly_reduces_positive_numbers () {
        Fraction f1 = new Fraction (2, 4);
        Fraction f2 = new Fraction (4, 2);
        Fraction f3 = new Fraction (3, 9);
        Fraction f4 = new Fraction (9, 3);
        Fraction f5 = new Fraction (12, 42);
        Fraction f6 = new Fraction (42, 12);

        Assert.assertTrue("constructor converts 2/4 to 1/2", f1.getNumerator() == 1 && f1.getDenominator() == 2);
        Assert.assertTrue("constructor converts 4/2 to 2/1", f2.getNumerator() == 2 && f2.getDenominator() == 1);

        Assert.assertTrue("constructor converts 3/9 to 1/3", f3.getNumerator() == 1 && f3.getDenominator() == 3);
        Assert.assertTrue("constructor converts 9/3 to 3/1", f4.getNumerator() == 3 && f4.getDenominator() == 1);

        Assert.assertTrue("constructor converts 12/42 to 2/7", f5.getNumerator() == 2 && f5.getDenominator() == 7);
        Assert.assertTrue("constructor converts 42/12 to 7/2", f6.getNumerator() == 7 && f6.getDenominator() == 2);
    }

    @Test
    public void constructor_converts_all_zero_values_to_0_over_1 () {
        Fraction f1 = new Fraction(0, 2);
        Fraction f2 = new Fraction(0, -1);

        Assert.assertTrue("0/2 converts to 0/1", f1.getNumerator() == 0 && f1.getDenominator() == 1);
        Assert.assertTrue("0/-1 converts to 0/1", f2.getNumerator() == 0 && f2.getDenominator() == 1);

    }

    @Test
    public void getDouble_returns_correct_decimal_equivalent () {

        Fraction f1 = new Fraction (1, 4);
        Fraction f2 = new Fraction (1, 3);

        double f1Decimal = f1.toDecimal();
        double f2Decimal = f2.toDecimal();

        Assert.assertEquals("1/4 doesn't equal 0.25", 0.25, f1Decimal, DELTA);
        Assert.assertEquals("1/3 doesn't equal 0.3333", 0.3333, f2Decimal, DELTA);

    }

    @Test
    public void reciprocal_returns_correct_value() {
        Fraction reciprocal1 = new Fraction (1, 2).reciprocal();
        Fraction reciprocal2 = new Fraction (3, 5).reciprocal();

        Assert.assertTrue(reciprocal1.getNumerator() == 2 && reciprocal1.getDenominator() == 1);
        Assert.assertTrue(reciprocal2.getNumerator() == 5 && reciprocal2.getDenominator() == 3);
    }

    @Test
    public void equals_works_correctly() {
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction (1, 2);
        Fraction f3 = new Fraction(1, 3);
        Fraction f4 = new Fraction (3, 2);

        Assert.assertTrue("equal fractions not reported as equal", f1.equals(f2));
        Assert.assertFalse("non equal fractions reported as equal", f1.equals(f3));
        Assert.assertFalse("non equal fractions reported as equal", f1.equals(f4));
    }

    @Test
    public void toString_returns_proper_string() {
        Fraction f1 = new Fraction (1, 2);
        Fraction f2 = new Fraction (5);

        Assert.assertEquals("incorrect String produced by 1 / 2", f1.toString(), "1 / 2");
        Assert.assertEquals("incorrect String produced by 5 / 1", f2.toString(), "5");
    }

    @Test
    public void add_returns_correct_values() {
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction (1, 4);
        Fraction f3 = new Fraction (2, 3);

        Fraction sum1 = f1.add(f1);
        Fraction sum2 = f1.add(f2);
        Fraction sum3 = f2.add(f3); // 11 / 12

        Assert.assertTrue("1/2 add 1/2 doesn't equal 1", sum1.getNumerator() == 1 && sum1.getDenominator() == 1);
        Assert.assertTrue("1/2 add 1/4 doesn't equal 3/4", sum2.getNumerator() == 3 && sum2.getDenominator() == 4);
        Assert.assertTrue("2/3 and 1/4 don't sum to 11/12", sum3.getNumerator() == 11 && sum3.getDenominator() == 12);
    }







}
