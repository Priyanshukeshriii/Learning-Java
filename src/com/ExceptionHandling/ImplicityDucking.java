package com.ExceptionHandling;

public class ImplicityDucking {
    static void method1(){
        System.out.println("Method1 Start");
        method2();
        System.out.println("Method1 end");
    }
    static void method2(){
        System.out.println("Method2 Start");
        try{
            method3();
        }
        catch (ArithmeticException ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
        System.out.println("Method2 end");
    }
    static void method3(){
        System.out.println("Method3 Start");
        int i = 10/0;
//        try{
//            int i = 10/0;
//        }
//        catch (ArithmeticException ex) {
//            ex.printStackTrace();
//        }
        System.out.println("Method3 end");
    }

    public static void main(String[] args) {
        System.out.println("Main starts");
        method1();
        System.out.println("Mian ends");
    }
}
