package MidSem.bankingSystem;

import java.util.Scanner;

public class BankFactory {

    public static BankAccount getAccount(String account){
        Scanner input = new Scanner(System.in);
        if(account.equalsIgnoreCase("Saving")){
            System.out.println("enter the minimun balance you want to keep it should be greater then 500:");
            double balance = input.nextDouble();
            return new Saving(balance);
        }
        else if(account.equalsIgnoreCase("Currrent")){
            System.out.println("enter the minimun balance you want to keep it should be greater then 500:");
            double balance = input.nextDouble();
            return new CurrentAccount(balance);
        }
        return null;
    }
}
