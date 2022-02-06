package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class WordCountTest {

    //Initializing WordCount for testing
    WordCount wordCount = new WordCount();

    @Test
    public void test_getCount_works_as_intended() {
        //Arrange
        String[] words = new String[] {"ba", "ba", "black", "sheep"};
        Map<String, Integer> expected = new HashMap<>();
        expected.put("ba", 2);
        expected.put("black", 1);
        expected.put("sheep", 1);

        String[] words2Empty = new String[]{};
        Map<String, Integer> expected2 = new HashMap<>();

        String[] words3 = new String[] {"a", "b", "a", "c", "b"};
        Map<String, Integer> expected3 = new HashMap<>();
        expected3.put("a", 2);
        expected3.put("b", 2);
        expected3.put("c", 1);

        //Act
        Map<String, Integer> output = wordCount.getCount(words);
        Map<String, Integer> output2 = wordCount.getCount(words2Empty);
        Map<String, Integer> output3 = wordCount.getCount(words3);

        //Assert
        Assert.assertEquals("output and expected should be equal", expected, output);
        Assert.assertEquals("output and expected should be equal", expected2, output2);
        Assert.assertEquals("output and expected should be equal", expected3, output3);


    }
}
