package com.enrollment.services;

import com.enrollment.entities.Student;

public interface StudentReg {
    void saveStudent(Student student);
    void displayAllStudents();
    boolean updateStudent(Student student);
    boolean removeStudent(String id);
    Student findStudent(String id); // Added to the contract
}