package com.enrollment.services;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.enrollment.entities.Course;
import com.enrollment.services.ICourseService;
import com.enrollment.services.impl.CourseServiceImpl;

public class CourseServiceTest {

    private ICourseService courseService;

    @BeforeEach
    void setUp() {
        courseService = new CourseServiceImpl();
    }

    @Test
    void testAddAndFindCourse() {
        // ARRANGE
        Course course = new Course("CS101", "Java Programming", "BSCS");

        // ACT
        courseService.addCourse(course);
        Course found = courseService.findCourse("CS101");

        // ASSERT
        assertNotNull(found, "Course should be found in the system.");
        assertEquals("Java Programming", found.getCourseName());
        assertEquals("BSCS", found.getCourseProgram());
    }
}