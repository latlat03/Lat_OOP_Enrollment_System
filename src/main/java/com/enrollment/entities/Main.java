package com.enrollment.entities;

import com.enrollment.entities.Student;
import com.enrollment.entities.Course;
import com.enrollment.entities.Instructor;
import com.enrollment.entities.Section;
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
            System.out.println("[1] Add Student");
            System.out.println("[2] Display Students");
            System.out.println("[3] Add Course");
            System.out.println("[4] Display Courses");
            System.out.println("[5] Test Tuition");
            System.out.println("[6] Add Instructor");
            System.out.println("[7] Display Instructors");
            System.out.println("[8] Create Section");
            System.out.println("[9] Enroll Student in Section");
            System.out.println("[10] Display Sections");
            System.out.println("[0] Exit");
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
                    System.out.print("Instructor Name: "); String instName = input.nextLine();
                    System.out.print("Instructor ID: "); String instId = input.nextLine();
                    System.out.print("Course Assigned: "); String instCourse = input.nextLine();
                    registrar.saveInstructor(new Instructor(instId, instName, instCourse));
                    break;
                case 7:
                    registrar.displayAllInstructors();
                    break;
                case 8:
                    System.out.print("Enter Section Name: ");
                    String secName = input.nextLine();
                    registrar.saveSection(new Section(secName));
                    break;
                case 9:
                    System.out.print("Enter Section Name: ");
                    String targetSection = input.nextLine();
                    System.out.print("Enter Student ID: ");
                    String targetID = input.nextLine();

                    Student foundStudent = registrar.findStudent(targetID);
                    if (foundStudent != null) {
                        registrar.enrollStudentInSection(targetSection, foundStudent);
                    } else {
                        System.out.println("Error: Student with ID " + targetID + " not found.");
                    }
                    break;
                case 10:
                    registrar.displayAllSections();
                    break;
                case 0:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}