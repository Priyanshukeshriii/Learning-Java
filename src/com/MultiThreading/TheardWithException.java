package com.MultiThreading;
class t extends Thread{
    @Override
    public void run() {
        try{
            System.out.println(1 / 0);
        }catch (ArithmeticException e){
            System.err.println("divide by 0");
        }
        for (int i = 0; i < 100; i++) {
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
    }
}
class t1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
    }
}

public class TheardWithException {
    public static void main(String[] args) {
        t e1 = new t();
        t1 e2 = new t1();
        e1.start();
        e2.start();
    }
}
