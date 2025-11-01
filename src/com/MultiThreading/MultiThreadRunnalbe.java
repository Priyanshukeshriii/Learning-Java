package com.MultiThreading;

public class MultiThreadRunnalbe implements Runnable {
    @Override
    public void run() {
        for (int i =0 ; i < 100 ; i++){
            System.out.println(i + " " + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        MultiThreadRunnalbe multiThreadRunnalbe = new MultiThreadRunnalbe();
        Thread t = new Thread(multiThreadRunnalbe);
        t.start();
    }
}
