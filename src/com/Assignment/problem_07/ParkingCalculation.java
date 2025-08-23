package com.Assignment.problem_07;

public class ParkingCalculation implements  ParkingInterface {
    int totalhour_parked;
    double totalAmount;
    @Override
    public double parkingAmount() {
        if (totalhour_parked <= 3){
            return 2;
        }
        totalAmount += 2;
        totalhour_parked -= 3;
        while (totalhour_parked >= 24) {
            totalAmount += 10;
            totalhour_parked -= 24;
        }
        if (totalhour_parked > 0){
            totalAmount+= 0.5*totalhour_parked;
            totalhour_parked = 0;
        }


        return totalAmount;
    }

    public ParkingCalculation(int totalhour_parked) {
        this.totalhour_parked = totalhour_parked;
    }
}
