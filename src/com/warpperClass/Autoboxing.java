package com.warpperClass;

public class Autoboxing {
    void show(byte i){
        System.out.println("byte");
    }
    void show(int i){
        System.out.println("int");
    }
//    void show(float i){
//        System.out.println("float");
//    }
    void show(short i){
        System.out.println("short");
    }
//    void show(double i){
//        System.out.println("double");
//    }
    void show(long i){
        System.out.println("long");
    }

    void show(Float i){
        System.out.println("Float");
    }
    void sum(int ...a){
        int sum = 0;
        for (int i = 0 ; i < a.length; i ++){
            sum += a[i];
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        Autoboxing a1 = new Autoboxing();
        a1.show(10.22f);//autoboxing and typecasting
        a1.sum(1,3,4,5,6,8); //variable argument
    }
}
