package com.Assignment.lab_4.problem_03;

import java.util.Scanner;

public class N_RepeatedChar {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("enter the repeation you want: ");
        int n = input.nextInt();
        input.nextLine();
        System.out.println("Enter the String: ");
        String str = input.next();
        char[] ch = str.toCharArray();
//        System.out.println(ch[1]);
        for (int i = 0; i <ch.length; i++) {
            int count= 1 ;
            for (int j = i+1; j <ch.length; j++) {
                if(ch[i] == ch[j]){
                    count++;
                }
            }
            if(count >= n){
                System.out.println(ch[i]);
            }
        }
    }
}
