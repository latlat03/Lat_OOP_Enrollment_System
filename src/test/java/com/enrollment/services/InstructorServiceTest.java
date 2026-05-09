package com.enrollment.services;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.enrollment.entities.Instructor;
import com.enrollment.services.impl.InstructorServiceImpl;

public class InstructorServiceTest {

    private IInstructorService instructorService;

    @BeforeEach
    void setUp() {
        instructorService = new InstructorServiceImpl();
    }

    @Test
    void testAddAndFindInstructor() {
        // ARRANGE
        Instructor prof = new Instructor("INS-501", "Dr. Kelvin", "Advanced Java");

        // ACT
        instructorService.addInstructor(prof);
        Instructor found = instructorService.getInstructorDetails("INS-501");

        // ASSERT
        assertNotNull(found, "Instructor should be successfully retrieved.");
        assertEquals("Dr. Kelvin", found.getPersonName());
    }
}