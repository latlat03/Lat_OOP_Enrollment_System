package com.enrollment.services;

import com.enrollment.entities.Department;
import java.util.List;

public interface IDepartmentService {
    void addDepartment(Department department);
    List<Department> getAllDepartments();
}