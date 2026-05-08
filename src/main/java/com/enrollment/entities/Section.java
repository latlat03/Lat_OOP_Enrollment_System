package com.enrollment.entities; // 1. Match the folder path

import com.enrollment.entities.Student;
import com.enrollment.entities.Instructor;
import java.util.ArrayList;

public class Section {
    private String sectionID;
    private String sectionName;
    private Instructor instructor; // Changed to lowercase 'instructor' for consistency
    private ArrayList<Student> studentList;

    public Section(String sectionID, String sectionName, Instructor instructor) {
        this.sectionID = sectionID;
        this.sectionName = sectionName;
        this.instructor = instructor;
        this.studentList = new ArrayList<>();
    }

    public void addStudent(Student student) {
        studentList.add(student);
    }

    public void displaySectionDetails() {
        System.out.println("Section: " + sectionName + " (ID: " + sectionID + ")");
        System.out.println("Instructor: " + instructor.getPersonName());
        System.out.println("Students Enrolled:");
        for (Student s : studentList) {
            System.out.println("- " + s.getPersonName());
        }
    }
}