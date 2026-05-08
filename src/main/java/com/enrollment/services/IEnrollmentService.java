package com.enrollment.services;

import com.enrollment.entities.Section;
import com.enrollment.entities.Student;
import java.util.List;

public interface IEnrollmentService {
    void saveSection(Section section);
    List<Section> getAllSections();

    Section findBySectionName(String sectionName);
    void updateSection(String oldName, Section updatedSection);
    void deleteSection(String sectionName);

    void enrollStudentInSection(Student student, String sectionName);
}