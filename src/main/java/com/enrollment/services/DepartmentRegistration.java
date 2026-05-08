package com.enrollment.services;

import com.enrollment.entities.Department;
import java.util.*;

public class DepartmentRegistration implements DepartmentReg {
    private List<Department> departments = new ArrayList<>();

    @Override
    public void save(Department department) {
        departments.add(department);
        System.out.println("Department '" + department.getDepartmentName() + "' registered.");
    }

    @Override
    public List<Department> displayAll() {
        return departments;
    }
}