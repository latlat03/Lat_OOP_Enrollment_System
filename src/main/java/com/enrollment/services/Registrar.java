package com.enrollment.services;

import com.enrollment.entities.*;

public class Registrar {
    private final IStudentService studentService;
    private final ICourseService courseService;
    private final IInstructorService instructorService;
    private final IEnrollmentService enrollmentService;
    private final IDepartmentService departmentService;
    private final ITuitionService tuitionService;

    public Registrar(IStudentService studentService,
                     ICourseService courseService,
                     IInstructorService instructorService,
                     IEnrollmentService enrollmentService,
                     IDepartmentService departmentService,
                     ITuitionService tuitionService) {

        this.studentService = studentService;
        this.courseService = courseService;
        this.instructorService = instructorService;
        this.enrollmentService = enrollmentService;
        this.departmentService = departmentService;
        this.tuitionService = tuitionService;
    }

    // STUDENT BRIDGE METHODS
    public void saveStudent(Student student) {
        studentService.addStudent(student);
    }

    public void displayAllStudents() {
        studentService.displayAllStudents();
    }

    public Student findStudent(String id) {
        return studentService.findStudent(id);
    }

    public void removeStudent(String id) {
        if(studentService.removeStudent(id)) {
            System.out.println("Student removed successfully.");
        } else {
            System.out.println("Error: Student ID not found.");
        }
    }

    public void updateStudent(String id, Student student) {
        studentService.updateStudent(id, student);
    }

    // COURSE BRIDGE METHODS
    public void saveCourse(Course course) {
        courseService.addCourse(course);
    }

    public void displayAllCourses() {
        courseService.displayAllCourses();
    }

    public Course findCourse(String code) {
        return courseService.findCourse(code);
    }

    public void updateCourse(Course course) {
        courseService.updateCourse(course.getCourseCode(), course);
    }

    public void removeCourse(String courseCode) {
        courseService.removeCourse(courseCode);
    }

    // INSTRUCTOR BRIDGE METHODS
    public void saveInstructor(Instructor instructor) {
        instructorService.addInstructor(instructor);
    }

    public void displayAllInstructors() {
        instructorService.displayAllInstructors();
    }

    public Instructor findInstructor(String id) {
        return instructorService.getInstructorDetails(id);
    }

    public void removeInstructor(String id) {
        instructorService.deleteInstructor(id);
    }

    public void updateInstructor(String id, Instructor instructor) {
        instructorService.updateInstructor(id, instructor);
    }

    // SECTION & ENROLLMENT BRIDGE METHODS
    public void saveSection(Section section) {
        enrollmentService.saveSection(section);
    }

    public void displayAllSections() {
        for (Section s : enrollmentService.getAllSections()) {
            System.out.println(s);
        }
    }

    public void deleteSection(String name) {
        enrollmentService.deleteSection(name);
        System.out.println("Section deleted.");
    }

    public void enrollStudentInSection(String sectionName, Student student) {
        enrollmentService.enrollStudentInSection(student, sectionName);
    }

    // Instructor to Section
    public void assignInstructorToSection(Instructor instructor, String sectionName) {
        enrollmentService.assignInstructorToSection(instructor, sectionName);
    }

    // Course to Section
    public void linkCourseToSection(Course course, String sectionName) {
        enrollmentService.linkCourseToSection(course, sectionName);
    }

    // DEPARTMENT BRIDGE METHODS
    public void saveDepartment(Department dept) {
        departmentService.addDepartment(dept);
    }

    public void displayDepartments() {
        if (departmentService.getAllDepartments().isEmpty()) {
            System.out.println("No departments registered.");
        } else {
            for (Department d : departmentService.getAllDepartments()) {
                System.out.println(d);
            }
        }
    }

    // FINANCE/TUITION BRIDGE METHODS
    public void processTuition(Student student, int units) {
        tuitionService.processStudentTuition(student, units);
        System.out.println("Processing complete for " + student.getPersonName());
        System.out.println("Current Student Balance: $" + String.format("%.2f", student.getBalance()));
    }
}