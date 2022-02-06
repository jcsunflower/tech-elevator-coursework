package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class CigarPartyTest {

    //Initializing CigarParty for testing
    CigarParty cigarParty = new CigarParty();

    @Test
    public void test_haveParty_with_50_cigars_on_a_weekday() {
        //Arrange
        int cigars = 50;
        boolean isWeekend = false;

        //Act
        boolean actual = cigarParty.haveParty(cigars, isWeekend);

        //Assert
        Assert.assertTrue("haveParty should return true", actual);
    }

    @Test
    public void test_haveParty_with_10_cigars() {
        //Arrange
        int cigars = 10;
        boolean isWeekend = false;

        //Act
        boolean actual = cigarParty.haveParty(cigars, isWeekend);

        //Assert
        Assert.assertFalse("haveParty should equal false", actual);
    }

    @Test
    public void test_haveParty_when_cigars_is_80_on_a_weekend() {
        //Act
        boolean actual = cigarParty.haveParty(80, true);

        //Assert
        Assert.assertTrue("haveParty should return true", actual);
    }

    @Test
    public void test_haveParty_when_cigars_is_80_on_a_weekday() {
        //Act
        boolean actual = cigarParty.haveParty(80, false);

        //Assert
        Assert.assertFalse("haveParty should return true", actual);
    }

    @Test
    public void test_haveParty_when_cigars_is_10_on_a_weekend() {
        //Act
        boolean actual = cigarParty.haveParty(10, true);

        //Assert
        Assert.assertFalse("haveParty should return true", actual);
    }

}
