package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class Less20Test {

    //Initializing Less20 for testing
    Less20 less20 = new Less20();

    @Test
    public void test_isLessThanMultipleOf20_works_as_intended() {
        //Arrange
        int test1 = 18;
        int test2 = 19;
        int test3 = 20;

        //Act
        boolean scenario1 = less20.isLessThanMultipleOf20(test1);
        boolean scenario2 = less20.isLessThanMultipleOf20(test2);
        boolean scenario3 = less20.isLessThanMultipleOf20(test3);

        //Assert
        Assert.assertTrue("scenario1 should return true", scenario1);
        Assert.assertTrue("scenario2 should return true", scenario2);
        Assert.assertFalse("scenario3 should return false", scenario3);


    }
}
