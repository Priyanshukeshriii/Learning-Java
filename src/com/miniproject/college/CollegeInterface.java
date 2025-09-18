package com.miniproject.college;

import com.miniproject.Student.StudentInterface;

public interface CollegeInterface {
    void login(String email , String password);
    void logout();
    void viewCourses();
}
