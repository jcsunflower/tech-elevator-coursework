package com.techelevator;

public class Airplane {

    //Instance variables
    private String planeNumber;
    private int totalFirstClassSeats, bookedFirstClassSeats, totalCoachSeats, bookedCoachSeats;

    //Derived variables
    private int availableFirstClassSeats() {
        return totalFirstClassSeats - bookedFirstClassSeats;
    }

    private int availableCoachSeats() {
        return totalCoachSeats - bookedCoachSeats;
    }

    //Constructor
    public Airplane(String planeNumber, int totalFirstClassSeats, int totalCoachSeats) {
        if (planeNumber.length() == 6) {
            this.planeNumber = planeNumber;
        }
        this.totalFirstClassSeats = totalFirstClassSeats;
        this.totalCoachSeats = totalCoachSeats;
    }

    //Method
    public boolean reserveSeats(boolean forFirstClass, int totalNumberOfSeats) {
        if (forFirstClass) {
            if (totalFirstClassSeats - bookedFirstClassSeats >= totalNumberOfSeats) {
                bookedFirstClassSeats += totalNumberOfSeats;
                return true;
            } else {
                return false;
            }
        }
        else {
            if (totalCoachSeats - bookedCoachSeats >= totalNumberOfSeats) {
                bookedCoachSeats += totalNumberOfSeats;
                return true;
            }
            else {
                return false;
            }
        }
    }
    //Getters
    public String getPlaneNumber() {
        return this.planeNumber;
    }

    public int getTotalFirstClassSeats() {
        return this.totalFirstClassSeats;
    }

    public int getBookedFirstClassSeats() {
        return this.bookedFirstClassSeats;
    }

    public int getAvailableFirstClassSeats() {
        return this.availableFirstClassSeats();
    }

    public int getTotalCoachSeats() {
        return this.totalCoachSeats;
    }

    public int getBookedCoachSeats() {
        return this.bookedCoachSeats;
    }

    public int getAvailableCoachSeats() {
        return this.availableCoachSeats();
    }
}
