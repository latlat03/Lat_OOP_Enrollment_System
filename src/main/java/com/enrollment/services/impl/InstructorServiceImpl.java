package com.enrollment.services.impl;

import com.enrollment.entities.Instructor;
import com.enrollment.services.IInstructorService;

import java.util.*;

public class InstructorServiceImpl implements IInstructorService {
    private List<Instructor> instructors = new ArrayList<>();

    @Override
    public void addInstructor(Instructor instructor) {
        instructors.add(instructor);
        System.out.println("Instructor " + instructor.getPersonName() + " added successfully.");
    }

    @Override
    public void displayAllInstructors() {
        if (instructors.isEmpty()) {
            System.out.println("No instructors found.");
            return;
        }
        for (Instructor i : instructors) {
            System.out.println(i);
        }
    }

    @Override
    public Instructor getInstructorDetails(String id) {
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