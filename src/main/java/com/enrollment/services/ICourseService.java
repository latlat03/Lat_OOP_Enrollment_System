package com.enrollment.services;

import com.enrollment.entities.Course;

public interface ICourseService {
    void addCourse(Course course);
    void displayAllCourses();
    void updateCourse(Course course);
    void removeCourse(String courseID);
}