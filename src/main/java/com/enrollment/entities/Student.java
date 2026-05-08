package com.enrollment.entities;

public class Student extends Person {
    private String program;

    public Student(String PersonID, String PersonName, String program) {
        super(PersonID, PersonName);
        this.program = program;
    }

    public String getProgram() { return program; }
    public void setProgram(String program) { this.program = program; }

    @Override
    public void mainTask() {
        System.out.println("Student learns");
    }
}