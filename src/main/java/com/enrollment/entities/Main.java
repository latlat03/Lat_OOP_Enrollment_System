package com.enrollment.entities;

import com.enrollment.entities.Student;
import com.enrollment.services.StudentRegistration;
import com.enrollment.services.TuitionFeePayment;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StudentRegistration sr = new StudentRegistration();
        TuitionFeePayment payment = new TuitionFeePayment();
        boolean running = true;

        while (running) {
            System.out.println("\n--- Enrollment System ---");
            System.out.println("[1] Save Student\n[2] Display Students\n[3] Test Tuition\n[4] Exit");
            System.out.print("Choice: ");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Name: "); String name = input.nextLine();
                    System.out.print("ID: "); String id = input.nextLine();
                    System.out.print("Program: "); String prog = input.nextLine();
                    sr.saveStudent(new Student(id, name, prog));
                    break;
                case 2:
                    sr.displayAllStudents();
                    break;
                case 3:
                    payment.calculateTuitionFee(3, 0);
                    System.out.println("Balance: " + payment.getBalance());
                    break;
                case 4:
                    running = false;
                    break;
            }
        }
    }
}