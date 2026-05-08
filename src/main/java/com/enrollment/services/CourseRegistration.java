package com.enrollment.services;

import com.enrollment.entities.Course;
import java.util.ArrayList;

public class CourseRegistration implements CourseReg {
    private ArrayList<Course> courseList = new ArrayList<>();

    @Override
    public void save(Course course) {
        courseList.add(course);
    }

    @Override
    public void displayAll() {
        if (courseList.isEmpty()) {
            System.out.println("No courses available.");
        } else {
            for (Course c : courseList) {
                System.out.println("Course ID: " + c.getCourseCode());
                System.out.println("Course Name: " + c.getCourseName());
                System.out.println("Program: " + c.getCourseProgram() + "\n");
            }
        }
    }

    @Override
    public void updateCourse(Course course) {
        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getCourseCode().equals(course.getCourseCode())) {
                courseList.set(i, course);
                break;
            }
        }
    }

    @Override
    public void removeCourse(String courseID) {
        courseList.removeIf(c -> c.getCourseCode().equalsIgnoreCase(courseID));
    }
}