package com.enrollment;

import com.enrollment.entities.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Hierarchy Test ---");

        Course javaCourse = new Course("CS101", "Java Programming", 3);

        Section it1a = new Section("IT-2D", 2);

        Instructor profDr = new Instructor("I001", "Dr. Pepper", "IT Department");
        it1a.setInstructor(profDr);

        Student student1 = new Student("S001", "MAKMAK");
        it1a.getEnrolledStudents().add(student1);

        Department itDept = new Department("College of Information Technology and Engineering");
        itDept.getSections().add(it1a);

        // Hierarchy Result
        System.out.println("Department: " + itDept.getDepartmentName());
        System.out.println("Section: " + itDept.getSections().get(0).getSectionName());
        System.out.println("Instructor: " + itDept.getSections().get(0).getInstructor().getName());
        System.out.println("Students Enrolled: " + it1a.getEnrolledStudents().size());
    }
}