package com.enrollment.services;

import com.enrollment.entities.Section;
import com.enrollment.entities.Student;
import java.util.List;

public interface SectionReg {
    void save(Section section);
    List<Section> displayAll();
    Section findBySectionName(String sectionName);
    void updateSection(String oldName, Section updatedSection);
    void deleteSection(String sectionName);
    void addStudentToSection(String sectionName, Student student);
}