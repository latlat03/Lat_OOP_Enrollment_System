package com.enrollment;

import com.enrollment.entities.*;
import com.enrollment.services.*;
import com.enrollment.services.impl.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Initialize Services
        IStudentService studentService = new StudentServiceImpl();
        ICourseService courseService = new CourseServiceImpl();
        IInstructorService instructorService = new InstructorServiceImpl();
        IEnrollmentService enrollmentService = new EnrollmentServiceImpl();
        IDepartmentService departmentService = new DepartmentServiceImpl();
        ITuitionService tuitionService = new TuitionServiceImpl();

        // Initialize Registrar
        Registrar registrar = new Registrar(
                studentService,
                courseService,
                instructorService,
                enrollmentService,
                departmentService,
                tuitionService
        );

        boolean running = true;

        while (running) {
            System.out.println("\n OOP Enrollment System Management ");

            System.out.println("   [STUDENTS]");
            System.out.println("    [1] Add Student       [2] Display All   [3] Remove Student    [16] Update Student");

            System.out.println("\n   [COURSES]");
            System.out.println("    [4] Add Course        [5] Display All   [17] Update Course    [18] Remove Course");

            System.out.println("\n   [INSTRUCTORS]");
            System.out.println("    [6] Add Instructor    [7] Display All   [8] Remove Instructor [19] Update Instructor");

            System.out.println("\n   [DEPARTMENTS]");
            System.out.println("    [9] Register Dept     [10] Display All");

            System.out.println("\n   [ENROLLMENT & SECTIONS]");
            System.out.println("    [11] Create Section   [12] Display All  [13] Delete Section");
            System.out.println("    [14] Enroll Student in Section");

            System.out.println("\n   [FINANCE]");
            System.out.println("    [15] Process Tuition");

            System.out.println("\n  [0] Exit System");
            System.out.print("\nChoice: ");

            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                // STUDENTS CRUD
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
                    System.out.print("Enter Student ID to remove: ");
                    registrar.removeStudent(input.nextLine());
                    break;
                case 16:
                    System.out.print("Enter Student ID to update: ");
                    String updateSid = input.nextLine();
                    System.out.print("New Name: "); String newSName = input.nextLine();
                    System.out.print("New Program: "); String newSProg = input.nextLine();
                    registrar.updateStudent(updateSid, new Student(updateSid, newSName, newSProg));
                    break;

                // COURSES CRUD
                case 4:
                    System.out.print("Code: "); String cCode = input.nextLine();
                    System.out.print("Name: "); String cName = input.nextLine();
                    System.out.print("Prog: "); String cProg = input.nextLine();
                    registrar.saveCourse(new Course(cCode, cName, cProg));
                    break;
                case 5:
                    registrar.displayAllCourses();
                    break;
                case 17:
                    System.out.print("Enter Course Code to update: ");
                    String updateCode = input.nextLine();
                    System.out.print("New Name: "); String newCName = input.nextLine();
                    System.out.print("New Program: "); String newCProg = input.nextLine();
                    registrar.updateCourse(new Course(updateCode, newCName, newCProg));
                    break;
                case 18:
                    System.out.print("Enter Course Code to remove: ");
                    registrar.removeCourse(input.nextLine());
                    break;

                // INSTRUCTORS CRUD
                case 6:
                    System.out.print("Name: "); String iName = input.nextLine();
                    System.out.print("ID: "); String iId = input.nextLine();
                    System.out.print("Course: "); String iCourse = input.nextLine();
                    registrar.saveInstructor(new Instructor(iId, iName, iCourse));
                    break;
                case 7:
                    registrar.displayAllInstructors();
                    break;
                case 8:
                    System.out.print("Enter Instructor ID to remove: ");
                    registrar.removeInstructor(input.nextLine());
                    break;
                case 19:
                    System.out.print("Enter Instructor ID to update: ");
                    String updateIid = input.nextLine();
                    System.out.print("New Name: "); String newIName = input.nextLine();
                    System.out.print("New Course Assignment: "); String newICourse = input.nextLine();
                    registrar.updateInstructor(updateIid, new Instructor(updateIid, newIName, newICourse));
                    break;

                // DEPARTMENTS
                case 9:
                    System.out.print("Dept Name: ");
                    registrar.saveDepartment(new Department(input.nextLine()));
                    break;
                case 10:
                    registrar.displayDepartments();
                    break;

                // ENROLLMENT & SECTIONS
                case 11:
                    System.out.print("Section Name: "); String sName = input.nextLine();
                    System.out.print("Capacity: "); int cap = input.nextInt();
                    input.nextLine(); // Consume newline
                    registrar.saveSection(new Section(sName, cap));
                    break;
                case 12:
                    registrar.displayAllSections();
                    break;
                case 13:
                    System.out.print("Section Name to delete: ");
                    registrar.deleteSection(input.nextLine());
                    break;
                case 14:
                    System.out.print("Section Name: "); String targetSec = input.nextLine();
                    System.out.print("Student ID: "); String targetID = input.nextLine();
                    Student found = registrar.findStudent(targetID);
                    if (found != null) {
                        registrar.enrollStudentInSection(targetSec, found);
                    } else {
                        System.out.println("Error: Student not found.");
                    }
                    break;

                // FINANCE
                case 15:
                    System.out.print("Enter units: ");
                    registrar.processTuition(input.nextInt());
                    input.nextLine();
                    break;

                case 0:
                    running = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid selection.");
            }
        }
    }
}