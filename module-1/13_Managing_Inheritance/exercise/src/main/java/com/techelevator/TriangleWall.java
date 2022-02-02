package com.techelevator;

public class TriangleWall extends Wall {
    //Instance variables
    private int base, height;

    //Constructor
    public TriangleWall(String name, String color, int base, int height) {
        super(name, color);
        this.base = base;
        this.height = height;
    }

    //Methods
    @Override
    public int getArea() {
        return (base * height) / 2;
    }

    public String toString() {
        return super.getName() + " (" + this.base + "x" + this.height + ") " + "triangle";
    }

    //Getters
    public int getBase() {
        return this.base;
    }

    public int getHeight() {
        return this.height;
    }
}
