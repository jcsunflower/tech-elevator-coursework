package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class Lucky13Test {

    //Initializing Lucky13 for testing
    Lucky13 lucky13 = new Lucky13();

    @Test
    public void test_getLucky_if_no_one_or_three() {
        //Act
        int[] nums = new int[] {0, 2, 4};

        //Arrange
        boolean actual = lucky13.getLucky(nums);

        //Assert
        Assert.assertTrue("getLucky should return true", actual);
    }

    @Test
    public void test_getLucky_if_there_is_a_one() {
        //Act
        int[] nums = new int[] {0, 1, 2};
        int[] nums2 = new int[] {1, 2, 4};
        int[] nums3 = new int[] {3, 2, 1};

        //Arrange
        boolean scenario1 = lucky13.getLucky(nums);
        boolean scenario2 = lucky13.getLucky(nums2);
        boolean scenario3 = lucky13.getLucky(nums3);

        //Assert
        Assert.assertFalse("getLucky should return false", scenario1);
        Assert.assertFalse("getLucky should return false", scenario2);
        Assert.assertFalse("getLucky should return false", scenario3);
    }

    @Test
    public void test_getLucky_if_there_is_a_three() {
        //Arrange
        int[] nums = new int[] {3, 5, 7};
        int[] nums2 = new int[] {5, 3, 7};
        int[] nums3 = new int[] {5, 7, 3};

        //Act
        boolean scenario1 = lucky13.getLucky(nums);
        boolean scenario2 = lucky13.getLucky(nums2);
        boolean scenario3 = lucky13.getLucky(nums3);

        //Assert
        Assert.assertFalse("getLucky should return false", scenario1);
        Assert.assertFalse("getLucky should return false", scenario2);
        Assert.assertFalse("getLucky should return false", scenario3);
    }
}
