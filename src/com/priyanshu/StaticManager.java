package com.priyanshu;
class A{
    int j =0 ;
    static int Staticvar = 0;
    void display(){
//        in non static block the static and non static both can be executed
        Staticvar++;
        System.out.println("display method Staticvar"+Staticvar);
        System.out.println("display method J "+j);
    }
    static void show(){// Static method and variable can be access in non static block
        //static block will run at compile time and non static block will run at run time
        System.out.println("Static Method");
        System.out.println(Staticvar);
//        System.out.println(j); this is not possible as j runs at run time but the static block run at compile time
    }
}
public class StaticManager {
    public static void main(String[] args) {
        A.show();
        A a = new A();
        a.show();//compiler convert it into -> A.show();
        System.out.println(A.Staticvar);
        a.display();
    }
}
