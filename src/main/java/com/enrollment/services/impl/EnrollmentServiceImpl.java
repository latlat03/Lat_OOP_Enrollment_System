package com.enrollment.services.impl;

import com.enrollment.entities.Course;
import com.enrollment.entities.Instructor;
import com.enrollment.entities.Section;
import com.enrollment.entities.Student;
import com.enrollment.exceptions.SectionFullException;
import com.enrollment.exceptions.DuplicateEnrollmentException;
import com.enrollment.services.IEnrollmentService;

import java.util.*;

public class EnrollmentServiceImpl implements IEnrollmentService {
    private List<Section> sections = new ArrayList<>();

    @Override
    public void saveSection(Section section) {
        sections.add(section);
        System.out.println("Section " + section.getSectionName() + " created with capacity: " + section.getMaxCapacity());
    }

    @Override
    public List<Section> getAllSections() {
        return sections;
    }

    @Override
    public Section findBySectionName(String sectionName) {
        for (Section s : sections) {
            if (s.getSectionName().equalsIgnoreCase(sectionName)) {
                return s;
            }
        }
        return null;
    }

    @Override
    public void enrollStudentInSection(Student student, String sectionName)
            throws SectionFullException, DuplicateEnrollmentException {

        Section foundSection = findBySectionName(sectionName);

        if (foundSection != null) {
            if (foundSection.getEnrolledStudents().contains(student)) {
                throw new DuplicateEnrollmentException("Enrollment Failed: " +
                        student.getPersonName() + " is already in " + sectionName);
            }

            if (foundSection.getEnrolledStudents().size() >= foundSection.getMaxCapacity()) {
                throw new SectionFullException("Enrollment Failed: " + sectionName +
                        " is at full capacity (" + foundSection.getMaxCapacity() + ").");
            }

            foundSection.getEnrolledStudents().add(student);
            System.out.println("Enrolled " + student.getPersonName() + " into " + sectionName);

        } else {
            System.out.println("Section " + sectionName + " not found!");
        }
    }

    @Override
    public void updateSection(String oldName, Section updatedSection) {
        for (int i = 0; i < sections.size(); i++) {
            if (sections.get(i).getSectionName().equalsIgnoreCase(oldName)) {
                sections.set(i, updatedSection);
                return;
            }
        }
    }

    @Override
    public void deleteSection(String sectionName) {
        sections.removeIf(s -> s.getSectionName().equalsIgnoreCase(sectionName));
    }

    @Override
    public void assignInstructorToSection(Instructor instructor, String sectionName) {
        Section foundSection = findBySectionName(sectionName);
        if (foundSection != null) {
            foundSection.setAssignedInstructor(instructor);
            System.out.println("Success: Instructor " + instructor.getPersonName() +
                    " assigned to section " + sectionName);
        } else {
            System.out.println("Error: Section " + sectionName + " not found!");
        }
    }

    @Override
    public void linkCourseToSection(Course course, String sectionName) {
        Section foundSection = findBySectionName(sectionName);
        if (foundSection != null) {
            foundSection.setCourse(course);
            System.out.println("Success: Section " + sectionName +
                    " is now an instance of " + course.getCourseName());
        } else {
            System.out.println("Error: Section " + sectionName + " not found!");
        }
    }
}