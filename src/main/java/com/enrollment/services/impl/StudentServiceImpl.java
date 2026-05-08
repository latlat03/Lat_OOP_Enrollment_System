package com.enrollment.services.impl;

import com.enrollment.entities.Student;
import com.enrollment.services.IStudentService;

import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements IStudentService {
    private List<Student> studentList = new ArrayList<>();

    @Override
    public void addStudent(Student student) {
        studentList.add(student);
        System.out.println("Student " + student.getPersonName() + " added successfully.");
    }

    @Override
    public void displayAllStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students registered yet.");
        } else {
            for (Student s : studentList) {
                System.out.println(s);
            }
        }
    }

    @Override
    public boolean updateStudent(Student student) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getPersonID().equals(student.getPersonID())) {
                studentList.set(i, student);
                System.out.println("Student ID " + student.getPersonID() + " updated.");
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeStudent(String id) {
        boolean removed = studentList.removeIf(s -> s.getPersonID().equalsIgnoreCase(id));
        if (removed) {
            System.out.println("Student ID " + id + " removed.");
        }
        return removed;
    }

    @Override
    public Student findStudent(String id) {
        for (Student s : studentList) {
            if (s.getPersonID().equalsIgnoreCase(id)) {
                return s;
            }
        }
        return null;
    }
}