package com.techelevator;

public class HotelReservation {
    //Instance variables
    private final double DAILY_RATE = 59.99;
    private String name;
    private int numberOfNights;
    private double estimatedTotal;

    //Constructor used to initialize a hotel reservation
    public HotelReservation(String name, int numberOfNights) {
        this.name = name;
        this.numberOfNights = numberOfNights;
        estimatedTotal = DAILY_RATE * numberOfNights;
    }

    //Getters and setters
    public String getName() {
        return this.name;
    }

    public int getNumberOfNights() {
        return this.numberOfNights;
    }

    public double getEstimatedTotal() {
        return this.estimatedTotal;
    }

    public double getDAILY_RATE() {
        return this.DAILY_RATE;
    }

    //Methods
    public double calculateActualTotal(Boolean requiresCleaning, Boolean usedMinibar) {
        double actualTotal = estimatedTotal;
        double minibarFee = 12.99;
        double cleaningFee = 34.99;

        if (requiresCleaning && usedMinibar) {
            actualTotal += (cleaningFee * 2) + minibarFee;
        } else if (requiresCleaning) {
            actualTotal += cleaningFee;
        } else if (usedMinibar) {
            actualTotal += minibarFee;
        }
        return actualTotal;
    }

    @Override
    public String toString() {
        return "RESERVATION - " + getName() + " - " + getEstimatedTotal();
    }
}
