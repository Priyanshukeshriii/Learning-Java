package MidSem.bankingSystem;

import java.util.Scanner;

public class BankSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter which account you want to create (saving or current): ");
        String msg = input.next();
        BankAccount B1 = BankFactory.getAccount(msg);
        boolean a = true;
        while (a){
            System.out.println("1. deposite");
            System.out.println("2. withdrawal");
            System.out.println("--------");
            System.out.println("enter the choise");
            int i = input.nextInt();
            switch (i){
                case 1:
                    System.out.println("enter the amount you want to deposite: ");
                    double deposite = input.nextDouble();
                    System.out.println("enter the amount: ");
                    double balance = input.nextDouble();
                    B1.deposti(deposite);
                    break;
                case 2:
                    System.out.println("enter the amount you want to deposite: ");
                    double withdrawal = input.nextDouble();
                    System.out.println("enter the amount: ");
                    double balance1 = input.nextDouble();
                    B1.withdraw(withdrawal);
                    break;
                case 3:
                    a= false;
                default:
                    System.out.println("enter a valid method");
            }
        }
    }
}
