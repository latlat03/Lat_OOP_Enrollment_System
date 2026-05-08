package com.enrollment.services;

import com.enrollment.entities.Instructor;
import java.util.*;

public class InstructorRegistration implements InstructorReg {
    private List<Instructor> instructors = new ArrayList<>();

    @Override
    public void save(Instructor instructor) {
        instructors.add(instructor);
        System.out.println("Instructor " + instructor.getPersonName() + " saved successfully.");
    }

    @Override
    public void displayAll() {
        if (instructors.isEmpty()) {
            System.out.println("No instructors found.");
            return;
        }
        for (Instructor i : instructors) {
            System.out.println("\n--- Instructor Details ---");
            System.out.println("Name: " + i.getPersonName());
            System.out.println("ID:   " + i.getPersonID());
            System.out.println("Course: " + i.getCourse());
        }
    }

    @Override
    public Instructor findByID(String id) {
        for (Instructor i : instructors) {
            if (i.getPersonID().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return null;
    }

    @Override
    public void updateInstructor(String id, Instructor updated) {
        for (int i = 0; i < instructors.size(); i++) {
            if (instructors.get(i).getPersonID().equalsIgnoreCase(id)) {
                instructors.set(i, updated);
                System.out.println("Instructor ID " + id + " updated successfully.");
                return;
            }
        }
        System.out.println("Update failed: ID not found.");
    }

    @Override
    public void deleteInstructor(String id) {
        boolean removed = instructors.removeIf(i -> i.getPersonID().equalsIgnoreCase(id));
        if (removed) {
            System.out.println("Instructor ID " + id + " deleted.");
        } else {
            System.out.println("Delete failed: ID not found.");
        }
    }
}