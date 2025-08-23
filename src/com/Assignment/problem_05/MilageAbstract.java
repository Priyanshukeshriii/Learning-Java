package com.Assignment.problem_05;

public abstract class MilageAbstract implements  MilageInterface {
    private double miles;
    private  double gas;
    private  double totalmiles;
    private  double totalgas;

    public double getTotalgas() {
        return totalgas;
    }

    public void setTotalgas(double totalgas) {
        this.totalgas = totalgas;
    }

    public double getTotalmiles() {
        return totalmiles;
    }

    public void setTotalmiles(double totalmiles) {
        this.totalmiles = totalmiles;
    }

    public double getGas() {
        return gas;
    }

    public double getMiles() {
        return miles;
    }
    public  void setGas(double gas){
        this.gas = gas;
    }
    public  void setMiles (double miles){
        this.miles = miles;
    }
    public abstract   double tripcalculator();
}
