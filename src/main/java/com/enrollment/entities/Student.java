package com.enrollment.entities;

public class Student extends Person {
    private String program;
    private double balance;

    public Student(String PersonID, String PersonName, String program) {
        super(PersonID, PersonName);
        this.program = program;
        this.balance = 0.0;
    }

    public String getProgram() { return program; }
    public void setProgram(String program) { this.program = program; }

    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }

    @Override
    public void mainTask() {
        System.out.println("Student " + getPersonName() + " is currently studying " + program + ".");
    }

    @Override
    public String toString() {
        return "Student Info [ID: " + getPersonID() +
                ", Name: " + getPersonName() +
                ", Program: " + program +
                ", Balance: $" + String.format("%.2f", balance) + "]";
    }
}