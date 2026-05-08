package com.enrollment.services;

import com.enrollment.entities.Person;
import com.enrollment.entities.Student;
import java.util.ArrayList;

public class StudentRegistration extends Person {
    private ArrayList<Student> studentList = new ArrayList<>();

    public void saveStudent(Student student) {
        studentList.add(student);
    }

    public void displayAllStudents() {
        for (Student s : studentList) {
            System.out.println("\nID: " + s.getPersonID() + " | Name: " + s.getPersonName() + " | Program: " + s.getProgram());
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

    @Override
    public void mainTask() {
        System.out.println("Registers students");
    }
}