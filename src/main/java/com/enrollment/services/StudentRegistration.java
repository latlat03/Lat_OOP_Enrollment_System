package com.enrollment.services;

import com.enrollment.entities.Student;
import java.util.ArrayList;

public class StudentRegistration { // Removed "extends Person"
    private ArrayList<Student> studentList = new ArrayList<>();

    public void saveStudent(Student student) {
        studentList.add(student);
    }

    public void displayAllStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students registered yet.");
        } else {
            for (Student s : studentList) {
                System.out.println(s);
            }
        }
    }

    public boolean updateStudent(Student student) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getPersonID().equals(student.getPersonID())) {
                studentList.set(i, student);
                return true;
            }
        }
        return false;
    }

    public Student findStudent(String id) {
        for (Student s : studentList) {
            if (s.getPersonID().equalsIgnoreCase(id)) {
                return s;
            }
        }
        return null;
    }
}