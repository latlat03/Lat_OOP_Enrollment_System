package com.enrollment.services;

import com.enrollment.entities.Student;

public interface ITuitionService {
    void processStudentTuition(Student student, int units);

    double getStudentBalance(Student student);
}