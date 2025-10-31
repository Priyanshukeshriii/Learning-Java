package com.MultiThreading;

public class EvenThread extends Thread{
    @Override
    public void run() {
        setName("Even");
        for (int i = 0; i < 100; i+=2) {
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
            System.out.println(getName() +":" +i);
        }
    }
}
