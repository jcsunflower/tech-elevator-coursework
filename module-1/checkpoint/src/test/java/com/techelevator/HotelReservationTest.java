package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class HotelReservationTest {

    @Test
    public void estimatedTotal_works_as_intended() {
        //Arrange
        HotelReservation hotelReservation = new HotelReservation("hotel1", 3);
        double expected = hotelReservation.getDAILY_RATE() * hotelReservation.getNumberOfNights();


        //Act
        double actual = hotelReservation.getEstimatedTotal();

        //Assert
        Assert.assertEquals("Did not get expected estimated total", expected, actual, 0.0);
    }

    @Test
    public void calculateActualTotal_works_as_intended() {
        //Arrange
        HotelReservation testReservation = new HotelReservation("test1", 3);
        double expected1 = testReservation.getEstimatedTotal();
        double expected2 = 262.94;

        //Act
        double actual1 = testReservation.calculateActualTotal(false, false);
        //Assert
        Assert.assertEquals("Did not get correct ammount", expected1, actual1, 0.0);
    }
}
