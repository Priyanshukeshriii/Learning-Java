package com.miniproject.Student;

import com.miniproject.college.CollegeInterface;
import com.miniproject.collegeData.StudentData;

import java.util.Scanner;

public class Student  implements CollegeInterface {
    String name;
    String roll;
    String email;
    String password;
    double CGPA;

    public Student(){};
    public Student(double CGPA, String email, String name, String password, String roll) {
        this.CGPA = CGPA;
        this.email = email;
        this.name = name;
        this.password = password;
        this.roll = roll;
    }

    public double getCGPA() {
        return CGPA;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getRoll() {
        return roll;
    }

    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public void hello(){
        System.out.println("hi");
    }


    public void display() {
        Scanner input = new Scanner(System.in);
        boolean running= true;
        while(running){
            System.out.println("enter the choise");
            System.out.println("1. Login");
            System.out.println("2. Hello");
            System.out.println("3. Exit");
            int i = input.nextInt();
            switch (i){
                case 1: this.login("a", "b");
                break;
                case 2: this.hello();
                break;
                case 3: running = false;
                break;
                default:
                    System.out.println("enter a correct value");
            }
        }
    }

    @Override
    public void login(String email , String password) {
        for(Student s : StudentData.studentList){
            if(s.getEmail().equals(email) && s.getPassword().equals(password)){
                System.out.println("login successfully");
            }
        }

        System.out.println("student login");
    }

    @Override
    public void logout() {
        System.out.println("sutdent logout");
    }

    @Override
    public void viewCourses() {
        System.out.println("view Course");
    }


}
