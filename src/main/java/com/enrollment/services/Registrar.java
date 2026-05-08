package com.enrollment.services;

import com.enrollment.entities.Student;
import com.enrollment.entities.Course;
import com.enrollment.entities.Instructor;
import com.enrollment.entities.Section; // Add this import

public class Registrar {
    private StudentReg studentRegistration;
    private CourseReg courseRegistration;
    private final InstructorReg instructorReg;
    private final SectionReg sectionReg; // NEW

    public Registrar(StudentReg studentRegistration, CourseReg courseRegistration) {
        this.studentRegistration = studentRegistration;
        this.courseRegistration = courseRegistration;
        this.instructorReg = new InstructorRegistration();
        this.sectionReg = new SectionRegistration(); // NEW
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

    // --- Instructor Methods ---
    public void saveInstructor(Instructor instructor) { instructorReg.save(instructor); }
    public void displayAllInstructors() { instructorReg.displayAll(); }
    public Instructor findInstructor(String id) { return instructorReg.findByID(id); }
    public void updateInstructor(String id, Instructor updated) { instructorReg.updateInstructor(id, updated); }
    public void deleteInstructor(String id) { instructorReg.deleteInstructor(id); }

    // --- Section Methods (NEW) ---
    public void saveSection(Section section) { sectionReg.save(section); }

    public void displayAllSections() {
        if (sectionReg.displayAll().isEmpty()) {
            System.out.println("No sections created yet.");
        } else {
            for (Section s : sectionReg.displayAll()) {
                System.out.println(s);
            }
        }
    }

    // This is the bridge for your 40-student limit logic
    public void enrollStudentInSection(String sectionName, Student student) {
        sectionReg.addStudentToSection(sectionName, student);
    }
}