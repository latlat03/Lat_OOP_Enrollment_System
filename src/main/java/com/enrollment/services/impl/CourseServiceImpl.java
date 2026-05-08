package com.enrollment.services.impl;

import com.enrollment.entities.Course;
import com.enrollment.services.ICourseService;

import java.util.ArrayList;
import java.util.List;

public class CourseServiceImpl implements ICourseService {
    private List<Course> courseList = new ArrayList<>();

    @Override
    public void addCourse(Course course) { // Renamed from save
        courseList.add(course);
        System.out.println("Course " + course.getCourseName() + " added successfully.");
    }

    @Override
    public void displayAllCourses() {
        if (courseList.isEmpty()) {
            System.out.println("No courses available.");
        } else {
            for (Course c : courseList) {
                System.out.println("Course Code: " + c.getCourseCode() +
                        " | Name: " + c.getCourseName() +
                        " | Program: " + c.getCourseProgram());
            }
        }
    }

    @Override
    public void updateCourse(Course course) {
        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getCourseCode().equals(course.getCourseCode())) {
                courseList.set(i, course);
                System.out.println("Course updated.");
                return;
            }
        }
        System.out.println("Course code not found.");
    }

    @Override
    public void removeCourse(String courseID) {
        boolean removed = courseList.removeIf(c -> c.getCourseCode().equalsIgnoreCase(courseID));
        if (removed) {
            System.out.println("Course " + courseID + " removed.");
        } else {
            System.out.println("Course not found.");
        }
    }
}