package com.Assignment;

import java.util.Scanner;

public class Problem_01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the two number: ");
        int a = input.nextInt();
        int b = input.nextInt();
        System.out.printf("The sum is %d\n" , (a+b));
        System.out.printf("The difference is %d\n" , (a-b));
        System.out.printf("The product is %d\n" , (a*b));
        System.out.printf("The division is %d" , (a/b));
    }
}
