package fundamentals.MultiThreading;
import java.util.Scanner;

class Banking2 implements Runnable{
    public void run(){
        withdraw();
    }
    public void withdraw(){

        System.out.println("Banking Activity Started...");
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the user name");
        String name = input.next();
        System.out.println("Enter the password");
        String pass = input.next();
        System.out.println("Enter the Amount");
        int amount = input.nextInt();
        System.out.println("Collect Your Money.");
        System.out.println("Banking Activity Terminated...");
    }
}

class printing2 implements Runnable{
    public void run(){
        try {
            printPattern();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void printPattern() throws InterruptedException {
        System.out.println("Printing Activity Started...");
        for (int i = 0; i < 5; i++) {
            System.out.println("#**#");
            Thread.currentThread().sleep(2000);
        }
        System.out.println("Printing Activity Terminated");
    }
}

class Imp_massage2 implements Runnable{
    public void run(){
        try {
            printImportantMassage();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void printImportantMassage() throws InterruptedException {
        System.out.println("Printing Important massage Started...");
        for (int i = 0; i < 5; i++) {
            System.out.println("Enjoy The Vibe...");
            Thread.currentThread().sleep(2000);
        }
        System.out.println("Printing Important massage  Terminated");
    }
}

public class Thread_04 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Application Started...");
        Banking2 b = new Banking2();
        printing2 p = new printing2();
        Imp_massage2 imp = new Imp_massage2();
        Thread thread1 = new Thread(b);
        Thread thread2 = new Thread(p);
        Thread thread3 = new Thread(imp);
        System.out.println(thread1.isAlive()); //Always False
        System.out.println(thread2.isAlive()); //Always False
        System.out.println(thread3.isAlive()); //Always False
        thread1.start();
        thread2.start();
        thread3.start();
        thread1.join();
        thread2.join();
        thread3.join();
//      As Join method before the main thread stared the other thread should have completed there task
        System.out.println(thread1.isAlive()); //without join method true //with join method false
        System.out.println(thread2.isAlive()); //without join method true //with join method false
        System.out.println(thread3.isAlive()); //without join method true //with join method false
        System.out.println("Application Terminated...");
    }
}
