package com.techelevator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NonStartTests {

    @Test
    public void omitFirstCharCaps(){
        NonStart nonStart = new NonStart();
        String result = nonStart.getPartialString("Hello", "There");
        assertEquals("ellohere", result);
    }

    @Test
    public void omitFirstCharLowercase(){
        NonStart nonStart = new NonStart();
        String result = nonStart.getPartialString("java", "code");
        assertEquals("avaode", result);
    }

    @Test
    public void omitFirstCharLastLetterCaps(){
        NonStart nonStart = new NonStart();
        String result = nonStart.getPartialString("shotL", "java");
        assertEquals("hotLava", result);
    }
}
