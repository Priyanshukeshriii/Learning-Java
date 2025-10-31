package com.miniProject01.users;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("enter the roll");
        String msg = input.next();
        User role =  UserFactory.getUser(msg);
        if(role instanceof Student){
            System.out.println("enter the email:");
            String email = input.next();
            System.out.println("enter the password");
            String password = input.next();
            if(role.login(email,password)){
                System.out.println("login sucessfully");

                Scanner scanner = new Scanner(System.in);
                role.viewMenu(scanner);
            }
        }
        else if(role instanceof Professor){
            System.out.println("enter the email:");
            String email = input.next();
            System.out.println("enter the password");
            String password = input.next();
            if(role.login(email,password)){
                System.out.println("login sucessfully");

                Scanner scanner = new Scanner(System.in);
                role.viewMenu(scanner);
            }
        }
        else if(role instanceof Administrator){

            System.out.println("enter the password");
            String password = input.next();
            if(role.login("",password)){
                System.out.println("login sucessfully");

                Scanner scanner = new Scanner(System.in);
                role.viewMenu(scanner);
            }
        }
    }
}
