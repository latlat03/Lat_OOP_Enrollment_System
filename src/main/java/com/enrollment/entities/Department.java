package com.enrollment.entities;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String departmentName;
    private List<Instructor> instructorList;
    private List<Section> sectionList;

    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.instructorList = new ArrayList<>();
        this.sectionList = new ArrayList<>();
    }

    public String getDepartmentName() { return departmentName; }
    public List<Instructor> getInstructorList() { return instructorList; }
    public List<Section> getSectionList() { return sectionList; }

    @Override
    public String toString() {
        return "Department: " + departmentName +
                " | Instructors: " + instructorList.size() +
                " | Sections: " + sectionList.size();
    }
}