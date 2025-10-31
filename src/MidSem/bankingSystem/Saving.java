package MidSem.bankingSystem;

public class Saving implements BankAccount{
    double balance;
    @Override
    public void deposti(double amount) {
        balance =+ amount;
    }

    @Override
    public void withdraw(double amount) {
        if(balance < amount ){
            System.out.println("insificient balanace");
            return;
        }
        balance = balance - amount;
    }
    Saving (double balance){
        if(balance<500){
            System.out.println("not sificient balance");
        }
        this.balance = balance;
    }
}
