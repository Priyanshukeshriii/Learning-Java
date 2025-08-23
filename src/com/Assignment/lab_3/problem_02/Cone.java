package com.Assignment.lab_3.problem_02;

public class Cone extends Figure{
    double radius ;
    double slant_height;
    @Override
    public void calcArea() {
        a = 2*(PI * radius* slant_height);
    }

    @Override
    public void calcVol() {
        v = (PI * radius* slant_height);
    }

    @Override
    public void dispArea() {
        System.out.println("The area of the cone is : "+ a);
    }

    @Override
    public void dispVol() {
        System.out.println("The volume of the cone is: " +v);
    }

    public Cone(double radius, double slant_height) {
        this.radius = radius;
        this.slant_height = slant_height;
    }
}
