package com.Interfacee;

public class InterfaceDemo {
    public static void main(String[] args) {
        Car c1 = new Tata();//reference can be made but not the object
//        Object c2 = new Tata(); // this can not be as java type check before the program runs so when the compilere
//        sees c2.engine() it look at decleration type of c2 which is Object the compiler checks for the engine method in
//        the Object class and can not find the Object class so it gives the error
//        if engine method was Object class then the tata class would have overridden the engine method
//        c2.engine();
        c1.engine();
    }
}
