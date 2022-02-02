package com.techelevator;

public class RectangleWall extends Wall {
    //Instance variables
    private int length, height;

    //Constructor
    public RectangleWall(String name, String color, int length, int height) {
        super(name, color);
        this.length = length;
        this.height = height;
    }

    //Methods
    @Override
    public int getArea() {
        return length * height;
    }

    public String toString() {
        return super.getName() + " (" + this.length + "x" + this.height + ") " + "rectangle";
    }

    //Getters
    public int getLength() {
        return this.length;
    }

    public int getHeight() {
        return this.height;
    }
}
