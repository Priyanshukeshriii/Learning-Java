package com.miniproject.collegeData;


import com.miniproject.Student.Student;

import java.util.*;


public class StudentData {
    public static HashMap<String, String> studentLogin = new HashMap<>();
    public static ArrayList<Student> studentList = new ArrayList<>();
    {
        studentLogin.put("priya.s101@college.edu", "priya123");
        studentLogin.put("rahul.s102@college.edu", "rahul123");
        studentLogin.put("aditi.s103@college.edu", "aditi789");
        studentLogin.put("karan.s104@college.edu", "karan321");
        studentLogin.put("sneha.s105@college.edu", "sneha654");
    }
    static {
        studentList.add(new Student(9,"sk.priyanshu" , "Priyanshu" , "password","24AI049"));
        studentList.add(new Student(8.5, "rahul.s101@college.edu", "Rahul", "rahul123", "24AI001"));
        studentList.add(new Student(7.9, "priya.s102@college.edu", "Priya", "priya123", "24AI002"));
        studentList.add(new Student(9.1, "anil.s103@college.edu", "Anil", "anil123", "24AI003"));
        studentList.add(new Student(8.2, "meena.s104@college.edu", "Meena", "meena123", "24AI004"));
    }



}
