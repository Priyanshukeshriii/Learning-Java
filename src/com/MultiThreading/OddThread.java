package com.MultiThreading;

public class OddThread extends Thread{
    @Override
    public void run() {
        setName("odd");
        for (int i = 1; i < 100; i+=2) {
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
            System.out.println(getName() +":" +i);
        }
    }
}
