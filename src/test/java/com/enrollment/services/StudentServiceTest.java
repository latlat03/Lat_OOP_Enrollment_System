package com.enrollment.services;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.enrollment.entities.Student;
import com.enrollment.services.impl.StudentServiceImpl;

public class StudentServiceTest {

    private IStudentService studentService;

    @BeforeEach
    void setUp() {
        // Initialize the service before each test
        studentService = new StudentServiceImpl();
    }

    @Test
    void testSaveAndFindStudent() {
        // ARRANGE
        Student student = new Student("S101", "Alice", "Computer Science");

        // ACT
        studentService.addStudent(student);
        Student found = studentService.findStudent("S101");

        // ASSERT
        assertNotNull(found, "Student should be found in the system.");
        assertEquals("Alice", found.getPersonName());
    }
}