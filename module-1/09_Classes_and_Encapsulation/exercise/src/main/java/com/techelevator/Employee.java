package com.techelevator;

public class Employee {
    //Instance variables
    private int employeeID;
    private String firstName, lastName, department;
    private double annualSalary;

    //Derived attribute
    private String fullName() {
        return lastName + ", " + firstName;
    }

    //Constructor
    public Employee(int employeeID, String firstName, String lastName, double salary) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.annualSalary = salary;
    }

    //Method
    public void raiseSalary(double percent) {
        double raisePercent = percent / 100;
        double raiseValue = annualSalary * raisePercent;
        annualSalary += raiseValue;
    }

    //Getters & setters
    public int getEmployeeId() {
        return this.employeeID;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return this.fullName();
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getAnnualSalary() {
        return this.annualSalary;
    }
}
