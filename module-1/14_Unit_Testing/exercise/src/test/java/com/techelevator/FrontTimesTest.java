package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class FrontTimesTest {

    //Initializing FrontTimes for testing
    FrontTimes frontTimes = new FrontTimes();

    @Test
    public void test_generateString_with_an_empty_string() {
        //Arrange
        String str = "";
        int copy = 3;

        //Act
        String actual = frontTimes.generateString(str, copy);

        //Assert
        Assert.assertEquals("String should be empty", "", actual);
    }

    @Test
    public void test_generateString_with_a_string_of_size_one_and_int_two() {
        //Arrange
        String str = "a";
        int copy = 2;

        //Act
        String actual = frontTimes.generateString(str, copy);

        //Assert
        Assert.assertEquals("String should be aa", "aa", actual);
    }

    @Test
    public void test_generateString_with_a_string_of_size_two_and_int_four() {
        //Arrange
        String str = "ab";
        int copy = 4;

        //Act
        String actual = frontTimes.generateString(str, copy);

        //Assert
        Assert.assertEquals("String should be abababab", "abababab", actual);
    }

    @Test
    public void test_generateString_works_as_intended() {
        //Arrange
        String str = "Chocolate";
        String str2 = "Abc";
        int copy = 3;
        int copy2 = 2;

        //Act
        String actual = frontTimes.generateString(str, copy);
        String actual2 = frontTimes.generateString(str, copy2);
        String actual3 = frontTimes.generateString(str2, copy);

        //Assert
        Assert.assertEquals("String should be ChoChoCho", "ChoChoCho", actual);
        Assert.assertEquals("String should be ChoCho", "ChoCho", actual2);
        Assert.assertEquals("String should be AbcAbcAbc", "AbcAbcAbc", actual3);
    }
}
