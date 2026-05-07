package com.enrollment;

import com.enrollment.entities.Student;
import com.enrollment.entities.Instructor;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Inheritance Test ---");

        Student student = new Student("S1001", "Mikel Jeckson");

        Instructor instructor = new Instructor("I2001", "Dr. Pepper", "Computer Science");

        System.out.println("Student: " + student.getName() + " (ID: " + student.getId() + ")");
        System.out.println("Instructor: " + instructor.getName() + " in " + instructor.getDepartment());
    }
}