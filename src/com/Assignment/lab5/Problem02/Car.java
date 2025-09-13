package com.Assignment.lab5.Problem02;

public class Car extends Vechile{
    private int maxSpeed;

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        if(maxSpeed < 0){
            throw new ArithmeticException("Speed can not be negative");
        }else {
            this.maxSpeed = maxSpeed;
        }
    }

    public Car(int numberOfdoors, int numberOfWheel) {
        super(numberOfdoors, numberOfWheel);
    }
}
