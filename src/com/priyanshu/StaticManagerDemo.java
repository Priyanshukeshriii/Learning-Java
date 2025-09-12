package com.priyanshu;
class c {
    static void show(){// non static block can be inherited  but will be access only with the object name
        System.out.println("c show");
    }
}
class b extends c{
    //when we extend a class we can use the child class name to call the static method or variable
    static void display(){
        System.out.println(" display b");
    }
}
public class StaticManagerDemo {
    public static void main(String[] args) {
        b.display();
        b.show();
    }
}
