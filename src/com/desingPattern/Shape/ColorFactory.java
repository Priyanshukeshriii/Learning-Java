package com.desingPattern.Shape;



public class ColorFactory {
    static Color getColor(String msg){
        if(msg.equalsIgnoreCase("red")){
            return new Red();
        }
        if(msg.equalsIgnoreCase("yellow")){
            return new Yellow();
        }
        if(msg.equalsIgnoreCase("green")){
            return new Green();
        }
        else return null;
    }

}
