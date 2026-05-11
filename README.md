## OOP ENROLLMENT SYSTEM

Author: Lat, Zeus Aron M.

Course: Integrative Programming - Object-Oriented Programming (Finals)

Architecture: Service-Oriented Architecture (SOA) | Interface-Driven Design

## Project Vision & Architectural Thinking
This Capstone project represents the transition from basic scripting to Professional Software Architecture. The system is built on a Service-Oriented Model, where logic is decoupled from data.

The "Registrar" Design Pattern
Instead of the Main class talking directly to every small part of the system, I implemented a Registrar Coordinator. This acts as a "Central Brain" or "Facade," orchestrating five specialized internal services. This ensures that the UI (Main Menu) remains clean and focused solely on user interaction, while the Registrar handles the complex "behind-the-scenes" object linking.


## The OOP Evolutionary Roadmap

### Inheritance & Encapsulation
I established a robust identity hierarchy using a Person base class. By using the protected access modifier and super() constructors, I ensured that Student and Instructor inherit core identities while maintaining strict encapsulation of their unique attributes.


### Abstraction (Enforcing Professional Roles)
To ensure the system remains logical, I defined Person as an Abstract Class. By defining an abstract method mainTask(), I forced the system to recognize that every person in the university must have a specific professional function:

Student: Implementation of mainTask() focuses on "Academic Learning."

Instructor: Implementation of mainTask() focuses on "Educational Instruction."


### Interface-Driven Polymorphism (Decoupling)
This is the core of the project's architecture. Every service (Student, Course, Instructor, Department, Enrollment) is defined by an Interface.

The Contract: The interface defines what must be done.

The Implementation: The ServiceImpl classes define how it is done.
This allows for Polymorphic behavior, where the Registrar can treat any service implementation as its interface type, making the code highly flexible and easy to update.


### Complex Institutional Mapping
The project successfully maps real-world academic relationships:

Department contains many Sections and Instructors.

Section links one Course, one Instructor, and many Students.

Hierarchical Traversal: The system can "walk" through a Department object to find all students currently enrolled in its specific sections.


## Advanced Business Logic & Bonus Features

### 1. Custom Exception Handling
   I moved beyond simple if statements and implemented Checked Exceptions to handle academic violations:

SectionFullException: Triggered when a section reaches its maxCapacity.

DuplicateEnrollmentException: Ensures a student cannot be added to the same class twice, maintaining data integrity.

### 2. Robust Finance & Scholarship Logic
   The TuitionServiceImpl handles advanced financial math:

Unit-Based Charging: Logic calculates fees based on Course units ($1,000 per unit).

Scholarship Application: Supports a percentage-based discount (e.g., 20% scholarship) that updates the student's balance in real-time.

### 3. Crash-Proof UI & Resource Management
   Input Validation: The Main menu uses a try-catch block to handle InputMismatchException. If a user types "ABC" where a number is expected, the system clears the scanner buffer and prompts again rather than crashing.

Memory Safety: Implemented input.close() to properly release system resources upon exit, preventing memory leaks.


## Quality Assurance (JUnit 5 Suite)

To earn the +15% Unit Testing Bonus, I developed a comprehensive suite of 12 automated tests using the AAA (Arrange, Act, Assert) pattern.

![Screenshot 2026-05-09 at 11.34.57 PM.png](images/Screenshot%202026-05-09%20at%2011.34.57%E2%80%AFPM.png)


## Interactive User Manual 

### To witness the full "Object Linking" and "Polymorphic" logic, follow this sequence in the Main Menu:

[Option 9] Register Department: Create a container (e.g., "College of Engineering").

[Option 4] Save Course: Create a course (e.g., "CS101", 3 units).

[Option 6] Hire Instructor: Create an instructor and link them to the course.

[Option 11] Create Section: Name it "CS-1A", set capacity to 2.

[Option 21/20] Link Entities: Connect the Course and Instructor to the Section.

[Option 1] Register Student: Add "Alice" and "Bob".

[Option 14] Enroll: Add students to the section. (Try adding a 3rd to trigger the FullSectionException).

[Option 15] Finance: Check the balance and apply tuition payments.


## Technical Stack

### Language: Java (JDK 17+)

### Testing: JUnit 5 (Jupiter)

### Build Tool: IntelliJ IDEA Internal Compiler

### Version Control: Git / GitHub (Conventional Commits)


## Inheritance

### Overview
focuses on the Core Data Entities and the implementation of Inheritance logic.

### 1. Inheritance Hierarchy (Person, Student, Instructor)
I used the `extends` keyword to create a relationship where `Student` and `Instructor` inherit attributes from the `Person` base class.
![Student Inheritance](images/Student.png)

### 2. Supporting Entities
Created the base classes for the institutional hierarchy.
![Course and Section](images/Section.png)

### 3. Execution Test
Screenshot of the `Main` class verifying that the objects can be instantiated and the hierarchy is functional.
![Hierarchy Test](images/Main.png)


## Abstraction

### Abstract Base Class (Person)
   I defined Person as an abstract class to act as the primary blueprint for the system. By including the abstract method mainTask(), I ensured that any class inheriting from Person is required to define its own specific behavior.
   ![](images/Person1.png)

### Concrete Implementation (Student)
   The Student class extends Person and provides the specific implementation for mainTask(). In this context, the student's primary task is defined as "learning."
   ![](images/Student1.png)

### Concrete Implementation (Instructor)
   Similarly, the Instructor class implements the mainTask() method inherited from the Person abstract class, defining the instructor's unique role as "teaching."
   ![](images/Instructor1.png)

