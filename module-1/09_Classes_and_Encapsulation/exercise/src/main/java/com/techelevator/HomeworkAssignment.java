package com.techelevator;

import org.w3c.dom.ls.LSOutput;

public class HomeworkAssignment {
    //Instance variables
    private int earnedMarks, possibleMarks;
    private String submitterName;

    //Derived variables
    public String letterGrade() {
        double grade = (double) earnedMarks / possibleMarks;
        if (grade >= 0.90) {
            return "A";
        }
        else if (grade >= 0.80 && grade <= 0.89) {
            return "B";
        }
        else if (grade >= 0.70 && grade <= 0.79) {
            return "C";
        }
        else if (grade >= 0.60 && grade <= 0.69) {
            return "D";
        }
        else {
            return "F";
        }
    }

    //Constructor
    public HomeworkAssignment(int possibleMarks, String submitterName) {
        this.possibleMarks = possibleMarks;
        this.submitterName = submitterName;
    }

    //Getters and setters
    public int getEarnedMarks() {
        return this.earnedMarks;
    }

    public void setEarnedMarks(int earnedMarks) {
        this.earnedMarks = earnedMarks;
    }

    public int getPossibleMarks() {
        return this.possibleMarks;
    }

    public String getSubmitterName() {
        return this.submitterName;
    }

    public String getLetterGrade() {
        return this.letterGrade();
    }
}

