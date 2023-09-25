package com.techelevator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MaxEnd3Tests {

    @Test
    public void lastElementLargerThanFirst(){
        MaxEnd3 maxEnd3 = new MaxEnd3();
        int[] nums = {1, 2, 3};
        int[] expected = {3, 3, 3};
        assertArrayEquals(expected, maxEnd3.makeArray(nums));
    }

    @Test
    public void firstElementLargerThanLast(){
        MaxEnd3 maxEnd3 = new MaxEnd3();
        int[] nums = {11, 5, 9};
        int[] expected = {11, 11, 11};
        assertArrayEquals(expected, maxEnd3.makeArray(nums));
    }

    @Test
    public void lastElementLargerThanFirstWithSecondElementLargest(){
        MaxEnd3 maxEnd3 = new MaxEnd3();
        int[] nums = {2, 11, 3};
        int[] expected = {3, 3, 3};
        assertArrayEquals(expected, maxEnd3.makeArray(nums));
    }

}
