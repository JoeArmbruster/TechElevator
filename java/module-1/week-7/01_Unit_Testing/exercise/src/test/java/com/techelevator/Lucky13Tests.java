package com.techelevator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Lucky13Tests {

    @Test
    public void testNoOnesOrThrees(){
        Lucky13 lucky13 = new Lucky13();
        int[] nums = {0, 2, 4};
        assertEquals(true, lucky13.getLucky(nums));
    }

    @Test
    public void testContainsOneAndThree(){
        Lucky13 lucky13 = new Lucky13();
        int[] nums = {1, 2, 3};
        assertEquals(false, lucky13.getLucky(nums));
    }

    @Test
    public void testContainsOne(){
        Lucky13 lucky13 = new Lucky13();
        int[] nums = {1, 2, 4};
        assertEquals(false, lucky13.getLucky(nums));
    }

    @Test
    public void testContainsThree(){
        Lucky13 lucky13 = new Lucky13();
        int[] nums = {2, 3, 4};
        assertEquals(false, lucky13.getLucky(nums));
    }
}
