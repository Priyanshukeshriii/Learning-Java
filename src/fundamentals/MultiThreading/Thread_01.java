package fundamentals.MultiThreading;

import java.util.Scanner;

public class Thread_01 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Application Started...");
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

        System.out.println("Printing Activity Started...");
        for (int i = 0; i < 5; i++) {
            System.out.println("#**#");
            Thread.currentThread().sleep(4000);
        }
        System.out.println("Printing Activity Terminated");

        System.out.println("Printing Important massage Started...");
        for (int i = 0; i < 5; i++) {
            System.out.println("#**#");
            Thread.currentThread().sleep(4000);
        }
        System.out.println("Printing Important massage  Terminated");


        System.out.println("Application Terminated...");
    }
}
