package com.Assignment.lab_4.problem_02;
//We need to write the function to check the password entered is correct or not based on the following
//conditions.
//        a) It must have atleast one lower case character and one digit.
//b) It must not have any Upper case characters and any special characters
//c) length should be b/w 5-12.
//d) It should not have any same immediate patterns like
//abcanan1 : not acceptable coz of an an pattern
//abc11se: not acceptable, coz of pattern 11
//123sd123 : acceptable, as not immediate pattern
//adfasdsdf : not acceptable, as no digits
//Aasdfasd12: not acceptable, as have uppercase character


import java.util.Scanner;

public class PasswordChecker {
    static boolean containsLowerCase(String password){
        for (char ch : password.toCharArray()){
            if(97<= (int) ch && (int)ch<= 122){
                return true;
            }
        }
        return false;
    }
    static boolean containsDigit(String password){
        for (char ch : password.toCharArray()){
            if(48<= (int) ch && (int)ch<= 57){
                return true;
            }
        }
        return false;
    }
    static boolean containsUpperCase(String password){
        for (char ch : password.toCharArray()){
            if(65<= (int) ch && (int)ch<= 96){
                return false;
            }
        }
        return true;
    }
//    static boolean containsPatterns(String password){
//        if(password.c)
//        return true;
//    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the password: ");
        String password = input.next();
        if(containsLowerCase(password) && containsUpperCase(password) && containsDigit(password)){
            System.out.println("correct password");
        }else {
            System.out.println("Wrong password");
        }
    }
}
