package com.enrollment.services.impl;

import com.enrollment.entities.Department;
import com.enrollment.services.IDepartmentService;

import java.util.*;

public class DepartmentServiceImpl implements IDepartmentService {
    private List<Department> departments = new ArrayList<>();

    @Override
    public void addDepartment(Department department) {
        departments.add(department);
        System.out.println("Department '" + department.getDepartmentName() + "' registered successfully.");
    }

    @Override
    public List<Department> getAllDepartments() {
        return departments;
    }
}