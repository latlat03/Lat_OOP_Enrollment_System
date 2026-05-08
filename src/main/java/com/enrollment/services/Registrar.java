package com.enrollment.services;

import com.enrollment.entities.*;

public class Registrar {
    private final IStudentService studentService;
    private final ICourseService courseService;
    private final IInstructorService instructorService;
    private final IEnrollmentService enrollmentService;
    private final IDepartmentService departmentService;

    public Registrar(IStudentService studentService,
                     ICourseService courseService,
                     IInstructorService instructorService,
                     IEnrollmentService enrollmentService,
                     IDepartmentService departmentService) {
        this.studentService = studentService;
        this.courseService = courseService;
        this.instructorService = instructorService;
        this.enrollmentService = enrollmentService;
        this.departmentService = departmentService;
    }

    //  Student Bridge Methods
    public void saveStudent(Student student) { studentService.addStudent(student); }
    public void displayAllStudents() { studentService.displayAllStudents(); }
    public Student findStudent(String id) { return studentService.findStudent(id); }

    //  Course Bridge Methods
    public void saveCourse(Course course) { courseService.addCourse(course); }
    public void displayAllCourses() { courseService.displayAllCourses(); }

    //  Instructor Bridge Methods
    public void saveInstructor(Instructor instructor) { instructorService.addInstructor(instructor); }
    public void displayAllInstructors() { instructorService.displayAllInstructors(); }
    public Instructor findInstructor(String id) { return instructorService.getInstructorDetails(id); }

    //  Section & Enrollment Bridge Methods
    public void saveSection(Section section) { enrollmentService.saveSection(section); }
    public void displayAllSections() {
        for (Section s : enrollmentService.getAllSections()) {
            System.out.println(s);
        }
    }

    public void enrollStudentInSection(String sectionName, Student student) {
        enrollmentService.enrollStudentInSection(student, sectionName);
    }

    //  Department Bridge Methods
    public void saveDepartment(Department dept) { departmentService.addDepartment(dept); }

    public void displayDepartments() {
        if (departmentService.getAllDepartments().isEmpty()) {
            System.out.println("No departments registered.");
        } else {
            for (Department d : departmentService.getAllDepartments()) {
                System.out.println(d);
            }
        }
    }
}