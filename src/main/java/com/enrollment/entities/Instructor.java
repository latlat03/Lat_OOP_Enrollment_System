package com.enrollment.entities;

public class Instructor extends Person {
    private String department;

    public Instructor(String id, String name, String department) {
        super(id, name);
        this.department = department;
    }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
}