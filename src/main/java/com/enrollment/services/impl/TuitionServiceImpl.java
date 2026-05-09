package com.enrollment.services.impl;

import com.enrollment.entities.Student;
import com.enrollment.services.ITuitionService;

public class TuitionServiceImpl implements ITuitionService {

    @Override
    public void processStudentTuition(Student student, int units) {
        double fee = units * 1500.0;

        double newBalance = student.getBalance() + fee;

        student.setBalance(newBalance);

        System.out.println("Processing tuition for: " + student.getPersonName());
        System.out.println("Fee for " + units + " units: $" + fee);
        System.out.println("New Total Balance: $" + student.getBalance());
    }

    @Override
    public double getStudentBalance(Student student) {
        return student.getBalance();
    }
}