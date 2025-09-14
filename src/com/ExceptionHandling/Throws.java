package com.ExceptionHandling;

public class Throws {
    static void method1() throws ClassNotFoundException{
        System.out.println("Method1 Start");
        method2();
        System.out.println("Method1 end");
    }
    static void method2() throws ClassNotFoundException{
        System.out.println("Method2 Start");
        method3();
//        try{
//            method3();
//        } catch (ClassNotFoundException e) {
//            System.out.println(e.getMessage());
//        }
        System.out.println("Method2 end");
    }
    static void method3() throws ClassNotFoundException{
        System.out.println("Method3 Start");
        Class.forName("");
//        try{
//            Class.forName("");
//        } catch (ClassNotFoundException e) {
//            System.out.println(e.getMessage());
//        }
//
        System.out.println("Method3 end");
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Main starts");
//        try{
//            method1();
//        } catch (ClassNotFoundException e) {
//            System.out.println(e.getMessage());
//        }
        method1();

        System.out.println("Mian ends");
    }
}
