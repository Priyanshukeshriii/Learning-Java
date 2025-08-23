package com.Assignment.lab_3.problem_02;

public class Demo {
    public static void main(String[] args) {
        Cone c = new Cone(1,1);
        Sphere s1 = new Sphere(1);
        Cylinder c2 = new Cylinder(1,1);
        c.calcArea();
        c.calcVol();
        c.dispArea();
        c.dispVol();
        c2.calcArea();
        c2.calcVol();
        c2.dispArea();
        c2.dispVol();
        s1.calcArea();
        s1.calcVol();
        s1.dispArea();
        s1.dispVol();
    }
}
