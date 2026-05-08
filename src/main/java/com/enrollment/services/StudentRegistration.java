package com.enrollment.services;

import com.enrollment.entities.Student;
import java.util.ArrayList;

public class StudentRegistration implements StudentReg {
    private ArrayList<Student> studentList = new ArrayList<>();

    @Override
    public void saveStudent(Student student) {
        studentList.add(student);
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
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeStudent(String id) {
        return studentList.removeIf(s -> s.getPersonID().equalsIgnoreCase(id));
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