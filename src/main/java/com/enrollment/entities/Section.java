package com.enrollment.entities;

import java.util.ArrayList;
import java.util.List;

public class Section {
    private String sectionName;
    private List<Student> studentList;

    public Section(String sectionName) {
        this.sectionName = sectionName;
        this.studentList = new ArrayList<>();
    }

    public String getSectionName() { return sectionName; }
    public void setSectionName(String sectionName) { this.sectionName = sectionName; }

    public List<Student> getStudentList() { return studentList; }
    public void setStudentList(List<Student> studentList) { this.studentList = studentList; }

    @Override
    public String toString() {
        return "Section: " + sectionName + " | Enrolled: " + studentList.size() + "/40";
    }
}