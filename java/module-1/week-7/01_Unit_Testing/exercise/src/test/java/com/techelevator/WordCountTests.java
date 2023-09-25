package com.techelevator;

import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCountTests {

    @Test
    public void testGetCountWithDuplicates(){
        WordCount wordCount = new WordCount();
        String[] words = {"ba", "ba", "black", "sheep"};
        Map<String, Integer> result = wordCount.getCount(words);

        Map<String, Integer> expected = new HashMap<>();
        expected.put("ba", 2);
        expected.put("black", 1);
        expected.put("sheep", 1);

        assertEquals(expected, result);
    }

    @Test
    public void testGetCountWithNoDuplicates(){
        WordCount wordCount = new WordCount();
        String[] words = {"c", "b", "a"};
        Map<String, Integer> result = wordCount.getCount(words);

        Map<String, Integer> expected = new HashMap<>();
        expected.put("c", 1);
        expected.put("b", 1);
        expected.put("a", 1);

        assertEquals(expected, result);
    }

    @Test
    public void testGetCountWithAllDuplicates(){
        WordCount wordCount = new WordCount();
        String[] words = {"a", "b", "c", "a", "b", "c"};
        Map<String, Integer> result = wordCount.getCount(words);

        Map<String, Integer> expected = new HashMap<>();
        expected.put("a", 2);
        expected.put("b", 2);
        expected.put("c", 2);

        assertEquals(expected, result);
    }


}
