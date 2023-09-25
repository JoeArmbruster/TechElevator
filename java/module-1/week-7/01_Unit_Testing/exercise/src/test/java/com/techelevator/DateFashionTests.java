package com.techelevator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DateFashionTests {

    @Test
    public void testStylishDate() {
        DateFashion dateFashion = new DateFashion();
        int result = dateFashion.getATable(5, 10);
        assertEquals(2, result);
    }

    @Test
    public void testDateNotStylish() {
        DateFashion dateFashion = new DateFashion();
        int result = dateFashion.getATable(5, 2);
        assertEquals(0, result);
    }

    @Test
    public void testStylishMaybe() {
        DateFashion dateFashion = new DateFashion();
        int result = dateFashion.getATable(5, 5);
        assertEquals(1, result);
    }
}

