package com.techelevator;

public class Elevator {
    //Instance variables
    private int currentFloor, numberOfFloors;
    private boolean doorOpen;

    //Constructor
    public Elevator(int numberOfLevels) {
        this.currentFloor = 1;
        this.numberOfFloors = numberOfLevels;
    }

    //Methods
    public void openDoor() {
        doorOpen = true;
    }

    public void closeDoor() {
        doorOpen = false;
    }

    public void goUp(int desiredFloor) {
        if (!doorOpen && desiredFloor > currentFloor && desiredFloor <= numberOfFloors) {
            currentFloor = desiredFloor;
        }
    }

    public void goDown(int desiredFloor) {
        if (!doorOpen && desiredFloor < currentFloor && desiredFloor >= 1) {
            currentFloor = desiredFloor;
        }
    }

    //Getters
    public int getCurrentFloor() {
        return this.currentFloor;
    }

    public int getNumberOfFloors() {
        return this.numberOfFloors;
    }

    public boolean isDoorOpen() {
        return this.doorOpen;
    }
}
