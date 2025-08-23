package com.priyanshu;
class p{
    void show(){
        System.out.println("P show");
    }
}
class q extends p{
    @Override// constructor overriding is not possible
    void show(){
        System.out.println("q show");
    }
}class z extends q{
    @Override
    void show(){
        System.out.println("z show");
    }
}
public class PolyManager {
    public static void main(String[] args) {
        p all[] = new p[3];
        all[0] = new p();
        all[1] = new q();
        all[2] = new z();
        for (int i =0 ; i< all.length ;  i++){
            all[i].show();
        }
    }
}
