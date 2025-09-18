package com.miniproject.Adminstrator;

public class Adminstrator implements AdminstratorInterface{
    @Override
    public void login(String email, String password) {
        System.out.println("Admin login");
    }
    public void login(String password){
        if(password.equals("admin")){
            System.out.println("login");
        }
        else{
            System.out.println("wrong password");
        }
    }

    @Override
    public void logout() {
        System.out.println("Admin logout");
    }

    @Override
    public void viewCourses() {
        System.out.println("view course");
    }
}
