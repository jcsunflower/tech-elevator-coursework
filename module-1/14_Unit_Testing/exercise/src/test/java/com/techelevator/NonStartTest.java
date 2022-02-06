package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class NonStartTest {

    //Initializing NonStart for Testing
    NonStart nonStart = new NonStart();

    @Test
    public void test_getPartialString_works_as_intended() {
        //Arrange
        String str = "Hello";
        String str2 = "There";
        String str3 = "java";
        String str4 = "code";
        String str5 = "shotl";
        String str6 = "java";

        //Act
        String actual1 = nonStart.getPartialString(str, str2);
        String actual2 = nonStart.getPartialString(str3, str4);
        String actual3 = nonStart.getPartialString(str5, str6);

        //Assert
        Assert.assertEquals("Did not get expected string", "ellohere", actual1);
        Assert.assertEquals("Did not get expected string", "avaode", actual2);
        Assert.assertEquals("Did not get expected string", "hotlava", actual3);
    }

    @Test
    public void test_getPartialString_when_either_string_is_null() {
        //Arrange
        String str = null;
        String str2 = "Mountain";
        String str3 = "Example";

        //Act
        String actual = nonStart.getPartialString(str, str2);
        String actual2 = nonStart.getPartialString(str3, str);

        //Arrange
        Assert.assertEquals("Did not get expected string", "ountain", actual);
        Assert.assertEquals("Did not get expected string", "xample", actual2);
    }
}
