package com.techelevator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Less20Tests {

    @Test
    public void testOneLessThanMultipleOf20(){
        Less20 less20 = new Less20();
        assertEquals(true, less20.isLessThanMultipleOf20(19));
        assertEquals(true, less20.isLessThanMultipleOf20(39));
    }

    @Test
    public void testTwoLessThanMultipleOf20(){
        Less20 less20 = new Less20();
        assertEquals(true, less20.isLessThanMultipleOf20(18));
        assertEquals(true, less20.isLessThanMultipleOf20(38));
    }

    @Test
    public void testExactlyMultipleOf20(){
        Less20 less20 = new Less20();
        assertEquals(false, less20.isLessThanMultipleOf20(20));
        assertEquals(false, less20.isLessThanMultipleOf20(40));
        assertEquals(false, less20.isLessThanMultipleOf20(60));
        assertEquals(false, less20.isLessThanMultipleOf20(80));
    }

    @Test
    public void testMoreThanTwoLessThanMultipleOf20(){
        Less20 less20 = new Less20();
        assertEquals(false, less20.isLessThanMultipleOf20(17));
        assertEquals(false, less20.isLessThanMultipleOf20(35));
    }
}
