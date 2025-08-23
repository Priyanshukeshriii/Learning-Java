package com.Assignment.lab_3.problem_03;

public class Demo {
    public static void main(String[] args) {
        Z z = new Z(2,4);
        System.out.println(z.product());
        System.out.println(z.sum());
        System.out.println(z.difference());
        z.i = 10;
        System.out.println(z.product());
        System.out.println(z.sum());
        System.out.println(z.difference());

    }
}
