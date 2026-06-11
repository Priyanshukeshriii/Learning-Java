package fundamentals.MultiThreading;
import java.util.Scanner;

class Banking3 implements Runnable{
    public void run(){
        String threadName = Thread.currentThread().getName();
        if (threadName.equals("Bank")){
            withdraw();
        }else if(threadName.equalsIgnoreCase("PrintPattern")){
            printPattern();
        }else{
            printImportantMassage();
        }
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
    public void printImportantMassage()  {
        System.out.println("Printing Important massage Started...");
        for (int i = 0; i < 5; i++) {
            System.out.println("Enjoy The Vibe...");
            try {
                Thread.currentThread().sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Printing Important massage  Terminated");
    }
    public void printPattern()  {
        System.out.println("Printing Activity Started...");
        for (int i = 0; i < 5; i++) {
            System.out.println("#**#");
            try {
                Thread.currentThread().sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Printing Activity Terminated");
    }
}



public class Thread_05 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Application Started...");
        Banking3 b = new Banking3();

        Thread thread1 = new Thread(b);
        Thread thread2 = new Thread(b);
        Thread thread3 = new Thread(b);
        thread1.setName("Bank");
        thread2.setName("PrintPattern");
        thread3.setName("ImpMassage");
        thread1.start();
        thread2.start();
        thread3.start();

        System.out.println("Application Terminated...");
    }
}
