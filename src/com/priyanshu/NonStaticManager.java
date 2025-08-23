package com.priyanshu;
class c1{
    void show(){
        System.out.println("c show");
    }
}
class x extends c1{
    void display(){
        System.out.println("Display B");
    }
}
public class NonStaticManager {
    public static void main(String[] args) {
//        x.display();
        x z = new x();
        z.show();
        z.display();
    }
}
