class B {
    static {// static block can be called without an object
        System.out.println("this is the SIB block");
    }
    {
        System.out.println("1st IIB block");// IIB block can not called without the object
    }
    {
        System.out.println("2st IIB block");
    }

    public B() {
        super();// after super the IIB block is called
        System.out.println("B Constructor");
    }
}



public class IIBManager {
    {
        System.out.println("Mian IIB block");
    }
    public static void main(String[] args) {
        IIBManager b = new IIBManager();
        B b1 = new B();
        B b2 = new B();
    }
}
