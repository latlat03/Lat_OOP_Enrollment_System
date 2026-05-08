package com.enrollment.services.impl;

import com.enrollment.entities.Section;
import com.enrollment.entities.Student;
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
    public void enrollStudentInSection(Student student, String sectionName) {
        Section foundSection = findBySectionName(sectionName);
        if (foundSection != null) {
            if (foundSection.getEnrolledStudents().size() < foundSection.getMaxCapacity()) {
                foundSection.getEnrolledStudents().add(student);
                System.out.println("Enrolled " + student.getPersonName() + " into " + sectionName);
            } else {
                System.out.println("Enrollment Failed: " + sectionName + " is at full capacity (" + foundSection.getMaxCapacity() + ").");
            }
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
}