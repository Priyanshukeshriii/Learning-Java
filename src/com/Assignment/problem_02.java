package com.Assignment;

import java.util.Scanner;

public class problem_02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the two number: ");
        int a = input.nextInt();
        int  b= input.nextInt();
        if ( a > b){
            System.out.println(a + " is large");
        } else if (a == b) {
            System.out.println("Both are equal");
        }else {
            System.out.println(b+ " is large");
        }
    }
}
