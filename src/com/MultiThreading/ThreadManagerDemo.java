package com.MultiThreading;

public class ThreadManagerDemo {
    public static void main(String[] args) {
//        Thread.currentThread().setName("Priyanshu");
//        ThreadManagerThread t0 = new ThreadManagerThread("Using Constructor");
//        t0.start();
//        t0.setName("In Main");
//        System.out.println(t0.getName());
        EvenThread e1 = new EvenThread();
        OddThread o1 = new OddThread();
        o1.start();
        e1.start();


//        for (int i = 0; i < 1000; i++) {
//            System.out.print( Thread.currentThread().getName() +" "+i);
//        }

    }
}
