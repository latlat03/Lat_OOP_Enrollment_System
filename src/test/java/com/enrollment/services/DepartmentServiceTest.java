package com.enrollment.services;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.enrollment.entities.Department;
import com.enrollment.services.impl.DepartmentServiceImpl;

public class DepartmentServiceTest {

    private IDepartmentService deptService;

    @BeforeEach
    void setUp() {
        deptService = new DepartmentServiceImpl();
    }

    @Test
    void testSaveAndRetrieveDepartment() {
        // ARRANGE
        Department dept = new Department("College of Information Technology");

        // ACT
        deptService.addDepartment(dept);

        // ASSERT
        assertFalse(deptService.getAllDepartments().isEmpty(), "Department list should not be empty.");
        assertEquals("College of Information Technology", deptService.getAllDepartments().get(0).getDepartmentName());
    }
}