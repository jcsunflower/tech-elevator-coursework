package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class MaxEnd3Test {

    //Initializing MaxEnd3 for testing
    MaxEnd3 maxEnd3 = new MaxEnd3();

    @Test
    public void test_makeArray_works_as_intended() {
        //Arrange
        int[] arr = new int[] {1, 2, 3};
        int[] arr2 = new int[] {11, 5, 9};
        int[] arr3 = new int[] {2, 11, 3};
        int[] expected1 = new int[] {3, 3, 3};
        int[] expected2 = new int[] {11, 11, 11};
        int[] expected3 = new int[] {3, 3, 3};

        //Act
        int[] actual1 = maxEnd3.makeArray(arr);
        int[] actual2 = maxEnd3.makeArray(arr2);
        int[] actual3 = maxEnd3.makeArray(arr3);

        //Assert
        Assert.assertArrayEquals("Did not get expected array", expected1, actual1);
        Assert.assertArrayEquals("Did not get expected array", expected2, actual2);
        Assert.assertArrayEquals("Did not get expected array", expected3, actual3);
    }
}
