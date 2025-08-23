package com.Assignment;

class Car{
     double totalMilesPerDay;
     double costPerGallonGasoline;
     double avgMilesPerGallon;
    int tollTaxPerDay;

    public Car(double avgMilesPerGallon, double costPerGallonGasoline, int tollTaxPerDay, double totalMilesPerDay) {
        this.avgMilesPerGallon = avgMilesPerGallon;
        this.costPerGallonGasoline = costPerGallonGasoline;
        this.tollTaxPerDay = tollTaxPerDay;
        this.totalMilesPerDay = totalMilesPerDay;
    }
    double  DailyDrivingCost(){
        double drivingCost = ((this.totalMilesPerDay/this.avgMilesPerGallon)* costPerGallonGasoline)+tollTaxPerDay;
        return drivingCost;
    }
}
public class Problem_07 {
    public static void main(String[] args) {
        Car c1 = new Car(10,100,500,1000);
        System.out.println(c1.DailyDrivingCost());
    }
}
