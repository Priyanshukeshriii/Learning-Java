class A1{

    A1() {
        System.out.println("A constructor");
    }

}
class B1 extends A1{
    B1() {
        super();//super call this call the constructor of A1
        System.out.println("B constructor");
    }
}



public class ConstructorChaining {
    public static void main(String[] args) {
        B1 b = new B1();
    }
}
