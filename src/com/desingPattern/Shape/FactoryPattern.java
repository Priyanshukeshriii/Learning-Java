package com.desingPattern.Shape;

import java.util.Scanner;

public class FactoryPattern {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("enter the shape :");
        String msg = input.next();
        System.out.println("enter the color :");
        String color = input.next();
        Shape shape = ShapeFactory.getShape(msg);
        Color color1 = ColorFactory.getColor(color);
        shape.draw();
        color1.fill();
    }
}
