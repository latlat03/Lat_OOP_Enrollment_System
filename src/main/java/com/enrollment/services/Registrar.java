package com.enrollment.services;

import com.enrollment.entities.Student;
import com.enrollment.entities.Course;

public class Registrar {
    private StudentReg studentRegistration;
    private CourseReg courseRegistration;

    public Registrar(StudentReg studentRegistration, CourseReg courseRegistration) {
        this.studentRegistration = studentRegistration;
        this.courseRegistration = courseRegistration;
    }

    // --- Student Methods ---
    public void saveStudent(Student student) { studentRegistration.saveStudent(student); }
    public void displayAllStudents() { studentRegistration.displayAllStudents(); }
    public boolean removeStudent(String id) { return studentRegistration.removeStudent(id); }
    public Student findStudent(String id) { return studentRegistration.findStudent(id); }
    public boolean updateStudent(Student student) { return studentRegistration.updateStudent(student); }

    // --- Course Methods ---
    public void saveCourse(Course course) { courseRegistration.save(course); }
    public void displayAllCourses() { courseRegistration.displayAll(); }
    public void removeCourse(String courseID) { courseRegistration.removeCourse(courseID); }
}