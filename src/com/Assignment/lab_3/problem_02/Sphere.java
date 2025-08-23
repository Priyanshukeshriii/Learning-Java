package com.Assignment.lab_3.problem_02;

public class Sphere extends  Figure{
    double radius;

    @Override
    public void calcArea() {
        a = 4*PI*radius*radius;
    }

    @Override
    public void calcVol() {
        v = ((double) 4 /3)* PI* radius*radius*radius;
    }

    @Override
    public void dispArea() {
        System.out.println("The area of sphere is: " + a);
    }

    @Override
    public void dispVol() {
        System.out.println("The volume of sphere is: " + v);

    }
    public Sphere(double radius){
        this.radius = radius;
    }
}
