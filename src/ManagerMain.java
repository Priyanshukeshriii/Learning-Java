class A3 {
    A3(){
        System.out.println("A con");
    }
    A3(int i){
        this();
        System.out.println("A " +i);
    }
}
class B3 extends A3{
    B3(){
        this(10);
        System.out.println("B con");
    }
    B3(int i){
        super(i);
        System.out.println("B " +i );
    }
}


public class ManagerMain {
    public static void main(String[] args) {
        B3 b = new B3();
    }
}
