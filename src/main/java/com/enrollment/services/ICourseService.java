package com.enrollment.services;

import com.enrollment.entities.Course;

public interface ICourseService {
    void addCourse(Course course);      // Renamed from save
    void displayAllCourses();           // Renamed from displayAll
    void updateCourse(Course course);
    void removeCourse(String courseID);
}