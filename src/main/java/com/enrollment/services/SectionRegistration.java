package com.enrollment.services;

import com.enrollment.entities.Section;
import com.enrollment.entities.Student;
import java.util.*;

public class SectionRegistration implements SectionReg {
    private List<Section> sections = new ArrayList<>();

    @Override
    public void save(Section section) {
        sections.add(section);
        System.out.println("Section " + section.getSectionName() + " created.");
    }

    @Override
    public List<Section> displayAll() {
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
    public void addStudentToSection(String sectionName, Student student) {
        Section foundSection = findBySectionName(sectionName);
        if (foundSection != null) {
            // YOUR SPECIFIC REQUIREMENT: 40 Student Limit
            if (foundSection.getStudentList().size() < 40) {
                foundSection.getStudentList().add(student);
                System.out.println("Enrolled " + student.getPersonName() + " into " + sectionName);
            } else {
                System.out.println("Enrollment Failed: " + sectionName + " is full (40/40).");
            }
        } else {
            System.out.println("Section not found!");
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