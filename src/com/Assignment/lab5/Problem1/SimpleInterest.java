package com.Assignment.lab5.Problem1;

public class SimpleInterest {
    public static void main(String[] args) {
        try{
            SimpleInterestCalculation s1 = new SimpleInterestCalculation(-1, 1, 1);
            System.out.println(s1.SICalculation());
        }
        catch (ArithmeticException ex){
            System.out.println(ex.getMessage());
        }
    }

}
