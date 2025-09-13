package com.Assignment.lab5.Problem1;

public class  SimpleInterestCalculation implements SimpleInterestInterface  {
    private double principle;
    private double rateOfInterest;
    private int month;

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if(month < 0){
            throw new ArithmeticException("Month is not valid , month can't be negative");
        }else {
            this.month = month;
        }
    }

    public double getPrinciple() {
        return principle;
    }

    public void setPrinciple(double principle) {
        if(principle < 0){
            throw new ArithmeticException("Principle amount is not valid , month can't be negative");
        }else {
            this.principle = principle;
        }
    }

    public double getRateOfInterest() {
        return rateOfInterest;
    }

    public void setRateOfInterest(double rateOfInterest) {
        if(rateOfInterest < 0){
            throw new ArithmeticException("rateOfInterest is not valid , month can't be negative");
        }else {
            this.rateOfInterest = rateOfInterest;
        }
    }

    public SimpleInterestCalculation(int month, double principle, double rateOfInterest) {
        setMonth(month);
        setPrinciple(principle);
        setRateOfInterest(rateOfInterest);
    }

    @Override
    public double SICalculation() {
        double simpleInterest = getPrinciple() + (getPrinciple()*(getRateOfInterest())*getMonth()/12)/100;
        return simpleInterest;
    }
}
