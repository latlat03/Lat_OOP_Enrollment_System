package com.enrollment.entities;

public class Student extends Person {
    // Encapsulated field: only accessible within this class
    private String program;

    public Student(String PersonID, String PersonName, String program) {
        super(PersonID, PersonName);
        this.program = program;
    }

    // Getter for program
    public String getProgram() {
        return program;
    }

    // Setter for program
    public void setProgram(String program) {
        this.program = program;
    }

    // Implementation of the abstract method
    @Override
    public void mainTask() {
        System.out.println("Student " + getPersonName() + " is currently studying " + program + ".");
    }

    @Override
    public String toString() {
        return "Student Info [ID: " + getPersonID() +
                ", Name: " + getPersonName() +
                ", Program: " + program + "]";
    }
}