### Supporting Entity (Course)
   The Course entity serves as a data model within the abstracted system to categorize academic offerings.
   ![](images/Course1.png)

### Abstracted Service Logic (StudentRegistration)
   I applied abstraction to the service layer by extending Person into Course/StudentRegistration. This allows the registration process itself to be treated as an entity with a specific functional task.
   ![](images/StudentReg.png)    ![](images/CourseReg.png)


### Abstraction Execution Test
   ![](images/MainExec1.png)

### Junit jupiter testing TuitionFeePayment
![Unit Test Results](images/Test_Results.png)


## Interface

### StudentReg (Interface):
Ensures any registration service provides save, display, update, and remove functionality.
![](images/StudentReg1.png)

### CourseReg (Interface):
Standardizes how courses are stored and retrieved independently of the UI.
![](images/CourseReg1.png)

### Registrar (Coordinator):
Acting as the central hub.
The Main class communicates only with the Registrar, which then delegates tasks to the specific service implementations.
![](images/Registrar1.png)


## Polymorphism 

### InstructorReg: 
The interface (contract) defining how instructors should be managed.
![](images/InstructorReg1.png)

### InstructorRegistration: 
The implementation class that actually stores the list of faculty.
![](images/InstructorRegistration1.png)

## Section Module
### SectionReg: 
Interface for section management; ensures all implementations handle student lists.
![](images/SectionReg1.png)

### SectionRegistration: 
Implementation containing the 40-student limit logic.
![](images/SectionRegistration1.png)

## Department Module
### DepartmentReg: 
Interface for top-level organizational grouping.
![](images/DepartmentReg1.png)

### DepartmentRegistration: 
Logic for registering departments and linking them to other entities.
![](images/DepartmentRegistration1.png)

## The Registrar 
### Registrar: 
Uses all 5 interfaces above to simplify the Main class.
![](images/Registrar2.png)




# FINALS OOP COMPLETE CODE





# ENTITIES



## Course
![Courses2.png](images/Courses2.png)


## Department
![Department2.png](images/Department2.png)


## Instructor
![Instructor2.png](images/Instructor2.png)


## Person
![Person2.png](images/Person2.png)


## Section
![Section2.png](images/Section2.png)


## Student
![Student2.png](images/Student2.png)


## TuitionFeePayment
![TuitionFeePayment2.png](images/TuitionFeePayment2.png)





# SERVICES



## Exceptions


## DuplicateEnrollmentException
![DuplicateFullEnrollmentException2.png](images/DuplicateFullEnrollmentException2.png)


## SectionFullException
![SectionFullException2.png](images/SectionFullException2.png)




## Implementation


## CourseServiceImpl
![CourseServiceImpl2.png](images/CourseServiceImpl2.png)


## DepartmentServiceImpl
![DepService2(1).png](images/DepService2%281%29.png)
![DepServiceImpl2(2).png](images/DepServiceImpl2%282%29.png)


## EnrollmentServiceImpl
![EnrollmentServiceImpl2(1).png](images/EnrollmentServiceImpl2%281%29.png)
![EnrollmentService2(2).png](images/EnrollmentService2%282%29.png)


## InstructorServiceImpl
![InstructorService2(1).png](images/InstructorService2%281%29.png)
![InstructorService2(2).png](images/InstructorService2%282%29.png)


## StudentServiceImpl
![StudentService2.png](images/StudentService2.png)


## TuitionServiceImpl
![TuitionServiceImpl2.png](images/TuitionServiceImpl2.png)





# Interfaces


## IcourseService
![ICourseService2.png](images/ICourseService2.png)


## IDepartmentService
![IDepartment2.png](images/IDepartment2.png)


## IEnrollmentService
![IEnrollment2.png](images/IEnrollment2.png)


## IInstructorService
![IInstructor2.png](images/IInstructor2.png)


## IStudentService
![IStudent2.png](images/IStudent2.png)


## ITuitionService
![ITtuition2.png](images/ITtuition2.png)





# Registrar
![Regis11.png](images/Regis11.png)
![Regis22.png](images/Regis22.png)
![Regis33.png](images/Regis33.png)





# Main
![Screenshot 2026-05-09 at 11.44.55 PM.png](images/Screenshot%202026-05-09%20at%2011.44.55%E2%80%AFPM.png)
![Screenshot 2026-05-09 at 11.45.01 PM.png](images/Screenshot%202026-05-09%20at%2011.45.01%E2%80%AFPM.png)
![Screenshot 2026-05-09 at 11.45.05 PM.png](images/Screenshot%202026-05-09%20at%2011.45.05%E2%80%AFPM.png)
![Screenshot 2026-05-09 at 11.45.11 PM.png](images/Screenshot%202026-05-09%20at%2011.45.11%E2%80%AFPM.png)
![Screenshot 2026-05-09 at 11.45.16 PM.png](images/Screenshot%202026-05-09%20at%2011.45.16%E2%80%AFPM.png)





# Junit Testing


## CourseServiceTest
![CourseTest2.png](images/CourseTest2.png)


## DepartmentServiceTest
![DepTest2.png](images/DepTest2.png)


## EnrollmentServiceTest
![EnrollmentTest(1).png](images/EnrollmentTest%281%29.png)
![EnrollmentTest2(2).png](images/EnrollmentTest2%282%29.png)


## InstructorServiceTest
![InstructorTest2.png](images/InstructorTest2.png)


## StudentServiceTest
![StudentTest2.png](images/StudentTest2.png)


## TuitionFeePaymentTest
![TuitionTest1(1).png](images/TuitionTest1%281%29.png)
![TuitionTest2(2).png](images/TuitionTest2%282%29.png)