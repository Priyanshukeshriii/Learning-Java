package com.priyanshu;
class Method{
    void show(){
        System.out.println("A show");
    }
    void show(int i ){
        System.out.println("A show" + i);
    }
    void show(double i){
        System.out.println("A show " + i);
    }
}
class Register extends Method{
    @Override
    void show() {
        super.show();
    }
    void show(int i , int j){
        System.out.println("regester " +(i+j));
    }
}
public class MethodOverloading {
    public static void main(String[] args) {
        Method m  = new Method();
        m.show();
        m.show(10);
        m.show(10.31);

    }
}
