package com.enrollment.entities;

public class Instructor extends Person {
    private String courses;

    public Instructor(String PersonID, String PersonName, String courses) {
        super(PersonID, PersonName);
        this.courses = courses;
    }

    public String getCourses() { return courses; }
    public void setCourses(String courses) { this.courses = courses; }

    @Override
    public void mainTask() {
        System.out.println("Instructor teaches");
    }
}