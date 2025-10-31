package com.MultiThreading;

public class ThreadManagerThread extends Thread{
    ThreadManagerThread(String s){
        super(s);
    }
    @Override
    public void run() {
        setName("Using Set name In Run");
        for (int i = 0; i < 1000; i++) {
            System.out.print(Thread.currentThread().getName()+" "+i);
        }
        System.out.println();
    }
}
