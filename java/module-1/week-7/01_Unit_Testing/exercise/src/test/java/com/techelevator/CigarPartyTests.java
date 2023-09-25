package com.techelevator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CigarPartyTests {

    @Test
    public void testPartyWithNotEnoughCigarsOnWeekday() {
        CigarParty party = new CigarParty();
        boolean result = party.haveParty(30, false);
        assertEquals(false, result);
    }
    @Test
    public void testPartyWithEnoughCigarsOnWeekday() {
        CigarParty party = new CigarParty();
        boolean result = party.haveParty(50, false);
        assertEquals(true, result);
    }

    @Test
    public void testPartyWithEnoughCigarsOnWeekend() {
        CigarParty party = new CigarParty();
        boolean result = party.haveParty(70, true);
        assertEquals(true, result);
    }

}

