package com.priyanshu;
final class r {
    void show(){//final method can be overload  but not  overridden
        //constructor can not be final but it is of no use as it can not be overridden not inherited
        System.out.println(" show r");
    }
}
//class t extends r {}
// this is not possible because the final class can not be extended
public class FinalManager {
    public static void main(String[] args) {
        r R = new r();
        R.show();
    }
}
