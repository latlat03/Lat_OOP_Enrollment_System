package com.enrollment.entities; // Keep your package name!

public class Instructor extends Person {
    private String course; // Changed from courses to course to match Meg's logic

    public Instructor(String personID, String personName, String course) {
        super(personID, personName);
        this.course = course;
    }

    // Changed to getCourse() so InstructorRegistration can find it
    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }

    @Override
    public void mainTask() {
        System.out.println("Instructor " + getPersonName() + " is currently teaching " + course);
    }

    @Override
    public String toString() {
        return "Instructor Info [ID: " + getPersonID() +
                ", Name: " + getPersonName() +
                ", Course: " + course + "]";
    }
}