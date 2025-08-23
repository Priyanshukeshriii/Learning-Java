package com.Assignment.problem_06;

public class CreditOperation implements CreditInterface{
    private int accoutNummber;
    private int currentPurchaseprice;

    private double creditLimit;
    private double currentBalance;

    public int getAccoutNummber() {
        return accoutNummber;
    }

    public void setAccoutNummber(int accoutNummber) {
        this.accoutNummber = accoutNummber;
    }



    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public int getCurrentPurchaseprice() {
        return currentPurchaseprice;
    }

    public void setCurrentPurchaseprice(int currentPurchaseprice) {
        this.currentPurchaseprice = currentPurchaseprice;
    }

    @Override
    public int getAccountNumber() {
        return accoutNummber;
    }

    @Override
    public boolean creditInLimit() {
        if(currentBalance < creditLimit) {
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Account Number " + accoutNummber);
        System.out.println("Current purchase price "+currentPurchaseprice);
        System.out.println("Current Balance "+currentBalance);


    }

    @Override
    public double calculateNewBalance(int currentPurchaseprice) {
        currentBalance += currentPurchaseprice;
        return currentBalance;
    }
}
