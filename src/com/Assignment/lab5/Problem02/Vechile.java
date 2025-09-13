package com.Assignment.lab5.Problem02;

public class Vechile {
    private int numberOfWheel;
    private int numberOfdoors;
    void start(){
        System.out.println("Starting...");
    }
    void stop(){
        System.out.println("stopped");
    }

    public int getNumberOfdoors() {
        return numberOfdoors;
    }

    public void setNumberOfdoors(int numberOfdoors) {
        if(numberOfdoors <= 0){
            throw new ArithmeticException("doors can not be negative");
        }
        this.numberOfdoors = numberOfdoors;
    }

    public int getNumberOfWheel() {
        return numberOfWheel;
    }

    public void setNumberOfWheel(int numberOfWheel) {
        if(numberOfWheel <= 0){
            throw new ArithmeticException("wheels can not be negative");
        }
        this.numberOfWheel = numberOfWheel;
    }

    public Vechile(int numberOfdoors, int numberOfWheel) {
        setNumberOfdoors(numberOfdoors);
        setNumberOfWheel(numberOfWheel);
    }
}
