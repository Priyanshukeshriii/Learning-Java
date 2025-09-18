package com.miniproject.college;

import com.miniproject.Student.Student;
import com.miniproject.Student.StudentInterface;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        StudentInterface s1 = null;
        Scanner input = new Scanner(System.in);
        System.out.println("enter the role");
        String msg = input.next();
        SpecificRole.getSpecificRole(msg);


    }
}
