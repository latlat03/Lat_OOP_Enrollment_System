package com.enrollment.services;

import com.enrollment.entities.Course;

public interface CourseReg {
    void save(Course course);
    void displayAll();
    void updateCourse(Course course);
    void removeCourse(String courseID); // Changed to String ID for easier menu logic
}