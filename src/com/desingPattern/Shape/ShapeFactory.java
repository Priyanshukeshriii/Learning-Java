package com.desingPattern.Shape;

public class ShapeFactory {
    static Shape getShape(String msg){
        if(msg.equalsIgnoreCase("Circle")){
            return new Circle();
        }
        if(msg.equalsIgnoreCase("Recrangle")){
            return new Rectangle();
        }
        if(msg.equalsIgnoreCase("Triangle")){
            return new Triangle();
        }
        else return null;
    }
}
