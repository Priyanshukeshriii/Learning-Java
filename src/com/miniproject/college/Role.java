package com.miniproject.college;

import com.miniproject.Adminstrator.Adminstrator;
import com.miniproject.Student.Student;
import com.miniproject.Student.StudentInterface;
import com.miniproject.professor.Professor;

public class Role {
    public static CollegeInterface getRole(String msg) {
        if(msg.equalsIgnoreCase("Student")){
            return new Student();
        } else if (msg.equalsIgnoreCase("professor")) {
            return new Professor();
        } else if (msg.equalsIgnoreCase("adminstrator")) {
            return new Adminstrator();
        }
        else{
            System.out.println("enter a valid role");
            return null;
        }
    }
}
