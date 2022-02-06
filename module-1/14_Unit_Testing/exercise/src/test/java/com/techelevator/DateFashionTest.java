package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class DateFashionTest {

    //Initializing DateFashion for testing
    DateFashion dateFashion = new DateFashion();

    @Test
    public void test_if_the_date_does_not_get_the_table() {
        //Arrange
        int you = 2;
        int date = 7;
        int youAlternate = 9;
        int dateAlternate = 1;
        int youUnlucky = 2;
        int dateUnlucky = 2;

        //Act
        int scenario1 = dateFashion.getATable(you, date);
        int scenario2 = dateFashion.getATable(youAlternate, dateAlternate);
        int scenario3 = dateFashion.getATable(youUnlucky, dateUnlucky);

        //Assert
        Assert.assertEquals("Did not get expected value", 0, scenario1);
        Assert.assertEquals("Did not get expected value", 0, scenario2);
        Assert.assertEquals("Did not get expected value", 0, scenario3);
    }

    @Test
    public void test_if_the_date_might_get_the_table() {
        //Arrange
        int you = 3;
        int date = 7;
        int youAlternate = 7;
        int dateAlternate = 3;

        //Act
        int scenario1 = dateFashion.getATable(you, date);
        int scenario2 = dateFashion.getATable(youAlternate, dateAlternate);

        //Assert
        Assert.assertEquals("Did not get expected value", 1, scenario1);
        Assert.assertEquals("Did not get expected value", 1, scenario2);
    }

    @Test
    public void test_if_the_date_does_get_the_table() {
        //Arrange
        int you = 4;
        int date = 8;
        int youAlternate = 9;
        int dateAlternate = 5;

        //Act
        int scenario1 = dateFashion.getATable(you, date);
        int scenario2 = dateFashion.getATable(youAlternate, dateAlternate);

        //Assert
        Assert.assertEquals("Did not get expected value", 2, scenario1);
        Assert.assertEquals("Did not get expected value", 2, scenario2);
    }
}
