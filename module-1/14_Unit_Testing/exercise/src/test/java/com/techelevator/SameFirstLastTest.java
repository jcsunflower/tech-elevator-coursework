package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class SameFirstLastTest {

    //Initializing SameFirstLast for testing
    SameFirstLast sameFirstLast = new SameFirstLast();

    @Test
    public void test_isItTheSame_works_as_intended() {
        //Arrange
        int[] arr = new int[] {1, 2, 3};
        int[] arr2 = new int[] {1, 2, 3, 1};
        int[] arr3= new int[] {1, 2, 1};

        //Act
        boolean scenario1 = sameFirstLast.isItTheSame(arr);
        boolean scenario2 = sameFirstLast.isItTheSame(arr2);
        boolean scenario3 = sameFirstLast.isItTheSame(arr3);

        //Assert
        Assert.assertFalse("Scenario1 should return False", scenario1);
        Assert.assertTrue("Scenario2 should return True", scenario2);
        Assert.assertTrue("Scenario3 should return True", scenario3);
    }

    @Test
    public void test_isItTheSame_with_a_null_array() {
        //Arrange
        int[] nums = null;

        //Act
        boolean actual = sameFirstLast.isItTheSame(nums);

        //Assert
        Assert.assertFalse("Method should return false", actual);
    }
}
