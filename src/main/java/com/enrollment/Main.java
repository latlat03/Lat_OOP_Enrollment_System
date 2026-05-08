package com.enrollment;

import com.enrollment.entities.*;
import com.enrollment.services.*;
import com.enrollment.services.impl.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Initialize Service Implementations
        IStudentService studentService = new StudentServiceImpl();
        ICourseService courseService = new CourseServiceImpl();
        IInstructorService instructorService = new InstructorServiceImpl();
        IEnrollmentService enrollmentService = new EnrollmentServiceImpl();
        IDepartmentService departmentService = new DepartmentServiceImpl();

        // Inject services to Registrar
        Registrar registrar = new Registrar(
                studentService,
                courseService,
                instructorService,
                enrollmentService,
                departmentService
        );

        boolean running = true;

        while (running) {
            System.out.println("\n--- Enrollment System ---");
            System.out.println("[1] Add Student");
            System.out.println("[2] Display Students");
            System.out.println("[3] Add Course");
            System.out.println("[4] Display Courses");
            System.out.println("[5] (Tuition Disabled - Coming Soon)");
            System.out.println("[6] Add Instructor");
            System.out.println("[7] Display Instructors");
            System.out.println("[8] Create Section (with Capacity)");
            System.out.println("[9] Enroll Student in Section");
            System.out.println("[10] Display Sections");
            System.out.println("[11] Register Department");
            System.out.println("[12] Display Departments");
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
                    System.out.println("This feature is currently disabled.");
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
                    System.out.print("Enter Maximum Capacity: ");
                    int cap = input.nextInt();
                    registrar.saveSection(new Section(secName, cap));
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
                case 11:
                    System.out.print("Enter Department Name: ");
                    String dName = input.nextLine();
                    registrar.saveDepartment(new Department(dName));
                    break;
                case 12:
                    registrar.displayDepartments();
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