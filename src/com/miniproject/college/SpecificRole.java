package com.miniproject.college;

import com.Assignment.problem_07.ParkingInterface;
import com.miniproject.Adminstrator.Adminstrator;
import com.miniproject.Adminstrator.AdminstratorInterface;
import com.miniproject.Student.Student;
import com.miniproject.Student.StudentInterface;
import com.miniproject.professor.Professor;
import com.miniproject.professor.ProfessorInterface;

public class SpecificRole {
    static void getSpecificRole (String msg){
        Student s1  = null;
        ProfessorInterface p1  = null;
        AdminstratorInterface a1 = null;
        CollegeInterface c1 = Role.getRole(msg);
        if (c1 instanceof Student){
            s1 = (Student) c1 ;
            s1.login("a","b");
            s1.display();
        }

    }
}
