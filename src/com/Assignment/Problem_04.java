package com.Assignment;

import java.util.Scanner;

//Q4) Write an application that input from the user that the radius of the circle is an integer and the print the circle
//diameter , circumfrence and area using the floating point value 3.14159 for math.Pi(You can also use the
//predefined constant math.pi for the value of pi.)
interface CalculationOfCircle{
    int diameter();
    double area();
    double circumfrence();
}
class MyCalculator implements CalculationOfCircle{
    int radius;

    public MyCalculator(int radius) {
        this.radius = radius;
    }

    @Override
    public int diameter() {
        return this.radius*2;
    }

    @Override
    public double area() {
        return Math.PI *this.radius*this.radius;
    }

    @Override
    public double circumfrence() {
        return 2*Math.PI*this.radius;
    }
}

public class Problem_04 {
    public static void main(String[] args) {
        Scanner input =  new Scanner(System.in);
        System.out.println("enter the integer radius: ");
        int r = input.nextInt();
        MyCalculator cal = new MyCalculator(r);
        System.out.println("The diameter of circle is :"+ cal.diameter());
        System.out.println("The circumfrence of circle is :"+ cal.circumfrence());
        System.out.println("The area of circle is :"+ cal.area());
    }

}
