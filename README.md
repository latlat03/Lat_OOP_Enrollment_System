## OOP ENROLLMENT SYSTEM

Author: Lat, Zeus Aron M.

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
