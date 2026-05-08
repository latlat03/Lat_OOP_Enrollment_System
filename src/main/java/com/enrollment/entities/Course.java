package com.enrollment.entities;

public class Course {
    private String courseCode;
    private String courseName;
    private String courseProgram;

    public Course(String courseCode, String courseName, String courseProgram) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.courseProgram = courseProgram;
    }

    // Getters
    public String getCourseCode() { return courseCode; }
    public String getCourseName() { return courseName; }
    public String getCourseProgram() { return courseProgram; }
}