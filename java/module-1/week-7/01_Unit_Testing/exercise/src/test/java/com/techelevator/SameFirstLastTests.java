package com.techelevator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SameFirstLastTests {

    @Test
    public void testEmptyArray(){
        SameFirstLast sameFirstLast = new SameFirstLast();
        boolean result = sameFirstLast.isItTheSame((new int[]{}));
        assertEquals(false, result);
    }

    @Test
    public void testSingleElementArray(){
        SameFirstLast sameFirstLast = new SameFirstLast();
        boolean result = sameFirstLast.isItTheSame((new int[]{1}));
        assertEquals(true, result);
    }

    @Test
    public void testDifferentFirstLastArray(){
        SameFirstLast sameFirstLast = new SameFirstLast();
        boolean result = sameFirstLast.isItTheSame((new int[]{1, 2, 3}));
        assertEquals(false, result);
    }

    @Test
    public void testSameFirstLastArray(){
        SameFirstLast sameFirstLast = new SameFirstLast();
        boolean result = sameFirstLast.isItTheSame((new int[]{1, 2, 3, 1}));
        assertEquals(true, result);
    }
}
