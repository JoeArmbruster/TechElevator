package com.techelevator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringBitsTests {

    @Test
    public void testGetBitsWithHello(){
        StringBits stringBits = new StringBits();
        String result = stringBits.getBits("Hello");
        assertEquals("Hlo", result);
    }

    @Test
    public void testGetBitsWithHi(){
        StringBits stringBits = new StringBits();
        String result = stringBits.getBits("Hi");
        assertEquals("H", result);
    }

    @Test
    public void testGetBitsWithHeeololeo(){
        StringBits stringBits = new StringBits();
        String result = stringBits.getBits("Heeololeo");
        assertEquals("Hello", result);
    }
}
