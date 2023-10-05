package com.techelevator;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class NonStartTests {

    @Test
    public void testOmitFirstCharCaps(){
        NonStart nonStart = new NonStart();
        String result = nonStart.getPartialString("Hello", "There");
        assertEquals("ellohere", result);
    }

    @Test
    public void testOmitFirstCharLowercase(){
        NonStart nonStart = new NonStart();
        String result = nonStart.getPartialString("java", "code");
        assertEquals("avaode", result);
    }

    @Test
    public void testOmitFirstCharLastLetterCaps(){
        NonStart nonStart = new NonStart();
        String result = nonStart.getPartialString("shotL", "java");
        assertEquals("hotLava", result);
    }

    @Test
    public void testFirstEmpty(){
        NonStart nonStart = new NonStart();
        String result = nonStart.getPartialString("", "There");
        assertEquals("here", result);
    }

    @Test
    public void testSecondEmpty(){
        NonStart nonStart = new NonStart();
        String result = nonStart.getPartialString("Hello", "");
        assertEquals("ello", result);
    }

    @Test
    public void testBothEmpty(){
        NonStart nonStart = new NonStart();
        String result = nonStart.getPartialString("", "");
        assertEquals("", result);
    }

    @Test
    public void testBothOneCharacter(){
        NonStart nonStart = new NonStart();
        String result = nonStart.getPartialString("a", "b");
        assertEquals("", result);
    }

}
