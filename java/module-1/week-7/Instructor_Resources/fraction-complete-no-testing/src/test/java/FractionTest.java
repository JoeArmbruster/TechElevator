import org.junit.Assert;
import org.junit.Test;

public class FractionTest {

    final static double DELTA = 0.0001;
    @Test
    public void constructor_creates_Fraction_with_correct_values() {
        // Arrange
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(5);

        // Assert
        Assert.assertEquals("constructor doesn't set numerator correctly", 1, f1.getNumerator());
        Assert.assertEquals("constructor doesn't set denominator correctly", 2, f1.getDenominator());
        Assert.assertEquals("one-argument constructor doesn't set correct numerator", 5, f2.getNumerator());
        Assert.assertEquals("one-argument constructor doesn't set denominator to 1", 1, f2.getDenominator());
    }

    @Test
    public void constructor_deals_with_negative_values_correctly() {
        // Arrange

        Fraction f1 = new Fraction (1, -2);
        Fraction f2 = new Fraction (-1, -3);

        // Assert
        Assert.assertEquals("constructor doesn't move negative from denominator to numerator", -1, f1.getNumerator());
        Assert.assertEquals("constructor doesn't move negative from denominator to numerator", 2, f1.getDenominator());
        Assert.assertTrue("constructor doesn't change - / - to + / +", f2.getNumerator() > 0 && f2.getDenominator() > 0 );
    }

    @Test
    public void constructor__correctly_reduces_positive_numbers () {
        // Arrange
        Fraction f1 = new Fraction (2, 4);
        Fraction f2 = new Fraction (4, 2);
        Fraction f3 = new Fraction (3, 9);
        Fraction f4 = new Fraction (9, 3);
        Fraction f5 = new Fraction (12, 42);
        Fraction f6 = new Fraction (42, 12);

        // Assert
        Assert.assertTrue("constructor converts 2/4 to 1/2", f1.getNumerator() == 1 && f1.getDenominator() == 2);
        Assert.assertTrue("constructor converts 4/2 to 2/1", f2.getNumerator() == 2 && f2.getDenominator() == 1);
        Assert.assertTrue("constructor converts 3/9 to 1/3", f3.getNumerator() == 1 && f3.getDenominator() == 3);
        Assert.assertTrue("constructor converts 9/3 to 3/1", f4.getNumerator() == 3 && f4.getDenominator() == 1);
        Assert.assertTrue("constructor converts 12/42 to 2/7", f5.getNumerator() == 2 && f5.getDenominator() == 7);
        Assert.assertTrue("constructor converts 42/12 to 7/2", f6.getNumerator() == 7 && f6.getDenominator() == 2);
    }

    @Test
    public void constructor_converts_all_zero_values_to_0_over_1 () {
        // Arrange
        Fraction f1 = new Fraction(0, 2);
        Fraction f2 = new Fraction(0, -1);

        // Assert
        Assert.assertTrue("0/2 converts to 0/1", f1.getNumerator() == 0 && f1.getDenominator() == 1);
        Assert.assertTrue("0/-1 converts to 0/1", f2.getNumerator() == 0 && f2.getDenominator() == 1);

    }


}
