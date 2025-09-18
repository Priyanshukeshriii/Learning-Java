package com.miniproject.collegeData;

import com.miniproject.Student.Student;

import java.util.ArrayList;

public class CourseData {
    public static ArrayList<Course> courseList = new ArrayList<>();
    static {
        courseList.add(new Course("AI101", "Data Structures", 4, "Dr. Sharma"));
        courseList.add(new Course("AI102", "Database Systems", 3, "Prof. Meena"));
        courseList.add(new Course("AI103", "Operating Systems", 4, "Dr. Gupta"));
        courseList.add(new Course("AI104", "Computer Networks", 3, "Dr. Ramesh"));
    }
}
