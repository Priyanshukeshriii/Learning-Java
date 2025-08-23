package com.Assignment;

import java.util.Scanner;

//5)Write an application that inputs one number consisting of five digits from the user, separate the number into
//its individual digits and print the digit separates from one another for three spaces each. for example if the user
//type the number 42335 the program should print ( 4 2 3 3 5).

public class Problem_05 {
    static  int counter(int num){
        int count = 0;
        while(num>0){
            num/=10;
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner input  = new Scanner(System.in);
        System.out.println("Enter the number s");
        int num  = input.nextInt();
        int count = counter(num) -1;
        while(count >= 0){
            int solution = (int) (num/Math.pow(10,count));
            System.out.print("  "+solution);
            num = num% (int) (Math.pow(10,count));
            count--;
        }
    }

}
