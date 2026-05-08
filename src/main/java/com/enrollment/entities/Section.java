package com.enrollment.entities;

import java.util.ArrayList;
import java.util.List;

public class Section {
    private String sectionName;
    private int maxCapacity;
    private Instructor assignedInstructor;
    private List<Student> enrolledStudents;

    public Section(String sectionName, int maxCapacity) {
        this.sectionName = sectionName;
        this.maxCapacity = maxCapacity;
        this.enrolledStudents = new ArrayList<>();
    }

    // Getters and Setters
    public String getSectionName() { return sectionName; }
    public void setSectionName(String sectionName) { this.sectionName = sectionName; }

    public int getMaxCapacity() { return maxCapacity; }
    public void setMaxCapacity(int maxCapacity) { this.maxCapacity = maxCapacity; }

    public Instructor getAssignedInstructor() { return assignedInstructor; }
    public void setAssignedInstructor(Instructor assignedInstructor) { this.assignedInstructor = assignedInstructor; }

    public List<Student> getEnrolledStudents() { return enrolledStudents; }
    public void setEnrolledStudents(List<Student> enrolledStudents) { this.enrolledStudents = enrolledStudents; }

    @Override
    public String toString() {
        // Updated to show dynamic capacity instead of hardcoded 40
        String instructorName = (assignedInstructor != null) ? assignedInstructor.getPersonName() : "TBA";        return "Section: " + sectionName +
                " | Instructor: " + instructorName +
                " | Enrolled: " + enrolledStudents.size() + "/" + maxCapacity;
    }
}