package com.enrollment.services;

import com.enrollment.entities.Course;
import com.enrollment.entities.Person;
import java.util.ArrayList;

public class CourseRegistration extends Person {
    private ArrayList<Course> courseList = new ArrayList<>();

    // Add a new course
    public void save(Course course) {
        courseList.add(course);
    }

    public void displayAll() {
        for (Course c : courseList) {
            System.out.println("Course ID: " + c.getPersonID());
            System.out.println("Course Name: " + c.getPersonName());
            System.out.println("Program: " + c.getCourseProgram() + "\n");
        }
    }

    public void updateCourse(Course course) {
        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getPersonID().equals(course.getPersonID())) {
                courseList.set(i, course);
                break;
            }
        }
    }

    public void removeCourse(Course course) {
        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getPersonID().equals(course.getPersonID())) {
                courseList.remove(i);
                break;
            }
        }
    }

    @Override
    public void mainTask() {
        System.out.println("Registers courses");
    }
}