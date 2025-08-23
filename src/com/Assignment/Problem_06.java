package com.Assignment;

public class Problem_06 {
    static int cube(int i){
        return (int)Math.pow(i,3);
    }
    static int square(int i){
        return (int) Math.pow(i,2);
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.printf("The square of %d is %d\n",i,square(i));
            System.out.printf("The cube of %d is %d\n",i,cube(i));
        }
    }
}
