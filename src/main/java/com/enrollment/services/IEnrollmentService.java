package com.enrollment.services;

import com.enrollment.entities.Section;
import com.enrollment.entities.Student;
import com.enrollment.entities.Instructor;
import com.enrollment.entities.Course;
import com.enrollment.exceptions.SectionFullException;       // NEW IMPORT
import com.enrollment.exceptions.DuplicateEnrollmentException; // NEW IMPORT
import java.util.List;

public interface IEnrollmentService {
    void saveSection(Section section);
    List<Section> getAllSections();

    Section findBySectionName(String sectionName);
    void updateSection(String oldName, Section updatedSection);
    void deleteSection(String sectionName);

    void enrollStudentInSection(Student student, String sectionName)
            throws SectionFullException, DuplicateEnrollmentException;

    void assignInstructorToSection(Instructor instructor, String sectionName);
    void linkCourseToSection(Course course, String sectionName);
}