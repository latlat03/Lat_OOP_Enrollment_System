package com.enrollment.entities;

import com.enrollment.entities.Student;
import com.enrollment.entities.Course;
import com.enrollment.services.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        StudentReg studentService = new StudentRegistration();
        CourseReg courseService = new CourseRegistration();

        Registrar registrar = new Registrar(studentService, courseService);

        TuitionFeePayment payment = new TuitionFeePayment();
        boolean running = true;

        while (running) {
            System.out.println("\n--- Enrollment System ---");
            System.out.println("[1] Add Student\n[2] Display Students\n[3] Add Course\n[4] Display Courses\n[5] Test Tuition\n[6] Exit");
            System.out.print("Choice: ");

            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Name: "); String name = input.nextLine();
                    System.out.print("ID: "); String id = input.nextLine();
                    System.out.print("Program: "); String prog = input.nextLine();
                    registrar.saveStudent(new Student(id, name, prog));
                    break;
                case 2:
                    registrar.displayAllStudents();
                    break;
                case 3:
                    System.out.print("Course Code: "); String code = input.nextLine();
                    System.out.print("Course Name: "); String cName = input.nextLine();
                    System.out.print("Program: "); String cProg = input.nextLine();
                    registrar.saveCourse(new Course(code, cName, cProg));
                    break;
                case 4:
                    registrar.displayAllCourses();
                    break;
                case 5:
                    payment.calculateTuitionFee(3, 0);
                    System.out.println("Balance: " + payment.getBalance());
                    break;
                case 6:
                    running = false;
                    break;
            }
        }
    }
}