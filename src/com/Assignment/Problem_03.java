package com.Assignment;

import java.util.Scanner;
interface Calculation{
    int sum() ;
    long product();
    double average();
    int large();
    int small();
}

abstract class Numberoperation implements Calculation{
    int num1, num2,num3;// this is for creating an place where the number can be store
    public Numberoperation(int a, int b ,int c) {
        this.num1 = a;
        this.num2 = b;
        this.num3 = c;
    }

    @Override
    public int sum() {
        return this.num1+this.num2+this.num3;
    }

    @Override
    public long product() {
        return this.num1*this.num2*this.num3;
    }

}
class calculator extends Numberoperation{
    public calculator(int a, int b, int c) {
        super(a, b, c);
    }

    @Override
    public double average() {
        return sum()/3.0;
    }

    @Override
    public int large() {
        return Math.max(num1 , Math.max(num2,num3));
    }

    @Override
    public int small() {
        return Math.min(num1 , Math.min(num2,num3));

    }
}

public class Problem_03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the three number: ");
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();
        calculator cal = new calculator(a,b,c);
        System.out.println("the sum is "+cal.sum());
        System.out.println("the product is "+cal.product());
        System.out.println("the average is "+cal.average());
        System.out.println("the largest is "+cal.large());
        System.out.println("the smallest is "+cal.small());
    }
}
