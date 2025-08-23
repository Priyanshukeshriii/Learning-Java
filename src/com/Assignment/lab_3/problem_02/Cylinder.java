package com.Assignment.lab_3.problem_02;

import javax.swing.plaf.PanelUI;

public class Cylinder extends Figure{
    double radius;
    double height;
    @Override
    public void calcArea() {
        a = 2* PI*radius*height + 2*PI*radius*radius;
    }

    @Override
    public void calcVol() {
        v = PI*radius*radius*height;
    }

    @Override
    public void dispArea() {
        System.out.println("the area of Cylinder is : "+ a);
    }

    @Override
    public void dispVol() {
        System.out.println("the volume of Cylinder is : "+ v);


    }
    public Cylinder(double radius, double height){
        this.radius=  radius;
        this.height = height;
    }
}
