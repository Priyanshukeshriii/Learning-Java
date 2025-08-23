package com.Assignment.problem_06;

public interface CreditInterface {
    int getAccountNumber();
    boolean creditInLimit();
    void displayInfo();
    double calculateNewBalance(int currentbuyprice);
}
