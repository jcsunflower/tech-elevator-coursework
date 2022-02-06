package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class StringBitsTest {

    //Initializing
    StringBits stringBits = new StringBits();

    @Test
    public void test_getBits_works_as_intended() {
        //Arrange
        String str = "Hello";
        String str2 = "Hi";
        String str3 = "Heeololeo";

        //Act
        String actual = stringBits.getBits(str);
        String actual2 = stringBits.getBits(str2);
        String actual3 = stringBits.getBits(str3);

        //Assert
        Assert.assertEquals("Did not get expected string", "Hlo", actual);
        Assert.assertEquals("Did not get expected string", "H", actual2);
        Assert.assertEquals("Did not get expected string", "Hello", actual3);
    }

    @Test
    public void test_getBits_with_a_null_string() {
        //Arrange
        String str = null;

        //Act
        String actual = stringBits.getBits(str);

        //Arrange
        Assert.assertEquals("String should be empty", "", actual);
    }
}
