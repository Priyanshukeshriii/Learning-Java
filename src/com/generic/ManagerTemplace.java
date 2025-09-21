package com.generic;

//class A1 {
//    public String toString(){
//        return "A";
//    }
//
//}
//class B1 extends A1 {
//    public String toString(){
//        return "B";
//    }
//}
//class Test extends B1{
//    public String toString(){
//        return "test";
//    }
//    public Test(){
//
//    }
//}

public class ManagerTemplace {


    static void test(){
        throw new RuntimeException("error occured");
    }
        static{
            System.out.println("static");
        }
    {
        System.out.println("IIB" );
    }
    public static void main(String[] args){
        {
            System.out.println("hi");
        }
        try{
            test();
        }
        catch(Error e){
            System.out.println("caught");
        } }
}
