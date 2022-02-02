package com.techelevator;

public class SquareWall extends RectangleWall {
    //Instance variables
    private int sideLength;

    // Constructor
    public SquareWall(String name, String color, int sideLength) {
        super(name, color, sideLength, sideLength);
        this.sideLength = sideLength;
    }

    //Method
    public String toString() {
        return super.getName() + " (" + this.sideLength + "x" + this.sideLength + ") " + "square";
    }

    //Getter
    public int getSideLength() {
        return this.sideLength;
    }
}
