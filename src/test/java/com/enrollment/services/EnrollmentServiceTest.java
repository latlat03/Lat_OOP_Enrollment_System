package com.enrollment.services;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.enrollment.entities.Student;
import com.enrollment.entities.Section;
import com.enrollment.services.impl.EnrollmentServiceImpl;
import com.enrollment.exceptions.DuplicateEnrollmentException;
import com.enrollment.exceptions.SectionFullException;

public class EnrollmentServiceTest {

    private EnrollmentServiceImpl enrollmentService;
    private Student testStudent;
    private Section testSection;

    @BeforeEach
    void setUp() {
        // ARRANGE (Global)
        enrollmentService = new EnrollmentServiceImpl();
        testStudent = new Student("S101", "John Porkie", "CS");
        testSection = new Section("CS101-A", 5);

        enrollmentService.saveSection(testSection);
    }

    @Test
    void testSuccessfulEnrollment() {
        // ACT
        assertDoesNotThrow(() -> {
            enrollmentService.enrollStudentInSection(testStudent, "CS101-A");
        });

        //  ASSERT
        assertEquals(1, testSection.getEnrolledStudents().size(), "Section should have 1 student.");
    }

    @Test
    void testDuplicateEnrollmentThrowsException() {
        // ARRANGE
        assertDoesNotThrow(() -> {
            enrollmentService.enrollStudentInSection(testStudent, "CS101-A");
        });

        // ACT ANFD ASSERT
        assertThrows(DuplicateEnrollmentException.class, () -> {
            enrollmentService.enrollStudentInSection(testStudent, "CS101-A");
        }, "Should throw DuplicateEnrollmentException when enrolling same student twice.");
    }

    @Test
    void testSectionFullThrowsException() {
        // ARRANGE
        Section tinySection = new Section("TINY-101", 1);
        enrollmentService.saveSection(tinySection);
        Student student2 = new Student("S102", "Jesabel Jessie J", "IT");

        assertDoesNotThrow(() -> {
            enrollmentService.enrollStudentInSection(testStudent, "TINY-101");
        });

        // ACT AND ASSERT
        assertThrows(SectionFullException.class, () -> {
            enrollmentService.enrollStudentInSection(student2, "TINY-101");
        }, "Should throw SectionFullException when capacity is exceeded.");
    }
}