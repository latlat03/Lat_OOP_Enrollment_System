package com.enrollment.services;

import com.enrollment.entities.Instructor;

public interface InstructorReg {
    void save(Instructor instructor);
    void displayAll();
    Instructor findByID(String id);
    void updateInstructor(String id, Instructor updated);
    void deleteInstructor(String id);
}