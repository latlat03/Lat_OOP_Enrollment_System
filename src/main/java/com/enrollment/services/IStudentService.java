package com.enrollment.services;

import com.enrollment.entities.Student;

public interface IStudentService {
    void addStudent(Student student);
    void displayAllStudents();
    boolean updateStudent(String id, Student student);
    boolean removeStudent(String id);
    Student findStudent(String id);
}