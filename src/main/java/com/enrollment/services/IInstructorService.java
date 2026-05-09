package com.enrollment.services;

import com.enrollment.entities.Instructor;

public interface IInstructorService {
    void addInstructor(Instructor instructor);     // Match Registrar
    void displayAllInstructors();                  // Match Registrar
    Instructor getInstructorDetails(String id);    // Match Registrar
    void updateInstructor(String id, Instructor updated);
    void deleteInstructor(String id);
}