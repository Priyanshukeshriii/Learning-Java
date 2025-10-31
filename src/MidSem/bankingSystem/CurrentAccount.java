package MidSem.bankingSystem;

public class CurrentAccount implements BankAccount{
    double balance;
    @Override
    public void deposti(double amount) {
        balance =+ amount;
    }

    @Override
    public void withdraw(double amount) {
        if(balance < amount ){
            System.out.println("insificient balanace");
        }
        balance =- amount;
    }

    public CurrentAccount(double balance) {
        this.balance = balance;
    }
}
