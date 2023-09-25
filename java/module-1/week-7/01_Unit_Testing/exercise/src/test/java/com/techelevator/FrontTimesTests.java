package com.techelevator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class FrontTimesTests {

    @Test
    public void testChocolateTwoTimes(){
        FrontTimes frontTimes = new FrontTimes();
        String result = frontTimes.generateString("Chocolate", 2);
        assertEquals("ChoCho", result);
    }

    @Test
    public void testChocolateThreeTimes() {
        FrontTimes frontTimes = new FrontTimes();
        String result = frontTimes.generateString("Chocolate", 3);
        assertEquals("ChoChoCho", result);
    }

    @Test
    public void testAbcThreeTimes() {
        FrontTimes frontTimes = new FrontTimes();
        String result = frontTimes.generateString("Abc", 3);
        assertEquals("AbcAbcAbc", result);
    }
}
