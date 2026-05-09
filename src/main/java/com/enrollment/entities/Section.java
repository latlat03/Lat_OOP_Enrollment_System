package com.enrollment.entities;

import java.util.ArrayList;
import java.util.List;

public class Section {
    private String sectionName;
    private int maxCapacity;
    private Instructor assignedInstructor;
    private Course course;
    private List<Student> enrolledStudents;

    public Section(String sectionName, int maxCapacity) {
        this.sectionName = sectionName;
        this.maxCapacity = maxCapacity;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getSectionName() { return sectionName; }
    public void setSectionName(String sectionName) { this.sectionName = sectionName; }

    public int getMaxCapacity() { return maxCapacity; }
    public void setMaxCapacity(int maxCapacity) { this.maxCapacity = maxCapacity; }

    public Instructor getAssignedInstructor() { return assignedInstructor; }
    public void setAssignedInstructor(Instructor assignedInstructor) { this.assignedInstructor = assignedInstructor; }

    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }

    public List<Student> getEnrolledStudents() { return enrolledStudents; }
    public void setEnrolledStudents(List<Student> enrolledStudents) { this.enrolledStudents = enrolledStudents; }

    @Override
    public String toString() {
        String instructorName = (assignedInstructor != null) ? assignedInstructor.getPersonName() : "TBA";
        String courseName = (course != null) ? course.getCourseName() : "No Course Assigned";

        return "Section: " + sectionName +
                " | Course: " + courseName +
                " | Instructor: " + instructorName +
                " | Enrolled: " + enrolledStudents.size() + "/" + maxCapacity;
    }
}