class A1{

    A1() {
        System.out.println("A constructor");
    }

}
class B1{
    B1() {
        System.out.println("B constructor");
    }
}



public class ConstructorChaining {
    public static void main(String[] args) {
        B1 b = new B1();
    }
}
