package fundamentals.MultiThreading;
import java.util.Scanner;

class Banking1 extends Thread{
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

class printing1 extends Thread{
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

class Imp_massage1 extends Thread{
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

public class Thread_03 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Application Started...");
        Banking1 b = new Banking1();
        printing1 p = new printing1();
        Imp_massage1 imp = new Imp_massage1();
//        b.withdraw();
//        p.printPattern();
//        imp.printImportantMassage();

//        this is same as a single threading
//        b.run(); //b.withdraw();
//        p.run();  //p.printPattern();
//        imp.run();  // imp.printImportantMassage();
        b.start();
        p.start();
        imp.start();
        System.out.println("Application Terminated...");
    }
}
