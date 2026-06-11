package fundamentals.MultiThreading;
import java.util.Scanner;

class Banking{
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

class printing{
    public void printPattern() throws InterruptedException {
        System.out.println("Printing Activity Started...");
        for (int i = 0; i < 5; i++) {
            System.out.println("#**#");
            Thread.currentThread().sleep(2000);
        }
        System.out.println("Printing Activity Terminated");
    }
}

class Imp_massage{
    public void printImportantMassage() throws InterruptedException {
        System.out.println("Printing Important massage Started...");
        for (int i = 0; i < 5; i++) {
            System.out.println("Enjoy The Vibe...");
            Thread.currentThread().sleep(2000);
        }
        System.out.println("Printing Important massage  Terminated");
    }
}

public class Thread_02 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Application Started...");
        Banking b = new Banking();
        printing p = new printing();
        Imp_massage imp = new Imp_massage();
         b.withdraw();
         p.printPattern();
         imp.printImportantMassage();
        System.out.println("Application Terminated...");
    }
}
