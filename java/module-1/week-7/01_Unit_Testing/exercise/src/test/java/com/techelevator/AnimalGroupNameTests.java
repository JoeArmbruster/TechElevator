package com.techelevator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AnimalGroupNameTests {

    @Test
    public void testValidAnimalName() {
        AnimalGroupName groupName = new AnimalGroupName();
        assertEquals("Herd", groupName.getHerd("Elephant"));
    }

    @Test
    public void testValidAnimalNameCaseInsensitive() {
        AnimalGroupName groupName = new AnimalGroupName();
        assertEquals("Crash", groupName.getHerd("rhino"));
    }

    @Test
    public void testUnknownAnimalName() {
        AnimalGroupName groupName = new AnimalGroupName();
        assertEquals("unknown", groupName.getHerd("walrus"));
    }

    @Test
    public void testEmptyAnimalName() {
        AnimalGroupName groupName = new AnimalGroupName();
        assertEquals("unknown", groupName.getHerd(""));
    }

    @Test
    public void testNullAnimalName() {
        AnimalGroupName groupName = new AnimalGroupName();
        assertEquals("unknown", groupName.getHerd(null));
    }
}

