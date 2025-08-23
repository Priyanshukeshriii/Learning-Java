package com.InterfaceNotes;

public class InterfaceDemo {
    public static void main(String[] args) {
        CDemo c = new CDemo();
        c.show();
        c.display();
        ADemo c1  = new ADemo();
        c1.display();
//        BDemo c3 = new BDemo() ;
        ADemo c4 = new CDemo();
        c4.display();
//        c4.show(); this is not possible why ??
        BDemo c5   = new CDemo();
        c5.show();
//        c5.display(); this is not possible why??
    }
}
/*
intreface -> abstract -> class 
 */
