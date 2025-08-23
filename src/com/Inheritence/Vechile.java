package com.Inheritence;

public class Vechile {
    private String brand;
    private int speed;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        if(speed>=0) {
            this.speed = speed;
        }
    }

    public Vechile(String brand, int speed) {
        this.brand = brand;
        setSpeed(speed);
    }
}
