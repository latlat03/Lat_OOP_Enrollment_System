package com.enrollment.services;

import com.enrollment.entities.Department;
import java.util.List;

public interface DepartmentReg {
    void save(Department department);
    List<Department> displayAll();
}