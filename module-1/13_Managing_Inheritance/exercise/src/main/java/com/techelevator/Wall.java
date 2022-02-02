package com.techelevator;

public abstract class Wall {
    //Instance variables
    private String name, color;

    //Constructor
    public Wall (String name, String color) {
        this.name = name;
        this.color = color;
    }

    //Method
    public abstract int getArea();

    //Getters
    public String getName() {
        return this.name;
    }

    public String getColor() {
        return this.color;
    }
}
